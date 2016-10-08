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

    public static void main(String[] args) {

        Plane planeA = new Plane();

        System.out.println("Plane is flying:");
        System.out.println("Plane's current status: " + planeA.status);
        System.out.println("Plane's current location: " + planeA.location);
        System.out.println("Is the plane currently flying?: " + planeA.isFlying());
        System.out.println();

        planeA.landed();
        System.out.println("Plane has landed:");
        System.out.println("Plane's current status: " + planeA.status);
        System.out.println("Plane's current location: " + planeA.location);
        System.out.println("Is the plane currently flying?: " + planeA.isFlying());
        System.out.println();

        planeA.flying();
        System.out.println("Plane is flying again:");
        System.out.println("Plane's current status: " + planeA.status);
        System.out.println("Plane's current location: " + planeA.location);
        System.out.println("Is the plane currently flying?: " + planeA.isFlying());
        System.out.println();
    }

}