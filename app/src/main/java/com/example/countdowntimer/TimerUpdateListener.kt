package com.example.countdowntimer

interface TimerUpdateListener {
    fun onTimerFinished()
    fun onTimerTick(progress: Int)
}