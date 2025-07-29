package org.example
import kotlin.math.round
import kotlin.math.pow

class Fraccion(
    // Se declaran los atributos / variables como privadas
    private var _numerador: Int,
    private var _denominador: Int) {

    // Se les da el valor a las variables
    var numerador: Int = _numerador
        get() = field
        set(value) { field = value }

    var denominador: Int = _denominador
        get() = field
        set(value) { field = value
        }

    // Excepción si denominador == 0
    init { if (denominador == 0){
        throw IllegalArgumentException("El denominador no puede ser cero")}}

    // Sobre escribe Metodo / función para mostrar por pantalla la fracción
    override fun toString(): String {
        return ("$_numerador/$_denominador")
    }

    // Muestra por pantalla la función toString
    fun mostrar(){
        println(this.toString())
    }

    private fun _simplificar(numerador: Int, denominador: Int): Fraccion{ //Devuelve el MCD
        var numSim = numerador
        var denSim = denominador

        while (denSim != 0) {
            val temp = denSim
            denSim = numSim % denSim
            numSim = temp
        }
        val resultN: Int = (numerador / numSim)
        val resultD: Int = (denominador / numSim)

        return Fraccion(resultN,resultD )
    }

    // Le enseña a la clase como hacer la SUMA de fracciónes
    operator fun plus(otra: Fraccion): Fraccion { //plus es una palabra reservada

        val sumaNumerador = (this.numerador * otra.denominador) + (otra.numerador * this.denominador)
        val sumaDenominador = this.denominador * otra.denominador

        return _simplificar(sumaNumerador, sumaDenominador)
    }

    // Le enseña a la clase como hacer la RESTA de fracciónes
    operator fun minus(otra: Fraccion): Fraccion { //minus es una palabra reservada

        val restaNumerador = (this.numerador * otra.denominador) - (otra.numerador * this.denominador)
        val restaDenominador = this.denominador * otra.denominador

        return _simplificar(restaNumerador, restaDenominador)
    }

    // Le enseña a la clase como hacer la MULTIPLICACIÓN de fracciónes
    operator fun times(otra: Fraccion): Fraccion { //times es una palabra reservada
        val multiNumerador = this.numerador * otra.numerador
        val multiDenominador = this.denominador * otra.denominador

        return _simplificar(multiNumerador, multiDenominador)
    }

    // Le enseña a la clase como hacer la DIVISIÓN de fracciónes
    operator fun div(otra: Fraccion): Fraccion{ //div es una palabra reservada
        if (otra.numerador == 0){
            throw IllegalArgumentException("El numerador de la segunda fracción no puede ser cero")
        }

        val diviNumerador = this.numerador * otra.denominador
        val diviDenominador = this.denominador * otra.numerador

        return _simplificar(diviNumerador, diviDenominador)
    }

    // Le enseña a la clase como hacer la COMPARACIÓN de fracciónes
    operator fun compareTo(otra: Fraccion): Int { //compareTo es una palabra reservada
        val comparaFraccion = (this.numerador/this.denominador).compareTo(otra.numerador/otra.denominador)
        return (comparaFraccion)
    }

    // sobrescribe el metodo para la VERIFICACIÓN DE IGUALDAD de fracciónes
    override fun equals(other: Any?): Boolean { //equals es una palabra reservada
        if (this === other){ // compara si los objetos son los mismos en memoria
            return true
        }

        if (other !is Fraccion) { // si other no es un objeto de la clase que retorne false
            return false
        }

        return this.numerador / this.denominador == other.numerador / other.denominador
    }

    fun esMayor(otra: Fraccion): Boolean { // Retorna true si es mayor
        if (this > otra){
            return true
        }
        return false
    }

    fun esMenor(otra: Fraccion): Boolean { // Retorna true si es menor
        if (this < otra){
            return true
        }
        return false
    }

    fun aDecimal(): Double{ // Retorna la fracción como decimal
        return round((numerador.toDouble() / denominador.toDouble())* 1000) / 1000
    }

    companion object{ // No se necesita crear un objeto para usarla (puedo llamar con un double y que retorne una Fraccion)

        //Esta función es solo por que no puedo llamar a la otra dentro de companion object
        fun simplificar(numerador: Int, denominador: Int): Fraccion{ //Devuelve el MCD
            var numSim = numerador
            var denSim = denominador

            while (denSim != 0) {
                val temp = denSim
                denSim = numSim % denSim
                numSim = temp
            }
            val resultN: Int = (numerador / numSim)
            val resultD: Int = (denominador / numSim)

            return Fraccion(resultN,resultD )
        }


        fun desdeDecimal(decimal: Double): Fraccion{ // Devuelve una Fracción

            // Divide los decimales del entero
            val numStr: String = decimal.toString()
            val decimasStr: String = numStr.substring(numStr.indexOf('.') + 1 )
            var numDecimas: Int = 0
            for (i in decimasStr){
                numDecimas += 1
            }

            // Convierte el Double en Fracción
            val resulNumerador = (decimal * 10.0.pow(numDecimas)).toInt()
            val resulDenominador = (10.0.pow(numDecimas)).toInt()
            return this.simplificar(resulNumerador, resulDenominador)
        }
    }

}

    //Muestra por pantalla la función toString
    fun mostrar(){
        println(this.toString())
    }

    private fun _simplificar(numerador: Int, denominador: Int): Fraccion{ //Devuelve el MCD
        var numSim = numerador
        var denSim = denominador
        while (denSim != 0) {
            val temp = denSim
            denSim = numSim % denSim
            numSim = temp
        }
        val resultN: Int = (numerador / numSim)
        val resultD: Int = (denominador / numSim)
        return Fraccion((numerador / numSim), (denominador / numSim))
    }

    //Le enseña a la clase como hacer la SUMA de fracciónes
    operator fun plus(otra: Fraccion): Fraccion { //plus es una palabra reservada

        val sumaNumerador = (this.numerador * otra.denominador) + (otra.numerador * this.denominador)
        val sumaDenominador = this.denominador * otra.denominador

        return _simplificar(sumaNumerador, sumaDenominador)
    }

    //Le enseña a la clase como hacer la RESTA de fracciónes
    operator fun minus(otra: Fraccion): Fraccion { //minus es una palabra reservada

        val restaNumerador = (this.numerador * otra.denominador) - (otra.numerador * this.denominador)
        val restaDenominador = this.denominador * otra.denominador

        return _simplificar(restaNumerador, restaDenominador)
    }

    //Le enseña a la clase como hacer la MULTIPLICACIÓN de fracciónes
    operator fun times(otra: Fraccion): Fraccion { //times es una palabra reservada
        val multiNumerador = this.numerador * otra.numerador
        val multiDenominador = this.denominador * otra.denominador

        return _simplificar(multiNumerador, multiDenominador)
    }

    //Le enseña a la clase como hacer la DIVISIÓN de fracciónes
    operator fun div(otra: Fraccion): Fraccion{ //div es una palabra reservada
        if (otra.numerador == 0){
            throw IllegalArgumentException("El numerador de la segunda fracción no puede ser cero")
        }

        val diviNumerador = this.numerador * otra.denominador
        val diviDenominador = this.denominador * otra.numerador

        return _simplificar(diviNumerador, diviDenominador)
    }
}
