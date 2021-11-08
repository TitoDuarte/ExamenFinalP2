package com.example.humbertoduarte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton1= findViewById<Button>(R.id.infobt)
        boton1.setOnClickListener{
            val lanzar = Intent(this, Informacion:: class.java)
            startActivity(lanzar)
        }

        unobt.setOnClickListener {numeroPresionado (Digito = "1")}
        dosbt.setOnClickListener {numeroPresionado (Digito = "2")}
        tresbt.setOnClickListener {numeroPresionado (Digito = "3")}
        cuatrobt.setOnClickListener {numeroPresionado (Digito = "4")}
        cincobt.setOnClickListener {numeroPresionado (Digito = "5")}
        seisbt.setOnClickListener {numeroPresionado (Digito = "6")}
        sietebt.setOnClickListener {numeroPresionado (Digito = "7")}
        ochobt.setOnClickListener {numeroPresionado (Digito = "8")}
        nuevebt.setOnClickListener {numeroPresionado (Digito = "9")}
        cerobt.setOnClickListener {numeroPresionado (Digito = "0")}

        sumabt.setOnClickListener {operacionPresionada(Suma)}
        restabt.setOnClickListener {operacionPresionada(Resta)}
        multiplicacionbt.setOnClickListener {operacionPresionada(Multipliacacion)}
        divisionbt.setOnClickListener {operacionPresionada(Division)}

        clearbt.setOnClickListener{
            num1 = 0.0
            num2 = 0.0
            resultextView.text = "0"
            operacion= No_Operacion
        }

        igualbt.setOnClickListener{
            var resultado = when (operacion){
                Suma -> num1 + num2
                Resta -> num1 - num2
                Multipliacacion -> num1 * num2
                Division -> num1 / num2
                else -> 0
            }
            resultextView.text = resultado.toString()
        }

    }
    private fun numeroPresionado(Digito: String) {
        resultextView.text = "${resultextView.text}$Digito"

        if (operacion == No_Operacion){
            num1 = resultextView.text.toString().toDouble()
        }else {
            num2 = resultextView.text.toString().toDouble()
        }
    }

    private fun operacionPresionada(operacion: Int){
        this.operacion = operacion


        resultextView.text = "0"

    }

    companion object {
        const val Suma = 1
        const val Resta = 2
        const val Multipliacacion = 3
        const val Division = 4
        const val No_Operacion = 5
    }

}