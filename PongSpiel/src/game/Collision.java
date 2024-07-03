package game;

import gameObjects.BeweglichesRechteck;
import game.GameLogic; 

public class Collision {
	private boolean collisionY = false; 
	private boolean collisionX = false; 
	
	
	public void collision(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		collisionX(obj1, obj2); 
		collisionY(obj1, obj2);
		System.out.println(obj1.positionY + " obj 1 ");
		if(collisionY == true && collisionX == true) {
			System.out.println("KOLLISION!!!!");
		}
	}
	public void collisionX(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		if((obj2.positionX < obj1.positionX + 20) && ((obj2.positionX + 20) > obj1.positionX)) {
			collisionX = true; 
		}
		else {
			collisionX = false; 
		}
	}
	public void collisionY(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
			if(obj2.positionY - 20 < obj1.positionY && obj2.positionY > obj1.positionY - 20) {
				collisionY = true; 
			}
			else {
				collisionY = false; 
			}
	}
	
	public void collisionScreen(BeweglichesRechteck obj, int screenheight){
		if(obj.positionY + 2  >= screenheight) {
			System.out.println("KOLLISION!!!!!!!!"); 
		}
		if(obj.positionY <=  0) {
			System.out.println("Kollision!!!!!!");		}
	}
	
	public void collisionPoints(BeweglichesRechteck obj, int linie1, int linie2) {
		if(obj.positionY == linie1) {
			System.out.println("PUNKT");
		}
		else if (obj.positionY == linie2) {
			System.out.println("PUNKT");
		}
	}
	
}
