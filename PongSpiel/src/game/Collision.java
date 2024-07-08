package game;

import gameObjects.BeweglichesRechteck;
import game.RandomBewegung;
import game.GameLogic;

public class Collision {
	RandomBewegung rndBewegung = new RandomBewegung(); 
	private boolean collisionY = false;
	private boolean collisionX = false;

	public void collision(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		collisionX(obj1, obj2);
		collisionY(obj1, obj2);
		if(collisionY == true && collisionX == true) {
			rndBewegung.collision = true;
			}
	}

	public void collisionX(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		if ((obj2.positionX < obj1.positionX + 20) && ((obj2.positionX + 20) > obj1.positionX)) {
			collisionX = true;
		} else {
			collisionX = false;
		}
	}

	public void collisionY(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		if (obj2.positionY - 20 < obj1.positionY && obj2.positionY > obj1.positionY - 20) {
			collisionY = true;
		} else {
			collisionY = false;
		}
	}

	public void collisionScreen(BeweglichesRechteck obj, int screenheight) {
		if (obj.positionY + 20 >= screenheight - 40) {
			System.out.println(rndBewegung.collision); 
			rndBewegung.collision = true; 
			System.out.println("        "  + rndBewegung.collision); 
		}
		if (obj.positionY <= 0) {
			System.out.println(rndBewegung.collision); 
			rndBewegung.collision = true; 
			System.out.println("        "  + rndBewegung.collision); 

		}
	}

	public void collisionPoints(BeweglichesRechteck obj, int linie1, int linie2) {
		if (obj.positionY == linie1) {
			System.out.println("PUNKT");
		} else if (obj.positionY == linie2) {
			System.out.println("PUNKT");
		}
	}

}
