package com.example.uas_clientserver_17620107.screen.match


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import com.example.uas_clientserver_17620107.FAVORITE
import com.example.uas_clientserver_17620107.MENU
import com.example.uas_clientserver_17620107.PREV_MATCH
import com.example.uas_clientserver_17620107.R
import com.example.uas_clientserver_17620107.common.ViewModel.Response
import com.example.uas_clientserver_17620107.common.domain.model.EventFootball
import com.example.uas_clientserver_17620107.common.domain.model.Events
import com.example.uas_clientserver_17620107.screen.detail_match.DETAIL_EVENT
import com.example.uas_clientserver_17620107.screen.detail_match.DetailMatch
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import timber.log.Timber
import javax.inject.Inject

class PrevMatchFragment : Fragment() {

    companion object {
        fun newInstance(): PrevMatchFragment = PrevMatchFragment()
    }

    lateinit var progressBar: ProgressBar
    lateinit var menu : String

    @Inject
    lateinit var prevMatchViewModelFactory: PrevMatchViewModelFactory

    private lateinit var prevMatchViewModel: PrevMatchViewModel

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val bundle = arguments
        when {
            bundle != null -> {
                menu = bundle.getString(MENU)
                Timber.e("hasil Menu adalah ${menu}")
            }

        }

        prevMatchViewModel = ViewModelProviders.of(this, prevMatchViewModelFactory).get(
            PrevMatchViewModel::class.java)

        prevMatchViewModel.response().observe(this, Observer { response -> execute(response!!) })

        launch(UI) {
            prevMatchViewModel.loadDataFootball(menu, context)
        }
    }

    override fun onResume() {
        super.onResume()
        launch(UI) {
            prevMatchViewModel.loadDataFootball(menu, context)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return UI {
            relativeLayout {

                progressBar = progressBar {
                    id = R.id.rv_pb_prev_match
                    indeterminateDrawable.setColorFilter(ContextCompat
                            .getColor(context, R.color.colorPrimary), PorterDuff.Mode.SRC_IN)

                }.lparams(){centerHorizontally(); centerVertically()}

                recyclerView {
                    id = R.id.rv_prev_match
                    layoutManager = LinearLayoutManager(context)

                }.lparams(matchParent, matchParent)
            }
        }.view
    }

    private fun execute(response : Response) = when (response) {
        is Response.Loading -> renderLoadingState()
        is Response.Success -> renderDataState(response.data)
        is Response.Error -> renderErrorState()
    }

    private fun renderLoadingState() {
        Timber.e("Loading")

    }

    private fun renderDataState(data : Any?) {
        Timber.e("Yesss")
        val recycler = view?.findViewById<RecyclerView>(R.id.rv_prev_match)
        if (menu == FAVORITE){
            val footballEvent = data as List<Events>
            recycler?.adapter = PrevMatchAdapter(footballEvent.toMutableList(), FAVORITE) {
                Toast.makeText(context, it.dateEvent, Toast.LENGTH_SHORT).show()

                val fragment = DetailMatch.newInstance()
                val bundle = Bundle()
                bundle.putParcelable(DETAIL_EVENT, it)
                fragment.arguments = bundle


                fragmentManager?.beginTransaction()
                        ?.replace(R.id.container, fragment, "Fragment")
                        ?.addToBackStack("Fragment")
                        ?.commit()
            }
        } else {
            val footballEvent = data as EventFootball
            recycler?.adapter = PrevMatchAdapter(footballEvent?.events?.toMutableList(), PREV_MATCH) {
                Toast.makeText(context, it.dateEvent, Toast.LENGTH_SHORT).show()
                val fragment = DetailMatch.newInstance()
                val bundle = Bundle()
                bundle.putParcelable(DETAIL_EVENT, it)
                fragment.arguments = bundle


                fragmentManager?.beginTransaction()
                        ?.replace(R.id.container, fragment, "Fragment")
                        ?.addToBackStack("Fragment")
                        ?.commit()
            }
        }
        progressBar.visibility = View.GONE
        val list = mutableListOf<Events>()




    }

    private fun renderErrorState() {
        Timber.e("Error")
        progressBar.visibility = View.GONE
        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
    }


}