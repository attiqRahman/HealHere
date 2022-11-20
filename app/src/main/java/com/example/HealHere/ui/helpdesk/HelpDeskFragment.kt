package com.example.HealHere.ui.helpdesk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.HealHere.R
import com.example.HealHere.databinding.FragmentPersonalizedPlansBinding

class HelpDeskFragment : Fragment() {

    private var _binding: FragmentPersonalizedPlansBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPersonalizedPlansBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Inflate the layout for this fragment
        return root
    }
}