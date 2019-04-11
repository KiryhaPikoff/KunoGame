package entity;

import entity.components.Attack;
import entity.components.Direction;
import entity.components.Inventory;
import entity.components.Stats;
import utils.Coordinates;

public abstract class Entity {
	Coordinates coordinate;
	Stats stat;
	Inventory inventory;
	Direction direction;
	Attack attack;
}
