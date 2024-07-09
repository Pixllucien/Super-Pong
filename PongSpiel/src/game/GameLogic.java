package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import actions.KeyHandler;
import gameObjects.BeweglichesRechteck;
import gui.GUIZwischenMenue;
import gui.Gui;

public class GameLogic {

	private Timer gameTimer;
	public int screenwidth;
	public int screenheight;
	public ArrayList<GameObject> spielObjekte;
	public int schwierigkeit = 0;

	private byte ballrichtung;

	public boolean keyLeftarrowpressed = false;
	public boolean keyRightarrowpressed = false;;
	public boolean keyUparrowpressed = false; 
	public boolean keyDownarrowpressed = false;
	public boolean keyEscapePressed = false;

	public boolean multiplayer = true;
	private BeweglichesRechteck ball;
	private BeweglichesRechteck stange2;
	private int ballPositionYAlt;
	private int ballPositionYNeu;

	private int geschwindigkeit;
	
	private Gui objGui;
	

	//Punktestand
	private int punktePlayer1 = 0;
	private int punktePlayer2 = 0;



	public GameLogic() {
		
		gameTimer = new Timer();
		spielObjekte = new ArrayList<GameObject>();

		//Ball erstellen und Startrichtung (Random) geben
		//0 = rechts
		//1 = links
		//2 = hoch
		//3 = runter
		ball = new BeweglichesRechteck(390, 290, 20, 20);
		spielObjekte.add(ball);
		Random rnd = new Random();
		ballrichtung = (byte) rnd.nextInt(0,4);



		//Stange 2 erstellen
		stange2 = new BeweglichesRechteck(770, 240, 20, 120);
		spielObjekte.add(stange2);

		gameTimer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				bewegung(); 
				if(keyEscapePressed == true) {
					objGui.closeWindow();
				}
			}
		}, 0, 5);



		//Schwierigkeit abfragen und Geschwindigkeit für KI-Feature anpassen
		geschwindigkeit = schwierigkeit+1;

		//KI Feature
		//0 Einfach
		//1 Mittel
		//2 Schwer
		gameTimer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				if(multiplayer == false) {
					ballPositionYAlt = ballPositionYNeu;
					ballPositionYNeu = ball.positionY;
					if(ballPositionYAlt > ballPositionYNeu) {
						stange2.positionY -= geschwindigkeit;
					} else if(ballPositionYAlt < ballPositionYNeu) {
						stange2.positionY += geschwindigkeit;
					}
				}
			}
		}, 0, 5);
		System.out.println("Geschwindigkeit = " + geschwindigkeit);
	}








	public void bewegung() {
		// Laufende Ausführungen im Spiel:

		if (ballrichtung == 0 && ball.positionX > 0) {
			ball.positionX -= geschwindigkeit;
		} else if (ballrichtung == 1 && ball.positionX < (screenwidth-20)) {
			ball.positionX += geschwindigkeit;
		}
		else if (ballrichtung == 2 && ball.positionY > 0) { 
			ball.positionY -= geschwindigkeit; 
		}
		else if (ballrichtung == 3 && ball.positionY < (screenheight-50)) {
			ball.positionY += geschwindigkeit; 
		}
	}


	public void setMultiplayer(boolean pMultiplayer) {
		multiplayer = pMultiplayer;
	}

	public boolean getMultiplayer() {
		return multiplayer;
	}


	public int getSchwierigkeit() {
		return schwierigkeit;
	}

	public int getPunktePlayer1() {
		return punktePlayer1;
	}

	public int getPunktePlayer2() {
		return punktePlayer2;
	}


}





