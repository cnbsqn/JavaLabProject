package GameView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DecorateView.DeerHuntDecorator;
import DecorateView.HeadsTailsDecorator;
import DecorateView.InterfaceView;
import DecorateView.RockPaperScissorsDecorator;
import DecorateView.TicTacToeDecorator;

public class View extends JFrame implements InterfaceView {

	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 600;
	public static final int WIDTH = 400;

	public JButton[] gamesButtons;
	public JButton newGame;
	protected JButton[] namesButtons;

	public JPanel panelOptions;
	public JPanel gamesButtonsPanel;
	public JPanel namesPanel;
	public JPanel timePanel = new JPanel();

	protected String[] GamesButtonsLabels;

	protected JLabel playerBadge[] = { new JLabel("", JLabel.CENTER), new JLabel("", JLabel.CENTER) };
	protected JLabel[] printScore = { new JLabel("Score", SwingConstants.CENTER), new JLabel("Score", SwingConstants.CENTER) };

	protected JLabel printRound;

	public JLabel countdownLabel = new JLabel();
	InterfaceView decoratedView = null;

	protected Color colors[] = { new Color(255, 255, 255), new Color(255, 255, 255) };

	public StrategyGamesView strategyView = null;

	public View(int game) {

		setLayout(null);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		gamesButtonsPanel = new JPanel();
		newGame = new JButton("NEW GAME");
		namesButtons = new JButton[2];
		printRound = new JLabel("ROUND: " + 1);

		panelOptions = new JPanel();

		/* 1 */ panelOptions.setBounds(20, 10, 100, 80);

		panelOptions.add(newGame);
		panelOptions.add(printRound);
		panelOptions.setOpaque(false);

		add(panelOptions);

		gamesButtonsPanel.setLayout(new GridLayout(3, 3));
		gamesButtonsPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		/* 2 */ gamesButtonsPanel.setBounds(40, 230, 300, 300);

		timePanel.setOpaque(false);
		Font font = new Font("Courier", Font.BOLD, 50);
		countdownLabel.setFont(font);
		timePanel.setPreferredSize(new Dimension(100, 50));
		timePanel.add(countdownLabel);
		/* 3 */ timePanel.setBounds(190, 10, 170, 80);

		add(timePanel);

		switch (game) {
		case 0:
			strategyView = new TicTacToeView(gamesButtons, GamesButtonsLabels, gamesButtonsPanel);
			break;
		case 1:
			strategyView = new HeadsAndTailsView(gamesButtons, GamesButtonsLabels, gamesButtonsPanel);
			break;
		case 2:
			strategyView = new RockPaperAndScissorsView(gamesButtons, GamesButtonsLabels, gamesButtonsPanel);
			break;
		case 3:
			strategyView = new DeerHuntView(gamesButtons, GamesButtonsLabels, gamesButtonsPanel);
			break;
		}

		switch (game) {
		case 0:
			decoratedView = new TicTacToeDecorator(this);
			break;
		case 1:
			decoratedView = new HeadsTailsDecorator(this);
			break;
		case 2:
			decoratedView = new RockPaperScissorsDecorator(this);
			break;
		case 3:
			decoratedView = new DeerHuntDecorator(this);
			break;
		}
		add(decoratedView.setTheGameBackground(WIDTH, HEIGHT));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void setPlayersInfo(String[] names, int score1, int score2) {
		printScore(score1, score2);
		setPlayersOnButtons(names);
		for (int i = 0; i < 2; i++) {
			namesPanel = new JPanel();

			namesPanel.setBackground(colors[i]);
			namesPanel.setLayout(new GridLayout(2, 0));

			namesButtons[i] = new JButton();

			namesButtons[i].setBackground(colors[i]);

			
			namesButtons[i].add(playerBadge[i]);

			namesPanel.add(namesButtons[i]);
			namesPanel.add(printScore[i]);

			/* 4 */ namesPanel.setBounds(10 + i * 180, 100, 180, 80);
			add(namesPanel);
		}
	}

	public void setGamesButtons() {
		gamesButtons = new JButton[strategyView.ReturnNumberOfButtons()];
		for (int i = 0; i < strategyView.ReturnNumberOfButtons(); i++) {
			gamesButtons[i] = new JButton(strategyView.ReturnSignaturesOfButtons(i));
			gamesButtonsPanel.add(gamesButtons[i]);
		}
		add(gamesButtonsPanel);
	}

	private void setPlayersOnButtons(String[] names) {
		for (int i = 0; i < 2; i++) {

			playerBadge[i] = new JLabel("PLAYER " + (i + 1) + ": " + names[i]);
		}
	}

	public void printRound(int round) {
		printRound.setText("ROUND: " + (round + 1));
	}

	public void printScore(int score1, int score2) {
		printScore[0].setText("SCORE: " + score1);
		printScore[1].setText("SCORE: " + score2);
	}

	public void setBadge(boolean whichPlayer) {
		if (whichPlayer == true) {
			playerBadge[0].setForeground(Color.RED);
			playerBadge[1].setForeground(Color.GREEN);
		}

		else {
			playerBadge[1].setForeground(Color.RED);
			playerBadge[0].setForeground(Color.GREEN);
		}
	}

	public JLabel setTheGameBackground(int x, int y) {

		return null;
	}

}
