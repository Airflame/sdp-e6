import database.Student;
import database.StudentDAO;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.deleteAll();

        studentDAO.save(new Student("Adam", "Nowak"));
        studentDAO.save(new Student("Piotr", "Kowalski"));
        studentDAO.getAll().forEach(System.out::println);
        System.out.println();

        studentDAO.delete(new Student("Piotr", "Kowalski"));
        studentDAO.save(new Student("Michał", "Zalewski"));
        studentDAO.getAll().forEach(System.out::println);
    }
}
