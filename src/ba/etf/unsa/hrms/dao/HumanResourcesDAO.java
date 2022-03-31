package ba.etf.unsa.hrms.dao;

import ba.etf.unsa.hrms.models.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HumanResourcesDAO {

    private static HumanResourcesDAO instance;
    private Connection conn;

    private PreparedStatement getAllEmployeesStatement;

    private HumanResourcesDAO() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:database/database.db");
        } catch (SQLException ignored) {}

        try {
            getAllEmployeesStatement = conn.prepareStatement("SELECT * FROM employees");
        } catch (Exception e) {
            regenerateDatabase();
            try {
                getAllEmployeesStatement = conn.prepareStatement("SELECT * FROM employees");
            } catch (SQLException e1) {
                e.printStackTrace();
            }
        }
    }
    public static HumanResourcesDAO getInstance() {
        if(instance == null) instance = new HumanResourcesDAO();
        return instance;
    }
    public static void removeInstance() {
        if(instance == null) return;
        instance.close();
        instance = null;
    }
    private void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void regenerateDatabase() {
        try {
            Scanner input = new Scanner(new FileInputStream("database/database.db.sql"));
            String sqlStatement = "";
            while (input.hasNext()) {
                sqlStatement = sqlStatement + input.nextLine();
                if ( sqlStatement.charAt( sqlStatement.length() - 1 ) == ';') {
                    try {
                        Statement stmt = conn.createStatement();
                        stmt.execute(sqlStatement);
                        sqlStatement = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
