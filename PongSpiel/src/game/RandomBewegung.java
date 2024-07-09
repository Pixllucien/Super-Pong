package game;

import game.GameLogic;
import gameObjects.BeweglichesRechteck;
import java.util.Random;
import game.Collision;

public class RandomBewegung {

	public boolean collision = false;
	private int addX;
	private int addY; 
	Random rnd = new Random();
	Collision col = new Collision(); 


	public void randomBewegungX(BeweglichesRechteck obj, boolean run, int screenheight, BeweglichesRechteck spieler1, BeweglichesRechteck spieler2) {
		if((col.collisionX(obj, spieler1) == true) && (col.collisionY(obj, spieler1) == true)) {
			addX = -addX;
		}
			if((col.collisionX(obj, spieler2) == true) && (col.collisionY(obj, spieler2) == true)) {
				addX = -addX;
		}
		if (run == false) {
			addX = rnd.nextInt(-1, 2);
			while (addX == 0) {
				addX = rnd.nextInt(-1, 2);
			}
			System.out.println(addX);
		} else if (run == true) {
			obj.positionX += addX;
		}
		}
		public void randomBewegungY(BeweglichesRechteck obj, boolean run, int screenheight, BeweglichesRechteck spieler1, BeweglichesRechteck spieler2) {
			if((col.collisionX(obj, spieler1) == true) && (col.collisionY(obj, spieler1) == true)) {
			
			}
			if((col.collisionX(obj, spieler2) == true) && (col.collisionY(obj, spieler2) == true)) {
			
			}
			if (col.collisionScreen(obj, screenheight)) {
				addY = -addY;
			}
			if (run == false) {
				addY = rnd.nextInt(-1, 2);
				while (addY == 0) {
					addY = rnd.nextInt(-1, 2);
				}
				System.out.println(addY);
			} else if (run == true) {
				obj.positionY += addY;
			}

	}
}
