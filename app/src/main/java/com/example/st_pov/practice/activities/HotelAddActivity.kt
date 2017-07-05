package com.example.st_pov.practice.activities

import android.os.Bundle
import butterknife.ButterKnife
import butterknife.OnClick
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.st_pov.practice.R
import com.example.st_pov.practice.models.Hotel
import com.example.st_pov.practice.util.Constants
import com.example.st_pov.practice.util.kawesomeValidation
import com.example.st_pov.practice.util.showText
import kotlinx.android.synthetic.main.activity_hotel_add.*

class HotelAddActivity : HeaderActivity() {

//    lateinit var photo: Image

    val hotel
        get() = Hotel(
                title = hotel_title_txt.text.toString(),
                starRating = rating_bar.rating.toInt(),
                address = hotel_address_txt.text.toString()
                        .takeIf(String::isNotBlank),
                hasBreakfast = has_breakfast.isChecked
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_add)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        ButterKnife.bind(this)
        header
    }

    @OnClick(R.id.add_hotel_btn)
    fun addHotel() {
        if (validator.validate()) {
            showText("...Подождите произвожу добавление отеля")

            finish()

//            sendToServer<HotelApi> {
//                addHotel(hotel)
//                        .enqueue(FunctionalCallback<Boolean>(
//                                { _, response ->
//                                    response.simpleResponseParser {
//                                        if (this) {
//                                            this@HotelAddActivity.finish()
//                                            "Отель добавлен"
//                                        } else "Такой отель не валидный"
//                                    }.let { showText(it) }
//                                },
//                                { _, t -> showText("Сетевая ошибка\n $t") }
//                        ))
//            }
        }
    }

//    @OnClick(R.id.add_photo_btn)
//    fun addPhoto() = showText("Добавление фото не работает")


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
