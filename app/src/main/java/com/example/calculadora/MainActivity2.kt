package com.example.calculadora

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    var tvResult: TextView? = null
    var tvInput: TextView? = null

    var mbtNumberZero: MaterialButton? = null
    var mbtNumberOne: MaterialButton? = null
    var mbtNumberTwo: MaterialButton? = null
    var mbtNumberThree: MaterialButton? = null
    var mbtNumberFour: MaterialButton? = null
    var mbtNumberFive: MaterialButton? = null
    var mbtNumberSix: MaterialButton? = null
    var mbtNumberSeven: MaterialButton? = null
    var mbtNumberEight: MaterialButton? = null
    var mbtNumberNine: MaterialButton? = null

    var mbtPercent: MaterialButton? = null
    var mbtDivision: MaterialButton? = null
    var mbtMultiplication: MaterialButton? = null
    var mbtSubtraction: MaterialButton? = null
    var mbtAddition: MaterialButton? = null

    var mbtDot: MaterialButton? = null
    var mbtEqual: MaterialButton? = null
    var mbtBackspace: MaterialButton? = null

    var primNumero = ""
    var operation = ""
    var segNumero = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()

        numbersAndDotClickListeners()
        operationsClickListeners()
    }

    private fun initializeViews() {
        tvResult = findViewById(R.id.tv_result)
        tvInput = findViewById(R.id.tv_input)

        mbtNumberZero = findViewById(R.id.mbt_number_zero)
        mbtNumberOne = findViewById(R.id.mbt_number_one)
        mbtNumberTwo = findViewById(R.id.mbt_number_two)
        mbtNumberThree = findViewById(R.id.mbt_number_three)
        mbtNumberFour = findViewById(R.id.mbt_number_four)
        mbtNumberFive = findViewById(R.id.mbt_number_five)
        mbtNumberSix = findViewById(R.id.mbt_number_six)
        mbtNumberSeven = findViewById(R.id.mbt_number_seven)
        mbtNumberEight = findViewById(R.id.mbt_number_eight)
        mbtNumberNine = findViewById(R.id.mbt_number_nine)

        mbtPercent = findViewById(R.id.mbt_percent)
        mbtDivision = findViewById(R.id.mbt_division)
        mbtMultiplication = findViewById(R.id.mbt_multiplication)
        mbtSubtraction = findViewById(R.id.mbt_subtraction)
        mbtAddition = findViewById(R.id.mbt_addition)

        mbtDot = findViewById(R.id.mbt_dot)
        mbtEqual = findViewById(R.id.mbt_equal)
        mbtBackspace = findViewById(R.id.mbt_backspace)
    }

    private fun numbersAndDotClickListeners() {
        mbtNumberZero?.setOnClickListener {
            concatenateNumbers(number = "0")
        }
        mbtNumberOne?.setOnClickListener {
            concatenateNumbers(number = "1")
        }
        mbtNumberTwo?.setOnClickListener {
            concatenateNumbers(number = "2")
        }
        mbtNumberThree?.setOnClickListener {
            concatenateNumbers(number = "3")
        }
        mbtNumberFour?.setOnClickListener {
            concatenateNumbers(number = "4")
        }
        mbtNumberFive?.setOnClickListener {
            concatenateNumbers(number = "5")
        }
        mbtNumberSix?.setOnClickListener {
            concatenateNumbers(number = "6")
        }
        mbtNumberSeven?.setOnClickListener {
            concatenateNumbers(number = "7")
        }
        mbtNumberEight?.setOnClickListener {
            concatenateNumbers(number = "8")
        }
        mbtNumberNine?.setOnClickListener {
            concatenateNumbers(number = "9")
        }
        mbtDot?.setOnClickListener {
            if (!tvInput?.text.toString().contains(other = ".")) {
                tvInput?.text = tvInput?.text.toString() + "."
            }
        }
    }

    private fun concatenateNumbers(number: String) {
        if (tvInput?.text == "0") {
            tvInput?.text = number
        } else {
            tvInput?.text = tvInput?.text.toString() + number
        }
    }

    private fun operationsClickListeners() {
        mbtAddition?.setOnClickListener {
            operation(sinal = "+")
        }
        mbtSubtraction?.setOnClickListener {
            operation(sinal = "-")
        }
        mbtDivision?.setOnClickListener {
            operation(sinal = "/")
        }
        mbtMultiplication?.setOnClickListener {
            operation(sinal = "*")
        }

        mbtEqual?.setOnClickListener {
            segNumero = tvInput?.text.toString()
            val resultConta: Double
            when (operation) {
                "+" -> {
                    resultConta = primNumero.toDouble() + segNumero.toDouble()
                    tvResult?.text = resultConta.toString()
                }
                "-" -> {
                    resultConta = primNumero.toDouble() - segNumero.toDouble()
                    tvResult?.text = resultConta.toString()
                }
                "*" -> {
                    resultConta = primNumero.toDouble() * segNumero.toDouble()
                    tvResult?.text = resultConta.toString()
                }
                "/" -> {
                    if (segNumero == "0") {
                        tvResult?.text = "Não dividirás por Zero"
                    } else {
                        resultConta = primNumero.toDouble() / segNumero.toDouble()
                        tvResult?.text = resultConta.toString()
                    }
                }
            }
            tvInput?.text = "0"
        }
        mbtBackspace?.text = "C / Ce"
        mbtBackspace?.setOnClickListener {
            tvInput?.text = "0"
            tvResult?.text = ""
        }
    }

    private fun operation(sinal: String) {
        if (tvInput?.text == "") {
            return
        } else {
            val pegaTextoInput = tvInput?.text.toString()
            val juntaDuas = "$pegaTextoInput $sinal "
            tvInput?.text = "0"
            tvResult?.text = juntaDuas
            primNumero = pegaTextoInput
            operation = sinal
        }
    }

}