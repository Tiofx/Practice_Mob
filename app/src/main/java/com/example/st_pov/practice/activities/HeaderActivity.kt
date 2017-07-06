package com.example.st_pov.practice.activities

import android.os.Bundle
import android.view.View
import butterknife.BindView
import butterknife.ButterKnife
import com.example.st_pov.practice.R
import com.example.st_pov.practice.kotlin.Header

open class HeaderActivity : AuthorizedUserActivity() {

    @BindView(R.id.header)
    protected lateinit var headerRoot: View

    protected val header by lazy {
        Header(headerRoot)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        header.updateHeaderState()
    }
}