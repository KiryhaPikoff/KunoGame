package entity;

import entity.components.Inventory;
import entity.components.Stats;
import utils.Coordinates;

public abstract class Entity {
	Coordinates coordinate;
	Stats stat;
	Inventory inventory;
}
