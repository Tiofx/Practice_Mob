package com.example.st_pov.practice.activities

import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.st_pov.practice.R
import com.example.st_pov.practice.util.Constants
import com.example.st_pov.practice.util.kawesomeValidation
import com.example.st_pov.practice.util.showText
import com.example.st_pov.practice.models.Feedback
import kotlinx.android.synthetic.main.activity_feedback_about_hotel.*

class FeedbackAboutHotelActivity : AppCompatActivity() {

    val feedback
        get() = Feedback(
                comment = feedback_txt.text.toString().trim(),
                rating = rating_bar.rating.toInt()
        )

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback_about_hotel)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ButterKnife.bind(this)
    }

    @OnClick(R.id.feedback_btn)
    fun feedback() {
        if (validator.validate()) {
            //TODO: send request to server
            showText("...Подождите выполняется добавление вашего отзыва")
        }
    }

    val validator by lazy {
        kawesomeValidation(ValidationStyle.BASIC) {
            setActivity { this@FeedbackAboutHotelActivity }

            addValidation(
                    R.id.feedback_txt,
                    Constants.Regex.FEEDBACK,
                    R.string.validation_hotel_title_error)
        }
    }
}
