package com.example.mortgagecalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import android.text.method.LinkMovementMethod
import android.widget.EditText
import android.widget.Spinner
import java.math.RoundingMode
import java.text.DecimalFormat
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.navigation.compose.NavHost
import com.example.mortgagecalculator.R
import com.example.mortgagecalculator.ui.theme.MortgageCalculatorTheme
import kotlin.math.pow

class MainActivity : ComponentActivity() {

    // Add button for login
    private lateinit var mloginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mButton1 = findViewById<Button>(R.id.forgot)
        mButton1.movementMethod = LinkMovementMethod.getInstance()

        mloginButton = findViewById(R.id.login)

        // Intents are objects of the android.content.Intent type. Your code can send them to the Android system defining
        // the components you are targeting. Intent to start an activity called SecondActivity with the following code.
        mloginButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            // start the activity connect to the specified class
            startActivity(intent)
        }
    }
}

class SecondActivity : ComponentActivity() {

    // Add button for signout
    private lateinit var signOutButton: Button

    private lateinit var calculateButton1: Button

    private lateinit var calculateButton2: Button

    private lateinit var calculateButton3: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        signOutButton = findViewById(R.id.sign_out)

        // Intents are objects of the android.content.Intent type. Your code can send them to the Android system defining
        // the components you are targeting. Intent to start an activity called SecondActivity with the following code.
        signOutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // start the activity connect to the specified class
            startActivity(intent)
        }

        calculateButton1 = findViewById(R.id.goToCalculate1)

        calculateButton1.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            // start the activity connect to the specified class
            startActivity(intent)

            val homePrice = findViewById<EditText>(R.id.editPrice)
            homePrice.setText("285000").toString().toDouble()
        }

        calculateButton2 = findViewById(R.id.goToCalculate2)

        calculateButton2.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            // start the activity connect to the specified class
            startActivity(intent)

            val homePrice = findViewById<EditText>(R.id.editPrice)
            homePrice.setText("220000").toString().toDouble()
        }

        calculateButton3 = findViewById(R.id.goToCalculate3)

        calculateButton3.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            // start the activity connect to the specified class
            startActivity(intent)

            val homePrice = findViewById<EditText>(R.id.editPrice)
            homePrice.setText("214973").toString().toDouble()
        }
    }
}

class ThirdActivity : ComponentActivity() {

    // Add button for home
    private lateinit var homeButton: Button

    private lateinit var calculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        homeButton = findViewById(R.id.home_button)

        // Intents are objects of the android.content.Intent type. Your code can send them to the Android system defining
        // the components you are targeting. Intent to start an activity called SecondActivity with the following code.
        homeButton.setOnClickListener {
           val intent = Intent(this, SecondActivity::class.java)
            // start the activity connect to the specified class
            startActivity(intent)
        }

        val price = findViewById<EditText>(R.id.editPrice)
        val interestRate = findViewById<EditText>(R.id.editInterest)
        val downpayment = findViewById<EditText>(R.id.editDownPayment)
        var loanAmount = findViewById<EditText>(R.id.editLoanAmount)
        val duration = findViewById<Spinner>(R.id.duration)
        val result = findViewById<TextView>(R.id.resultLabel)

        val p = price.text.toString().toDouble()
        val r = (interestRate.text.toString().toDouble() / 100) / 12
        val dp = downpayment.text.toString().toDouble()
        val principal = p-dp
        loanAmount.setText(principal.toString())
        val n = 12 * duration.selectedItem.toString().toDouble()
        val i = (1+r).pow(n).toString().toDouble()

        @SuppressLint("DefaultLocale")
        val m = String.format("%.2f", (principal*r*i)/(i-1))

//        downpayment.addTextChangedListener(textWatcher)

        calculate = findViewById(R.id.calculate)

        calculate.setOnClickListener {
            result.text = m
        }

    }

//    private var textWatcher: TextWatcher = object : TextWatcher {
//
//        val price = findViewById<EditText>(R.id.editPrice)
//        val downpayment = findViewById<EditText>(R.id.editDownPayment)
//        var loanAmount = findViewById<EditText>(R.id.editLoanAmount)
//
//        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
//            // this function is called before text is edited
//        }
//
//        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//            // this function is called when text is edited
//        }
//
//        override fun afterTextChanged(s: Editable) {
//            // this function is called after text is edited
//            loanAmount.setText((price.text.toString().toDouble() - downpayment.text.toString().toDouble()).toString())
//        }
//    }
}
