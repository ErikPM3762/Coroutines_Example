package com.example.coroutines_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val TAG = "ActividadPrincipal"

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Funcion Main iniciada")

        Ejectutar.setOnClickListener {
            GlobalScope.launch (Dispatchers.Main){
                Log.d(TAG, "Corrutina #1 Iniciada")
            //    Thread.sleep(5000) Con este codigo no permite pasar a la corrutina numero dos
                // ya que esta esperando a terminar el proceso.
                delay(5000)
                Log.d(TAG, "Corrutina #1 Finalizada")
            }

            GlobalScope.launch (Dispatchers.Main){
                Log.d(TAG, "Corrutina #2")
            }

        }

    }

}