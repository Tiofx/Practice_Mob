package com.example.st_pov.practice.util

import android.app.Activity
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import java.util.regex.Pattern

fun kawesomeValidation(validationStyle: ValidationStyle,
                       block: KAwesomeValidation.() -> Unit): AwesomeValidation =
        KAwesomeValidation(validationStyle).run {
            block()
            awesomeValidation
        }

class KAwesomeValidation(validationStyle: ValidationStyle) {
    var awesomeValidation = AwesomeValidation(validationStyle)
    var activity: Activity? = null

    fun setActivity(block: () -> Activity) {
        activity = block.invoke()
    }

    fun addValidation(fieldId: Int, pattern: String, errorMessageId: Int) {
        awesomeValidation.addValidation(
                activity,
                fieldId,
                pattern,
                errorMessageId
        )
    }

    fun addValidation(fieldId: Int, pattern: Pattern, errorMessageId: Int) {
        awesomeValidation.addValidation(
                activity,
                fieldId,
                pattern,
                errorMessageId
        )
    }
}