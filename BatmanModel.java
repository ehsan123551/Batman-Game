package ProjectBatman;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class BatmanModel {

	private int score;
	private Batman batman;
	private List<BasicBlock> blocks;
	private List<Coins> coins;
	private BufferedImage backgroundImage;
	
	public BatmanModel() {
		initializeBackground();
		reset();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Batman getBatman() {
		return batman;
	}

	public List<BasicBlock> getBlocks() {
		return blocks;
	}

	public List<Coins> getCoins() {
		return coins;
	}

	public BufferedImage getBackgroundImage() {
		return backgroundImage;
	}
	
	public void initializeBackground() {
		try {
			backgroundImage = ImageIO.read(new File(Constants.BACKGROUND_IMAGE_URL));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void reset() {
		score = 0;
		batman = BatmanSetUp.getInstance().createBatman(Constants.BATMAN_HORIZONTAL_POSITION, 0);
		blocks = new ArrayList<BasicBlock>();
		coins = new ArrayList<Coins>();
			
		for (int i = 0; i < Constants.INITIAL_NUMBER_BLOCKS; i++) {
			if (blocks.size() == 0) {
				blocks.add(BatmanSetUp.getInstance().createLargeBlock(Constants.INITIAL_BLOCK_X, Constants.BLOCK_LEVITATION_HEIGHT));
			} else {
				BasicBlock previous = blocks.get(i - 1);
				blocks.add(BatmanSetUp.getInstance().createRandomBlock(previous.getX() + previous.getWidth() + Constants.BLOCK_DISTANCE_MIN, Constants.BLOCK_LEVITATION_HEIGHT, Constants.BLOCK_DISTANCE_RANDOM));
			}
		}
		
		for (int i = 0; i < Constants.INITIAL_NUMBER_COINS; i++) {
			if (coins.size() == 0) {
				coins.add(BatmanSetUp.getInstance().createRandomCoin(Constants.INITIAL_COINS_X, Constants.COINS_LEVITATION_HEIGHT));
			} else {
				Coins previous = coins.get(i - 1);
				coins.add(BatmanSetUp.getInstance().createRandomCoin(previous.getX() + previous.getWidth() + Constants.COINS_DISTANCE_MIN, Constants.COINS_LEVITATION_HEIGHT, Constants.COINS_DISTANCE_RANDOM));
			}
		}
	}
}