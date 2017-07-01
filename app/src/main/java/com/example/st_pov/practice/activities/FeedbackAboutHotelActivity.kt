package com.example.st_pov.practice.activities

import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.st_pov.practice.R
import com.example.st_pov.practice.models.Feedback
import com.example.st_pov.practice.kotlin.showText
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

    @OnClick(R.id.add_hotel_btn)
    fun addHotel() = showText("Добавление отеля не готово")
}
