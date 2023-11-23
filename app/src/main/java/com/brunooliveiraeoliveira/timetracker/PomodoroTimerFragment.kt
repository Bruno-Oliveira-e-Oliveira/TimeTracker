package com.brunooliveiraeoliveira.timetracker

import android.opengl.Visibility
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brunooliveiraeoliveira.timetracker.databinding.FragmentPomodoroTimerBinding

class PomodoroTimerFragment : Fragment() {
    private lateinit var binding: FragmentPomodoroTimerBinding
    private var timer = 20
//    private val timerType = "POMODORO"
    private var timeInSeconds = 0
    private var running: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPomodoroTimerBinding.inflate(inflater, container, false)

        timeInSeconds = timer
        binding.startBtn.visibility = View.VISIBLE
        binding.stopBtn.visibility = View.GONE

        binding.startBtn.setOnClickListener {
            running = true
            binding.startBtn.visibility = View.GONE
            binding.stopBtn.visibility = View.VISIBLE
        }

        binding.stopBtn.setOnClickListener {
            running = false
            binding.startBtn.visibility = View.VISIBLE
            binding.stopBtn.visibility = View.GONE
        }

        binding.resetBtn.setOnClickListener {
            running = false
            timeInSeconds = timer
            binding.startBtn.visibility = View.VISIBLE
            binding.stopBtn.visibility = View.GONE
        }

        runTimer()

        return binding.root
    }

    private fun runTimer() {
        val handler = Handler(Looper.getMainLooper())  //--- TODO - Use another thread

        handler.post(object : Runnable {
            override fun run() {
                val hours: Int = timeInSeconds / 3600
                val minutes: Int = (timeInSeconds % 3600) / 60
                val seconds: Int = timeInSeconds % 60
                val time: String = String.format("%02d:%02d:%02d", hours, minutes, seconds)

                binding.timeTxt.text = time

                if (running && timeInSeconds > 0) {
                    timeInSeconds--
                }

                handler.postDelayed(this, 1000)
            }
        })
    }
}