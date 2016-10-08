import java.util.ArrayList;

public class Airport {

    private static final int DEFAULT_CAPACITY = 20;

    ArrayList<Plane> planes;
    int capacity;

    public Airport() {
        this.planes = new ArrayList<>();
        this.capacity = DEFAULT_CAPACITY;
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

}