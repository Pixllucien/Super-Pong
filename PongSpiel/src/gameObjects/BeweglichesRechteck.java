package gameObjects;

import game.GameObject;

public class BeweglichesRechteck extends GameObject {
	
	public byte richtung;
	public int schritteInGleicherRichtung;

	public BeweglichesRechteck(int posX, int posY, int breite, int hoehe) {
		super(posX, posY, breite, hoehe);
		schritteInGleicherRichtung = 0;
	}
	
	
	public void automatischeKreisbewegung() {
		if(richtung == 0) {
			positionX++; 
		}
		else if(richtung == 1) {
			positionX--; 
		}
		if(schritteInGleicherRichtung == 200) {
			richtung++; 
			if(richtung == 2) {
				richtung = 0; 
			}
			schritteInGleicherRichtung = 0; 
		}
		schritteInGleicherRichtung++; 
	}
}
