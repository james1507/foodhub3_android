package com.james.foodhub.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.james.foodhub.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        mBinding = ActivitySplashBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)
        moveToWelcomeScreen()
    }

    private fun moveToWelcomeScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, WelcomeActivity::class.java))
        }, 2000)
    }
}