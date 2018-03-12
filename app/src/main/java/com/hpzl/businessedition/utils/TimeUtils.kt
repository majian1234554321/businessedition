package com.hpzl.businessedition.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 *
 * @author admin
 * @date 2018/2/5
 */
class TimeUtils {
    companion object {
        /**
         * 日期转字符串
         * @param date
         * @return
         */
        fun formatDate(date: Date): String? {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            var result: String? = null
            result = sdf.format(date)
            return result
        }

        /**
         * 字符串转日期，格式为："yyyy-MM-dd HH:mm:ss"
         * @param dateStr
         * @return
         */
        fun formatDate(dateStr: String): Date? {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            var result: Date? = null
            try {
                result = sdf.parse(dateStr)
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            return result
        }

        /**
         * 获取当前时间戳
         * @return
         */
        fun currentTimeStamp(): Int? {
            return (System.currentTimeMillis() / 1000).toInt()
        }

        /**
         * 时间戳转日期
         * @param ms yyyy-MM-dd HH:mm:ss
         * @return
         */
        fun transForDate(ms: Long?,style:String?): String? {
            var ms = ms
            if (ms == null) {
                ms = 0.toLong()
            }
            val msl = ms * 1000
            val sdf = SimpleDateFormat(style, Locale.CHINESE)
            var temp: String? = null

            try {
                val str = sdf.format(msl)
                temp = str
            } catch (e: ParseException) {
                e.printStackTrace()
            }


            return temp
        }
    }
}