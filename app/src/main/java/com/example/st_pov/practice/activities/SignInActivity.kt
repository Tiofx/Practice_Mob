package com.example.st_pov.practice.activities

import android.support.v7.app.AppCompatActivity
import android.util.Patterns
import butterknife.ButterKnife
import butterknife.OnClick
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.st_pov.practice.R
import com.example.st_pov.practice.R.layout.password_input
import com.example.st_pov.practice.service.UserApi
import com.example.st_pov.practice.kotlin.*
import com.example.st_pov.practice.models.User
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.password_input.*
import org.json.JSONObject

class SignInActivity : AppCompatActivity() {
    val passwordInput by lazy {
        PasswordInput(findViewById(password_input))
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
    }

    @OnClick(R.id.forget_btn)
    fun forgetPassword() {
        showText("Забывать пароль не дозволено")
    }

    @OnClick(R.id.sign_in_btn)
    fun signIn() {
        if (validator.validate()) {
            showText(".....Подождите... Идет загрузка на сервер")

            sendToServer<UserApi> {
                validate(user).enqueue(FunctionalCallback<Boolean>(
                        { _, response ->
                            response.simpleResponseParser {
                                if (this) "Поздравляю вы успешно вошли"
                                else "Пароль или логин неверен"
                            }.let { showText(it) }
                        },
                        { _, t -> showText("Сетевая ошибка\n $t") }
                ))
            }

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
                    Constants.Regex.PASSWORD,
                    R.string.validation_password_error)
        }
    }
}
