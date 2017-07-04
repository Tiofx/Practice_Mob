package com.example.st_pov.practice.activities

import android.media.Image
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.st_pov.practice.R
import com.example.st_pov.practice.models.Hotel
import com.example.st_pov.practice.service.HotelApi
import com.example.st_pov.practice.util.*
import kotlinx.android.synthetic.main.activity_hotel_add.*

class HotelAddActivity : AppCompatActivity() {

    lateinit var photo: Image

    val hotel
        get() = Hotel(
                title = hotel_title_txt.text.toString(),
                starRating = rating_bar.rating.toInt(),
                address = hotel_address_txt.text.toString()
                        .takeIf(String::isNotBlank),
                photo = photo)

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
        kawesomeValidation(ValidationStyle.BASIC) {
            setActivity { this@HotelAddActivity }

            addValidation(
                    R.id.hotel_title_txt,
                    Constants.Regex.HOTEL_TITLE,
                    R.string.validation_hotel_title_error)

            addValidation(
                    R.id.hotel_address_txt,
                    Constants.Regex.ADDRESS,
                    R.string.validation_address_error)
        }
    }
}
