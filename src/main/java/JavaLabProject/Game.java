package JavaLabProject;

import GameController.GamesController;
import GameModel.GamesModel;
import GameView.View;
import Menu.Menu;
import Players.Player;

public class Game {
	View view = null;
	GamesController controller = null;
	GamesModel model = null;
	Menu menu = null;

	public Game(Player P1, Player P2, int game, int round) {

		switch (game) {

		case 0:
		case 1:
		case 2:
		case 3:
			view = new View(game);
			model = new GamesModel(P1, P2, round, game);
			controller = new GamesController(model, view, game);
			break;
		case 5:
			menu = new Menu();

		}
	}
}
