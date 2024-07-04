package game;

import java.util.ArrayList;
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
	public boolean run = false; 
	
	private Collision objCollision;
	
	public GameLogic() {
		objCollision = new Collision(); 
		gameTimer = new Timer();
		spielObjekte = new ArrayList<GameObject>();
		RandomBewegung randomBewegung = new RandomBewegung(); 
		
		keyLeftarrowpressed = false;
		keyRightarrowpressed = false;
		
		// Objekte im Spiel:
		BeweglichesRechteck beispielObjekt1 = new BeweglichesRechteck(0, 0, 20, 20);
		spielObjekte.add(beispielObjekt1);
		beispielObjekt1.richtung = 0; // Startrichtung
		BeweglichesRechteck beispielObjekt2 = new BeweglichesRechteck(300, 400, 20, 20);
		spielObjekte.add(beispielObjekt2);
		
		gameTimer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				RandomBewegung randomBewegung = new RandomBewegung();
				// Laufende Ausführungen im Spiel:
				randomBewegung.randomBewegung(beispielObjekt1, run); 
				
				run = true; 
				if (keyLeftarrowpressed) {
					beispielObjekt2.positionX -= 1;
				} else if (keyRightarrowpressed) {
					beispielObjekt2.positionX += 1;
				}
				else if(keyUparrowpressed) {
					beispielObjekt2.positionY -= 1; 
				}
				else if(keyDownarrowpressed) {
					beispielObjekt2.positionY +=1; 
				}
				
				objCollision.collision(beispielObjekt1, beispielObjekt2);
				objCollision.collisionScreen(beispielObjekt2, screenheight); 
				
	
			
			}
		}, 0, 5);
	}
	
}
