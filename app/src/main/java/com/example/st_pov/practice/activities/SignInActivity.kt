package com.example.st_pov.practice.activities

import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.st_pov.practice.R
import com.example.st_pov.practice.R.layout.password_input
import com.example.st_pov.practice.kotlin.PasswordInput
import com.example.st_pov.practice.kotlin.User
import com.example.st_pov.practice.kotlin.showText
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    val passwordInput by lazy { PasswordInput(findViewById(password_input)) }

    val user
        get() = User(
                email.text.toString(),
                passwordInput.password.text.toString()
        )

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        ButterKnife.bind(this)

    }

    @OnClick(R.id.forget_btn)
    fun forgetPassword() = showText("Забывать пароль не дозволено")

    @OnClick(R.id.sign_in_btn)
    fun signIn() = showText("войти в аккант еще не реализован")
}
