package components.UI;

import java.awt.Graphics;

import entity.player.Player;
import utils.Drawable;

public class PlayerInterface implements Drawable {

	HealthPointBar healthPointBar;
	ManaPointBar manaPointBar;
	
	public PlayerInterface(Player player) {
		healthPointBar = new HealthPointBar(player.getStats().getCurrentHealthPoint(), player.getStats().getMaxHealthPoint());
		manaPointBar = new ManaPointBar(player.getStats().getCurrentManaPoint(), player.getStats().getMaxManaPoint());
	}
	
	public void paint(Graphics g) {
		healthPointBar.paint(g);
		manaPointBar.paint(g);
	}
}
