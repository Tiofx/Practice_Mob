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
    fun next() {
        if (validator.validate()) {
            //TODO: send request to server
            showText("...Подождите произвожу проверку на сервере")
        }
    }

    val validator by lazy {
        AwesomeValidation(ValidationStyle.BASIC).apply {
            addValidation(this@CreateAccountActivity,
                    R.id.email,
                    Patterns.EMAIL_ADDRESS,
                    R.string.validation_email_error)

            addValidation(this@CreateAccountActivity,
                    R.id.password,
                    Constants.Regex.PASSWORD,
                    R.string.validation_password_error)

            addValidation(this@CreateAccountActivity,
                    R.id.first_name,
                    Constants.Regex.FIRST_NAME,
                    R.string.validation_first_name_error)

            addValidation(this@CreateAccountActivity,
                    R.id.last_name,
                    Constants.Regex.LAST_NAME,
                    R.string.validation_last_name_error)
        }
    }
}