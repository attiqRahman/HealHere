package com.example.HealHere.ui.trackerlog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.HealHere.R
import com.example.HealHere.databinding.FragmentTrackerLogBinding

class TrackerLogFragment : Fragment() {

    private var _binding: FragmentTrackerLogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTrackerLogBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Inflate the layout for this fragment
        return root
    }
}