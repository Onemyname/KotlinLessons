interface Moveable {
    var engine : Engine
    fun runEngine(){
        println("Двигатель запущен")
        this.engine.isRunned = true
    }
    fun stopEngine() {
        println("Двигатель остановлен")
        this.engine.isRunned = true
    }
}