package com.gincana.model

import android.util.Log

class Validate {

    fun checkisEmpty(vararg inputs: String): Boolean {
        var empty:Boolean = false
        var contador: Int=0
        Log.d("Funcion checkinputs", "ENTRO VAMOS ARGENTINA VAMOS MESSI CARAJO")
        while(contador<inputs.size && !empty){
            Log.d("Input", inputs[contador])
            if (inputs[contador].isEmpty()) {
                empty = true
                Log.d("EMPTYINPUT", inputs[contador])
            }
            contador++
        }

        return empty
    }
}