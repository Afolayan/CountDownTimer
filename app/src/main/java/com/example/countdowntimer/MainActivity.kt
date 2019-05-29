package com.example.countdowntimer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countDownTimer = NotificationCountDownTimer(30000, 1000, object : TimerUpdateListener{
            override fun onTimerFinished() {
                updateText(getString(R.string.countdown_finished_text))
                buttonStartCountDown.text = getString(R.string.button_text)
            }

            override fun onTimerTick(progress: Int) {
                updateText(getString(R.string.countdown_update_text, progress.toString().plus("%")))
            }

        })

        updateText(getString(R.string.countdown_update_text, "0%"))
        buttonStartCountDown.setOnClickListener {
            buttonStartCountDown.text = getString(R.string.button_progress_text)
            countDownTimer.start()
        }
    }

    fun updateText(text: String){
        tvCountdownProgress.text = text
    }
}
