package com.example.st_pov.practice.activities

import android.support.v7.app.AppCompatActivity
import android.util.Patterns
import butterknife.ButterKnife
import butterknife.OnClick
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.st_pov.practice.MainActivity
import com.example.st_pov.practice.R
import com.example.st_pov.practice.R.layout.password_input
import com.example.st_pov.practice.kotlin.PasswordInput
import com.example.st_pov.practice.models.User
import com.example.st_pov.practice.util.*
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.password_input.*


class CreateAccountActivity : AppCompatActivity() {
    val passwordInput by lazy { PasswordInput(findViewById(password_input)) }

    val user
        get() = User(
                email = email.text.toString(),
                password = password.text.toString(),
                fullName = "${first_name.text} ${last_name.text}"
                        .takeIf(String::isNotBlank)
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
            showText("...Подождите произвожу проверку на сервере")

            //TODO:delete stub
            Session.currentUser = user
            loadActivity<MainActivity>()

//            sendToServer<UserApi> {
//                registerUser(user)
//                        .enqueue(FunctionalCallback<Boolean>(
//                                { _, response ->
//                                    response.simpleResponseParser {
//                                        if (this) {
//                                            loadActivity<MainActivity>()
//                                            "Поздравляю вы успешно зарегестированы"
//                                        }
//                                        else "Пароль или логин неверен"
//                                    }.let { showText(it) }
//
//                                },
//                                { _, t -> showText("Сетевая ошибка\n $t") }
//                        ))
//            }
        }
    }

    val validator by lazy {
        kawesomeValidation(ValidationStyle.BASIC) {
            setActivity { this@CreateAccountActivity }

            addValidation(
                    R.id.email,
                    Patterns.EMAIL_ADDRESS,
                    R.string.validation_email_error)

            addValidation(
                    R.id.password,
                    Constants.Regex.PASSWORD,
                    R.string.validation_password_error)

            addValidation(
                    R.id.first_name,
                    Constants.Regex.FIRST_NAME,
                    R.string.validation_first_name_error)

            addValidation(
                    R.id.last_name,
                    Constants.Regex.LAST_NAME,
                    R.string.validation_last_name_error)
        }
    }
}