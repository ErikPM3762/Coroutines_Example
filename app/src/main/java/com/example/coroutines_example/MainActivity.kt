package com.example.coroutines_example
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
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

       Ejectutar.setOnClickListener {
           lifecycleScope.launch {
               while (true) {
                   delay(1000)
                   Log.d(TAG, "Corriendo Corrutina")
               }
           }
           GlobalScope.launch {
               delay(5000)
               Intent(this@MainActivity, MainActivity2:: class.java).also {
                   startActivity(it)
                   finish()
               }

           }
       }
    }
}