package Players;

import javax.swing.JOptionPane;

public class Preschooler extends Player {

	public Preschooler() {
		name = "Unknown";
		points = 0;
		money = 100;
		playerType = "Preschooler";
		timeLimit = 360;
	}

	public Preschooler(String _name, int _points, int _money) {
		name = _name;
		points = _points;
		money = _money;
		playerType = "Preschooler";
		timeLimit = 360;
	}

	public void winText(int points, int randomText) {
		switch (randomText) {
		case 0:
			JOptionPane.showMessageDialog(null, "Well done " + name + ", you gained " + points + " points!\n");
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Nice work " + name + ", you gained " + points + " points!\n");
			break;
		}
	}

	public void loseText(int points, int randomText) {
		switch (randomText) {
		case 0:
			JOptionPane.showMessageDialog(null, "Bad luck " + name + ", you lost " + points + " points!\n");
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Sorry, " + name + ". You lost " + points + " points!\n");
			break;
		}
	}
}
