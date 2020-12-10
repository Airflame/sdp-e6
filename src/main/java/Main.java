import database.Student;
import database.StudentDao;

public class Main {
    public static void main(String[] args) {
        exercise1();
    }

    private static void exercise1() {
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

    private static void exercise2() {
        StudentDao studentDao = new StudentDao();
        IndexTest indexTest = new IndexTest();
        studentDao.deleteAll();
        indexTest.insert(1000);
        indexTest.select();
        indexTest.delete();
        studentDao.deleteAll();
        indexTest.insert(10000);
        indexTest.select();
        indexTest.delete();
        studentDao.deleteAll();
        indexTest.insert(100000);
        indexTest.select();
        indexTest.delete();
        studentDao.deleteAll();
        indexTest.insert(1000000);
        indexTest.select();
        indexTest.delete();
    }
}
