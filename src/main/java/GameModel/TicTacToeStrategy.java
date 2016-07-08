
package GameModel;

import javax.swing.JOptionPane;

import Players.Player;
import Threads.Timer;

public class TicTacToeStrategy implements StrategyGamesModel {

	public String[] symbole = { "O", "X" };
	public String symbol = "O";
	String[] signatures = new String[9];

	public String setChar(boolean whichPlayer) {

		if (whichPlayer == true) {
			symbol = symbole[1];
		} else {
			symbol = symbole[0];
		}
		return symbol;
	}

	public boolean Wins(Player P1, Player P2, int win, int lose, String[] signatures) {
		boolean Status = false;
		int count = 0;

		if ((signatures[0] == signatures[1] && signatures[1] == signatures[2] && signatures[2] == symbol)
				|| (signatures[3] == signatures[4] && signatures[4] == signatures[5] && signatures[5] == symbol)
				|| (signatures[6] == signatures[7] && signatures[7] == signatures[8] && signatures[8] == symbol)
				|| (signatures[0] == signatures[4] && signatures[4] == signatures[8] && signatures[8] == symbol)
				|| (signatures[2] == signatures[4] && signatures[4] == signatures[6] && signatures[6] == symbol)

				|| (signatures[0] == signatures[3] && signatures[3] == signatures[6] && signatures[6] == symbol)
				|| (signatures[1] == signatures[4] && signatures[4] == signatures[7] && signatures[7] == symbol)
				|| (signatures[2] == signatures[5] && signatures[5] == signatures[8] && signatures[8] == symbol)) {

			if (symbol == "X") {
				JOptionPane.showMessageDialog(null, P2.name + " has won.");
				P2.points += win;
				P1.points -= lose;
			}

			else if (symbol == "O") {
				JOptionPane.showMessageDialog(null, P1.name + " has won.");
				P1.points += win;
				P2.points -= lose;
			}
			Status = true;
		}

		else {
			for (int i = 0; i < 9; i++)
				if (signatures[i] != " ")
					count++;
			if (count == 9) {
				JOptionPane.showMessageDialog(null, "It's a draw!");
				Status = true;
			}
		}
		return Status;

	}

	public int CheckRandomButton(String[] signatures, String symbol) {
		int random;
		for (int i = 0; i < 9; i++)
			System.out.println(signatures[i]);
		do
			random = (int) (Math.random() * 9);
		while (signatures[random] != " ");
		return random;
	}

	public boolean EndOfTime(Timer timer) {
		JOptionPane.showMessageDialog(null, "End of time! Symbol will be placed on random position.");
		timer.gameOver = false;
		return timer.gameOver;
	}

	public int ChoiceOfTheFirstPlayer(String choice, Player P1) {
		return 0;
	}

	public int Random(Player P1, Player P2, int n, int whoIsDrawing) {
		return 0;
	}

	public String Judge(Player P1, Player P2, int win, int lose, int randomChoice) {
		return null;
	}

	public int setRand(Player P1, Player P2) {
		return 0;
	}

}
