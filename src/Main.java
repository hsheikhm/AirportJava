public class Main {

    public static void main(String[] args) throws AirportException {

        Plane plane = new Plane();

        System.out.println("Plane is flying:");
        System.out.println("Plane's current status: " + plane.status);
        System.out.println("Plane's current location: " + plane.location);
        System.out.println("Is the plane currently flying?: " + plane.isFlying());
        System.out.println();

        plane.landed();
        System.out.println("Plane has landed:");
        System.out.println("Plane's current status: " + plane.status);
        System.out.println("Plane's current location: " + plane.location);
        System.out.println("Is the plane currently flying?: " + plane.isFlying());
        System.out.println();

        plane.flying();
        System.out.println("Plane is flying again:");
        System.out.println("Plane's current status: " + plane.status);
        System.out.println("Plane's current location: " + plane.location);
        System.out.println("Is the plane currently flying?: " + plane.isFlying());
        System.out.println();

        Airport airportA = new Airport();
        Airport airportB = new Airport(30);
        System.out.println(airportA.capacity);
        System.out.println(airportB.capacity);
        System.out.println();

        airportB.land(new Plane());
        airportB.land(new Plane());
        System.out.println(airportB.planes.size());
        airportB.takeOff();
        System.out.println(airportB.planes.size());

    }

}