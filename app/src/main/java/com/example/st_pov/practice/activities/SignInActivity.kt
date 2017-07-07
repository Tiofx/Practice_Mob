package com.example.st_pov.practice.activities

import android.support.v7.app.AppCompatActivity
import android.util.Patterns
import android.widget.FrameLayout
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.st_pov.practice.R
import com.example.st_pov.practice.kotlin.PasswordInput
import com.example.st_pov.practice.models.User
import com.example.st_pov.practice.util.*
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.password_input.*

class SignInActivity : AppCompatActivity() {
    @BindView(R.id.password_container)
    lateinit var password_input: FrameLayout

    val passwordInput by lazy {
        PasswordInput(password_input)
    }

    val user
        get() = User(
                email = email.text.toString(),
                password = password.text.toString()
        )

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        ButterKnife.bind(this)
        passwordInput
    }

    @OnClick(R.id.sign_in_btn)
    fun signIn() {
        if (validator.validate()) {
            showText(".....Подождите... Идет загрузка на сервер")

//            sendToServer<UserApi> {
//                validate(user).enqueue(FunctionalCallback<AuthToken>(
//                        { _, response ->
//                            response.simpleResponseParser {
//                                if (!token.isNullOrBlank()) {
                                    Session.currentUser = user
//                                    Session.tokenValue = token

                                    loadActivity<MainActivity>()
//
//                                    "Поздравляю вы успешно вошли"
//                                } else "Пароль или логин неверен"
//                            }.let { showText(it) }
//                        },
//                        { _, t -> showText("Сетевая ошибка\n $t") }
//                ))
//            }

        }
    }

    val validator by lazy {
        kawesomeValidation(ValidationStyle.BASIC) {
            setActivity { this@SignInActivity }

            addValidation(
                    R.id.email,
                    Patterns.EMAIL_ADDRESS,
                    R.string.validation_email_error)

            addValidation(
                    R.id.password,
                    Constants.Regex.PASSWORD,
                    R.string.validation_password_error)
        }
    }
}
