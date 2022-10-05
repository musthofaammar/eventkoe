package id.eureka.dotakoe.core.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class DateUtils {
    companion object {

        fun formatDatetimeToDate(datetime: String?): String {
            try {

                val dateSubstring = datetime?.substringBeforeLast(".")

                val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

                val dates = date.parse(dateSubstring)

                val formatter = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())

                val string = formatter.format(dates)

                Log.d("Error : ", string)

                return string
            } catch (e: Exception) {
                Log.d("Error : ", e.localizedMessage)
            }

            return ""
        }


    }
}