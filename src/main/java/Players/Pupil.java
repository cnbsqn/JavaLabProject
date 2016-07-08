package Players;

import javax.swing.JOptionPane;

public class Pupil extends Player {

	public Pupil() {
		name = "Unknown";
		points = 0;
		money = 100;
		playerType = "Pupil";
		timeLimit = 240;
	}

	public Pupil(String _name, int _points, int _money) {
		name = _name;
		points = _points;
		money = _money;
		playerType = "Pupil";
		timeLimit = 240;
	}

	public void winText(int points, int randomText) {
		switch (randomText) {
		case 0:
			JOptionPane.showMessageDialog(null, "Really nice, " + name + "! You gained " + points + " points!\n");
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Pretty well, dude. " + name + ", you gained " + points + " points!\n");
			break;
		}
	}

	public void loseText(int points, int randomText) {
		switch (randomText) {
		case 0:
			JOptionPane.showMessageDialog(null, "Damn it! " + name + ", you lost " + points + " points!\n");
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Sorry, bro :(. " + name + ", you lost " + points + " points!\n");
			break;
		}
	}

}
