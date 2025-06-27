package org.example

fun main() {
    println("Hola app!")

    val f1 = Fraccion(2, 3)
    val f2 = Fraccion(1, 6)

    println("Fracción 1: $f1")
    println("Fracción 2: $f2")

    val suma = f1 + f2
    val resta = f1 - f2
    val producto = f1 * f2
    val division = f1 / f2

    println("Suma: $suma")
    println("Resta: $resta")
    println("Multiplicación: $producto")
    println("División: $division")
}

class Fraccion(numerador: Int, denominador: Int) {

    var numerador: Int = numerador
        get() = field
        set(value) {
            field = value
        }

    var denominador: Int = denominador
        get() = field
        set(value) {
            if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
            field = value
        }

    init {
        if (denominador == 0) {
            throw IllegalArgumentException("El denominador no puede ser cero")
        }
        simplificar()
    }

    override fun toString(): String {
        return "$numerador/$denominador"
    }

    fun mostrar() {
        println(toString())
    }

    operator fun plus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.denominador + this.denominador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun minus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.denominador - this.denominador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun times(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun div(otra: Fraccion): Fraccion {
        if (otra.numerador == 0) {
            throw IllegalArgumentException("No se puede dividir por una fracción con numerador cero (equivale a dividir por cero).")
        }
        val nuevoNumerador = this.numerador * otra.denominador
        val nuevoDenominador = this.denominador * otra.numerador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    private fun simplificar() {
        val mcd = mcd(kotlin.math.abs(numerador), kotlin.math.abs(denominador))
        numerador /= mcd
        denominador /= mcd

        if (denominador < 0) {
            numerador *= -1
            denominador *= -1
        }
    }

    private fun mcd(a: Int, b: Int): Int {
        return if (b == 0) a else mcd(b, a % b)
    }
}
