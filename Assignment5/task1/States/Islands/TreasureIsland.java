package States.Islands;

import States.Action;
import States.State;

public class TreasureIsland implements State{

    @Override
    public State transition(Action action) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transition'");
    }

    @Override
    public String str() {
        return "Treasure Island";
    }

    @Override
    public String info() {
        return "No transitions available, goal reached!";
    }
    
}
