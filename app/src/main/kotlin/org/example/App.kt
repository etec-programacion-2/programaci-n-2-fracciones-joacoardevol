
package org.example

fun main() {
    //Parte 1
    val f1 = Fraccion(-5, 3)
    f1.mostrar()

    //Parte 2
    val f2 = Fraccion(-4,6)
    println("La suma es: ${f1 + f2}")
    println("La resta es: ${f1 - f2}")

    //Parte 3
    println("La multiplicación es: ${f1 * f2}")
    println("La división es: ${f1 / f2}")

    //Parte 4
    println("La comparación es: ${f1.compareTo(f2)}")
    println("La igualdad es: ${f1 == f2}")
    println("f1 es mayor que f2: ${f1.esMayor(f2)}")
    println("f1 es menor que f2: ${f1.esMenor(f2)}")
    println("f1 es en decimal: ${f1.aDecimal()}")
    val d1 = 1.75
    println("f1 en fracción es: ${Fraccion.desdeDecimal(d1)}")

}

