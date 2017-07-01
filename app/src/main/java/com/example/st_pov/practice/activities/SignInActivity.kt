package com.example.st_pov.practice.activities

import android.support.v7.app.AppCompatActivity
import android.util.Patterns
import butterknife.ButterKnife
import butterknife.OnClick
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.st_pov.practice.R
import com.example.st_pov.practice.R.layout.password_input
import com.example.st_pov.practice.kotlin.Constants
import com.example.st_pov.practice.kotlin.PasswordInput
import com.example.st_pov.practice.kotlin.showText
import com.example.st_pov.practice.models.User
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    val passwordInput by lazy {
        PasswordInput(findViewById(password_input))
    }

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
    fun signIn() {
        if (validator.validate()) {
            //TODO:send request to the server
            showText(".....Подождите... Идет загрузка на сервер")
        }
    }

    val validator by lazy {
        AwesomeValidation(ValidationStyle.BASIC).apply {
            addValidation(this@SignInActivity,
                    R.id.email,
                    Patterns.EMAIL_ADDRESS,
                    R.string.validation_email_error)

            addValidation(this@SignInActivity,
                    R.id.password,
                    ".{${Constants.MIN_PASSWORD_LENGTH},${Constants.MAX_PASSWORD_LENGTH}}",
                    R.string.validation_password_error)
        }
    }
}
