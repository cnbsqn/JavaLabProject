package Players;

import javax.swing.JOptionPane;

import Interfaces.LoseGame;
import Interfaces.WinGame;

public abstract class Player implements WinGame, LoseGame {

	// variables
	public String name = "Unknown";
	public int points;
	int money;
	public int choice = 3;
	public int timeLimit;
	String playerType = "Player Type";

	//constructor
	public Player() {
	}

	//methods
	String getPlayerType() {
		return playerType;
	}

	String getName() {
		return name;
	}

	int getScore() {
		return money;
	}

	public void displayPlayerInfo() {
		System.out.println(getName() + "(" + getPlayerType() + ")" + " starts game with " + getScore() + " points");
	}

	public void strategy(int tab[], int n, int i) {
		tab[i] = choice;
	}

	public void displayStrategy(int tab[], int n) {
		System.out.print(name + "'s" + " strategy: { ");
		for (int i = 0; i < n; i++)
			System.out.print(tab[i] + " ");
		System.out.println("}");
	}

	public void setName() {
		name = JOptionPane.showInputDialog("Input your name: ");
		displayPlayerInfo();
	}

}