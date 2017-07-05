package com.example.st_pov.practice.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.example.st_pov.practice.util.Session
import com.example.st_pov.practice.util.loadActivity
import com.example.st_pov.practice.util.showText


open class AuthorizedUserActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()
        if (Session.currentUser == null) {
            loadActivity<WelcomeActivity> {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            }

            showText("Пожалуйста6 зайдите в систему")
        }
    }
}