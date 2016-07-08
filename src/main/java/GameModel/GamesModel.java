package GameModel;

import javax.swing.JOptionPane;
import Players.Player;
import Threads.Timer;

public class GamesModel {

	public boolean whichPlayer = false;

	public int allRounds;
	public Player P1 = null;
	public Player P2 = null;
	public int round = 0;
	public int win;
	public int lose;
	public StrategyGamesModel gamesModel = null;

	public GamesModel(Player P1, Player P2, int allRounds, int game) {
		this.P1 = P1;
		this.P2 = P2;

		this.allRounds = allRounds;
		round = 0;

		switch (game) {
		case 0:
			gamesModel = new TicTacToeStrategy();
			break;
		case 1:
			gamesModel = new HeadsTailsStrategy();
			break;
		case 2:
			gamesModel = new RockPaperScissorsStrategy();
			break;
		case 3:
			gamesModel = new DeerHuntStrategy();
			break;
		}
		win = 10;
		lose = 20;

	}

	public int roundFunction() {
		this.round++;
		if (round == allRounds) {
			Winner();
			System.exit(0);
		}
		return round;
	}

	public boolean Winner() {
		boolean theFirstPlayerIsTheWinner = false;
		if (P1.points > P2.points) {
			JOptionPane.showMessageDialog(null, P1.name + " has won and gained " + P1.points + " points!\n" + P2.name
					+ " lost and has gained " + P2.points + " points.");
			theFirstPlayerIsTheWinner = true;
		} else if (P2.points > P1.points)
			JOptionPane.showMessageDialog(null, P2.name + " has won and gained " + P2.points + " points\n" + P1.name
					+ " lost and has gained " + P1.points + " points.");
		else
			JOptionPane.showMessageDialog(null, "End of the rounds. Final score: it's a draw.");

		return theFirstPlayerIsTheWinner;
	}

	public boolean StartTimerFunc(Timer timer, int timeLimit, int allRoundss) {

		timer.countTime(timeLimit, allRoundss);
		timer.gameOver = false;
		timer.hurryUp = true;

		return true;
	}

	public boolean EndOfTime(Timer timer, Player P1, int allRounds) {
		System.out.println(P1.name);
		if ((P1.choice == 0 || P1.choice == 1 || P1.choice == 2) && timer.gameOver == false)
			timer.gameOver = true;
		else if ((P1.choice != 0 || P1.choice != 1 || P1.choice != 2) && timer.gameOver == false)
			timer.gameOver = true;
		else
			P1.choice = timer.EndTime(P1);

		return timer.gameOver;
	}

	public int returnWin() {
		return win;
	}

	public int returnLose() {
		return lose;
	}

}
