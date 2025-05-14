package States.Islands;

import States.Action;
import States.State;

public class PiratesIsland implements State {

    @Override
    public State transition(Action action) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transition'");
    }

    @Override
    public String str() {
        return "Pirates' Island";
    }

    @Override
    public String info() {
        return "Aktion A -> Shipwreck Bay; Aktion B -> Musket Hill";
    }
    
}
