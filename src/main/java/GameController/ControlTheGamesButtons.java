package GameController;

import javax.swing.JButton;

import GameModel.GamesModel;
import GameView.View;
import Players.Player;
import Threads.Timer;

public interface ControlTheGamesButtons {

	public void controlTheButtons(Object source, GamesModel model, View view, Timer timer, Player P1, int allRounds,
			JButton[] gamesButtons);

	public void NewGameFunction(JButton[] gamesButtons);
}
