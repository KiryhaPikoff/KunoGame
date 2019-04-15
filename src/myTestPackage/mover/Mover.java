package myTestPackage.mover;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import myTestPackage.Drawable;
import myTestPackage.map.Chunk;
import myTestPackage.utils.Constants;

public abstract class Mover {
	public static void moveObject(Movable object) {
		object.move();
	}
}
