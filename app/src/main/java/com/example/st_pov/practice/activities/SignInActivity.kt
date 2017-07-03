package com.example.st_pov.practice.activities

import android.support.v7.app.AppCompatActivity
import android.util.Patterns
import butterknife.ButterKnife
import butterknife.OnClick
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.st_pov.practice.R
import com.example.st_pov.practice.R.layout.password_input
import com.example.st_pov.practice.api.UserApi
import com.example.st_pov.practice.kotlin.Constants
import com.example.st_pov.practice.kotlin.PasswordInput
import com.example.st_pov.practice.kotlin.showText
import com.example.st_pov.practice.models.User
import kotlinx.android.synthetic.main.activity_sign_in.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
    fun forgetPassword() {
        showText("Забывать пароль не дозволено")
    }

    @OnClick(R.id.sign_in_btn)
    fun signIn() {
        if (validator.validate()) {
            showText(".....Подождите... Идет загрузка на сервер")

            Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(UserApi::class.java)
                    .validate(user)
                    .enqueue(object : Callback<Boolean> {
                        override fun onResponse(call: Call<Boolean>?, response: Response<Boolean>?) {
                            (response
                                    ?.let {
                                        if (it.isSuccessful)
                                            it.body()?.takeIf { it }
                                                    ?.let { "Поздравляю вы успешно вошли" }
                                                    ?: "Пароль или логин неверен"
                                        else "Произошла ошибка ${it.code()}"
                                    }
                                    ?: "Ошибка на строне сервера")
                                    .let { this@SignInActivity.showText(it) }

                        }

                        override fun onFailure(call: Call<Boolean>?, t: Throwable?) {
                            this@SignInActivity.showText("Сетевая ошибка\n $t")
                        }
                    })

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
