package entity.components;

import java.awt.Shape;

public class Zones {
	private int radiusVisibility;		// радиус видимости
	private int radiusPursuit;			// радиус преследования
	private int radiusAttack;			// радиус атаки
	
	private Shape visibility;			// зона видимости
	private Shape pursuit;				// зона преследования
	private Shape attack;				// зона атаки
	
	public Zones(int radiusAttack, int radiusVisibility, int radiusPursuit) {
		
	}
}
