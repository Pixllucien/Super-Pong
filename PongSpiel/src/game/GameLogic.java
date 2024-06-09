package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import actions.KeyHandler;
import gameObjects.BeweglichesRechteck;

public class GameLogic {

	private Timer gameTimer;
	public int screenwidth;
	public int screenheight;
	public ArrayList<GameObject> spielObjekte;
	public int schwierigkeit = 0;


	//private BeweglichesRechteck beweglichesRechteck; 
	private byte ballrichtung;

	public boolean keyLeftarrowpressed = false;
	public boolean keyRightarrowpressed = false;;
	public boolean keyUparrowpressed = false; 
	public boolean keyDownarrowpressed = false;
	//private BeweglichesRechteck beispielObjekt1;
	//private BeweglichesRechteck beispielObjekt2; 

	public boolean multiplayer = true;
	private BeweglichesRechteck ball;
	private BeweglichesRechteck stange2;
	private int ballPositionYAlt;
	private int ballPositionYNeu;

	public GameLogic() {

		gameTimer = new Timer();
		spielObjekte = new ArrayList<GameObject>();

		/*
		beispielObjekt1 = new BeweglichesRechteck(50, 100, 20, 20);
		spielObjekte.add(beispielObjekt1);
		beispielObjekt1.richtung = 0; // Startrichtung
		beispielObjekt2 = new BeweglichesRechteck(300, 400, 20, 20);
		spielObjekte.add(beispielObjekt2);
		 */

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
			}
		}, 0, 5);

		//beweglichesRechteck = new BeweglichesRechteck(); 

		//KI Feature
		gameTimer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {

				if(multiplayer == false) {
					ballPositionYAlt = ballPositionYNeu;
					ballPositionYNeu = ball.positionY;
					if(ballPositionYAlt > ballPositionYNeu) {
						stange2.positionY -= 1;
					} else if(ballPositionYAlt < ballPositionYNeu) {
						stange2.positionY += 1;
					}
				}
			}
		}, 0, 5);
	}






	public void bewegung() {
		// Laufende Ausführungen im Spiel:
		//beispielObjekt1.automatischeKreisbewegung();

		/*
		if (keyLeftarrowpressed) {
			beispielObjekt2.positionX -= 1;
		} else if (keyRightarrowpressed) {
			beispielObjekt2.positionX += 1;
		}
		else if (keyUparrowpressed) { 
			beispielObjekt2.positionY -= 1; 
		}
		else if (keyDownarrowpressed) {
			beispielObjekt2.positionY += 1; 
		}
		 */

		if (ballrichtung == 0 && ball.positionX > 0) {
			ball.positionX -= 1;
		} else if (ballrichtung == 1 && ball.positionX < (screenwidth-20)) {
			ball.positionX += 1;
		}
		else if (ballrichtung == 2 && ball.positionY > 0) { 
			ball.positionY -= 1; 
		}
		else if (ballrichtung == 3 && ball.positionY < (screenheight-50)) {
			ball.positionY += 1; 
		}
	}

	/*public void colision() {

		if(beispielObjekt1.positionX == beispielObjekt2.positionX) {
			//keyHandler.invert = (-1); 

		}
	}
	 */


	public void setMultiplayer(boolean pMultiplayer) {
		multiplayer = pMultiplayer;
	}

	public boolean getMultiplayer() {
		return multiplayer;
	}
}