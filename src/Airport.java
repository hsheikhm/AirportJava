import java.util.ArrayList;

public class Airport {

    private int defaultCapacity = 20;

    ArrayList<Plane> planes;
    int capacity;

    public Airport() {
        this.planes = new ArrayList<>();
        this.capacity = defaultCapacity;
    }

    public Airport(int airportCapacity) {
        this.planes = new ArrayList<>();
        this.capacity = airportCapacity;
    }

    protected void land(Plane plane) throws AirportException {
        checkIfOkForLanding();
        if (plane.isFlying()) {
            planes.add(plane);
            plane.landed();
        } else { System.out.println("This plane has already landed"); }
    }

    protected Plane takeOff() throws AirportException {
        checkIfOkForTakeOff();
        Plane planeForTakeOff = planes.get(planes.size() - 1);
        planeForTakeOff.flying();
        planes.remove(planeForTakeOff);
        return planeForTakeOff;
    }

    private void checkIfOkForLanding() throws AirportException {
        if (airportFull()) { throw new AirportException("Airport is full!"); }
        if (stormyWeather()) { throw new AirportException("Landing denied. Weather is stormy!"); }
    }

    private void checkIfOkForTakeOff() throws AirportException {
        if (!planesAvailable()) { throw new AirportException("No planes available!"); }
        if (stormyWeather()) { throw new AirportException("Take-off denied. Weather is stormy!"); }
    }

    private boolean airportFull() {
        return planes.size() >= capacity;
    }

    private boolean planesAvailable() {
        return planes.size() > 0;
    }

    protected boolean stormyWeather() {
        return Math.random() > 0.95;
    }

    public static void main(String[] args) throws AirportException {
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