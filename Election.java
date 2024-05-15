import java.util.ArrayList;
import java.util.Scanner;

public class Election {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the nominee 1 name: ");
        String nominee1 = scanner.nextLine();

        System.out.print("Enter the nominee 2 name: ");
        String nominee2 = scanner.nextLine();

        int num1Votes = 0;
        int num2Votes = 0;

        ArrayList<Integer> voterId = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            voterId.add(i);
        }

        int numOfVoter = voterId.size();

        while (true) {
            if (voterId.isEmpty()) {
                System.out.println("Voting Session is Over");
                if (num1Votes > num2Votes) {
                    double percentage = ((double) num1Votes / numOfVoter) * 100;
                    System.out.println(nominee1 + " has won the election with " + percentage + " %");
                    break;
                } else if (num1Votes < num2Votes) {
                    double percentage = ((double) num2Votes / numOfVoter) * 100;
                    System.out.println(nominee2 + " has won the election with " + percentage + " %");
                    break;
                } else {
                    System.out.println("Both have equal votes");
                    break;
                }
            } else {
                System.out.print("Enter your Voter id: ");
                int voter = scanner.nextInt();
                if (voterId.contains(voter)) {
                    System.out.println("You are a valid voter...");
                    voterId.remove(Integer.valueOf(voter));
                    System.out.print("Choose your nominee to vote 1 or 2: ");
                    int vote = scanner.nextInt();
                    if (vote == 1) {
                        num1Votes++;
                        System.out.println("Thank you for voting.");
                    } else if (vote == 2) {
                        num2Votes++;
                        System.out.println("Thank you for voting.");
                    }else{
                        System.out.println("Invalid Nominee");
                    }

                } else {
                    System.out.println("You are not a voter here or you have already voted...");
                }
            }
        }
        scanner.close();
    }
}
