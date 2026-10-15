mport java.util.*;

class Student {
    String studentName;
    Student(String name) {
        studentName = name;
    }
}

public class UniversityTracker extends Student {
    ArrayList<String> subjects = new ArrayList<>(
        Arrays.asList("Java", "Maths", "Physics"));
    ArrayList<Integer> marks = new ArrayList<>();
    int[] attended = new int[3], total = new int[3];

    UniversityTracker(String name) {
        super(name);
    }

    String grade(int m) {
        if (m >= 90) return "A+";
        if (m >= 80) return "A";
        if (m >= 70) return "B";
        if (m >= 60) return "C";
        return "F";
    }

    void displayReport() {
        System.out.println("\n--- University Student Report ---");
        System.out.println("Student Name: " + studentName);

        for (int i = 0; i < subjects.size(); i++) {
            System.out.println("\nSubject: " + subjects.get(i));
            System.out.println("Marks: " + marks.get(i));
            System.out.println("Grade: " + grade(marks.get(i)));

            if (total[i] > 0) {
 if (total[i] > 0) {
                double a = attended[i] * 100.0 / total[i];
                System.out.printf("Attendance: %.2f%%%n", a);
                if (a < 75) System.out.println("Warning: Low Attendance!");
            } else System.out.println("Invalid total classes!");
        }

        System.out.println("\nSubjects with marks >= 80:");
        subjects.stream()
            .filter(s -> marks.get(subjects.indexOf(s)) >= 80)
            .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        UniversityTracker st = new UniversityTracker(sc.nextLine().trim());

        for (int i = 0; i < st.subjects.size(); i++) {
            System.out.print(st.subjects.get(i) + " Marks: ");
            st.marks.add(sc.nextInt());
            System.out.print("Attended Classes: ");
            st.attended[i] = sc.nextInt();
            System.out.print("Total Classes: ");
            st.total[i] = sc.nextInt();
        }

        st.displayReport();
        sc.close();
    }
}
