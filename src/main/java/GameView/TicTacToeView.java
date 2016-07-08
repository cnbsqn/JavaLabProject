package GameView;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TicTacToeView implements StrategyGamesView {
	public JButton[] gamesButtons = null;
	public String[] GamesButtonsLabels = null;
	public JPanel gamesButtonsPanel = null;

	int numberOfButtons;

	public TicTacToeView(JButton[] gamesButtons, String[] GamesButtonsLabels, JPanel gamesButtonsPanel) {
		gamesButtons = new JButton[9];
		GamesButtonsLabels = new String[9];
		for (int i = 0; i < 9; i++)
			GamesButtonsLabels[i] = " ";
		numberOfButtons = 9;

		this.gamesButtonsPanel = gamesButtonsPanel;
		this.gamesButtons = gamesButtons;
		this.GamesButtonsLabels = GamesButtonsLabels;
	}

	public int ReturnNumberOfButtons() {
		return numberOfButtons;
	}

	public String ReturnSignaturesOfButtons(int i) {
		return GamesButtonsLabels[i];
	}
}
