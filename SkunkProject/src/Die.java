
public class Die
{
	protected int lastRoll;

	public Die()
	{
		this.init();
	}

	public int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}

	protected void init()
	{
		this.roll();
	}
	public void roll() // note how this changes Die's state, but doesn't return
						// anything
	{
		this.lastRoll = (int) (Math.random() * 6 + 1);
	}

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}

}
