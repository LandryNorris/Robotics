package com.example.robotics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

fun color(r: Int, g: Int, b: Int): Paint {
    val paint = Paint()
    paint.setARGB(255, r, g, b)
    return paint
}

class Joystick(context: Context, attributeSet: AttributeSet): View(context, attributeSet), View.OnTouchListener {

    var touching = false
    var event:MotionEvent? = null
    override fun onTouch(view: View?, event: MotionEvent?): Boolean {
        this.event = event
        touching = event?.action != MotionEvent.ACTION_UP
        invalidate()
        return true
    }

    var r = 500
    var stickX = 0F
    var stickY = 0F

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas!!)
        r = canvas.height/2

        val paint = color(0, 0, 0)
        paint.style = Paint.Style.STROKE

        if(touching) {
            stickX = event!!.x-x
            stickY = event!!.y-y
        }

        else {
            stickX = canvas.width/2F
            stickY = canvas.height/2F
        }

        canvas.drawCircle(canvas.width/2F, canvas.height/2F, r.toFloat(), paint)

        canvas.drawCircle(stickX, stickY, r/4F, paint)
    }

    fun getR(): Double {
        return Math.sqrt(stickX*stickX + stickY*stickY.toDouble())/r
    }

    fun getTheta(): Double {
        return Math.atan(stickY/stickX.toDouble())
    }
}