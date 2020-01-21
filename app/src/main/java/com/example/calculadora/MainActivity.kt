package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var ban:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ban=0

        //numbers
        tv1_1.setOnClickListener {mostrar_operacion("1")}
        tv1_2.setOnClickListener {mostrar_operacion("2")}
        tv1_3.setOnClickListener {mostrar_operacion("3")}

        tv2_1.setOnClickListener {mostrar_operacion("4")}
        tv2_2.setOnClickListener {mostrar_operacion("5")}
        tv2_3.setOnClickListener {mostrar_operacion("6")}

        tv3_1.setOnClickListener {mostrar_operacion("7")}
        tv3_2.setOnClickListener {mostrar_operacion("8")}
        tv3_3.setOnClickListener {mostrar_operacion("9")}

        tv4_2.setOnClickListener {mostrar_operacion("0")}


        //operadores


        tv1_4.setOnClickListener { if(ban==0)mostrar_operacion("+");ban = 1 }
        tv2_4.setOnClickListener { if(ban==0)mostrar_operacion("-");ban = 1 }
        tv3_4.setOnClickListener { if(ban==0)mostrar_operacion("*");ban = 1 }
        tv4_4.setOnClickListener { if(ban==0)mostrar_operacion("/");ban = 1 }

        //punto
        tv4_1.setOnClickListener {mostrar_operacion(".")}
        //igual
        tv4_3.setOnClickListener {calcular();ban=0}


        //ce
        b_ce.setOnClickListener { tvValor.text="";ban=0 }





    }

    fun mostrar_operacion(carac:String)
    {
        tvValor.text=tvValor.text.toString()+carac
    }

    fun calcular(){

        var operacion:String=tvValor.text.toString()
        var num1:String=""
        var num2:String=""

        var banNum1=1
        var banNum2=0
        var signo ='+'
        for (i in 0..(operacion.length-1)){


            if (operacion.get(i)=='+' || operacion.get(i)=='-'|| operacion.get(i)=='*'|| operacion.get(i)=='/' && num1==""){

                banNum2=1
                banNum1=0
                signo= operacion.get(i)

            }


            else{
                if(banNum1==1){
                    num2=""
                    num1=num1+operacion.get(i)}
                else if (banNum2==1){
                    num2=num2+operacion.get(i)}


            }


        }


        if(num1 != "" && num2 != "") {
            var numero1: Double = num1.toDouble()
            var numero2: Double = num2.toDouble()

            var resul: Double = 0.0

            if (signo == '+'){
                resul = numero1 + numero2
                tvValor.text = resul.toString()}

            else if (signo == '-'){
                resul = numero1 - numero2
                tvValor.text = resul.toString()}

            else if (signo == '*'){
                resul = numero1 * numero2
                tvValor.text = resul.toString()}

            else if (signo == '/'){
                if(numero2==0.0){
                    tvValor.text="Error"
                }
                else{
                    resul = numero1 / numero2
                    tvValor.text = resul.toString()}

            }

        }
    }

}
