package com.example.coroutines_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    private val TAG = "ActividadPrincipal"
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


          GlobalScope.launch (Dispatchers.IO) {
          val time = measureTimeMillis {
              val  respuesta1 = getInternetInfo(1)
              val  respuesta2 = getInternetInfo(2)

              Log.d(TAG, respuesta1 )
              Log.d(TAG, respuesta2)
          }
          Log.d(TAG, "Tiempo Transcurrido $time")

      }

      /*  GlobalScope.launch (Dispatchers.IO) {
            val time = measureTimeMillis {
                val job1 = async { getInternetInfo(1) }
                val job2 = async { getInternetInfo(2) }
                job1.join()
                job2.join()
                Log.d(TAG, job1.await())
                Log.d(TAG, job2.await())
            }
            Log.d(TAG, "Tiempo Transcurrido $time")

        }*/

    }

    suspend fun getInternetInfo(num: Int) :String {
        delay(3000)
        return "Respuesta desde internet $num"
    }
}