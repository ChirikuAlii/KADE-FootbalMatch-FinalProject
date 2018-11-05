package chirikualii.com.footballapps.common

import android.util.Log
import androidx.appcompat.widget.SearchView
import chirikualii.com.footballapps.BuildConfig
import com.google.gson.Gson
import com.google.gson.JsonElement
import java.text.SimpleDateFormat

/**
 * Created by chirikualii on {DATE}
 */
fun logI(tag: String, msg: String) {
    if (BuildConfig.DEBUG) Log.i(tag, msg)
}

fun logW(tag: String, msg: String) {
    if (BuildConfig.DEBUG) Log.w(tag, msg)
}

fun logE(tag: String, msg: String) {
    if (BuildConfig.DEBUG) Log.e(tag, msg)
}

fun logD(tag: String, msg: String) {
    if (BuildConfig.DEBUG) Log.d(tag, msg)
}

fun toJsonElement(any: Any): JsonElement = Gson().toJsonTree(any)


fun String.toDate(): String? {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    val output = SimpleDateFormat("MMM dd, yyyy")
    val date = dateFormat.parse(this)
    return output.format(date)
}

