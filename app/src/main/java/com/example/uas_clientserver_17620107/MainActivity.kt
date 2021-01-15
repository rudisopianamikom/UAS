package com.example.uas_clientserver_17620107

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.example.uas_clientserver_17620107.screen.match.PrevMatchFragment
import kotlinx.android.synthetic.main.activity_main.*


const val BACK_STACK_ROOT_TAG = "root_fragment"
const val PREV_MATCH = "prev_match"
const val NEXT_MATCH = "next_match"
const val FAVORITE = "favorite"
const val MENU = "menu"

class MainActivity : AppCompatActivity(), FragmentManager.OnBackStackChangedListener {

    private val onNavigationSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener {
                item -> when (item.itemId) {
            R.id.prev_match -> {
                item.isCheckable = true
                val prevMatchFragment = PrevMatchFragment.newInstance()
                openFragment(prevMatchFragment, PREV_MATCH)
                return@OnNavigationItemSelectedListener  true
            }
            R.id.next_match -> {
                item.isCheckable = true
                val prevMatchFragment = PrevMatchFragment.newInstance()
                openFragment(prevMatchFragment, NEXT_MATCH)
                return@OnNavigationItemSelectedListener  true
            }
            R.id.favorites -> {
                item.isCheckable = true
                val prevMatchFragment = PrevMatchFragment.newInstance()
                openFragment(prevMatchFragment, FAVORITE)
                return@OnNavigationItemSelectedListener  true
            }
        }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        supportFragmentManager.addOnBackStackChangedListener(this)
        shouldDisplayHomeUp()
        setContentView(R.layout.activity_main)
        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationSelectedListener)
        bottomNavigation.selectedItemId = R.id.prev_match


    }

    private fun openFragment(fragment: Fragment, menu : String) {

        var bundle = Bundle()
        bundle.putString(MENU, menu)
        fragment.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction()
        transaction.apply {

            replace(R.id.container, fragment,BACK_STACK_ROOT_TAG)
            addToBackStack(BACK_STACK_ROOT_TAG)
            commit()

        }
    }

    override fun onBackStackChanged() {
        shouldDisplayHomeUp()
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFragmentManager.popBackStack()
        return true

    }

    fun shouldDisplayHomeUp() {
        val canback = supportFragmentManager.backStackEntryCount > 1
        supportActionBar?.setDisplayHomeAsUpEnabled(canback)
    }


}