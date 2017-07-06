package com.example.st_pov.practice.activities

import butterknife.ButterKnife
import butterknife.OnClick
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.st_pov.practice.R
import com.example.st_pov.practice.models.Feedback
import com.example.st_pov.practice.util.Constants
import com.example.st_pov.practice.util.kawesomeValidation
import com.example.st_pov.practice.util.showText
import kotlinx.android.synthetic.main.activity_feedback_about_hotel.*

class FeedbackAboutHotelActivity : HeaderActivity() {

    val feedback
        get() = Feedback(
                hotelId = intent.getIntExtra("hotel_id", -1).takeIf { it != -1 },
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
            showText("...Подождите выполняется добавление вашего отзыва")

//            sendToServer<FeedbackApi> {
//                giveFeedback(feedback).enqueue(FunctionalCallback<Boolean>(
//                        { _, response ->
//                            response.simpleResponseParser {
//                                if (this) {
                                    finish()
//                                    "Ваш отзыв добавлен"
//                                } else "У вас недостаточно прав"
//                            }.let { showText(it) }
//
//                        },
//                        { _, t -> showText("Сетевая ошибка\n $t") }
//                ))
//            }
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
