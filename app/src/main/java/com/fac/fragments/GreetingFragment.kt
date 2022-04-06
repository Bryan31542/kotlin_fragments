package com.fac.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class GreetingFragment : Fragment() { // to use fragments we must heredity

    override fun onCreateView(
        inflater: LayoutInflater, // allow us to receive an xml + context + view parent = view
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_greeting, container, false) // we will use this line always
    }
}