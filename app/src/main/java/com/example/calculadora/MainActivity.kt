package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.toSpanned
import com.google.android.material.button.MaterialButton

class MainActivity2 : AppCompatActivity() {

    var primNumero = ""
    var operation = ""
    var segNumero = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResult: TextView = findViewById(R.id.tv_result)
        val tvInput: TextView = findViewById(R.id.tv_input)

        val mbtNumberZero: MaterialButton = findViewById(R.id.mbt_number_zero)
        val mbtNumberOne: MaterialButton = findViewById(R.id.mbt_number_one)
        val mbtNumberTwo: MaterialButton = findViewById(R.id.mbt_number_two)
        val mbtNumberThree: MaterialButton = findViewById(R.id.mbt_number_three)
        val mbtNumberFour: MaterialButton = findViewById(R.id.mbt_number_four)
        val mbtNumberFive: MaterialButton = findViewById(R.id.mbt_number_five)
        val mbtNumberSix: MaterialButton = findViewById(R.id.mbt_number_six)
        val mbtNumberSeven: MaterialButton = findViewById(R.id.mbt_number_seven)
        val mbtNumberEight = findViewById<MaterialButton>(R.id.mbt_number_eight)
        val mbtNumberNine: MaterialButton = findViewById(R.id.mbt_number_nine)

        val mbtPercent: MaterialButton = findViewById(R.id.mbt_percent)
        val mbtDivision: MaterialButton = findViewById(R.id.mbt_division)
        val mbtMultiplication: MaterialButton = findViewById(R.id.mbt_multiplication)
        val mbtSubtraction: MaterialButton = findViewById(R.id.mbt_subtraction)
        val mbtAddition: MaterialButton = findViewById(R.id.mbt_addition)

        val mbtDot: MaterialButton = findViewById(R.id.mbt_dot)
        val mbtEqual: MaterialButton = findViewById(R.id.mbt_equal)
        val mbtBackspace: MaterialButton = findViewById(R.id.mbt_backspace)
        mbtBackspace.text = "C / Ce"

        //mandar o número do botão para o textView
        mbtNumberZero.setOnClickListener {
            if (tvInput.text == "" || tvInput.text == "0") {
                tvInput.text = "0"
            } else {
                tvInput.text = tvInput.text.toString() + "0"
            }
        }
        mbtNumberOne.setOnClickListener {
            if (tvInput.text == "0") {
                tvInput.text = "1"
            } else {
                tvInput.text = tvInput.text.toString() + "1"
            }
        }
        mbtNumberTwo.setOnClickListener {
            if (tvInput.text == "0") {
                tvInput.text = "2"
            } else {
                tvInput.text = tvInput.text.toString() + "2"
            }
        }
        mbtNumberThree.setOnClickListener {
            if (tvInput.text == "0") {
                tvInput.text = "3"
            } else {
                tvInput.text = tvInput.text.toString() + "3"
            }
        }
        mbtNumberFour.setOnClickListener {
            if (tvInput.text == "0") {
                tvInput.text = "4"
            } else {
                tvInput.text = tvInput.text.toString() + "4"
            }
        }
        mbtNumberFive.setOnClickListener {
            if (tvInput.text == "0") {
                tvInput.text = "5"
            } else {
                tvInput.text = tvInput.text.toString() + "5"
            }
        }
        mbtNumberSix.setOnClickListener {
            if (tvInput.text == "0") {
                tvInput.text = "6"
            } else {
                tvInput.text = tvInput.text.toString() + "6"
            }
        }
        mbtNumberSeven.setOnClickListener {
            if (tvInput.text == "0") {
                tvInput.text = "7"
            } else {
                tvInput.text = tvInput.text.toString() + "7"
            }
        }
        mbtNumberEight.setOnClickListener {
            if (tvInput.text == "0") {
                tvInput.text = "8"
            } else {
                tvInput.text = tvInput.text.toString() + "8"
            }
        }
        mbtNumberNine.setOnClickListener {
            if (tvInput.text == "0") {
                tvInput.text = "9"
            } else {
                tvInput.text = tvInput.text.toString() + "9"
            }
        }
        mbtDot.setOnClickListener {
            if (tvInput.text == "") {
                tvInput.text = "0."
            } else {
                tvInput.text = tvInput.text.toString() + "."
            }
        }

        //operações básicas do 0 ao 9
        mbtAddition.setOnClickListener {
            if (tvInput.text == "") {
                return@setOnClickListener
            } else {
                val pegaTextoInput = tvInput.text.toString()
                val juntaDuas = "$pegaTextoInput + "
                tvInput.text = "0"
                tvResult.text = juntaDuas
                primNumero = pegaTextoInput
                operation = "+"
            }
        }
        mbtSubtraction.setOnClickListener {
            if (tvInput.text == "") {
                return@setOnClickListener
            } else {
                val pegaTextoInput = tvInput.text.toString()
                val juntaDuas = "$pegaTextoInput - "
                tvInput.text = "0"
                tvResult.text = juntaDuas
                primNumero = pegaTextoInput
                operation = "-"
            }
        }
        mbtDivision.setOnClickListener {
            if (tvInput.text == "") {
                return@setOnClickListener
            } else {
                val pegaTextoInput = tvInput.text.toString()
                val juntaDuas = "$pegaTextoInput / "
                tvInput.text = "0"
                tvResult.text = juntaDuas
                primNumero = pegaTextoInput
                operation = "/"
            }
        }
        mbtMultiplication.setOnClickListener {
            if (tvInput.text == "") {
                return@setOnClickListener
            } else {
                val pegaTextoInput = tvInput.text.toString()
                val juntaDuas = "$pegaTextoInput * "
                tvInput.text = "0"
                tvResult.text = juntaDuas
                primNumero = pegaTextoInput
                operation = "*"
            }
        }

        mbtEqual.setOnClickListener {
            if (operation == "+") {
                segNumero = tvInput.text.toString()
                val resultConta = primNumero.toDouble() + segNumero.toDouble()
                tvResult.text = resultConta.toString()
            } else if (operation == "-") {
                segNumero = tvInput.text.toString()
                val resultConta = primNumero.toDouble() - segNumero.toDouble()
                tvResult.text = resultConta.toString()
            } else if (operation == "*") {
                segNumero = tvInput.text.toString()
                val resultConta = primNumero.toDouble() * segNumero.toDouble()
                tvResult.text = resultConta.toString()
            } else if (operation == "/") {
                segNumero = tvInput.text.toString()
                if (segNumero == "0") {
                    tvResult.text = "Não dividirás por Zero"
                } else {
                    val resultConta = primNumero.toDouble() / segNumero.toDouble()
                    tvResult.text = resultConta.toString()
                }
            }
            tvInput.text = "0"
        }
        mbtBackspace.setOnClickListener {
            tvInput.text = "0"
            tvResult.text = ""
        }
    }

}