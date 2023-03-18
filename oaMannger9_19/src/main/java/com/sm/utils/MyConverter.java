package com.sm.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyConverter implements Converter<String,Date> {

    @Override
    public Date convert(String s) {
        Date date=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
                date=sdf.parse(s);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return date;
    }
}
