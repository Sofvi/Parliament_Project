package com.suvilai.ex5.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.suvilai.ex5.R
import com.suvilai.ex5.databinding.FragmentMemberDetailsBinding
import com.suvilai.ex5.databinding.GradeDialogFragmentBinding
import com.suvilai.ex5.viewmodels.GradeDialogViewModel
import com.suvilai.ex5.viewmodels.GradeDialogViewModelFactory
import kotlinx.android.synthetic.main.fragment_member_details.*


private lateinit var binding : GradeDialogFragmentBinding
private lateinit var gradeSet : FragmentMemberDetailsBinding
var currentGrade: Int = 0

class GradeDialogFragment : DialogFragment() {

    private val gradeDialogViewModel : GradeDialogViewModel by viewModels {
        GradeDialogViewModelFactory()
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.grade_dialog_fragment, container, false)

        gradeSet = DataBindingUtil.inflate(inflater,R.layout.fragment_member_details,container,false)

        binding.oneStar.setOnClickListener {
            Toast.makeText(context,"You gave 1 star", Toast.LENGTH_LONG).show()
            updateGrade(1)
            gradeHere.text = currentGrade.toString()
            dismiss()
        }

        binding.twoStars.setOnClickListener {
            Toast.makeText(context,"You gave 2 stars", Toast.LENGTH_LONG).show()
            updateGrade(2)
            gradeHere.text = currentGrade.toString()
            dismiss()
        }

        binding.threeStars.setOnClickListener {
            Toast.makeText(context, "You gave 3 stars", Toast.LENGTH_LONG).show()
            updateGrade(3)
            gradeHere.text = currentGrade.toString()
            dismiss()
        }

        return binding.root
    }

        /*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.oneStar.setOnClickListener {
            Toast.makeText(context,"You gave 1 star", Toast.LENGTH_LONG).show()
            updateGrade(1)
            dismiss()
        }

        binding.twoStars.setOnClickListener {
            Toast.makeText(context,"You gave 2 stars", Toast.LENGTH_LONG).show()
            updateGrade(2)
            dismiss()
        }

        binding.threeStars.setOnClickListener {
            Toast.makeText(context,"You gave 3 stars", Toast.LENGTH_LONG).show()
            updateGrade(3)
            dismiss()
        }
    }

         */

    private fun updateGrade(amount: Int) {
        currentGrade += amount
        //updateUi()
    }

    /*
    private fun updateUi() {
        gradeSet.gradeView.setText(currentGrade)
    }

     */

    /*
    private fun updateDatabase(grade: Grade) {
        gradeDialogViewModel.updateGrade(grade)
    }

     */


}