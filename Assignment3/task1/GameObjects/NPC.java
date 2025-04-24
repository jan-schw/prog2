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

    public void walkRight(){
        this.xCoordinate++;
    }

    public void dashRight(){
        if(!isCrouching){
            this.xCoordinate += 2;
        }
    }

    public boolean isCrouching() {
        return isCrouching;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }
}
