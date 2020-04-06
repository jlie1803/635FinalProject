
public class DiceResult {
    private int die1;
    private int die2;

    public DiceResult(int d1, int d2) {
        this.die1 = d1;
        this.die2 = d2;
    }

    public DiceResult(Dice dice) {
        this.die1 = dice.getDie1();
        this.die2 = dice.getDie2();
    }
    @Override
    public String toString() {
        return "{" + this.die1 + "," + this.die2 + "}";
    }
}