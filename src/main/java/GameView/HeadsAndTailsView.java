package GameView;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HeadsAndTailsView implements StrategyGamesView {

	public JButton[] gamesButtons = null;
	public String[] GamesButtonsLabels = null;
	public JPanel gamesButtonsPanel = null;

	int numberOfButtons;

	public HeadsAndTailsView(JButton[] gamesButtons, String[] GamesButtonsLabels, JPanel gamesButtonsPanel) {
		gamesButtons = new JButton[2];
		GamesButtonsLabels = new String[2];
		GamesButtonsLabels[0] = "Tail";
		GamesButtonsLabels[1] = "Head";
		numberOfButtons = 2;

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
