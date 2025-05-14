package States.Islands;

import States.Action;
import States.State;

public class DeadMansIsland implements State{

    @Override
    public State transition(Action action) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transition'");
    }

    @Override
    public String str() {
        return "Dead Man's Island";
    }

    @Override
    public String info() {
        return "Aktion A -> Musket Hill; Aktion B -> Shipwreck Bay";
    }
    
}
