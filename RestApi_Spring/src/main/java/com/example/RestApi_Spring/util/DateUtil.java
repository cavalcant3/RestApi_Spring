package com.example.RestApi_Spring.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class DateUtil {
    public String formatLocalDateTimeToDataBaseTime(LocalDateTime localDateTime){

        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }

}
