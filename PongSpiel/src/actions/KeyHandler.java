package actions;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.GameLogic;
import gameObjects.BeweglichesRechteck;

public class KeyHandler implements KeyListener {

	GameLogic gamelogic;

	public KeyHandler(GameLogic spiellogik) {
		gamelogic = spiellogik;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			gamelogic.keyLeftarrowpressed = true;
		
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			gamelogic.keyRightarrowpressed = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			gamelogic.keyUparrowpressed = true; 
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			gamelogic.keyDownarrowpressed = true; 
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			gamelogic.keyWpressed = true; 
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			gamelogic.keyApressed = true; 
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			gamelogic.keySpressed = true; 
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			gamelogic.keyDpressed = true; 
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			gamelogic.keyLeftarrowpressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			gamelogic.keyRightarrowpressed = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			gamelogic.keyUparrowpressed = false; 
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			gamelogic.keyDownarrowpressed = false; 
		}
		else if(e.getKeyCode() == KeyEvent.VK_W) {
			gamelogic.keyWpressed = false; 
		}
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			gamelogic.keyApressed = false; 
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			gamelogic.keySpressed = false; 
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			gamelogic.keyDpressed = false; 
		}

}
