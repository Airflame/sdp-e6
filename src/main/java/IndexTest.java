import database.*;

import java.time.*;
import java.util.*;

public class IndexTest {
    private String characters = "abcdefghijklmnopqrstuvwxyz";
    private StudentDao studentDao;

    public IndexTest() {
        studentDao = new StudentDao();
    }

    public void insert(int n) {
        Random random = new Random();
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            students.add(new Student(Character.toString(characters.charAt(random.nextInt(characters.length()))),
                    Character.toString(characters.charAt(random.nextInt(characters.length())))));
        }
        Instant start = Instant.now();
        studentDao.saveMultiple(students);
        Instant finish = Instant.now();
        System.out.print("INSERT "+n+" rows: ");
        System.out.println(Duration.between(start, finish).toMillis());
    }

    public void select() {
        Instant start = Instant.now();
        int rows = studentDao.findByLastName("a").size();
        Instant finish = Instant.now();
        System.out.print("SELECT: ");
        System.out.println(Duration.between(start, finish).toMillis());
    }

    public void delete() {
        Instant start = Instant.now();
        studentDao.deleteByLastName("a");
        Instant finish = Instant.now();
        System.out.print("DELETE: ");
        System.out.println(Duration.between(start, finish).toMillis());
    }
}
