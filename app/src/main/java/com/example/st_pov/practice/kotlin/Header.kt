package com.example.st_pov.practice.kotlin

import android.view.View
import com.example.st_pov.practice.util.Session
import kotlinx.android.synthetic.main.header.view.*


class Header(var headerRoot: View) {

    val userInfo
        get() = headerRoot.user_info

    val signOutBtn
        get() = headerRoot.sign_out_btn

    fun updateUserInfo() {
        userInfo.text = Session.currentUser?.let {
            it.fullName ?: "Почта: ${it.email}"
        } ?: "Пользователя НЕТ"
    }

    init {
        updateUserInfo()

        signOutBtn.setOnClickListener {
            Session.currentUser = null
            updateUserInfo()
            headerRoot.visibility = View.GONE
        }
    }
}