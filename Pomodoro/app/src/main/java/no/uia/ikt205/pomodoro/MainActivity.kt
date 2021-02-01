package no.uia.ikt205.pomodoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import no.uia.ikt205.pomodoro.util.millisecondsToDescriptiveTime

class MainActivity : AppCompatActivity() {

    lateinit var timer:CountDownTimer
    lateinit var startButton:Button
    lateinit var coutdownDisplay:TextView

    var timeToCountDownInMs = 5000L
    val timeTicks = 1000L
    val oneMinutinTicks = 60000L;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       startButton = findViewById<Button>(R.id.startCountdownButton)
       startButton.setOnClickListener(){
           startCountDown(it)
       }
       coutdownDisplay = findViewById<TextView>(R.id.countDownView)


       var thirtyMinutesButton = findViewById<Button>(R.id.setTimeDurationTo30MinutesBt)
        thirtyMinutesButton.setOnClickListener(){
            if(startButton.isEnabled){
                setCountDownTime(oneMinutinTicks*30)
            }
        }
        var sixtyMinutesButton = findViewById<Button>(R.id.setTimeDurationTo60MinutesBt)
        sixtyMinutesButton.setOnClickListener(){
            if(startButton.isEnabled){
                setCountDownTime(oneMinutinTicks*60)
            }
        }
        var ninetyMinutesButton = findViewById<Button>(R.id.setTimeDurationTo90MinutesBt)
        ninetyMinutesButton.setOnClickListener(){
            if(startButton.isEnabled){
                setCountDownTime(oneMinutinTicks*90)
            }
        }
        var oneTwentyMinutesButton = findViewById<Button>(R.id.setTimeDurationTo120MinutesBt)
        oneTwentyMinutesButton.setOnClickListener(){
            if(startButton.isEnabled){
                setCountDownTime(oneMinutinTicks*120)
            }
        }




    }

    fun setCountDownTime(newCountDownTimeInMs:Long){
        timeToCountDownInMs = newCountDownTimeInMs
        updateCountDownDisplay(timeToCountDownInMs)
    }

    fun startCountDown(v: View){

        timer = object : CountDownTimer(timeToCountDownInMs,timeTicks) {
            override fun onFinish() {
                Toast.makeText(this@MainActivity,"Arbeidsøkt er ferdig", Toast.LENGTH_SHORT).show()
                v.isEnabled=true
            }

            override fun onTick(millisUntilFinished: Long) {
               updateCountDownDisplay(millisUntilFinished)
            }
        }
        v.isEnabled=false
        timer.start()
    }

    fun updateCountDownDisplay(timeInMs:Long){
        coutdownDisplay.text = millisecondsToDescriptiveTime(timeInMs)
    }

}