import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int exam1, exam2, exam3, exam4;
        double exam1_score1, exam1_score2;
        double exam2_score1, exam2_score2;
        double exam3_score1, exam3_score2;
        double exam4_score1, exam4_score2;

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number of first exams :" );
        exam1 = scanner.nextInt();

        System.out.println("enter your first grade for the first exam: " );
        exam1_score1 = scanner.nextDouble();
        System.out.println("enter your first grade for the second exam " );
        exam1_score2 = scanner.nextDouble();

        int exam1_total = (int) (exam1_score1 + exam1_score2);
        System.out.println("result: " + exam1_total / exam1);

        System.out.println("enter the number of second exams :" );
        exam2 = scanner.nextInt();

        System.out.println("enter your second grade for the first exam: " );
        exam2_score1 = scanner.nextDouble();
        System.out.println("enter your second grade for the second exam " );
        exam2_score2 = scanner.nextDouble();

        int exam2_total = (int) (exam2_score1 + exam2_score2);
        System.out.println("result: " + exam2_total / exam2);


        System.out.println("Enter the number of third exams :" );
        exam3 = scanner.nextInt();

        System.out.println("enter your third grade for the first exam: " );
        exam3_score1 = scanner.nextDouble();
        System.out.println("enter your third grade for the second exam " );
        exam3_score2 = scanner.nextDouble();

        int exam3_total = (int) (exam3_score1 + exam3_score2);
        System.out.println("result: " + exam3_total / exam3);


        System.out.println("Enter the number of fourth exams :" );
        exam4 = scanner.nextInt();

        System.out.println("enter your fourth grade for the first exam: " );
        exam4_score1 = scanner.nextDouble();
        System.out.println("enter your fourth grade for the second exam " );
        exam4_score2 = scanner.nextDouble();

        int exam4_total = (int) (exam4_score1 + exam4_score2);
        System.out.println("result: " + exam4_total / exam4);


    }
}