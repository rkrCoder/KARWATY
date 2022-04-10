package com.jaiecom.karwaty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jaiecom.karwaty.fragment.ProductDetailsFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragment = ProductDetailsFragment()
        showFragment(fragment)


    }

    fun showFragment(fragment: ProductDetailsFragment) {
        val fram = supportFragmentManager.beginTransaction()
        fram.replace(R.id.fragment_main, fragment)
        fram.commit()
    }

}
