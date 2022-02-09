package mx.kodemia.trycatch

import mx.kodemia.trycatch.exceptions.*

class SpaceCraft {
    private var isConnectionAvailable: Boolean = false

    private var isEngineInOrder: Boolean = false

    private var fuel: Int = 0

    private var windhsield: Boolean = false
    private var pressure: Int = 86

    var isInSpace: Boolean = false

    fun launch() {
        if (fuel < 5) {
            throw OutOfFuelException()
        }

        if (!isEngineInOrder) {
            throw BrokenEngineException()
        }

        if(pressure > 50){
            throw BrokenPressureSystemException()
        }

        if(!windhsield){
            throw BrokenWindshieldException()
        }

        if (!isConnectionAvailable) {
            throw SpaceToEarthConnectionFailedException()
        }

        sendMessageToEarth("Intentando el lanzamiento...")
        fuel -= 5
        isInSpace = true
        sendMessageToEarth("¡Estoy en el espacio!")
        sendMessageToEarth("¿Esos son extraterrestres?")
    }

    fun refuel() {
        fuel += 5
        sendMessageToEarth("El depósito de combustible está lleno")
    }

    fun repairEngine() {
        isEngineInOrder = true
        sendMessageToEarth("Los impulsores están en funcionamiento")
    }

    fun repairPressureSystem(){
        pressure -= 50
        sendMessageToEarth("El sistema de presurizacion a sido arreglada, niveles de presión adecuados!")
    }

    fun repairWindshield(){
        windhsield = true
        sendMessageToEarth("El parabrisas a sido arreglado!")
    }

    fun fixConnection() {
        isConnectionAvailable = true
        sendMessageToEarth("Tlatelolco, tlatelolco ¿Pueden escucharme?")
        sendMessageToEarth("La conexión se ha establecido")
    }

    fun land() {
        sendMessageToEarth("Aterrizando...")
        isInSpace = false
    }

    fun sendMessageToEarth(message: String) = println("Nave espacial a la tierra: $message")
}
