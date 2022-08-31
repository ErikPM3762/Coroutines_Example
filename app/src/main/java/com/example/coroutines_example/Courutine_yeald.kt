package com.example.coroutines_example

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main () {
    println("Funcion Main Iniciada")

    runBlocking {
        launch { suspendTask1() }
        launch { suspendTask2() }
    }
    println("Funcion Main Terminada")
}
suspend fun suspendTask1() {
    println("Tarea 1 iniciada en el subproceso : ${Thread.currentThread().name}")
    yield()
    println("Tarea 1 finalizada en el subproceso : ${Thread.currentThread().name}")
}

suspend fun suspendTask2() {
    println("Tarea 2 iniciada en el subproceso : ${Thread.currentThread().name}")
    yield()
    println("Tarea 2 finalizada en el subproceso : ${Thread.currentThread().name}")
}