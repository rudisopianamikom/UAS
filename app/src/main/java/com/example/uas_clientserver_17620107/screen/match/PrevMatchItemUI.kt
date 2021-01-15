package com.example.uas_clientserver_17620107.screen.match

import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.uas_clientserver_17620107.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class PrevMatchItemUI : AnkoComponent<ViewGroup> {



    override fun createView(ui: AnkoContext<ViewGroup>) : View = with(ui) {
        cardView {

            lparams(matchParent, dip(80)){margin = dip(10); bottomMargin = dip(0)}

            verticalLayout {
                padding = dip(10)
                lparams(matchParent, matchParent)
                orientation = LinearLayout.VERTICAL

                textView {
                    id = R.id.date_match_item
                    text = context.getString(R.string.date_example)
                    textColor = ContextCompat.getColor(context,R.color.colorPrimary)
                    gravity = Gravity.CENTER_HORIZONTAL
                }.setTypeface(textView().typeface, Typeface.BOLD)

                relativeLayout {

                    lparams(matchParent, wrapContent)

                    textView {
                        id = R.id.home_match_item
                        text = context.getString(R.string.club_example)
                        gravity = Gravity.START
//                        filters = arrayOf<InputFilter>(InputFilter.LengthFilter(10))
//                        ellipsize = TextUtils.TruncateAt.START

                    }.lparams(){rightMargin = dip(10); leftOf(R.id.home_score_item)}

                    textView {
                        id = R.id.home_score_item
                        text = "3"
                        setTypeface(this.typeface, Typeface.BOLD)
                    }.lparams(){rightMargin = dip(10); leftOf(R.id.tv_vs_item)}

                    textView {
                        id = R.id.tv_vs_item
                        text = context.getString(R.string.vs)
                        gravity = Gravity.CENTER_HORIZONTAL
                    }.lparams(){centerHorizontally()}

                    textView {
                        id = R.id.away_score_item
                        text = "3"
                        gravity = Gravity.RIGHT
                        setTypeface(this.typeface, Typeface.BOLD)
                    }.lparams(){leftMargin = dip(10); rightOf(R.id.tv_vs_item)}

                    textView {
                        id = R.id.away_match_item
                        text = context.getString(R.string.club_example)
//                        filters = arrayOf<InputFilter>(InputFilter.LengthFilter(10))
//                        this.ellipsize = TextUtils.TruncateAt.MIDDLE

                    }.lparams(){leftMargin = dip(10);
                        rightOf(R.id.away_score_item)
                    }

                }
            }
        }
    }

}