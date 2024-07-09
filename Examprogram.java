import java.util.HashMap;
import java.util.Scanner;

public class Examprogram {
    public static void main(String[] args) {
        HashMap<String, Integer> coursework = new HashMap<>();
        coursework.put("ass1", 0);
        coursework.put("ass2", 0);
        coursework.put("ass3", 0);
        coursework.put("cat1", 0);
        coursework.put("cat2", 0);

        double finalExam = 0;
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. View coursework results");
            System.out.println("2. View exam results");
            System.out.println("3. Exit the program");
            System.out.print("Enter your choice (1/2/3): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewCourseworkResults(coursework);
                    break;
                case 2:
                    if (checkCourseworkCompletion(coursework)) {
                        System.out.print("Enter final exam score (out of 50): ");
                        finalExam = scanner.nextDouble();
                        viewExamResults(coursework, finalExam);
                    } else {
                        System.out.println("Student has not completed 2/3 of the coursework. Repeat required irrespective of Final Exam Grade.\n");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        } while (choice != 3);

        scanner.close();
    }

    public static void viewCourseworkResults(HashMap<String, Integer> coursework) {
        System.out.println("\nCoursework Results:");
        for (String key : coursework.keySet()) {
            System.out.println(key + ": " + coursework.get(key));
        }
        System.out.println();
    }

    public static void viewExamResults(HashMap<String, Integer> coursework, double finalExam) {
        int courseworkScore = 0;
        for (int score : coursework.values()) {
            courseworkScore += score;
        }
        double totalScore = courseworkScore + finalExam;
        System.out.println("\nExam Results:");
        System.out.println("Coursework (50%): " + courseworkScore);
        System.out.println("Final Exam (50%): " + finalExam);
        System.out.println("Total Score (100%): " + totalScore + "\n");
    }

    public static int countCourseworkAssessments(HashMap<String, Integer> coursework) {
        return coursework.size();
    }

    public static boolean checkCourseworkCompletion(HashMap<String, Integer> coursework) {
        int numAssessmentsDone = countCourseworkAssessments(coursework);
        int totalAssessments = 5; // ass1, ass2, ass3, cat1, cat2
        return numAssessmentsDone >= (2.0 / 3.0) * totalAssessments;
    }
}
