package com.example.st_pov.practice.activities

import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.st_pov.practice.R
import com.example.st_pov.practice.R.layout.password_input
import com.example.st_pov.practice.kotlin.PasswordInput
import com.example.st_pov.practice.kotlin.User
import com.example.st_pov.practice.kotlin.showText
import kotlinx.android.synthetic.main.activity_create_account.*


class CreateAccountActivity : AppCompatActivity() {
    val passwordInput by lazy { PasswordInput(findViewById(password_input)) }

    val user
        get() = User(
                email.text.toString(),
                passwordInput.password.text.toString(),
                "${first_name.text} ${last_name.text}"
        )

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.next_btn)
    fun next() = showText("Регистрация еще не работает")
}