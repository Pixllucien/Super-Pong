package game;

import gameObjects.BeweglichesRechteck;

import game.RandomBewegung;
import game.GameLogic;


public class Collision {
	
	public Collision() {}
	
	
	private boolean collisionY = false;
	private boolean collisionX = false;



	public boolean collisionX(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		if ((obj2.positionX < obj1.positionX + 20) && ((obj2.positionX + 20) > obj1.positionX)) {
			System.out.println("KollisionX");
			return true;
		} else {
			return false;
		}
	}

	public boolean collisionY(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		if (obj2.positionY < obj1.positionY + 20  && obj2.positionY + 80 > obj1.positionY ) {
			return true;
		} else {
			return false;
		}
	}

	public boolean collisionScreen(BeweglichesRechteck obj, int screenheight) {
		if (obj.positionY + 20 >= screenheight - 40) {
			return true; 
		}
		else if (obj.positionY <= 0) {
		return true; 	

		}
		else {
			return false; 
		}
	}

	public int collisonLeft(BeweglichesRechteck obj, int linie) {
		if (obj.positionX == linie) {
			
			return 1; 
		}
		else {
			return 0; 
		}
		}
	
			
	public int collisionRight(BeweglichesRechteck obj, int linie) {
			if (obj.positionX == linie) {
			return 1; 
		}
		else { 
			return 0; 
		}
	}

}
