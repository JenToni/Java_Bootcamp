package edu.school21.chat.Main;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static DataSource dataSource = null;
    static String dbURL;
    static String dbUsername;
    static String dbPassword ;

    public DBUtils() {
        getdata();
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbURL);
        config.setUsername(dbUsername);
        config.setPassword(dbPassword);
        dataSource = new HikariDataSource(config);

    }
    public static void getdata()  {

        FileInputStream fis;
        Properties properties_ = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            properties_.load(fis);
            dbURL = properties_.getProperty("db.host");
            dbUsername = properties_.getProperty("db.Username");
            dbPassword = properties_.getProperty("db.Password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
