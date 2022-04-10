package com.jaiecom.karwaty.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.jaiecom.karwaty.R
import kotlinx.android.synthetic.main.fragment_add_product.*


class AddProductFragment: Fragment()  {

     var mLinearLayout: ViewGroup? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_add_product, container, false)


       //mLinearLayout =    view.findViewById(R.id.add_new_layout) as ViewGroup

       // mLinearLayout = view.findViewById(R.id.add_new_layout) as LinearLayout



        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        iv_add.setOnClickListener {

            addLayout()

        }
    }

    private fun addLayout() {
        val layout2: View = LayoutInflater.from(activity).inflate(R.layout.add_new_layout, mLinearLayout, false)
        val et_english = layout2.findViewById<View>(R.id.et_english_item) as EditText
        val et_arabic = layout2.findViewById<View>(R.id.et_english_item) as EditText


        mLinearLayout!!.addView(layout2)
    }
}


