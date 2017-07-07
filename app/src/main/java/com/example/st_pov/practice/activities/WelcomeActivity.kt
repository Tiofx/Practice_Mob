package com.example.st_pov.practice.activities

import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.st_pov.practice.R
import com.example.st_pov.practice.util.loadActivity


class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ButterKnife.bind(this)
    }

    @OnClick(R.id.sign_in_btn)
    fun signIn() = loadActivity<SignInActivity>()

    @OnClick(R.id.create_account_btn)
    fun createAccount() = loadActivity<CreateAccountActivity>()
}