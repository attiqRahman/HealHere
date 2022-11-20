package com.example.HealHere

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.HealHere.databinding.ActivitySelfAssessmentResultsBinding

class SelfAssessmentResultsActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySelfAssessmentResultsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelfAssessmentResultsBinding.inflate((layoutInflater))
        setContentView(binding.root)
    }
}