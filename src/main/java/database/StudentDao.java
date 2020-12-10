package database;

import java.sql.*;
import java.util.*;

public class StudentDao {
    private final static String DBURL = "jdbc:postgresql://localhost:5432/sdp";
    private final static String DBUSER = "postgres";
    private final static String DBPASS = "Ja3170";

    private Connection conn;
    private Statement stmt;

    public StudentDao() {
        try {
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(Student student) {
        update(StudentParser.createSaveQuery(student));
    }

    public void delete(Student student) {
        update(StudentParser.createDeleteQuery(student));
    }

    public void deleteAll() {
        update(StudentParser.createDeleteAllQuery());
    }

    public List<Student> findByLastName(String lastName) {
        return find(StudentParser.createFindByLastNameQuery(lastName));
    }

    public List<Student> findAll() {
        return find(StudentParser.createFindAllQuery());
    }

    private void update(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Student> find(String sql) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Student> students = new ArrayList<>();
        try {
            while (rs.next())
                students.add(new Student(rs.getString("First_name"), rs.getString("Last_name")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
