package GameModel;

import javax.swing.JOptionPane;

import Players.Player;
import Threads.Timer;

public class RockPaperScissorsStrategy implements StrategyGamesModel {

	public int Random(Player P1, Player P2, int n, int whoIsDrawing) {
		int choice;
		choice = (int) (Math.random() * n);
		if (choice == 0)
			JOptionPane.showMessageDialog(null, "Player " + P2.name + " has chosen: ROCK.");
		else if (choice == 1)
			JOptionPane.showMessageDialog(null, "Player " + P2.name + " has chosen: PAPER.");
		else
			JOptionPane.showMessageDialog(null, "Player " + P2.name + " has chosen: SCISSORS.");
		return choice;
	}

	public int setRand(Player P1, Player P2) {
		return Random(P1, P2, 3, 0);
	}

	public String Judge(Player P1, Player P2, int win, int lose, int randomChoice) {

		String winner = P1.name;
		P2.choice = randomChoice;
		int drawn = P2.choice;
		if ((P1.choice == 0 && drawn == 2) || (P1.choice == 2 && drawn == 1) || (P1.choice == 1 && drawn == 0)) {
			drawn = (int) (Math.random() * 2);
			P1.points += win;
			P1.winText(win, drawn);
			P2.points -= lose;
			P2.loseText(lose, drawn);
		}

		else if (P1.choice == drawn) {
			System.out.println("It's a draw!");
			winner = "draw";
		}

		else {
			if (P1.choice == 3 || (P1.choice != 0 && P1.choice != 1 && P1.choice != 2)) {
				System.out.println(P2.name + " has won " + win + " points.");
				P2.points += win;
				P1.points -= lose;
				winner = P2.name;
			} else if (((P2.choice == 0 && drawn == 2) || (P2.choice == 2 && drawn == 1)
					|| (P2.choice == 1 && drawn == 0)))
				P2.points += win;
			P2.winText(win, drawn);
			P1.points -= lose;
			P1.loseText(lose, drawn);
			winner = P2.name;
		}
		return winner;
	}

	public int ChoiceOfTheFirstPlayer(String choice, Player P1) {
		if (choice == "Rock") {
			JOptionPane.showMessageDialog(null, P1.name + " has chosen: ROCK.");
			P1.choice = 0;
		} else if (choice == "Paper") {
			JOptionPane.showMessageDialog(null, P1.name + " has chosen: PAPER.");
			P1.choice = 1;
		} else if (choice == "Scissors") {
			JOptionPane.showMessageDialog(null, P1.name + " has chosen: SCISSORS.");
			P1.choice = 2;
		}
		return P1.choice;

	}

	public String setChar(boolean whichPlayer) {

		return null;
	}

	public boolean Wins(Player P1, Player P2, int win, int lose, String[] Signatures) {

		return false;
	}

	public boolean EndOfTime(Timer timer) {

		return false;
	}

	public int CheckRandomButton(String[] Signatures, String symbol) {

		return 0;
	}
}
