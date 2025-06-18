import java.util.Scanner;

public class RockPaperScissorsGame {

    // Method to get computer's random choice
    public static String getComputerChoice() {
        int random = (int) (Math.random() * 3); // 0, 1, or 2
        switch (random) {
            case 0: return "rock";
            case 1: return "paper";
            default: return "scissors";
        }
    }

    // Method to determine the winner
    public static String getWinner(String player, String computer) {
        if (player.equals(computer)) {
            return "Draw";
        } else if (
            (player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("paper") && computer.equals("rock")) ||
            (player.equals("scissors") && computer.equals("paper"))
        ) {
            return "Player";
        } else {
            return "Computer";
        }
    }

    // Method to calculate percentages and return stats in a 2D array
    public static String[][] getStats(int playerWins, int computerWins, int draws, int totalGames) {
        String[][] stats = new String[3][3];

        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(playerWins);
        stats[0][2] = String.format("%.2f", (playerWins * 100.0) / totalGames) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", (computerWins * 100.0) / totalGames) + "%";

        stats[2][0] = "Draws";
        stats[2][1] = String.valueOf(draws);
        stats[2][2] = String.format("%.2f", (draws * 100.0) / totalGames) + "%";

        return stats;
    }

    // Method to display result table
    public static void displayResults(String[][] rounds, String[][] stats) {
        System.out.println("\nGame | Player   | Computer | Winner");
        System.out.println("--------------------------------------");

        for (int i = 0; i < rounds.length; i++) {
            System.out.printf(" %2d   | %-8s | %-8s | %s\n", i + 1, rounds[i][0], rounds[i][1], rounds[i][2]);
        }

        System.out.println("\nSummary:");
        System.out.println("Who      | Wins | Win %");
        System.out.println("-----------------------------");
        for (String[] row : stats) {
            System.out.printf("%-9s| %4s | %s\n", row[0], row[1], row[2]);
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many games do you want to play? ");
        int games = sc.nextInt();
        sc.nextLine(); // consume newline

        String[][] rounds = new String[games][3];
        int playerWins = 0, computerWins = 0, draws = 0;

        for (int i = 0; i < games; i++) {
            System.out.print("\nRound " + (i + 1) + " - Enter your move (rock/paper/scissors): ");
            String playerChoice = sc.nextLine().toLowerCase();

            String computerChoice = getComputerChoice();
            String winner = getWinner(playerChoice, computerChoice);

            if (winner.equals("Player")) playerWins++;
            else if (winner.equals("Computer")) computerWins++;
            else draws++;

            rounds[i][0] = playerChoice;
            rounds[i][1] = computerChoice;
            rounds[i][2] = winner;
        }

        String[][] stats = getStats(playerWins, computerWins, draws, games);
        displayResults(rounds, stats);
    }
}
