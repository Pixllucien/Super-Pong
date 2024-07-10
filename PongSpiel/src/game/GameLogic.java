package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import game.RandomBewegung;

import gameObjects.BeweglichesRechteck;

public class GameLogic {

	private Timer gameTimer;
	public int screenwidth;
	public int screenheight;
	public ArrayList<GameObject> spielObjekte;

	public boolean keyLeftarrowpressed;
	public boolean keyRightarrowpressed;
	public boolean keyUparrowpressed;
	public boolean keyDownarrowpressed;

	public boolean keyWpressed;
	public boolean keyApressed;
	public boolean keySpressed;
	public boolean keyDpressed;
	public boolean runX = false;
	public boolean runY = false;
	private int punkteSp1 = 0;
	private int punkteSp2 = 0;
	private int wait = 0;

	private int add = 0;
	Random rnd = new Random();

	private Collision objCollision;
	public int screen;

	public GameLogic() {

		objCollision = new Collision();

		gameTimer = new Timer();
		spielObjekte = new ArrayList<GameObject>();
		RandomBewegung randomBewegung = new RandomBewegung();
		keyLeftarrowpressed = false;
		keyRightarrowpressed = false;

		// Objekte im Spiel:

		BeweglichesRechteck ball = new BeweglichesRechteck(350, 280, 20, 20);
		spielObjekte.add(ball);
		ball.richtung = 0; // Startrichtung
		BeweglichesRechteck spieler1 = new BeweglichesRechteck(25, 280, 20, 80);
		BeweglichesRechteck spieler2 = new BeweglichesRechteck(735, 280, 20, 80);
		spielObjekte.add(spieler1);
		spielObjekte.add(spieler2);
		gameTimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {

				if (keyUparrowpressed) {
					spieler2.positionY -= 1;
				} else if (keyDownarrowpressed) {
					spieler2.positionY += 1;
				}

				if (keyWpressed) {
					spieler1.positionY -= 1;
				} else if (keySpressed) {
					spieler1.positionY += 1;
				}

				if (wait <= 0) {
					randomBewegung.randomBewegungX(ball, runX, screenheight, spieler1, spieler2);
					runX = true;
					randomBewegung.randomBewegungY(ball, runY, screenheight, spieler1, spieler2);
					runY = true;
				}
				
				setPunkteSp2(objCollision.collisonLeft(ball, 0));
				setPunkteSp1(objCollision.collisionRight(ball, 760));
				System.out.println("Spielstand: " + getPunkteSp1() + "   " + getPunkteSp2());

				if (objCollision.collisionRight(ball, 760) == 1 || objCollision.collisonLeft(ball, 0) == 1) {
					ball.positionX = 350;
					ball.positionY = 280;
					runX = false;
					runY = false;
					// hier bitte warten
					wait = 100;
				}
				if (wait > 0) {
					wait--;
				}

			}
		}, 0, 5); // war mal 5
	}

	public int getPunkteSp2() {
		return punkteSp2;
	}

	public void setPunkteSp2(int punkteSp2) {
		this.punkteSp2 += punkteSp2;
	}

	public int getPunkteSp1() {
		return punkteSp1;
	}

	public void setPunkteSp1(int punkteSp1) {
		this.punkteSp1 += punkteSp1;
	}

}
