package com.iuriy.numbertowordukrainian

import android.icu.text.MessageFormat
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
fun Long.toWords(language: String , country: String): String {
    val formatter = MessageFormat(
        "{0,spellout,currency}",
        Locale(language, country)
    )
    return formatter.format(arrayOf(this))
}