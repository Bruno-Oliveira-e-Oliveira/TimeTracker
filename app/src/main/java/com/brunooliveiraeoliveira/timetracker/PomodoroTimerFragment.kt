package com.brunooliveiraeoliveira.timetracker

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brunooliveiraeoliveira.timetracker.databinding.FragmentPomodoroTimerBinding

class PomodoroTimerFragment : Fragment() {
    private lateinit var binding: FragmentPomodoroTimerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPomodoroTimerBinding.inflate(inflater, container, false)

        val timeInSeconds = 0 //125324

        val hours: Int = timeInSeconds / 3600
        val minutes: Int = (timeInSeconds % 3600) / 60
        val seconds: Int = timeInSeconds % 60
        val time: String = String.format("%02d:%02d:%02d", hours, minutes, seconds)

        binding.timeTxt.text = time

        return binding.root
    }
}