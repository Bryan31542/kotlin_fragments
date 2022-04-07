package com.fac.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity(), SumFragment.OnActionListener {
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

        val changeButton: Button = findViewById(R.id.action_change)

        changeButton.setOnClickListener {
            val n1 = (1..100).random()
            val n2 = (1..100).random()
            val fragmentChange = SumFragment.newInstance(n1,n2)
            fragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout_fragment, fragmentChange)
                .commit()
        }
    }

    override fun onActionClick(result: Int) {
        Toast
            .makeText(this, "The result is $result", Toast.LENGTH_SHORT)
            .show()
    }
}