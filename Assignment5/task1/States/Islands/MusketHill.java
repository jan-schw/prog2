package States.Islands;

import States.Action;
import States.State;

public class MusketHill implements State{

    @Override
    public State transition(Action action) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transition'");
    }

    @Override
    public String str() {
        return "Musket Hill";
    }

    @Override
    public String info() {
        return "Aktion A -> Pirates' Island; Aktion B -> Mutineer's Island";
    }
    
}
