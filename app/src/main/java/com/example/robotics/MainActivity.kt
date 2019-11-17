package com.example.robotics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private val network = Network()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val joystick = findViewById<Joystick>(R.id.joystick)
        joystick.setOnTouchListener(joystick)

        network.establishConnection()

        val t = Thread {
            network.outputCommand("", "", "")
            Thread.sleep(100)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        network.closeConnection()
    }
}
