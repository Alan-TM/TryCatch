package mx.kodemia.trycatch

import mx.kodemia.trycatch.exceptions.*

object Spaceport {
    fun investigateSpace(spaceCraft: SpaceCraft) {
        try {
            spaceCraft.launch()
        } catch (exception: OutOfFuelException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.refuel()
        } catch (exception: BrokenEngineException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.repairEngine()
        } catch (exception: BrokenPressureSystemException){
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.repairPressureSystem()
        }
        catch (exception: BrokenWindshieldException){
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.repairWindshield()
        }
        catch (exception: SpaceToEarthConnectionFailedException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.fixConnection()
        } finally {
            if (spaceCraft.isInSpace) {
                spaceCraft.land()
            } else {
                investigateSpace(spaceCraft)
            }
        }
    }
}