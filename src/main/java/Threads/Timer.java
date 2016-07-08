package Threads;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Players.Player;

public class Timer implements Runnable {
	NumberFormat formatter = new DecimalFormat("#00");
	private JLabel timeLabel;
	public JLabel countdownLabel;
	public int minutes = 0;
	public int seconds = 0;
	public boolean getState = true;
	int time = 0;
	int round;
	int timeLimit;
	
	public Player P = null;

	public boolean hurryUp = false;
	public boolean gameOver = false;

	public Timer(Player P, JLabel timeLabel, JLabel countdownLabel) {
		super();
		this.P = P;
		this.timeLabel = timeLabel;
		this.countdownLabel = countdownLabel;
	}

	public void countTime(int limit, int round) {
		System.out.println(limit);
		this.timeLimit = limit / round;
	}

	public void run() {
		while (getState) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException exc) {
				JOptionPane.showMessageDialog(null, "Time counter has stopped.");
				return;
			}

			if (!(CountGameTime(getState)) && timeLabel != null)
				System.exit(0);

			EndTheRound(hurryUp);
		}
	}

	void displayTime() {
		timeLabel.setText(formatter.format(minutes) + ":" + formatter.format(seconds));
	}

	boolean CountGameTime(boolean getState) {
		time++;
		minutes = time / 60;
		seconds = time % 60;
		if (timeLabel != null)
			displayTime();
		if (!getState)
			JOptionPane.showMessageDialog(null, "Game was running for: " + minutes + ":" + seconds);
		return getState;
	}

	public void EndTheRound(boolean hurryUp) {
		if (hurryUp) {

			displayHurryUpTime();
			if (timeLimit < 0) {
				gameOver = true;
			}
		}

	}

	public int EndTime(Player P) {
		System.out.println("End of time!");
		P.choice = 3;
		return P.choice;
	}

	public void displayHurryUpTime() {
		int min = 0, s = 0;
		countdownLabel.setForeground(Color.BLACK);
		if (((timeLimit) >= 0)) {
			min = timeLimit / 60;
			s = timeLimit % 60;
			countdownLabel.setText(formatter.format(min) + ":" + formatter.format(s));
			if (timeLimit < 10)
				countdownLabel.setForeground(Color.RED);
			timeLimit--;
		}

		else {
			countdownLabel.setForeground(Color.RED);
			countdownLabel.setText("End of time!");
		}
	}

}
