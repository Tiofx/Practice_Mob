package com.example.st_pov.practice.activities

import android.os.Bundle
import butterknife.ButterKnife
import com.example.st_pov.practice.R
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : HeaderActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        ButterKnife.bind(this)

        price.text = intent.extras.getInt("price").toString()
        room_description.text = intent.extras.getString("room_description")
    }
}
