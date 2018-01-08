package com.example.heinhtet.mvps.utils

import com.example.heinhtet.mvps.di.need.Constants
import timber.log.Timber
import java.security.MessageDigest

/**
 * Created by heinhtet on 11/23/2017.
 */

class GenerateUrl {
    companion object {
        fun getGenerateHashedUrl(): String {

            var needToHash = timeStamp() + Constants.PRIVATE_KEY + Constants.PUBLIC_KEY

            var url = "ts=${timeStamp()}&apikey=${Constants.PUBLIC_KEY}&hash=" +
                    "${createHash(needToHash)}"
            var url2 =
                    "${Constants.BASE_URL}v1/public/characters?ts=${timeStamp()}&apikey=${Constants.PUBLIC_KEY}&hash=" +
                            "${createHash(needToHash)}"
            Timber.i("base url $url")
            return url
        }

        fun createHash(key: String) = hashString("MD5", key)

        fun timeStamp() = (System.currentTimeMillis() / 1000).toString()
        /**
         * Supported algorithms on Android:
         *
         * Algorithm	Supported API Levels
         * MD5          1+
         * SHA-1	    1+
         * SHA-224	    1-8,22+
         * SHA-256	    1+
         * SHA-384	    1+
         * SHA-512	    1+
         */
        private fun hashString(type: String, input: String): String {
            val HEX_CHARS = "0123456789abcdef"
            val bytes = MessageDigest
                    .getInstance(type)
                    .digest(input.toByteArray())
            val result = StringBuilder(bytes.size * 2)
            bytes.forEach {
                val i = it.toInt()
                result.append(HEX_CHARS[i shr 4 and 0x0f])
                result.append(HEX_CHARS[i and 0x0f])
            }
            return result.toString()
        }


    }

}