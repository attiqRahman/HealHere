package com.example.HealHere.ui.selfassessment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.HealHere.SQLHelper
import com.example.HealHere.ScoreModel
import com.example.HealHere.SelfAssessmentResultsActivity
import com.example.HealHere.UserModel
import com.example.HealHere.databinding.ActivitySignInBinding
import com.example.HealHere.databinding.FragmentSelfAssesmentBinding
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class SelfAssessmentFragment : Fragment() {

    private var _binding: FragmentSelfAssesmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var sqlitehelper: SQLHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSelfAssesmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initComponent()

        // Inflate the layout for this fragment
        /*return inflater.inflate(R.layout.fragment_self_assesment, container, false)*/
        return root
    }

    private fun initComponent() {

        //get selected option from each radiogroup from each question
        binding.selfAssessmentSubmit.setOnClickListener {

            //depression questions
            var q1_answer = binding.questionOneRadio!!.checkedRadioButtonId.toString()
            var q2_answer = binding.questionTwoRadio!!.checkedRadioButtonId.toString()
            var q3_answer = binding.questionThreeRadio!!.checkedRadioButtonId.toString()
            var q4_answer = binding.questionFourRadio!!.checkedRadioButtonId.toString()
            var q5_answer = binding.questionFiveRadio!!.checkedRadioButtonId.toString()
            var q6_answer = binding.questionSixRadio!!.checkedRadioButtonId.toString()
            var q7_answer = binding.questionSevenRadio!!.checkedRadioButtonId.toString()
            var q8_answer = binding.questionEightRadio!!.checkedRadioButtonId.toString()
            var q9_answer = binding.questionNineRadio!!.checkedRadioButtonId.toString()
            var q10_answer = binding.questionTenRadio!!.checkedRadioButtonId.toString()

            //bipolar test
            var bipolar_q1 = binding.bipolarQuestionnaire.bipolarOneRadio!!.checkedRadioButtonId.toString()
            var bipolar_q2 = binding.bipolarQuestionnaire.bipolarTwoRadio!!.checkedRadioButtonId.toString()
            var bipolar_q3 = binding.bipolarQuestionnaire.bipolarThreeRadio!!.checkedRadioButtonId.toString()
            var bipolar_q4 = binding.bipolarQuestionnaire.bipolarFourRadio!!.checkedRadioButtonId.toString()
            var bipolar_q5 = binding.bipolarQuestionnaire.bipolarFiveRadio!!.checkedRadioButtonId.toString()
            var bipolar_q6 = binding.bipolarQuestionnaire.bipolarSixRadio!!.checkedRadioButtonId.toString()
            var bipolar_q7 = binding.bipolarQuestionnaire.bipolarSevenRadio!!.checkedRadioButtonId.toString()
            var bipolar_q8 = binding.bipolarQuestionnaire.bipolarEightRadio!!.checkedRadioButtonId.toString()
            var bipolar_q9 = binding.bipolarQuestionnaire.bipolarNineRadio!!.checkedRadioButtonId.toString()
            var bipolar_q10 = binding.bipolarQuestionnaire.bipolarTenRadio!!.checkedRadioButtonId.toString()
            var bipolar_q11 = binding.bipolarQuestionnaire.bipolarElevenRadio!!.checkedRadioButtonId.toString()
            var bipolar_q12 = binding.bipolarQuestionnaire.bipolarTwelveRadio!!.checkedRadioButtonId.toString()

            //anxiety test
            var anxiety_q1 = binding.anxietyQuestionnaire.anxietyOneRadio!!.checkedRadioButtonId.toString()
            var anxiety_q2 = binding.anxietyQuestionnaire.anxietyTwoRadio!!.checkedRadioButtonId.toString()
            var anxiety_q3 = binding.anxietyQuestionnaire.anxietyThreeRadio!!.checkedRadioButtonId.toString()
            var anxiety_q4 = binding.anxietyQuestionnaire.anxietyFourRadio!!.checkedRadioButtonId.toString()
            var anxiety_q5 = binding.anxietyQuestionnaire.anxietyFiveRadio!!.checkedRadioButtonId.toString()
            var anxiety_q6 = binding.anxietyQuestionnaire.anxietySixRadio!!.checkedRadioButtonId.toString()
            var anxiety_q7 = binding.anxietyQuestionnaire.anxietySevenRadio!!.checkedRadioButtonId.toString()
            var anxiety_q8 = binding.anxietyQuestionnaire.anxietyEightRadio!!.checkedRadioButtonId.toString()
            var anxiety_q9 = binding.anxietyQuestionnaire.anxietyNineRadio!!.checkedRadioButtonId.toString()
            var anxiety_q10 = binding.anxietyQuestionnaire.anxietyTenRadio!!.checkedRadioButtonId.toString()
            var anxiety_q11 = binding.anxietyQuestionnaire.anxietyElevenRadio!!.checkedRadioButtonId.toString()

            //panic disorder test
            var panic_q1 = binding.panicQuestionnaire.panicOneRadio!!.checkedRadioButtonId.toString()
            var panic_q2 = binding.panicQuestionnaire.panicTwoRadio!!.checkedRadioButtonId.toString()
            var panic_q3 = binding.panicQuestionnaire.panicThreeRadio!!.checkedRadioButtonId.toString()
            var panic_q4 = binding.panicQuestionnaire.panicFourRadio!!.checkedRadioButtonId.toString()
            var panic_q5 = binding.panicQuestionnaire.panicFiveRadio!!.checkedRadioButtonId.toString()
            var panic_q6 = binding.panicQuestionnaire.panicSixRadio!!.checkedRadioButtonId.toString()
            var panic_q7 = binding.panicQuestionnaire.panicSevenRadio!!.checkedRadioButtonId.toString()
            var panic_q8 = binding.panicQuestionnaire.panicEightRadio!!.checkedRadioButtonId.toString()
            var panic_q9 = binding.panicQuestionnaire.panicNineRadio!!.checkedRadioButtonId.toString()
            var panic_q10 = binding.panicQuestionnaire.panicTenRadio!!.checkedRadioButtonId.toString()
            var panic_q11 = binding.panicQuestionnaire.panicElevenRadio!!.checkedRadioButtonId.toString()
            var panic_q12 = binding.panicQuestionnaire.panicTwelveRadio!!.checkedRadioButtonId.toString()
            var panic_q13 = binding.panicQuestionnaire.panicThirteenRadio!!.checkedRadioButtonId.toString()
            var panic_q14 = binding.panicQuestionnaire.panicFourteenRadio!!.checkedRadioButtonId.toString()
            var panic_q15 = binding.panicQuestionnaire.panicFifteenRadio!!.checkedRadioButtonId.toString()
            var panic_q16 = binding.panicQuestionnaire.panicSixteenRadio!!.checkedRadioButtonId.toString()
            var panic_q17 = binding.panicQuestionnaire.panicSeventeenRadio!!.checkedRadioButtonId.toString()
            var panic_q18 = binding.panicQuestionnaire.panicEighteenRadio!!.checkedRadioButtonId.toString()
            var panic_q19 = binding.panicQuestionnaire.panicNineteenRadio!!.checkedRadioButtonId.toString()
            var panic_q20 = binding.panicQuestionnaire.panicTwentyRadio!!.checkedRadioButtonId.toString()

            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())
            System.out.println(" C DATE is  "+currentDate)

            System.out.println(q1_answer)

//            val user = ScoreModel(
//                id = 0,
//                date = currentDate,
//
//            )
//            sqlitehelper.addScore()
            //to be continued...
            val intent = Intent(context, SelfAssessmentResultsActivity::class.java)
            startActivity(intent)
        }

    }

}