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
        }

        calculateButton2 = findViewById(R.id.goToCalculate2)

        calculateButton2.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            // start the activity connect to the specified class
            startActivity(intent)
        }

        calculateButton3 = findViewById(R.id.goToCalculate3)

        calculateButton3.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            // start the activity connect to the specified class
            startActivity(intent)
        }
    }
}

class ThirdActivity : ComponentActivity() {

    // Add button for home
    private lateinit var homeButton: Button

    private lateinit var calculate: Button

    private var price = findViewById<EditText>(R.id.editPrice)
    private var interestRate = findViewById<EditText>(R.id.editInterest)
    private var downpayment = findViewById<EditText>(R.id.editDownPayment)
    private var loanAmount = findViewById<EditText>(R.id.editLoanAmount)
    private var duration = findViewById<Spinner>(R.id.duration)
    private var result = findViewById<TextView>(R.id.resultLabel)

    private val p = price.text.toString().toDouble()
    private val r = interestRate.text.toString().toDouble() / 100
    private val dp = downpayment.text.toString().toDouble()
    private var principal = p-dp
    private val n = 12 * duration.selectedItem.toString().toDouble()

    @SuppressLint("DefaultLocale")
    val m = String.format("%.2f", (principal*r*(1+r)*n)/((1+r)*n-1)).toDouble()

    private var textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            // this function is called before text is edited
        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            // this function is called when text is edited
        }

        override fun afterTextChanged(s: Editable) {
            // this function is called after text is edited
            loanAmount.setText(m.toString())
        }
    }

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

        downpayment.addTextChangedListener(textWatcher)

        calculate = findViewById(R.id.calculate)

        calculate.setOnClickListener {
            result.text = m.toString()
        }


    }
}
