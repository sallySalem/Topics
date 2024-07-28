open class Vehicle(private val vehicleType: String) {
    fun showType() {
        println("$vehicleType is running")
    }
}

interface Engine {
    fun start()
    fun stop()
}

open class DieselEngine : Engine {

    override fun start() {
        println("DieselEngine is starting.")
    }

    override fun stop() {
        println("DieselEngine is Stopping.")
    }
}

open class ElectricEngine : Engine {
    fun startEngine() {
        println("ElectricEngine is started without interface")
    }

    override fun start() {
        println("ElectricEngine is starting.")
    }

    override fun stop() {
        println("ElectricEngine is Stopping.")
    }
}

class Car(vehicleType: String, private val engine: Engine) : Vehicle(vehicleType) {
    fun startCar() {
        println("Start Car")
        showType() // The implementation is in the "Vehicle" base class
        engine.start()
//        engine.startEngine() // Error: Unresolved reference: startEngine. Use only funs from interface.
    }
}



println("Start..")
val engine = ElectricEngine()
val car = Car("Red Car", ElectricEngine())
car.startCar()
car.showType() // Access base class fun
//car.startEngine() // Error: Unresolved reference
//car.start() // Error: Unresolved reference
//car.stop() // Error: Unresolved reference
engine.stop()
