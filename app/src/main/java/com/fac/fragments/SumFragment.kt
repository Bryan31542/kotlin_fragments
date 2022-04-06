package com.fac.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// we are going to use these vars to pass arguments
private const val ARG_SUM1 = "sum1"
private const val ARG_SUM2 = "sum2"

class SumFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var sum1: Int? = null // ? bc are null safety
    private var sum2: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            sum1 = it.getInt(ARG_SUM1, 0)
            sum2 = it.getInt(ARG_SUM2 , 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sum, container, false)
    }

    // when the view has already created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addingOneTV: TextView = view.findViewById(R.id.adding_one_text_view)
        val addingTwoTV: TextView = view.findViewById(R.id.adding_two_text_view)
        val resultTV: TextView = view.findViewById(R.id.result_text_view)

        addingOneTV.text = sum1.toString()
        addingTwoTV.text = sum2.toString()
        resultTV.text = sum1?.plus(sum2!!).toString()
    }

    // is used to create an instance with an easy way, design pattern, factory method, static method
    companion object {
        @JvmStatic
        fun newInstance(sum1: Int, sum2: Int) =
            SumFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SUM1, sum1)
                    putInt(ARG_SUM2, sum2)
                }
            }
    }
}