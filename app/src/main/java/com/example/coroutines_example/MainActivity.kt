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

        Log.d(TAG, "Funcion Main Iniciada")

        runBlocking {
            Log.d(TAG, "Iniciando corrutina con : ${Thread.currentThread().name} con runblocking")
            delay(2000)
            Log.d(TAG, "Finalizando corrutina con: ${Thread.currentThread().name} con runblocking")
        }
        Log.d(TAG, "Funcion Main FInalizada")

        
       /* GlobalScope.async {
            val suma1 = async {
                suma (2, 5)
            }

            val suma2 = async {
                suma (8, 2)
            }

            val total = suma (suma1.await(), suma2.await())
            Log.d(TAG, "TOTAL: $total")

        }*/

       /* val job = GlobalScope.launch {
            Log.d(TAG,"Corrutina Iniciada")
            delay(5000)
            Log.d(TAG, "Corrutina terminada")
        }
        Ejectutar.setOnClickListener {
            job.cancel()
            Log.d(TAG, "Corrutina Cancelada")
        }*/
    }
}
 fun suma (num1 : Int, num2 : Int) = num1 + num2