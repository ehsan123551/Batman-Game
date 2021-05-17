package ProjectBatman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.Timer;

public class BatmanControls {
	
	private BatmanModel model;
	private BatmanView view;
	private Timer timer;
	
	public BatmanControls(BatmanModel model, BatmanView view) {
		this.model = model;
		this.view = view;
		this.view.addKeyListener(new GameKeyListener());
		
		timer = new Timer(Constants.TIMER_TICK_MILLISECONDS, new GameTimerListener());
		timer.setInitialDelay(Constants.INITIAL_TIMER_DELAY);
		timer.start();
	}
	
	public void moveBlocks(List<BasicBlock> blocks) {
		for (int i = 0; i < blocks.size(); i++) {
			if (blocks.get(i).getX() <= blocks.get(i).getWidth() * -1) {
				BasicBlock previous = i == 0 ? blocks.get(blocks.size() - 1) : blocks.get(i - 1);
				blocks.set(i, BatmanSetUp.getInstance().createRandomBlock(previous.getX() + previous.getWidth() + Constants.BLOCK_DISTANCE_MIN, Constants.BLOCK_LEVITATION_HEIGHT, Constants.BLOCK_DISTANCE_RANDOM));
			}
			
			blocks.get(i).setX(blocks.get(i).getX() - Constants.PIXEL_SPEED_PER_TICK);
		}
	}
	
	public boolean  batmanIsOnBlock(Batman batman, List<BasicBlock> blocks) {
		if (batman.getY() != Constants.BLOCK_LEVITATION_HEIGHT - batman.getHeight()) {
			return false;
		}
		
		for (BasicBlock b : blocks) {
			if (batman.getX() + Constants.BATMAN_BLOCK_COLLISION_OFFSET > b.getX() && batman.getX() < b.getX() + b.getWidth() - Constants.BATMAN_BLOCK_COLLISION_OFFSET) {
				return true;
			}
		}
		
		return false;
	}
	
	public void applyBatmanGravity(Batman batman, List<BasicBlock> blocks) {
		if (!batmanIsOnBlock(batman, blocks)) {
			batman.setVerticalVelocity(batman.getVerticalVelocity() + Constants.GRAVITY);
			
			if (batman.getState() == BatmanState.FirstRun) {
				batman.setState(BatmanState.Falling);
			}
		} else if (batman.getVerticalVelocity() > 0) {
			batman.setVerticalVelocity(0);
			batman.setState(BatmanState.FirstRun);
		}
	}
	
	public void updateBatmanPosition(Batman batman) {
		int newYPosition = batman.getY() + batman.getVerticalVelocity();
		
		if (batman.getY() < Constants.BLOCK_LEVITATION_HEIGHT - batman.getHeight() && newYPosition > Constants.BLOCK_LEVITATION_HEIGHT - batman.getHeight()) {
			batman.setY(Constants.BLOCK_LEVITATION_HEIGHT - batman.getHeight());
		} else {
			batman.setY(newYPosition);
		}
	}
	
	public void processKeyInput(Batman batman, int keyCode) {
		switch(batman.getState()) {
			case FirstRun:
			case SecondRun:
				if (keyCode == KeyEvent.VK_SPACE) {
					model.getBatman().setVerticalVelocity(Constants.JUMP_STRENGTH);
					model.getBatman().setState(BatmanState.FirstJump);
				}
				break;
			case FirstJump:
				if (keyCode == KeyEvent.VK_SPACE) {
					model.getBatman().setVerticalVelocity(Constants.JUMP_STRENGTH);
					model.getBatman().setState(BatmanState.SecondJump);
				}
				break;
			case SecondJump:
			case Falling:
			default:
				break;
		}
		
		if (!timer.isRunning()) {
			resetGame();
		}
	}
	
	public int animateBatmanRun(Batman batman, int currentTickInSecond) {
		if (currentTickInSecond % Constants.TIMER_TICKS_RUN_ANIMATION == 0) {
			if (batman.getState() == BatmanState.FirstRun) {
				batman.setState(BatmanState.SecondRun);
			} else if (batman.getState() == BatmanState.SecondRun) {
				batman.setState(BatmanState.FirstRun);
			}
			
			return 1;
		}
		
		return ++currentTickInSecond;
	}
	
	public void moveCoins(List<Coins> coins) {
		for (int i = 0; i < coins.size(); i++) {
			if (coins.get(i).getX() <= coins.get(i).getWidth() * -1) {
				Coins previous = i == 0 ? coins.get(coins.size() - 1) : coins.get(i - 1);
				coins.set(i, BatmanSetUp.getInstance().createRandomCoin(previous.getX() + previous.getWidth() + Constants.COINS_DISTANCE_MIN, Constants.COINS_LEVITATION_HEIGHT, Constants.COINS_DISTANCE_RANDOM));
			}
			
			coins.get(i).setX(coins.get(i).getX() - Constants.PIXEL_SPEED_PER_TICK);
		}
	}
	
	public int checkCoinsCollision(Batman batman, List<Coins> coins) {	
		int pointsToAdd = 0;
		
		batman.updateHitBox();
		
		for (int i = 0; i < coins.size(); i++) {
			coins.get(i).updateBox();
			
			if (batman.getBox().intersects(coins.get(i).getBox())) {
				pointsToAdd += coins.get(i).coins();
				
				Coins previous = i == 0 ? coins.get(coins.size() - 1) : coins.get(i - 1);
				coins.set(i, BatmanSetUp.getInstance().createRandomCoin(previous.getX() + previous.getWidth() + Constants.COINS_DISTANCE_MIN, Constants.COINS_LEVITATION_HEIGHT, Constants.COINS_DISTANCE_RANDOM));

				return pointsToAdd;
			}
		}
		
		return pointsToAdd;
	}

	
	public void gameOverCheck(Batman batman) {
		if (batman.getY() > Constants.FRAME_HEIGHT) {
			timer.stop();
		}
	}
	
	public void resetGame() {
		model.reset();
		view.repaint();
		timer.restart();
	}
	
	class GameTimerListener implements ActionListener {
		private int animationTickTracker;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			animationTickTracker = animateBatmanRun(model.getBatman(), animationTickTracker);
			applyBatmanGravity(model.getBatman(), model.getBlocks());
			updateBatmanPosition(model.getBatman());
			moveBlocks(model.getBlocks());
			moveCoins(model.getCoins());
			model.setScore(model.getScore() + Constants.SCORE_INCREMENT);
			model.setScore(model.getScore() + checkCoinsCollision(model.getBatman(), model.getCoins()));
			gameOverCheck(model.getBatman());
			view.repaint();
		}
	}
	
	class GameKeyListener implements KeyListener {
		
		@Override
		public void keyReleased(KeyEvent e) {
			processKeyInput(model.getBatman(), e.getKeyCode());			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {

		}

		@Override
		public void keyTyped(KeyEvent e) {
						
		}	
	}
}