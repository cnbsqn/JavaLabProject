package Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import JavaLabProject.Game;
import Players.Player;
import Players.Preschooler;
import Players.Student;
import Players.Pupil;
import Threads.Timer;

@SuppressWarnings("unused")
public class Menu extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 400;
	public static final int WIDTH = 430;
	private JComboBox<String> comboPlayersBox;
	private JComboBox<String> comboGamesBox;

	private JButton startButton;
	private JButton exit;

	public JLabel timeLabel = new JLabel("00:00");

	Timer timer = new Timer(null, timeLabel, null);
	Thread timerThread = new Thread(timer);

	private JPanel gamersPanel;;
	private JPanel gamesPanel;
	private JPanel timePanel;

	String string[] = {};
	String playerType[] = { "Preschooler", "Pupil", "Student" };
	String gamesAvailable[] = { "Tic Tac Toe", "Heads or Tails", "Rock-Paper-Scissors", "Deer & hare hunting" };

	public int round;

	public Player P1, P2;

	public Menu() {
		setLayout(new FlowLayout());

		P1 = null;
		P2 = null;
		round = 0;

		comboPlayersBox = new JComboBox<String>(playerType);
		createMenuPanels(gamersPanel, comboPlayersBox, "CHOOSE PLAYER TYPE");

		comboPlayersBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboPlayersBox.getSelectedIndex() == 0) {
					comboGamesBox.removeAllItems();
					for (int i = 0; i < 2; i++) {
						comboGamesBox.addItem(gamesAvailable[i]);
					}
				}

				else if (comboPlayersBox.getSelectedIndex() == 1) {
					comboGamesBox.removeAllItems();
					for (int i = 0; i < 3; i++) {
						comboGamesBox.addItem(gamesAvailable[i]);
					}
				}

				else if (comboPlayersBox.getSelectedIndex() == 2) {
					comboGamesBox.removeAllItems();
					for (int i = 0; i < 4; i++) {
						comboGamesBox.addItem(gamesAvailable[i]);
					}
				}
			}
		});

		comboGamesBox = new JComboBox<String>();
		createMenuPanels(gamesPanel, comboGamesBox, "CHOOSE GAME");

		/* */

		startButton = new JButton("START GAME");
		startButton.addActionListener(this);
		add(startButton);

		exit = new JButton("EXIT");
		exit.addActionListener(this);
		add(exit);

		timePanel = new JPanel();

		timePanel.setPreferredSize(new Dimension(50, 50));

		timePanel.add(timeLabel);
		add(timePanel);

		timerThread.start();

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private void createMenuPanels(JPanel jpanel, JComboBox<String> jcombobox, String string) {
		jpanel = new JPanel();
		jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
		Label namelabel = new Label(string);
		jpanel.setBorder(BorderFactory.createEmptyBorder());
		jpanel.add(namelabel);
		Font font = new Font("Courier", Font.BOLD, 12);
		namelabel.setFont(font);
		jpanel.setPreferredSize(new Dimension(300, 70));
		jpanel.add(jcombobox);
		add(jpanel);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (((AbstractButton) source).getText() == "EXIT") {
			timer.getState = false;
		}

		if (((AbstractButton) source).getText() == "START GAME") {

			callPlayer(comboPlayersBox.getSelectedIndex(), "P1");
			setPlayersNames(comboGamesBox.getSelectedIndex());

			callGame(comboGamesBox.getSelectedIndex());
		}
	}

	public void callPlayer(int playerType, String playerName) {

		if (playerType == 0) {
			P1 = new Preschooler(playerName, 100, 100);
			P2 = new Preschooler("Computer", 100, 100);
			System.out.println(P1.timeLimit);

		}

		else if (playerType == 1) {
			P1 = new Pupil(playerName, 100, 100);
			P2 = new Pupil("Computer", 100, 100);
		}

		else if (playerType == 2) {
			P1 = new Student(playerName, 100, 100);
			P2 = new Student("Computer", 100, 100);
		}
	}

	private void setPlayersNames(int game) {
		P1.setName();
		if (game == 0)
			P2.setName();
	}

	public void callGame(final int game) {
		round = Integer.parseInt(JOptionPane.showInputDialog(null, "How many rounds you wish to play: "));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Game(P1, P2, game, round);
			}
		});
	}

}
