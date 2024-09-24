package com.example.guard.ui.dashboard.mode1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.guard.databinding.FragmentDashboardMode1Binding

class Mode1Fragment : Fragment() {

    private var _binding: FragmentDashboardMode1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mode1ViewModel = ViewModelProvider(this).get(Mode1ViewModel::class.java)

        _binding = FragmentDashboardMode1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        mode1ViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
