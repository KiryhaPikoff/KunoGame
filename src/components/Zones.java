package components;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Zones {
	protected int radiusVisibility;		// радиус видимости
	protected int radiusPursuit;		// радиус преследования
	protected int radiusAttack;			// радиус атаки
	
	protected Shape visibility;			// зона видимости
	protected Shape pursuit;			// зона преследования
	protected Shape attack;				// зона атаки
	
	public Zones(int radiusAttack, Coordinates currentCoord) /*в большей степени для игрока*/ {
		this.attack = new Ellipse2D.Float(currentCoord.getX() - radiusAttack, 
											currentCoord.getY() - radiusAttack,
											radiusAttack * 2, radiusAttack * 2);
	}
	
	public Zones(int radiusAttack, int radiusVisibility, int radiusPursuit, Coordinates currentCoord,
				 Coordinates spawnCoordinate) /*в большей степени для монстров*/ {
		this.attack = new Ellipse2D.Float(currentCoord.getX() - radiusAttack, 
				currentCoord.getY() - radiusAttack,
				radiusAttack * 2, radiusAttack * 2);
		
		this.visibility = new Ellipse2D.Float(currentCoord.getX() - radiusVisibility, 
				currentCoord.getY() - radiusVisibility,
				radiusVisibility * 2, radiusVisibility * 2);
		
		this.pursuit = new Ellipse2D.Float(spawnCoordinate.getX() - radiusPursuit, 
				spawnCoordinate.getY() - radiusPursuit,
				radiusPursuit * 2, radiusPursuit * 2);
	}
	
	public Shape getVisibility() {
		return visibility;
	}

	public void setVisibility(Shape visibility) {
		this.visibility = visibility;
	}

	public Shape getPursuit() {
		return pursuit;
	}

	public void setPursuit(Shape pursuit) {
		this.pursuit = pursuit;
	}

	public Shape getAttack() {
		return attack;
	}

	public void setAttack(Shape attack) {
		this.attack = attack;
	}
}
