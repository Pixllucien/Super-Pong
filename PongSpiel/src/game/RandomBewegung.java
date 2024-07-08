package game;

import game.GameLogic;
import gameObjects.BeweglichesRechteck;
import java.util.Random;

public class RandomBewegung {

	public boolean collision = false;
	private int add;
	Random rnd = new Random();

	public void randomBewegung(BeweglichesRechteck obj, boolean run) {

		if (collision == true) {
			add = add * (-1);
		}
		if (run == false) {
			add = rnd.nextInt(-1, 2);
			while (add == 0) {
				add = rnd.nextInt(-1, 2);
			}
			System.out.println(add);
		} else if (run == true) {
			obj.positionY += add;
			System.out.println(add);
		}

	}
}
