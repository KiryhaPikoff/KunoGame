package myTestPackage.components.direction;

public abstract class DirectionChanger {
	public static void changeObjectDirection(Directed object) {
		if(object instanceof DirectedByKeyboard) {
			((DirectedByKeyboard) object).changeDirection();
		}
		if(object instanceof DirectedByRule) {
			((DirectedByRule) object).changeDirection();
		}
	}
}
