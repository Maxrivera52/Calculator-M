package com.example.calculadoram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private var prevnumber:String = "0"
    private var dispNumber:String = "0"
    private var operating:Boolean = false
    private var currentOperator:String = ""

    private lateinit var tvdisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        super.getSupportActionBar()?.hide()
        val btn0 = findViewById<Button>(R.id.btnnumber0)
        val btn1 = findViewById<Button>(R.id.btnnumber1)
        val btn2 = findViewById<Button>(R.id.btnnumber2)
        val btn3 = findViewById<Button>(R.id.btnnumber3)
        val btn4 = findViewById<Button>(R.id.btnnumber4)
        val btn5 = findViewById<Button>(R.id.btnnumber5)
        val btn6 = findViewById<Button>(R.id.btnnumber6)
        val btn7 = findViewById<Button>(R.id.btnnumber7)
        val btn8 = findViewById<Button>(R.id.btnnumber8)
        val btn9 = findViewById<Button>(R.id.btnnumber9)
        val btnsum =findViewById<Button>(R.id.btnplus)
        val btnminus = findViewById<Button>(R.id.btnminus)
        val btnmultiply = findViewById<Button>(R.id.btnmultiply)
        val btndivide = findViewById<Button>(R.id.btndivide)
        val btnequals = findViewById<Button>(R.id.btnequals)
        val btndel = findViewById<Button>(R.id.btndel)
        this.tvdisplay = findViewById(R.id.tvdisplay)

        //Setting functionality
        btn0.setOnClickListener { this.touchNumber(0) }
        btn1.setOnClickListener { this.touchNumber(1) }
        btn2.setOnClickListener { this.touchNumber(2) }
        btn3.setOnClickListener { this.touchNumber(3) }
        btn4.setOnClickListener { this.touchNumber(4) }
        btn5.setOnClickListener { this.touchNumber(5) }
        btn6.setOnClickListener { this.touchNumber(6) }
        btn7.setOnClickListener { this.touchNumber(7) }
        btn8.setOnClickListener { this.touchNumber(8) }
        btn9.setOnClickListener { this.touchNumber(9) }
        //Opertions
        btndel.setOnClickListener { this.deleteString() }

        //establecer funcionamiento de botón igual, debe restablecer la variable currentOperator a ""
        btnequals.setOnClickListener { this.equalsOperator()}
        //crear funcion operatorSelect que reciba como parámetro el operador string y lo interprete dentro de la misma.
        //también modifica el valor de la variable currentOperator
        btnsum.setOnClickListener { this.addOperator() }
        btnminus.setOnClickListener { this.minusOperator() }
        btnmultiply.setOnClickListener { this.multiplyOperator() }
        btndivide.setOnClickListener { this.divideOperator() }

    }

    private fun touchNumber(n:Number,tvdisplay:TextView = this.tvdisplay){
        if(this.dispNumber.length<9){
            if(this.operating && this.dispNumber.length>1){
                this.tvdisplay.text=""
                this.dispNumber = "0"
            }
            if(this.dispNumber=="0") this.dispNumber = n.toString()
            else this.dispNumber += n.toString()
            tvdisplay.text = this.dispNumber
            //this.currentnumber = (this.currentnumber.toString() + n.toString()).toDouble()
        }
    }

    private fun deleteString(tvdisplay: TextView = this.tvdisplay){
        if(this.dispNumber.length==1) {
            tvdisplay.text = "0"
            this.dispNumber = "0"
        }else{
            this.dispNumber = this.dispNumber.substring(0, dispNumber.length - 1)
            tvdisplay.text = this.dispNumber
        }
    }

    private fun equalsOperator(){
        when (currentOperator){
            "+"-> this.addOperator()
            "-"-> this.minusOperator()
            "x"-> this.multiplyOperator()
            "/"-> this.divideOperator()
        }
        this.operating = false
        this.currentOperator = ""
    }

    private fun addOperator() {
        this.currentOperator = "+"
        this.operating = true
        //set to back the current number
        this.prevnumber = this.dispNumber
        this.prevnumber = (this.dispNumber.toInt() + this.prevnumber.toInt()).toString()
        this.tvdisplay.text = this.prevnumber
    }

    private fun minusOperator() {
        this.currentOperator = "-"
        if (!this.operating){
            this.operating = true
            this.prevnumber = this.dispNumber
        }else{
            this.dispNumber = (this.dispNumber.toDouble() + this.prevnumber.toDouble()).toString()
            this.tvdisplay.text = this.dispNumber
        }
    }

    private fun multiplyOperator() {
        this.currentOperator = "x"
        if (!this.operating){
            this.operating = true
            this.prevnumber = this.dispNumber
        }else{
            this.dispNumber = (this.dispNumber.toDouble() + this.prevnumber.toDouble()).toString()
            this.tvdisplay.text = this.dispNumber
        }
    }

    private fun divideOperator() {
        this.currentOperator = "/"
        if (!this.operating){
            this.operating = true
            this.prevnumber = this.dispNumber
        }else{
            this.dispNumber = (this.dispNumber.toDouble() + this.prevnumber.toDouble()).toString()
            this.tvdisplay.text = this.dispNumber
        }
    }


}