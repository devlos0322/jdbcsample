package me.me.whiteship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/springdata";
        String username = "devlos";
        String password = "pass";

        try (Connection connection = DriverManager.getConnection(url, username, password)){
            System.out.println("Connection created: "+ connection);
            String sql = "CREATE TABLE ACCOUNT (id int, username varchar(255), password varchar(255));";
            String sql_insert = "INSERT INTO ACCOUNT VALUES(1, 'devlos', 'pass')";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.execute();
            }
            try(PreparedStatement statement = connection.prepareStatement(sql_insert)) {
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
