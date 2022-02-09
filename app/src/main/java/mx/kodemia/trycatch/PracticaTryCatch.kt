package mx.kodemia.trycatch

import java.lang.Exception

fun main(){
    /*
    Leer de la consola un dato y convertirlo en un número
    Si es posible, multiplicarlo por 5 e imprimirlo
    Si ocurre una excepción, atraparla e imprimir un mensaje explicativo
     */

    primerEjercicio()

    /*
    El usuario debe ingresar cuántos kilométros corrió el día de hoy
    Convertir el valor en millas
    Manejar cualquier excepción que pueda ocurrir
    1 kilometro = 0.62 millas
     */

   segundoEjercicio()

    /*
    Un cliente le dice al programa que producto quiere comprar
    después le dice cuántos productos quiere
    Si el precio es de 14.99
    ¿Cuál es el total?
    Manejar cualquier excepción que pueda ocurrir
     */

    tercerEjercicio()
}

fun primerEjercicio(){
    println("Ingresa un numero: ")
    try{
        val numero = readLine()?.toInt()
        println("El resultado de $numero * 5 es: ${numero!!*5}")
    } catch(e: Exception){
        println("Por favor ingresa solo numeros")
        println(e.message)
    }
}

fun segundoEjercicio(){
    println("Kilometros recorridos: ")
    try{
        val kilometros = readLine()?.toDouble()
        println("$kilometros km : ${kilometros!!*0.62} millas")
    } catch(e: Exception){
        println("Ingresa solamente el numero de kilometros")
    }
}

fun tercerEjercicio(){
    println("Producto: ")
    val producto = readLine()
    val precio = 14.99
    println("Cantidad: ")
    try{
        val cantidad = readLine()?.toInt()
        println("Producto: $producto\nCantidad: $cantidad\nTotal: ${cantidad!! * precio}")
    } catch(e: Exception){
        println("Ocurrio un error en la cantidad")
    }
}