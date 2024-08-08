package com.example.mortgagecalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import android.text.method.LinkMovementMethod
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
    private lateinit var login_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mButton1 = findViewById<Button>(R.id.forgot)
        mButton1.movementMethod = LinkMovementMethod.getInstance()

        login_button = findViewById(R.id.login)

        // Intents are objects of the android.content.Intent type. Your code can send them to the Android system defining
        // the components you are targeting. Intent to start an activity called SecondActivity with the following code.
        login_button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            // start the activity connect to the specified class
            startActivity(intent)
        }
    }
}

class SecondActivity : ComponentActivity() {

    // Add button for signout
    private lateinit var sign_out_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        sign_out_button = findViewById(R.id.sign_out)

        // Intents are objects of the android.content.Intent type. Your code can send them to the Android system defining
        // the components you are targeting. Intent to start an activity called SecondActivity with the following code.
        sign_out_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // start the activity connect to the specified class
            startActivity(intent)
        }
    }


}