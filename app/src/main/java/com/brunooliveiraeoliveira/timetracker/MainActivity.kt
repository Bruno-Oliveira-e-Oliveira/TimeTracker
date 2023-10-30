package com.brunooliveiraeoliveira.timetracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.brunooliveiraeoliveira.timetracker.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.Time
import java.time.OffsetDateTime

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


        binding.button.setOnClickListener {

        }

        binding.button2.setOnClickListener {

        }


    }
}