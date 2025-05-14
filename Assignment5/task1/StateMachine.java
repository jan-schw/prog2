import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import States.Action;
import States.State;
import States.Islands.PiratesIsland;
import States.Islands.TreasureIsland;

public class StateMachine {
    private State currentState = new PiratesIsland();
    private State goalState = new TreasureIsland();
    private Scanner scanner = new Scanner(System.in);
    private List<State> visitedStates;

    public StateMachine() {
        this.visitedStates = new ArrayList<State>();
        this.visitedStates.add(currentState);
    }

    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine();
        System.out.println("Behold, a fancy state-based treasure hunt!");

        while(!stateMachine.currentState.str().equals(stateMachine.goalState.str())){
            stateMachine.printInfo();
            Action nextAction = stateMachine.getActionFromUserInput();
            stateMachine.currentState = stateMachine.currentState.transition(nextAction);
            System.out.println("Welcome to " + stateMachine.currentState.str());
            stateMachine.visitedStates.add(stateMachine.currentState);
            System.out.println("-----------");
        }

        System.out.println("Goal reached! Welcome to Treasure Island!");
        stateMachine.printAllVisitedStates();
    }

    private void printInfo(){
        System.out.println("Current position: " + this.currentState.str());
        System.out.println("Options: " + this.currentState.info());
    }

    private void printAllVisitedStates(){
        System.out.println("Here are all the visited islands:");
        for(State current: this.visitedStates){
            System.out.println(current.str());
        }
    }

    private Action getActionFromUserInput(){
        System.out.println("Where to? A or B?");
        String userAction = this.scanner.nextLine();
        Action choseAction = null;
        if(userAction.equals("A")){
            choseAction = Action.A;
        }
        else if(userAction.equals("B")){
            choseAction = Action.B;
        }

        System.out.println("Chosen option: " + choseAction.str());
        return choseAction;
    }
}
