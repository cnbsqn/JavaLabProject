package GameController;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import GameModel.GamesModel;
import GameView.View;
import Players.Player;
import Threads.Timer;

public class TTTButtons implements ControlTheGamesButtons {

	String[] signatures = new String[9];

	public void NewGameFunction(JButton[] gamesButtons) {
		resetButtons(gamesButtons);
		UpdateSignaturesOnButtons(gamesButtons);
	}

	public String[] UpdateSignaturesOnButtons(JButton[] buttons) {
		for (int i = 0; i < 9; i++)
			signatures[i] = buttons[i].getText();

		return signatures;
	}

	public void controlTheButtons(Object choice, GamesModel model, View view, Timer timer, Player P1, int allRounds,
			JButton[] gamesButtons) {
		if (((AbstractButton) choice).getText() == " ") {
			if (timer.gameOver)
				EndOfTime(model, timer, P1, allRounds, UpdateSignaturesOnButtons(gamesButtons),
						model.gamesModel.setChar(model.whichPlayer), gamesButtons);

			else
				((AbstractButton) choice).setText(model.gamesModel.setChar(model.whichPlayer));
			model.whichPlayer = !model.whichPlayer;
			view.setBadge(model.whichPlayer);
			model.StartTimerFunc(timer, P1.timeLimit, allRounds);
			if (model.gamesModel.Wins(model.P1, model.P2, model.win, model.lose,
					UpdateSignaturesOnButtons(gamesButtons))) {
				resetButtons(gamesButtons);
				UpdateSignaturesOnButtons(gamesButtons);
				model.roundFunction();
				view.printRound(model.round);
				view.printScore(model.P1.points, model.P2.points);
			}
		}
	}

	private void resetButtons(JButton[] gamesButtons) {
		for (int i = 0; i < 9; i++) {
			gamesButtons[i].setText(" ");
			gamesButtons[i].repaint();
		}
	}

	public void setRandomButton(GamesModel model, JButton[] gamesButtons, String symbol) {
		gamesButtons[model.gamesModel.CheckRandomButton(signatures, symbol)].setText(symbol);
	}

	public void EndOfTime(GamesModel model, Timer timer, Player P1, int allRounds, String[] Sigantures, String symbol,
			JButton[] gamesButtons) {
		setRandomButton(model, gamesButtons, symbol);
		model.gamesModel.EndOfTime(timer);
	}

}
