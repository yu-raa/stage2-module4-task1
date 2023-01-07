package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;
import org.h2.jdbc.JdbcConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/h2database.properties"));
            Class.forName(properties.getProperty("jdbc_driver"));
            return DriverManager.getConnection(properties.getProperty("db_url"), properties.getProperty("user"), properties.getProperty("password"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

