package GameModel;

import Players.Player;
import Threads.Timer;

public interface StrategyGamesModel{
	public int ChoiceOfTheFirstPlayer(String choice, Player P1);
	public int Random(Player P1, Player P2, int n, int whoIsDrawing);
	public String Judge(Player P1, Player P2, int win, int lose, int randomChoice);
	public String setChar(boolean whichPlayer);
	public boolean Wins(Player P1, Player P2, int win, int lose, String []signatures);
	public boolean EndOfTime(Timer timer);
	public int CheckRandomButton(String []signatures, String symbol);
	public int setRand(Player P1, Player P2);
}
