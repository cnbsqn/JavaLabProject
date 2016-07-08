package GameView;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RockPaperAndScissorsView implements StrategyGamesView {

	public JButton[] gamesButtons = null;
	public String[] GamesButtonsLabels = null;
	public JPanel gamesButtonsPanel = null;

	int numberOfButtons;

	public RockPaperAndScissorsView(JButton[] gamesButtons, String[] GamesButtonsLabels, JPanel gamesButtonsPanel) {
		gamesButtons = new JButton[3];
		GamesButtonsLabels = new String[3];
		GamesButtonsLabels[0] = "Rock";
		GamesButtonsLabels[1] = "Paper";
		GamesButtonsLabels[2] = "Scissors";
		numberOfButtons = 3;

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
