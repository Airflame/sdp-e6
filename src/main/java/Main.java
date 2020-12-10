import database.Student;
import database.StudentDao;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        studentDao.deleteAll();

        studentDao.save(new Student("Adam", "Nowak"));
        studentDao.save(new Student("Piotr", "Kowalski"));
        studentDao.findAll().forEach(System.out::println);
        System.out.println();

        studentDao.delete(new Student("Piotr", "Kowalski"));
        studentDao.save(new Student("Dawid", "Zalewski"));
        System.out.println("Studenci po usunięciu Kowalskiego i dodaniu Zalewskiego:");
        studentDao.findAll().forEach(System.out::println);
        System.out.println();

        studentDao.save(new Student("Jan", "Zalewski"));
        System.out.println("Studenci z nazwiskiem Zalewski po dodaniu Jana Zalewskiego:");
        studentDao.findByLastName("Zalewski").forEach(System.out::println);
    }
}
