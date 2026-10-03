import java.util.Scanner;

public class UniversityTracker {
    static String grade(int marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else return "F";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] subjects = {"Java", "Maths", "Physics"};
        int[] marks = new int[3];
        int[] attended = new int[3];
        int[] total = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print(subjects[i] + " Marks: ");
            marks[i] = sc.nextInt();
            System.out.print("Attended Classes: ");
            attended[i] = sc.nextInt();
            System.out.print("Total Classes: ");
            total[i] = sc.nextInt();
        }
        System.out.println("\n--- Student Report ---");
        for (int i = 0; i < 3; i++) {
            double attendance = attended[i] * 100.0 / total[i];
            System.out.println(subjects[i] +
                    " | Grade: " + grade(marks[i]) +
                    " | Attendance: " + attendance + "%");
            if (attendance < 75)
                System.out.println("Warning: Low Attendance!");
        }
        sc.close();
    }
}