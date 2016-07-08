package JavaLabProject;

import org.junit.Assert;

import GameModel.GamesModel;
import Players.Player;
import Players.Student;

public class Tests {

	Player P1 = new Student();
	Player P2 = new Student();

	@org.junit.Test
	public void testCreateGamesModel() {
		GamesModel model = new GamesModel(P1, P2, 5, 1);
		Assert.assertNotNull(model);
		Assert.assertEquals(10, model.returnWin());
		Assert.assertEquals(20, model.returnLose());
	}

	@org.junit.Test
	public void testFromModelFunctionroundFunction() {
		GamesModel model = new GamesModel(P1, P2, 5, 2);
		Assert.assertEquals(1, model.roundFunction());
	}

	@org.junit.Test
	public void testFromModelFunctionWinner() {
		P1.points = 150;
		P2.points = -150;
		GamesModel model = new GamesModel(P1, P2, 5, 2);
		Assert.assertEquals(true, model.Winner());
	}

	@org.junit.Test
	public void testFromRockPaperScissorsModelFunctionRandom() {
		GamesModel model = new GamesModel(P1, P2, 5, 2);
		Assert.assertEquals(0, model.gamesModel.ChoiceOfTheFirstPlayer("Rock", P1));
		Assert.assertEquals(1, model.gamesModel.ChoiceOfTheFirstPlayer("Paper", P1));
		Assert.assertEquals(2, model.gamesModel.ChoiceOfTheFirstPlayer("Scissors", P1));
	}

	@org.junit.Test
	public void testFromHareAndDeerModelFunctionJudge() {
		GamesModel model = new GamesModel(P1, P2, 5, 3);
		P1.choice = 1;
		Assert.assertEquals(("Winners: " + P1.name + " and " + P2.name),
				model.gamesModel.Judge(P1, P2, model.win, model.lose, 1));
		P1.choice = 2;
		Assert.assertEquals(P1.name, model.gamesModel.Judge(P1, P2, model.win, model.lose, 1));
		P1.choice = 2;
		Assert.assertEquals(("Winners: " + P1.name + " and " + P2.name),
				model.gamesModel.Judge(P1, P2, model.win, model.lose, 2));
		P1.choice = 1;
		Assert.assertEquals(P2.name, model.gamesModel.Judge(P1, P2, model.win, model.lose, 2));
	}

	@org.junit.Test
	public void testFromTicTacToeModelFunctionWins() {
		GamesModel model = new GamesModel(P1, P2, 5, 0);
		String[] signatures = new String[9];
		// WIN O TEST
		signatures[0] = "O";
		signatures[1] = "O";
		signatures[2] = "O";
		signatures[3] = "X";
		signatures[4] = "O";
		signatures[5] = "X";
		signatures[6] = "X";
		signatures[7] = "X";
		signatures[8] = "X";

		Assert.assertEquals(true, model.gamesModel.Wins(P1, P2, model.win, model.lose, signatures));

		// WIN O TEST
		signatures[0] = "O";
		signatures[1] = " ";
		signatures[2] = "O";
		signatures[3] = "O";
		signatures[4] = "O";
		signatures[5] = " ";
		signatures[6] = "X";
		signatures[7] = " ";
		signatures[8] = "O";

		Assert.assertEquals(true, model.gamesModel.Wins(P1, P2, model.win, model.lose, signatures));

		// DRAW TEST
		signatures[0] = "X";
		signatures[1] = "O";
		signatures[2] = "X";
		signatures[3] = "O";
		signatures[4] = "O";
		signatures[5] = "X";
		signatures[6] = "X";
		signatures[7] = "X";
		signatures[8] = "O";

		Assert.assertEquals(true, model.gamesModel.Wins(P1, P2, model.win, model.lose, signatures));

		// NOBODY TO TEST
		signatures[0] = " ";
		signatures[1] = " ";
		signatures[2] = " ";
		signatures[3] = " ";
		signatures[4] = " ";
		signatures[5] = " ";
		signatures[6] = " ";
		signatures[7] = " ";
		signatures[8] = " ";

		Assert.assertEquals(false, model.gamesModel.Wins(P1, P2, model.win, model.lose, signatures));

	}

}
