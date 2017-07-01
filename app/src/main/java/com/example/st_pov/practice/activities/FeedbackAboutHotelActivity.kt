package com.example.st_pov.practice.activities

import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.st_pov.practice.R
import com.example.st_pov.practice.kotlin.Constants
import com.example.st_pov.practice.kotlin.showText
import com.example.st_pov.practice.models.Feedback
import kotlinx.android.synthetic.main.activity_feedback_about_hotel.*

class FeedbackAboutHotelActivity : AppCompatActivity() {

    val feedback
        get() = Feedback(
                feedback_txt.text.toString(),
                rating_bar.rating.toInt()
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
        AwesomeValidation(ValidationStyle.BASIC).apply {
            addValidation(this@FeedbackAboutHotelActivity,
                    R.id.feedback_txt,
                    Constants.Regex.FEEDBACK,
                    R.string.validation_hotel_title_error)
        }
    }
}
