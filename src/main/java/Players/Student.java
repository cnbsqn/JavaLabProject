package Players;

import javax.swing.JOptionPane;

public class Student extends Player {
	public Student() {
		name = "Unknown";
		points = 100;
		money = 100;
		playerType = "Student";
		timeLimit = 120;
	}

	public Student(String _name, int _points, int _money) {
		name = _name;
		points = _points;
		money = _money;
		playerType = "Student";
		timeLimit = 120;
	}

	public void winText(int points, int randomText) {
		switch (randomText) {
		case 0:
			JOptionPane.showMessageDialog(null, "Holy shit, " + name + " you gained " + points + " points!\n");
			break;
		case 1:
			JOptionPane.showMessageDialog(null,
					"You can call yourself 'bad motherfucker'! " + name + " you gained " + points + " points!\n");
			break;
		}
	}

	public void loseText(int points, int randomText) {
		switch (randomText) {
		case 0:
			JOptionPane.showMessageDialog(null, "What a looser! " + name + ", you lost " + points + " points!\n");
			break;
		case 1:
			JOptionPane.showMessageDialog(null, name + " you're so fucked, you lost " + points + " points!\n");
			break;
		}
	}

}
