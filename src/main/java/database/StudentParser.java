package database;

public class StudentParser {
    public static String createSaveQuery(Student student) {
        return "INSERT INTO \"STUDENTS\"(\"First_name\",\"Last_name\") VALUES(\'"
                +student.getFirstName()+"\', \'"+student.getLastName()+"\');";
    }

    public static String createDeleteQuery(Student student) {
        return "DELETE FROM \"STUDENTS\" WHERE \"First_name\"=\'"
                +student.getFirstName()+"\' AND \"Last_name\"=\'"+student.getLastName()+"\';";
    }

    public static String createFindByLastNameQuery(String lastName) {
        return "SELECT * FROM \"STUDENTS\" WHERE \"Last_name\"=\'"+lastName+"\';";
    }

    public static String createFindAllQuery() {
        return "SELECT * FROM \"STUDENTS\"";
    }

    public static String createDeleteAllQuery() {
        return "TRUNCATE TABLE \"STUDENTS\"";
    }
}
