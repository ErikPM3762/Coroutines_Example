package com.example.coroutines_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "ActividadPrincipal"
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Funcion Main iniciada")

        GlobalScope.launch {
            val respuesta  = getInternetInfo()
            Log.d(TAG, respuesta)
        }

      /*  GlobalScope.launch {
            Log.d(TAG, "Corriendo corrutinas en el subproceso: ${Thread.currentThread().name} ")
            delay(1000) //Esta es una funcion suspendible que indica el tiempo de espera
            Log.d(TAG, "Mundo! ")
        }
        Log.d(TAG, "Corriendo codigo en el subproceso: ${Thread.currentThread().name} ")
        Log.d(TAG, "Hola")*/
    }

    suspend fun getInternetInfo() :String {
        delay(2000)
        return "Respuesta desde internet"
    }
}