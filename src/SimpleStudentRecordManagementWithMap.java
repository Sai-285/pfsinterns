
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleStudentRecordManagementWithMap {
    private static final String FILE_PATH = "students.txt";
    private static HashMap<Integer, Student> studentMap = new HashMap<>();

    public static void main(String[] args){
        loadStudentsFromFile();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1. Add Student \n 2. View Students \n 3. Update Student \n 4.Delete Student \n Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1: addStudent(scanner); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(scanner); break;
                case 4: deleteStudent(scanner); break;
                case 5: return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void addStudent(Scanner scanner){
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();

        studentMap.put(rollNumber, new Student(name, grade));
        saveStudentsToFile();
        System.out.println("Student added.");
    }

    private static void viewStudents() {
        if(studentMap.isEmpty()){
            System.out.println("No students found.");
            return;
        }
        System.out.println("Student Records: ");
        for(Map.Entry<Integer, Student> entry : studentMap.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private  static void updateStudent(Scanner scanner) {
        System.out.print("Enter roll number to update");
        int rollNumber = scanner.nextInt();

        if(studentMap.containsKey(rollNumber)){
            System.out.print("Enter new name: ");
            scanner.nextLine();
            String newName = scanner.nextLine();
            System.out.print("Enter new grade: ");
            double newGrade = scanner.nextDouble();

            studentMap.put(rollNumber, new Student(newName, newGrade));
            saveStudentsToFile();
            System.out.println("Student updated.");
        }else{
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter roll number to delete: ");
        int rollNumber = scanner.nextInt();

        if(studentMap.remove(rollNumber) != null){
            saveStudentsToFile();
            System.out.println("Student deleted.");
        }else{
            System.out.println("Student not found.");
        }
    }

    private static void loadStudentsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int rollNumber = Integer.parseInt(parts[0]);
                String name = parts[1];
                double grade = Double.parseDouble(parts[2]);
                studentMap.put(rollNumber, new Student(name, grade));
            }
        }catch (IOException e){
            System.out.println("Error loading students: " + e.getMessage());
        }
    }

    private static void saveStudentsToFile() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<Integer, Student> entry : studentMap.entrySet()){
                writer.write(entry.getKey() + "," + entry.getValue().toString());
            }
        }catch (IOException e){
            System.out.println("Error saving students: " + e.getMessage());
        }
    }
}