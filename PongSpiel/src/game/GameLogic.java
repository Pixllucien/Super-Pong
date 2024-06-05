package game;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import actions.KeyHandler;
import gameObjects.BeweglichesRechteck;

public class GameLogic {

	private Timer gameTimer;
	public int screenwidth;
	public int screenheight;
	public ArrayList<GameObject> spielObjekte;
	
	
	private BeweglichesRechteck beweglichesRechteck; 
	
	
	
	public boolean keyLeftarrowpressed = false;
	public boolean keyRightarrowpressed = false;;
	public boolean keyUparrowpressed = false; 
	public boolean keyDownarrowpressed = false;
	private BeweglichesRechteck beispielObjekt1;
	private BeweglichesRechteck beispielObjekt2; 
	
	public GameLogic() {
		
		gameTimer = new Timer();
		spielObjekte = new ArrayList<GameObject>();
		
		
		beispielObjekt1 = new BeweglichesRechteck(50, 100, 20, 20);
		spielObjekte.add(beispielObjekt1);
		beispielObjekt1.richtung = 0; // Startrichtung
		beispielObjekt2 = new BeweglichesRechteck(300, 400, 20, 20);
		spielObjekte.add(beispielObjekt2);
		
		
		
		gameTimer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				bewegung(); 
			}
		}, 0, 5);
		
		beweglichesRechteck = new BeweglichesRechteck(); 
	}
	


	public void bewegung() {
		// Laufende Ausführungen im Spiel:
		beispielObjekt1.automatischeKreisbewegung();
		
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
}
	
	public void colision() {
	
		if(beispielObjekt1.positionX == beispielObjekt2.positionX) {
			keyHandler.invert = (-1); 
			//was soll das? 
		}
}
}
