package com.example.st_pov.practice.activities

import android.media.Image
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.st_pov.practice.R
import com.example.st_pov.practice.api.HotelApi
import com.example.st_pov.practice.kotlin.*
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
            showText("...Подождите произвожу добавление отеля")

            sendToServer<HotelApi> {
                addHotel(hotel)
                        .enqueue(FunctionalCallback<Boolean>(
                                { _, response ->
                                    response.simpleResponseParser {
                                        if (this) "Отель добавлен"
                                        else "Такой отель не валидный"
                                    }.let { showText(it) }
                                },
                                { _, t -> showText("Сетевая ошибка\n $t") }
                        ))
            }
        }
    }

    @OnClick(R.id.add_photo_btn)
    fun addPhoto() = showText("Добавление фото не работает")


    val validator by lazy {
        AwesomeValidation(ValidationStyle.BASIC).apply {
            addValidation(this@HotelAddActivity,
                    R.id.hotel_title_txt,
                    Constants.Regex.HOTEL_TITLE,
                    R.string.validation_hotel_title_error)

            addValidation(this@HotelAddActivity,
                    R.id.hotel_address_txt,
                    Constants.Regex.ADDRESS,
                    R.string.validation_address_error)
        }
    }
}
