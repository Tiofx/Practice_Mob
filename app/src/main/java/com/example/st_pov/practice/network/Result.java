package com.example.st_pov.practice.network;

import android.text.TextUtils;

/**
 * Created by st_pov on 05.07.2017.
 */

public class Result {
    String status;

    public boolean isSuccess() {
        return TextUtils.equals(status, "success");
    }
}