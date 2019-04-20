package myTestPackage;

import myTestPackage.components.direction.DirectionMovement;
import myTestPackage.entity.player.Player;
import myTestPackage.map.Chunk;
import myTestPackage.map.TileType;
import myTestPackage.utils.Constants;

public class ChunkChanger {
	
	public static DirectionMovement canChangeChunk(Chunk chunk, Player player) { /* возвращает направление смены чанка */
		if(chunk.getTileXY(player.getCoordinates().getX(), player.getCoordinates().getY()).getTileType() == TileType.door) {
			if(player.getCoordinates().getX() >= Constants.SIZE_TILE * Constants.WIDTH_CHUNK - 5) {
				return DirectionMovement.EAST;
			}
			if(player.getCoordinates().getX() <= 5) {
				return DirectionMovement.WEST;
			}
			if(player.getCoordinates().getY() <= 25) {
				return DirectionMovement.NORTH;
			}
			if(player.getCoordinates().getY() >= Constants.SIZE_TILE * Constants.HEIGHT_CHUNK - 15) {
				return DirectionMovement.SOUTH;
			}	
		}
		return null;
	}
	
	
	public static Chunk changeChunk(Chunk chunk, DirectionMovement direction, Player player) {
		switch(direction) {
			case EAST: {
				player.getCoordinates().setX(30);
				return new Chunk(chunk.hashCode(), direction);
			}
			case WEST: {
				player.getCoordinates().setX(Constants.SIZE_TILE * Constants.WIDTH_CHUNK - 30);
				return new Chunk(chunk.hashCode(), direction);
			}
			case NORTH: {
				player.getCoordinates().setY(Constants.SIZE_TILE * Constants.HEIGHT_CHUNK - 30);
				return new Chunk(chunk.hashCode(), direction);
			}
			case SOUTH: {
				player.getCoordinates().setY(30);	
				return new Chunk(chunk.hashCode(), direction);
			}
			default: return chunk;
		}
	}
}
