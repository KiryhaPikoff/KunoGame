package myTestPackage.components.direction;

public abstract class DirectionChanger {
	public static void changeObjectDirection(Directed object) {
		if(object instanceof Directed) {
			((Directed) object).changeDirection();
		}
	}
}
