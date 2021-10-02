package com.morgann.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Morgann on 28/03/2016.
 */
public class OmnisOdbc {
    public static void main(String[] args) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");// ClassNotFoundException
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (Exception e) {
            System.out.println("Erreur en enregistrant le driver jdbc MySQL");
            e.printStackTrace();
            return;
        } finally {
            System.out.println("Terminé");
        }
    }
}
