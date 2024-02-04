package core;

import java.sql.Connection;
import java.sql.DriverManager;

public class Db {
        private Connection connection = null;
        private static Db instance = null;
        private final String DB_URL = "jdbc:postgresql://localhost/TourismAgencyApp";
        private final String DB_USER = "postgres";
        private final String DB_PASSWORD = "postgres";

        private Db() {
            try {
                this.connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        public Connection getConnection() {
            return connection;
        }

        public static Connection getInstance(){
            try {
                if(instance == null || instance.getConnection().isClosed()){
                    instance = new Db();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return instance.getConnection();
        }
    }

