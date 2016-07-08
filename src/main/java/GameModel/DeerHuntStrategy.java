package GameModel;

import javax.swing.JOptionPane;

import Players.Player;
import Threads.Timer;

public class DeerHuntStrategy implements StrategyGamesModel {

	public int Random(Player P1, Player P2, int n, int whoIsDrawing) {
		int choice;
		choice = (int) ((Math.random() * n) + 1);
		if (choice == 1)
			JOptionPane.showMessageDialog(null, P2.name + " is hunting: DEER.");
		else if (choice == 2)
			JOptionPane.showMessageDialog(null, P2.name + " is hunting: HARE.");
		return choice;
	}

	public int setRand(Player P1, Player P2) {
		return Random(P1, P2, 2, 0);
	}

	public String Judge(Player P1, Player P2, int winHare, int winDeer, int randomChoice) {
		int drawn;
		winHare = 1;
		winDeer = 2;
		String winner;

		P2.choice = randomChoice;

		if (P1.choice == 3 || (P1.choice != 1 && P1.choice != 2)) {
			JOptionPane.showMessageDialog(null, P2.name + " has won and gained " + winHare + " points.");
			P2.points += winHare;
			P1.points -= winHare;
			winner = P2.name;
		}

		else if ((P1.choice == P2.choice) && (P1.choice == 1)) {
			P1.points += 2;
			P2.points += 2;
			drawn = (int) (Math.random() * 2);
			P1.winText(winDeer, drawn);
			P2.winText(winDeer, drawn);
			winner = ("Winners: " + P1.name + " and " + P2.name);
		}

		else if ((P1.choice == 2) && (P2.choice == 1)) {
			P1.points += winHare;
			drawn = (int) (Math.random() * 2);
			P1.winText(winHare, drawn);
			P2.loseText(winDeer, drawn);
			winner = P1.name;
		}

		else if ((P1.choice == 1 && P2.choice == 2)) {
			P2.points += winHare;
			drawn = (int) (Math.random() * 2);
			P2.winText(winHare, drawn);
			P1.loseText(winDeer, drawn);
			winner = P2.name;
		}

		else {
			P1.points += winHare;
			P2.points += winHare;
			drawn = (int) (Math.random() * 2);
			P1.winText(winHare, drawn);
			P2.winText(winHare, drawn);
			winner = ("Winners: " + P1.name + " and " + P2.name);
		}
		return winner;
	}

	public int ChoiceOfTheFirstPlayer(String choice, Player P1) {
		if (choice == "Deer") {
			JOptionPane.showMessageDialog(null, P1.name + " is hunting: DEER.");
			P1.choice = 1;
		} else if (choice == "Hare") {
			JOptionPane.showMessageDialog(null, P1.name + " is hunting: HARE.");
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

	public int CheckRandomButton(String[] Signatures, String znak) {

		return 0;
	}
}
