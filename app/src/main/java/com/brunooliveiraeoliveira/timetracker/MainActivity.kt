package com.brunooliveiraeoliveira.timetracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.room.Room
import com.brunooliveiraeoliveira.timetracker.database.AppDatabase
import com.brunooliveiraeoliveira.timetracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // TODO - Verificar como fazer a parametrização do nome do banco de dados
        val db = Room.databaseBuilder(
            applicationContext, AppDatabase::class.java, "database"
        ).build()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.pomodoroTimerFragment)

    }
}