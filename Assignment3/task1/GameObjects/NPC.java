package GameObjects;

public class NPC {
    private boolean isCrouching;
    private int xCoordinate;

    public NPC(){
        this.isCrouching = false;
        this.xCoordinate = 0;
    }

    public void standUp(){
        this.isCrouching = false;
    }

    public void crouch(){
        this.isCrouching = true;
    }
}
