package GameController;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import GameModel.GamesModel;
import GameView.View;
import Players.Player;
import Threads.Timer;

public class OtherGamesButtons implements ControlTheGamesButtons {

	public void controlTheButtons(Object source, GamesModel model, View view, Timer timer, Player p1, int allRounds,
			JButton[] gamesButtons) {

		model.gamesModel.ChoiceOfTheFirstPlayer(((AbstractButton) source).getText(), model.P1);
		model.whichPlayer = !model.whichPlayer;
		view.setBadge(model.whichPlayer);
		model.EndOfTime(timer, p1, allRounds);

		model.gamesModel.Judge(model.P1, model.P2, model.win, model.lose, model.gamesModel.setRand(model.P1, model.P2));
		model.whichPlayer = !model.whichPlayer;
		view.setBadge(model.whichPlayer);
		model.StartTimerFunc(timer, p1.timeLimit, allRounds);

		model.roundFunction();
		view.printRound(model.round);
		view.printScore(model.P1.points, model.P2.points);
	}

	public void NewGameFunction(JButton[] gamesButtons) {
	}

}
