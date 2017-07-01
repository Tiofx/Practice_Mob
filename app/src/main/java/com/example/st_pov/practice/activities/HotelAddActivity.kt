package com.example.st_pov.practice.activities

import android.media.Image
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.st_pov.practice.R
import com.example.st_pov.practice.kotlin.Constants
import com.example.st_pov.practice.kotlin.showText
import com.example.st_pov.practice.models.Hotel
import kotlinx.android.synthetic.main.activity_hotel_add.*

class HotelAddActivity : AppCompatActivity() {

    lateinit var photo: Image

    val hotel
        get() = Hotel(
                hotel_title_txt.text.toString(),
                rating_bar.rating.toInt(),
                hotel_address_txt.text.toString(),
                photo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_add)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.add_hotel_btn)
    fun addHotel() {
        if (validator.validate()) {
            //TODO:send request to the server
            showText("...Подождите произвожу добавление отеля")
        }
    }

    @OnClick(R.id.add_photo_btn)
    fun addPhoto() = showText("Добавление фото не работает")


    val validator by lazy {
        AwesomeValidation(ValidationStyle.BASIC).apply {
            addValidation(this@HotelAddActivity,
                    R.id.hotel_title_txt,
                    "[\\w|\\s]{${Constants.MIN_HOTEL_TITLE_LENGTH},${Constants.MAX_HOTEL_TITLE_LENGTH}}",
                    R.string.validation_hotel_title_error)
        }
    }
}
