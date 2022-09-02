package com.example.coroutines_example

import kotlinx.coroutines.*
import java.lang.RuntimeException

fun main () = runBlocking {

    val exeptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Exepcion cachada...")
    }

    val coroutineScope = CoroutineScope(Dispatchers.Unconfined + exeptionHandler)

    val job1 = coroutineScope.launch {
        println("Job1 Started")
        delay(100)
        throw  RuntimeException()

    }
    val job2 = coroutineScope.launch {
        println("Job2 Started")
        delay(200)
        println("Job2 Finalizada")

    }
    Thread.sleep(2000)

    println("Job1 -> ${job1.status()}")
    println("Job2 -> ${job2.status()}")
    println("Job Padre Continua Activo -> ${coroutineScope.isActive}")

}

fun Job.status () : String = when {
    isCancelled -> "Cancelado"
    isActive -> "Activo"
    isCompleted -> "Completado"
    else -> "Nada"
}