package com.example.HealHere.ui.selfassessment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.HealHere.SelfAssessmentResultsActivity
import com.example.HealHere.databinding.FragmentSelfAssesmentBinding

class SelfAssessmentFragment : Fragment() {

    private var _binding: FragmentSelfAssesmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSelfAssesmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //get selected option from each radiogroup from each question
        binding.selfAssesmentSubmit.setOnClickListener {
            var q1_answer = binding.qoneRadio!!.checkedRadioButtonId.toString()
            var q2_answer = binding.qtwoRadio!!.checkedRadioButtonId.toString()
            var q3_answer = binding.qthreeRadio!!.checkedRadioButtonId.toString()

            //to be continued...
            val intent = Intent(context, SelfAssessmentResultsActivity::class.java)
            startActivity(intent)
        }

        // Inflate the layout for this fragment
        /*return inflater.inflate(R.layout.fragment_self_assesment, container, false)*/
        return root
    }
}