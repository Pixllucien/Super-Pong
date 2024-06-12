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
	public boolean doNothing = false;
	
	
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
		
		
		beispielObjekt1 = new BeweglichesRechteck(100, 100, 20, 20);
		spielObjekte.add(beispielObjekt1);
		beispielObjekt1.richtung = 0; // Startrichtung
		beispielObjekt2 = new BeweglichesRechteck(300, 100, 20, 20);
		spielObjekte.add(beispielObjekt2);
		
		
		
		gameTimer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				bewegung(); 
			}
		}, 0, 5);
		
	 
	}
	


	public void bewegung() {
		// Laufende Ausführungen im Spiel:
		//beispielObjekt1.automatischeKreisbewegung();
		
		beispielObjekt1.beispielbewegung();
		collision();
		if (keyLeftarrowpressed && doNothing == false) {
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
	
	public void collision() {
	
		if(((beispielObjekt1.positionX  +10) == (beispielObjekt2.positionX - 10)) && beispielObjekt1.positionY == beispielObjekt2.positionY) {
			doNothing = true; 	
			beispielObjekt1.moving = true; 
			}
		else {
			doNothing = false;
			
		}
		
		
		}
	}
		

