package map;

import components.Coordinates;
import components.DirectionMove;
import entity.player.Player;
import utils.Constants;

public class ChunkChanger {
	public static void changeChunk(Chunk currentChunk, Player player) {
		if(player.getCurrentCoordinate().getX() >= Constants.SIZE_TILE * Constants.WIDTH_CHUNK - 5) {
			currentChunk = new Chunk(currentChunk.hashCode(), DirectionMove.EAST);
			player.setCurrentCoordinate(new Coordinates(30, player.getCurrentCoordinate().getY()));
		}
		if(player.getCurrentCoordinate().getX() <= 5) {
			currentChunk = new Chunk(currentChunk.hashCode(), DirectionMove.WEST);
			player.setCurrentCoordinate(new Coordinates(Constants.SIZE_TILE * Constants.WIDTH_CHUNK - 30, player.getCurrentCoordinate().getY()));
		}
		if(player.getCurrentCoordinate().getY() <= 25) {
			currentChunk = new Chunk(currentChunk.hashCode(), DirectionMove.NORTH);
			player.setCurrentCoordinate(new Coordinates(player.getCurrentCoordinate().getX(), Constants.SIZE_TILE * Constants.HEIGHT_CHUNK - 30));
		}
		if(player.getCurrentCoordinate().getY() >= Constants.SIZE_TILE * Constants.HEIGHT_CHUNK - 5) {
			currentChunk = new Chunk(currentChunk.hashCode(), DirectionMove.SOUTH);
			player.setCurrentCoordinate(new Coordinates(player.getCurrentCoordinate().getX(), 30));
		}	
	}
}
