package database;

import java.util.ArrayList;

public class StudentParser {
    public static String createSaveQuery(Student student) {
        return "INSERT INTO \"STUDENTS\"(\"First_name\",\"Last_name\") VALUES(\'"
                +student.getFirstName()+"\', \'"+student.getLastName()+"\');";
    }

    public static String createSaveMultipleQuery(ArrayList<Student> students) {
        StringBuilder sql = new StringBuilder("INSERT INTO \"STUDENTS\"(\"First_name\",\"Last_name\") VALUES");
        for (Student student : students)
            sql.append("(\'").append(student.getFirstName()).append("\', \'").append(student.getLastName()).append("\'),");
        sql.append("('x','x');");
        return sql.toString();
    }

    public static String createFindByLastNameQuery(String lastName) {
        return "SELECT * FROM \"STUDENTS\" WHERE \"Last_name\"=\'"+lastName+"\';";
    }

    public static String createFindAllQuery() {
        return "SELECT * FROM \"STUDENTS\"";
    }

    public static String createDeleteQuery(Student student) {
        return "DELETE FROM \"STUDENTS\" WHERE \"First_name\"=\'"
                +student.getFirstName()+"\' AND \"Last_name\"=\'"+student.getLastName()+"\';";
    }

    public static String createDeleteByLastNameQuery(String lastName) {
        return "DELETE FROM \"STUDENTS\" WHERE \"Last_name\"=\'"+lastName+"\';";
    }

    public static String createDeleteAllQuery() {
        return "TRUNCATE TABLE \"STUDENTS\" RESTART IDENTITY";
    }
}
