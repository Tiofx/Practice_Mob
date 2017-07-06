package com.example.st_pov.practice.activities

import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.st_pov.practice.R

class RoomActivity : HeaderActivity() {
    @BindView(R.id.room_description)
    lateinit var roomDescription: TextView

    @BindView(R.id.price)
    lateinit var price: TextView

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        ButterKnife.bind(this)

        price!!.text = intent.extras.getInt("price").toString()
        roomDescription!!.text = intent.extras.getString("room_description")
    }
}
