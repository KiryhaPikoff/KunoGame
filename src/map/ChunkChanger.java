package map;

import components.Coordinates;
import components.DirectionMove;
import entity.player.Player;
import utils.Constants;
import utils.Renderer;

public class ChunkChanger {
	public static void changeChunk(Chunk currentChunk, Player player) {
		if(currentChunk.getTileXY(player.getCurrentCoordinate().getX(), player.getCurrentCoordinate().getY()).getTileType() == TileType.door) {
			if(player.getCurrentCoordinate().getX() >= Constants.SIZE_TILE * Constants.WIDTH_CHUNK - 5) {
				currentChunk = new Chunk(currentChunk.hashCode(), DirectionMove.EAST);
				player.setCurrentCoordinate(new Coordinates(30, player.getCurrentCoordinate().getY()));
				Renderer.addObject(currentChunk);
				return;
			}
			if(player.getCurrentCoordinate().getX() <= 5) {
				currentChunk = new Chunk(currentChunk.hashCode(), DirectionMove.WEST);
				player.setCurrentCoordinate(new Coordinates(Constants.SIZE_TILE * Constants.WIDTH_CHUNK - 30, player.getCurrentCoordinate().getY()));
				Renderer.addObject(currentChunk);
				return;
			}
			if(player.getCurrentCoordinate().getY() <= 25) {
				currentChunk = new Chunk(currentChunk.hashCode(), DirectionMove.NORTH);
				player.setCurrentCoordinate(new Coordinates(player.getCurrentCoordinate().getX(), Constants.SIZE_TILE * Constants.HEIGHT_CHUNK - 30));
				Renderer.addObject(currentChunk);
				return;
			}
			if(player.getCurrentCoordinate().getY() >= Constants.SIZE_TILE * Constants.HEIGHT_CHUNK - 5) {
				currentChunk = new Chunk(currentChunk.hashCode(), DirectionMove.SOUTH);
				player.setCurrentCoordinate(new Coordinates(player.getCurrentCoordinate().getX(), 30));
				Renderer.addObject(currentChunk);
				return;
			}	
		}
	}
}
