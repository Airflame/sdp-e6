package database;

public class SQLStudentParser {
    public static String createSaveQuery(Student student) {
        return "INSERT INTO \"STUDENTS\"(\"First_name\",\"Last_name\") VALUES(\'"
                +student.getFirstName()+"\', \'"+student.getLastName()+"\');";
    }

    public static String createDeleteQuery(Student student) {
        return "DELETE FROM \"STUDENTS\" WHERE \"First_name\"=\'"
                +student.getFirstName()+"\' AND \"Last_name\"=\'"+student.getLastName()+"\';";
    }
}
