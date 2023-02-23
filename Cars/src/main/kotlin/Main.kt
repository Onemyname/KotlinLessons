fun main(args: Array<String>) {
   val car: SpeedCar = SpeedCar(300,"Bugatti", Engine("Diezel",700))
    println(car.toString())
    val standartCar = SpeedCar(100,"Lada")
    println(standartCar.toString())

    car.runEngine()
    println(car.engine.isRunned)
}

abstract class Car {
    abstract val modelName: String
}

class SpeedCar  : Car, Moveable{
    var speed = 100
    override var engine : Engine = Engine("Benzin", 100)
    override var modelName: String = "Standart Speed Car"
    constructor( speed: Int, modelName: String){
        this.speed = speed
        this.modelName = modelName
    }
    constructor( speed: Int,modelName: String, engine : Engine) {
        this.speed = speed
        this.modelName  = modelName
        this.engine = engine
    }

    override fun toString(): String {
        return "SpeedCar(speed=$speed, engine=$engine, modelName='$modelName')"
    }

}

class Engine (val fuel : String, val horsesPower : Int){
    var isRunned : Boolean = false
    override fun toString(): String {
        return "Engine(fuel='$fuel', horsesPower=$horsesPower)"
    }

}
