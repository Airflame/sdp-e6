package database;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    private final static String DBURL = "jdbc:postgresql://localhost:5432/sdp";
    private final static String DBUSER = "postgres";
    private final static String DBPASS = "Ja3170";

    private Connection conn;
    private Statement stmt;
    private String sql;

    public StudentDAO() {
        try {
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(Student student) {
        sql = SQLStudentParser.createSaveQuery(student);
        try {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Student student) {
        sql = SQLStudentParser.createDeleteQuery(student);
        try {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        sql = "TRUNCATE TABLE \"STUDENTS\"";
        try {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getAll() {
        sql = "SELECT * FROM \"STUDENTS\"";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Student> students = new ArrayList<>();
        try {
            while (rs.next())
                students.add(new Student(rs.getString("First_name"), rs.getString("Last_name")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
