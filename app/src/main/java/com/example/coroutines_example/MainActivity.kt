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

        GlobalScope.launch(Dispatchers.IO) {
            val respuesta = getInfoInternet()
            withContext(Dispatchers.Main) {
            txt_info.text= respuesta
            }
        }

    }
    suspend fun getInfoInternet() : String {
        delay(3000)
        return "Respuesta de internet"

    }
}