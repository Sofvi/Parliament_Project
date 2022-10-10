package com.suvilai.ex5.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.suvilai.ex5.R
import com.suvilai.ex5.data.Grade
import com.suvilai.ex5.databinding.GradeDialogFragmentBinding
import com.suvilai.ex5.viewmodels.GradeDialogViewModel
import com.suvilai.ex5.viewmodels.GradeDialogViewModelFactory

/**     Suvi Laitinen, 10.10.2022
 *      2113710
 *
 *      The grade dialog fragment of the application.
 *      Asks the user to grade the member.
 */

private lateinit var binding : GradeDialogFragmentBinding

var currentGrade: Int = 0

class GradeDialogFragment : DialogFragment() {

    //ViewModel
    private val gradeDialogViewModel : GradeDialogViewModel by viewModels {
        GradeDialogViewModelFactory() }

    @SuppressLint("RestrictedApi", "UseGetLayoutInflater")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.grade_dialog_fragment, container, false)

        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_gradeDialogFragment_to_memberDetailsFragment)
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        return binding.root
    }

    // Asks for the grade and calls to update the database
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.oneStar.setOnClickListener {
            Toast.makeText(context,"You gave 1 star", Toast.LENGTH_LONG).show()
            updateGrade(1)

            val grade = Grade(currentMember.hetekaId, currentGrade)
            updateDatabase(grade)
        }

        binding.twoStars.setOnClickListener {
            Toast.makeText(context,"You gave 2 stars", Toast.LENGTH_LONG).show()
            updateGrade(2)

            val grade = Grade(currentMember.hetekaId, currentGrade)
            updateDatabase(grade)
        }

        binding.threeStars.setOnClickListener {
            Toast.makeText(context, "You gave 3 stars", Toast.LENGTH_LONG).show()
            updateGrade(3)

            val grade = Grade(currentMember.hetekaId, currentGrade)
            updateDatabase(grade)
        }

    }

    // Tries to update the grade
    private fun updateGrade(amount: Int) {
        currentGrade += amount
        updateUi()
    }

    // Tries to update the view in member_details
    private fun updateUi() {
        binding.gradeHere.text = currentGrade.toString()
    }

    // Tries to update the database
    private fun updateDatabase(grade: Grade) {
        gradeDialogViewModel.updateGrade(grade)
    }




}