package com.example.st_pov.practice.activities

import android.media.Image
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.st_pov.practice.R
import com.example.st_pov.practice.models.Hotel
import com.example.st_pov.practice.kotlin.showText
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
    fun addHotel() = showText("Добавление отеля еще не работает")

    @OnClick(R.id.add_photo_btn)
    fun addPhoto() = showText("Добавление фото не работает")

}
