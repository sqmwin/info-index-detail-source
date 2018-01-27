package com.mindnode.immipal.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/27
 */
public class TimeUtil {
    /**
     * 将毫秒值转化成时间字符串
     */
    public static String toLocalString(long timeMillis) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return simpleDateFormat.format(new Date(timeMillis));
    }
}
