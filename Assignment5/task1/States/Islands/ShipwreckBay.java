package States.Islands;

import States.Action;
import States.State;

public class ShipwreckBay implements State{

    @Override
    public State transition(Action action) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transition'");
    }

    @Override
    public String str() {
        return "Shipwreck Bay";
    }

    @Override
    public String info() {
        return "Aktion A -> Musket Hill; Aktion B -> Dead Man's Island";
    }
    
}
