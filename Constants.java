package ProjectBatman;

public final class Constants
{
	private Constants() {
		throw new UnsupportedOperationException();
	}
	
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 500;
	public static final int FONT_SIZE = 24;
	public static final int GRAVITY = 2;
	public static final int JUMP_STRENGTH = -28;
	public static final int PIXEL_SPEED_PER_TICK = 15;
	public static final int COINS_LEVITATION_HEIGHT = 150;
	public static final int BLOCK_LEVITATION_HEIGHT = 400;
	public static final int BATMAN_BLOCK_COLLISION_OFFSET = 40;
	public static final int BATMAN_HORIZONTAL_POSITION = 300;
	public static final int BLOCK_DISTANCE_MIN = 200;
	public static final int BLOCK_DISTANCE_RANDOM = 151;
	public static final int COINS_DISTANCE_MIN = 2000;
	public static final int COINS_DISTANCE_RANDOM = 1001;
	public static final int SCORE_BOX_X = 24;
	public static final int SCORE_BOX_Y = 40;
	public static final int SCORE_FONT_SIZE = 24;
	public static final int SCORE_INCREMENT = 4;
	public static final int INITIAL_NUMBER_COINS = 2;
	public static final int INITIAL_NUMBER_BLOCKS = 3;
	public static final int INITIAL_BLOCK_X = 500;
	public static final int INITIAL_COINS_X = 1100;
	public static final int TIMER_TICK_MILLISECONDS = 30;
	public static final int INITIAL_TIMER_DELAY = 1000;
	public static final int TIMER_TICKS_RUN_ANIMATION = 2;
	public static final int BRONZE_POINTS = 500;
	public static final int SILVER_POINTS = 1000;
	public static final int GOLD_POINTS = 2000;
	
	public static final String GAME_NAME = "BATMAN: ARKHAM KNIGHT";
	public static final String SCORE_TEXT = "Score: ";
	public static final String BACKGROUND_IMAGE_URL = "img/Back.jpg";
	public static final String BATMAN_RUN_ONE_IMAGE_URL = "img/batrun11.png";
	public static final String BATMAN_RUN_TWO_IMAGE_URL = "img/batrun22.png";
	public static final String BATMAN_JUMP_IMAGE_URL = "img/batrun11.png";
	public static final String BLOCK_SMALL_IMAGE_URL = "img/small.jpg";
	public static final String BLOCK_MEDIUM_IMAGE_URL = "img/medium.jpg";
	public static final String BLOCK_LARGE_IMAGE_URL = "img/large.jpg";
	public static final String BRONZE_IMAGE_URL = "img/Bronze.png";
	public static final String SILVER_IMAGE_URL = "img/Silverr.png";
	public static final String GOLD_IMAGE_URL = "img/Goold.png";
	public static final String FRONT_URL = "img/Bat.jpeg";
}
