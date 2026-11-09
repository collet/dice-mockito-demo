package god;

import java.util.Optional;

public class Game {

    private final Player left;
    private final Player right;

    public Game(Player left, Player right) {
        this.left = left;
        this.right = right;
    }

    public Optional<Player> play() {
        int counter = 0;
        while(counter < 5) {
            left.play();  PlayResult l = left.getLastValue().get();
            right.play(); PlayResult r = right.getLastValue().get();

            int cmp = l.compareTo(r);
            
            if(cmp > 0 )      { return Optional.of(left);  }
            else if (cmp < 0) { return Optional.of(right); }

            counter++;
        }
        return Optional.empty();
    }
    
}

