package ProjectBatman;

public abstract class SetUp 
{
	public abstract Batman createBatman(int x, int y);
	public abstract BasicBlock createSmallBlock(int x, int y);
	public abstract BasicBlock createMediumBlock(int x, int y);
	public abstract BasicBlock createLargeBlock(int x, int y);
	public abstract BasicBlock createRandomBlock(int x, int y);
	public abstract BasicBlock createRandomBlock(int x, int y, int horizontalShift);
	public abstract Coins createBronze(int x, int y);
	public abstract Coins createSilver(int x, int y);
	public abstract Coins createGold(int x, int y);
	public abstract Coins createRandomCoin(int x, int y);
	public abstract Coins createRandomCoin(int x, int y, int horizontalShift);
}
