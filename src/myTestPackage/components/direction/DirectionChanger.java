package myTestPackage.components.direction;

/*
 * DirectionChanger система для смены направления
 * 
 * Author: Pikov Kirill
 */

public abstract class DirectionChanger {
	public static void changeObjectDirection(Directed object) {
		if(object instanceof Directed) {
			((Directed) object).changeDirection();
		}
	}
}
