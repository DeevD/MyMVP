package com.example.heinhtet.mvps.utils

import com.example.heinhtet.mvps.network.data.ErrorModel
import com.google.gson.Gson
import okhttp3.ResponseBody
import java.io.IOException

/**
 * Created by heinhtet on 11/30/2017.
 */
class ErrorUtils {
    companion object {
        var errorResponse: ErrorModel? = null
        fun
                getErrorResponse(body: ResponseBody): ErrorModel {
            val gson = Gson()
            val adapter = gson.getAdapter(ErrorModel::class.java)
            try {
                var errorParser = adapter.fromJson(body.string())
                errorResponse = errorParser
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return errorResponse!!
        }
    }

}