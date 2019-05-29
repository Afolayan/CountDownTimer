package com.example.countdowntimer

import android.os.CountDownTimer

class NotificationCountDownTimer(private val millisInFuture: Long, private val countDownInterval: Long, private val timerUpdateListener: TimerUpdateListener) :
        CountDownTimer(millisInFuture, countDownInterval) {
    override fun onFinish() {
        timerUpdateListener.onTimerFinished()
    }

    override fun onTick(millisUntilFinished: Long) {
        timerUpdateListener.onTimerTick(calculateProgress(millisUntilFinished))
    }

    private fun calculateProgress(millisUntilFinished: Long): Int {
        val subtraction = millisInFuture - millisUntilFinished
        val percentage = subtraction.toDouble() / millisInFuture
        return (percentage * 100).toInt()
    }

}
