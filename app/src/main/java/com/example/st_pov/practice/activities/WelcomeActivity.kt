package com.example.st_pov.practice.activities

import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.st_pov.practice.R
import com.example.st_pov.practice.kotlin.loadActivity
import com.example.st_pov.practice.kotlin.showText


class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ButterKnife.bind(this)
    }

    @OnClick(R.id.sign_in_btn)
    fun signIn() = loadActivity<SignInActivity>()

    @OnClick(R.id.use_google_btn)
    fun useGoogle() = showText("Гугл не работает")

    @OnClick(R.id.create_account_btn)
    fun createAccount() = loadActivity<CreateAccountActivity>()

    @OnClick(R.id.agreement_btn)
    fun userAgreement() = showText("Пользовательское соглашение не работает")
}