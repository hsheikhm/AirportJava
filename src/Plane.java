public class Plane {

    String status;
    String location;

    public Plane() {
        this.status = "flying";
        this.location = "air";
    }

    protected void flying() {
        this.status = "flying";
        this.location = "air";
    }

    protected void landed() {
        this.status = "landed";
        this.location = "airport";
    }

    protected boolean isFlying() {
        return status == "flying";
    }

}