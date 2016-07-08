package GameModel;

import javax.swing.JOptionPane;

import Players.Player;
import Threads.Timer;

public class HeadsTailsStrategy implements StrategyGamesModel {

	protected int win = 10;
	protected int lose = 20;

	protected int allRounds;
	public int round;

	public int Random(Player P1, Player P2, int n, int whoIsDrawing) {
		int choice;
		choice = (int) (Math.random() * n);
		if (choice == 0)
			if (whoIsDrawing == 0)
				JOptionPane.showMessageDialog(null, "TAIL here!");
			else
				JOptionPane.showMessageDialog(null, P2.name + " has chosen TAIL.");
		else if (whoIsDrawing == 0)
			JOptionPane.showMessageDialog(null, "HEAD here!");
		else
			JOptionPane.showMessageDialog(null, P2.name + " has chosen HEAD.");
		return choice;
	}

	public int ChoiceOfTheFirstPlayer(String choice, Player P1) {
		if (choice == "Tail") {
			JOptionPane.showMessageDialog(null, P1.name + " has chosen TAIL.");
			P1.choice = 0;
		} else if (choice == "Head") {
			JOptionPane.showMessageDialog(null, P1.name + " has chosen HEAD.");
			P1.choice = 1;
		}
		return P1.choice;
	}

	public int setRand(Player P1, Player P2) {
		return Random(P1, P2, 2, 2);
	}

	public String Judge(Player P1, Player P2, int win, int lose, int randomChoice) {

		P2.choice = randomChoice;
		round++;
		String winner = P1.name;

		JOptionPane.showMessageDialog(null, "Tossing a coin...");
		int drawn = Random(P1, P2, 2, 0);

		if (P1.choice == drawn) {
			drawn = (int) (Math.random() * 2);
			P1.points += win;
			P1.winText(win, drawn);
			P2.points -= lose;
			P2.loseText(lose, drawn);
		}

		else {
			if (P1.choice == 3 || (P1.choice != 0 && P1.choice != 1)) {
				JOptionPane.showMessageDialog(null, " End of time! " + P2.name + " has won " + win + " points.");
				P2.points += win;
				P1.points -= lose;
				winner = P2.name;
			}

			else if (P1.choice != drawn && P2.choice != drawn) {
				JOptionPane.showMessageDialog(null, "No one guessed correctly :-(");
				winner = "draw";
			} else {
				drawn = (int) (Math.random() * 2);
				P2.points += win;
				P2.winText(win, drawn);
				P1.points -= lose;
				P1.loseText(lose, drawn);
				winner = P2.name;
			}
		}
		return winner;
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
