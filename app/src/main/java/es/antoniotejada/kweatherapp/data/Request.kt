package es.antoniotejada.kweatherapp.data

import android.util.Log
import java.net.URL

/**
 * Created by apptodev on 20/7/17.
 */
class Request(val url: String) {

    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}