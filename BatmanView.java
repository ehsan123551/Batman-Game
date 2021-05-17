package ProjectBatman;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BatmanView extends JPanel {

	private BatmanModel model;
	
	public BatmanView(BatmanModel model) {
		this.model = model;
		setPreferredSize(new Dimension(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT));
		setDoubleBuffered(true);
		setFocusable(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(model.getBackgroundImage(), 0, 0, null);
		g.setFont(new Font("Calibri", Font.BOLD, Constants.FONT_SIZE));
		g.drawString(Constants.SCORE_TEXT + Integer.toString(model.getScore()), Constants.SCORE_BOX_X, Constants.SCORE_BOX_Y);
		
		for (Coins ac : model.getCoins()) {
			g.drawImage(ac.getImage(), ac.getX(), ac.getY(), null);
		}
		
		for (BasicBlock b : model.getBlocks()) {
			g.drawImage(b.getImage(), b.getX(), b.getY(), null);
		}
		
		g.drawImage(model.getBatman().getCurrentImageFrame(), model.getBatman().getX(), model.getBatman().getY(),null);
	}
}
