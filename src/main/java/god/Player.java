package god;
import java.util.Optional;

public class Player {

    private final String name;
    private final Dice dice;
    private PlayResult lastValue = null;

    public Player(String name, Dice dice) {
        this.name = name;
        this.dice = dice;
    }

    public void play() {
    	int a = dice.roll();
    	int b = dice.roll();
        this.lastValue = new PlayResult(Math.max(a, b));
    }

    public Optional<PlayResult> getLastValue() {
        return Optional.ofNullable(lastValue);
    }

    public String getName() {
        return name;
    }
}

