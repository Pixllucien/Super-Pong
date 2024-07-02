package game;

import gameObjects.BeweglichesRechteck;
import game.GameLogic; 

public class Collision {
	private boolean collisionY = false; 
	private boolean collisionX = false; 
	
	
	public void collision(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		collisionX(obj1,obj2); 
		collisionY(obj1, obj2);
		System.out.println(obj1.positionY + " obj 1 ");
		System.out.println(obj2.positionY + " obj 2 ");
		if(collisionY == true && collisionX == true) {
			System.out.println("KOLLISION!!!!");
		}
	}
	public void collisionX(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		if(((obj2.positionX - 10) < obj1.positionX) && ((obj2.positionX + 10) > obj1.positionX)) {
			collisionX = true; 
		}
		else {
			collisionX = false; 
		}
	}
	public void collisionY(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
			if((obj2.positionY - 10) < obj1.positionY && (obj2.positionY + 10) > obj1.positionY) {
				collisionY = true; 
			}
			else {
				collisionY = false; 
			}
				
	}
	
	public void collisionHorizontal(BeweglichesRechteck obj1, int screenheight){
		if(obj1.positionY  >= screenheight) {
			System.out.println("KOLLISION!!!!!!!!"); 
			
		}
	}
}
