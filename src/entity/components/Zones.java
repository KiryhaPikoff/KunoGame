package entity.components;

import java.awt.Shape;

public class Zones {
	protected int radiusVisibility;		// радиус видимости
	protected int radiusPursuit;		// радиус преследования
	protected int radiusAttack;			// радиус атаки
	
	protected Shape visibility;			// зона видимости
	protected Shape pursuit;			// зона преследования
	protected Shape attack;				// зона атаки
	
	public Zones(int radiusAttack, int radiusVisibility) {
		// дописать инициализацию зон
	}
}
