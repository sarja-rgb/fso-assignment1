
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  Student registration application for add and display list of students
 */
public class StudentApp {
    private final List<Student> studentList = new ArrayList<>();

   /*
   *  Add a new student
   */
    public void addStudent(String name, int age) {
        studentList.add(new Student(name, age));
        System.out.println("Student added successfully!\n");
    }

   /*
    * Display list of students
   */
    public void listStudents() {

        System.out.println("\nList of current Students:");
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StudentApp app = new StudentApp();
            
            OUTER:
            while (true) {
                System.out.println("1. Add Student");
                System.out.println("2. List Students");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        app.addStudent(name, age);
                    }
                    case 2 -> app.listStudents();
                    case 3 -> {
                        System.out.println("Exiting program.");
                        break OUTER;
                    }
                    default -> System.out.println("Invalid choice. Please try again.\n");
                }
            }
        }
    }
}
