Fraccion.kt : 
package org.example


class Fraccion(
   private var _numerador: Int,
   private var _denominador: Int
) {


   var numerador: Int
       get() = _numerador
       set(value) {
           _numerador = value
       }


   var denominador: Int
       get() = _denominador
       set(value) {
           _denominador = value
       }


   operator fun plus(otra: Fraccion): Fraccion {
       var nuevo_numerador = this._numerador * otra.
       _denominador + this._denominador * otra._numerador
       var nuevo_denominador = this._denominador * otra._denominador
      
       return Fraccion(nuevo_numerador, nuevo_denominador).simplificada()
   }   


   operator fun minus(otra: Fraccion): Fraccion {
       val nuevo_numerador = this._numerador * otra._denominador - this._denominador * otra._numerador
       val nuevo_denominador = this._denominador * otra._denominador
       return Fraccion(nuevo_numerador, nuevo_denominador).simplificada()
   }


   fun obtenesValor(): String {
       return toString()
   }


   override fun toString(): String {
       return "$numerador / $denominador"
   }


   private fun simplificar(): Fraccion {
       val mcd = mcd(numerador, denominador)
       return Fraccion(numerador / mcd, denominador / mcd)
   }
   private fun simplificada(): Fraccion {
       return this.simplificar()
   }
   private fun mcd(a: Int, b: Int): Int {
       return if (b == 0) a else mcd(b, a % b)
   }
}
