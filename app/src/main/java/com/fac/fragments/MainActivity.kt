package com.fac.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // in viewModel we use data logic not UI Logic

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction() // we initialize a transaction to add an element to the screen

        val fragment = SumFragment.newInstance(2,5)
        fragmentTransaction
            .add(R.id.frame_layout_fragment, fragment)
            .commit()

        // looking for an existing fragment
        // fragmentManager.findFragmentById(R.id.greeting_one)
    }
}