package entity;

import entity.components.Attack;
import entity.components.Direction;
import entity.components.Inventory;
import entity.components.Stats;
import utils.Coordinates;

public abstract class Entity {
	private Coordinates coordinate;
	private Stats stat;
	private Inventory inventory;
	private Direction direction;
	private Attack attack;
}
