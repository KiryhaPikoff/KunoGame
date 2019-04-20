package components.UI;

import java.awt.Graphics;

import entity.Entity;
import entity.player.Player;
import utils.Drawable;

public class PlayerInterface implements Drawable {

	HealthPointBar healthPointBar;
	ManaPointBar manaPointBar;
	
	public PlayerInterface(Player testPlayer) {
		healthPointBar = new HealthPointBar(testPlayer.getStats().getCurrentHealthPoint(), testPlayer.getStats().getMaxHealthPoint());
		manaPointBar = new ManaPointBar(testPlayer.getStats().getCurrentManaPoint(), testPlayer.getStats().getMaxManaPoint());
	}
	
	public void paint(Graphics g) {
		healthPointBar.paint(g);
		manaPointBar.paint(g);
	}
}
