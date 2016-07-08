package GameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import GameModel.GamesModel;
import GameView.View;
import Players.Player;
import Threads.Timer;

public class GamesController implements ActionListener {

	GamesModel model = null;
	View view = null;

	String[] names = new String[2];

	Timer timer = null;
	Thread threadtimer = new Thread(timer);
	ControlTheGamesButtons ctgb = null;

	public GamesController(final GamesModel model, final View view, int game) {

		this.view = view;
		this.model = model;
		names[0] = model.P1.name;
		names[1] = model.P2.name;

		view.setPlayersInfo(names, model.P1.points, model.P2.points);
		timer = new Timer(model.P1, null, view.countdownLabel);
		Thread threadtimer = new Thread(timer);

		threadtimer.start();

		view.setBadge(model.whichPlayer);

		view.setGamesButtons();

		addActionListeners();
		System.out.println(model.P1.name);
		StartTimerFunc(model.P1.timeLimit, model.allRounds);

		switch (game) {
		case 0:
			ctgb = new TTTButtons();
			break;
		case 1:
		case 2:
		case 3:
			ctgb = new OtherGamesButtons();
			break;
		}

		view.newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctgb.NewGameFunction(view.gamesButtons);
				view.printRound(model.round);
				model.P1.points = 100;
				model.P2.points = 100;
				view.printScore(model.P1.points, model.P2.points);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		ctgb.controlTheButtons((AbstractButton) source, model, view, timer, model.P1, model.allRounds,
				view.gamesButtons);

	}

	private void addActionListeners() {
		for (JButton gamesButtons : view.gamesButtons)
			gamesButtons.addActionListener(this);
	}

	protected boolean StartTimerFunc(int timeLimit, int allRoundss) {

		timer.countTime(timeLimit, allRoundss);
		timer.gameOver = false;
		timer.hurryUp = true;

		return true;
	}

	protected boolean EndOfTime(Player p1, int allRoundss) {
		System.out.println(p1.name);
		if ((p1.choice == 0 || p1.choice == 1 || p1.choice == 2) && timer.gameOver == false)
			timer.gameOver = true;
		else if ((p1.choice != 0 || p1.choice != 1 || p1.choice != 2) && timer.gameOver == false)
			timer.gameOver = true;
		else
			p1.choice = timer.EndTime(p1);

		return timer.gameOver;
	}
}
