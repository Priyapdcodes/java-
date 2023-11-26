import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the student's name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter the student's score: ");
        double studentScore = scanner.nextDouble();

        char grade = calculateGrade(studentScore);

        System.out.println("Student Name: " + studentName);
        System.out.println("Student Score: " + studentScore);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static char calculateGrade(double score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}