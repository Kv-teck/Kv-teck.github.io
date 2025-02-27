package com.quanlysach.quanlysach.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigInit{
    public static String DB_URL;
    public static String DB_USERNAME;
    public static String DB_PASSWORD;
    public static String BASE_URL;
    static {
        try(InputStream input = ConfigInit.class.getClassLoader().getResourceAsStream("application.properties")){
            if(input == null){
                throw new IOException("lỗi");
            }
            Properties prop = new Properties();
            prop.load(input);
            DB_URL = prop.getProperty("db.url");
            DB_USERNAME = prop.getProperty("db.username");
            DB_PASSWORD = prop.getProperty("db.password");
            BASE_URL = prop.getProperty("baseUrl");
        } catch (IOException e){
            e.printStackTrace();
            throw new ExceptionInInitializerError("Lỗi load cấu hình");
        }
    }

}
