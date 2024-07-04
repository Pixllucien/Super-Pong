package game;
import game.GameLogic; 
import gameObjects.BeweglichesRechteck; 
import java.util.Random; 

public class RandomBewegung {
	
	public boolean collision = false;
	private int bewegung = 1; 
	private boolean run = false; 
	Random rnd = new Random(); 


	 public void randomBewegung(BeweglichesRechteck obj, boolean run) {
		if(run == false) {
		obj.positionX += rnd.nextInt(-1, 2) * bewegung; 
		obj.positionY += rnd.nextInt(-1, 2) * bewegung; 
		}
		if(collision = true) {
			bewegung *= -1; 
			collision = false; 
		}
	 // TO DO DAS ÄNDERN DAS ES DIE RANDOM ALS MAL NIMMT DAMIT ICH IMMER MIT EINER VARIABEL DAS DRAUFRECHNEN KANN 
	 
	 }
}
