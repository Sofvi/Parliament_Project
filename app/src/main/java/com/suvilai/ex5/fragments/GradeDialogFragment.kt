package com.suvilai.ex5.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.suvilai.ex5.R
import com.suvilai.ex5.databinding.GradeDialogFragmentBinding


private lateinit var binding : GradeDialogFragmentBinding

class GradeDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.grade_dialog_fragment, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.oneStar.setOnClickListener {
            Toast.makeText(context,"You gave 1 star", Toast.LENGTH_LONG).show()
            dismiss()
        }

        binding.twoStars.setOnClickListener {
            Toast.makeText(context,"You gave 2 stars", Toast.LENGTH_LONG).show()
            dismiss()
        }

        binding.threeStars.setOnClickListener {
            Toast.makeText(context,"You gave 3 stars", Toast.LENGTH_LONG).show()
            dismiss()
        }
    }


}