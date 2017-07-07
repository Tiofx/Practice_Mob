package com.example.st_pov.practice.views

import android.view.View
import com.example.st_pov.practice.util.Session
import kotlinx.android.synthetic.main.header.view.*


class Header(var headerRoot: View) {

    protected val userInfo
        get() = headerRoot.user_info

    protected val signOutBtn
        get() = headerRoot.sign_out_btn

    init {
        updateHeaderState()

        signOutBtn.setOnClickListener {
            Session.currentUser = null
            updateHeaderState()
        }
    }

    fun updateHeaderState() {
        updateVisibility()
        updateUserInfo()
    }

    protected fun updateUserInfo() {
        userInfo.text = Session.currentUser?.let {
            it.fullName ?: "Почта: ${it.email}"
        } ?: ""
    }

    protected fun updateVisibility() {
        headerRoot.visibility =
                if (Session.currentUser != null) View.VISIBLE else View.GONE
    }
}