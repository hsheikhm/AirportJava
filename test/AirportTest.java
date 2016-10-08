import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AirportTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void newAirportPlanes() {
        Airport airport = new Airport();
        int numberOfPlanes = airport.planes.size();
        assertEquals("New airport should have 0 planes", 0, numberOfPlanes);
    }

    @Test
    public void newAirportCapacity() {
        Airport airportA = new Airport();
        assertEquals("Airport should have default capacity of 20", 20, airportA.capacity);
        Airport airportB = new Airport(40);
        assertEquals("Airport can have a custom specified capacity", 40, airportB.capacity);
    }

    @Test
    public void airportLandingPlane() throws AirportException {
        Airport mockAirport = spy(new Airport());
        Plane plane = new Plane();
        when(mockAirport.stormyWeather()).thenReturn(false);
        assertEquals("Airport should have 0 planes", 0, mockAirport.planes.size());
        mockAirport.land(plane);
        assertEquals("Airport should have 1 plane", 1, mockAirport.planes.size());
    }

    @Test
    public void airportLandingPlaneAirportFull() throws AirportException {
        Airport mockAirport = spy(new Airport());
        when(mockAirport.stormyWeather()).thenReturn(false);
        for (int x = 1; x <= 20; x++) { mockAirport.land(new Plane()); }
        assertEquals("Airport should be full", 20, mockAirport.planes.size());
        thrown.expect(AirportException.class);
        thrown.expectMessage("Airport is full!");
        mockAirport.land(new Plane());
        assertEquals("Plane does not land", 20, mockAirport.planes.size());
    }

    @Test
    public void airportLandingPlaneStormyWeather() throws AirportException {
        Airport mockAirport = spy(new Airport());
        Plane plane = new Plane();
        when(mockAirport.stormyWeather()).thenReturn(true);
        thrown.expect(AirportException.class);
        thrown.expectMessage("Landing denied. Weather is stormy!");
        mockAirport.land(plane);
        assertEquals("Plane does not land", 0, mockAirport.planes.size());
    }

    @Test
    public void airportTakingOffPlane() throws AirportException {
        Airport mockAirport = spy(new Airport());
        Plane plane = new Plane();
        when(mockAirport.stormyWeather()).thenReturn(false);
        mockAirport.land(plane);
        assertEquals("There should be 1 plane available", 1, mockAirport.planes.size());
        Plane planeForTakeOff = mockAirport.takeOff();
        assertEquals("The plane takes off", planeForTakeOff, plane);
        assertEquals("There should be no planes in the airport", 0, mockAirport.planes.size());
    }

    @Test
    public void airportTakingOffPlaneNoPlanes() throws AirportException {
        Airport airport = new Airport();
        thrown.expect(AirportException.class);
        thrown.expectMessage("No planes available!");
        airport.takeOff();
    }

    @Test
    public void airportTakingOffPlaneStormyWeather() throws AirportException {
        Airport mockAirport = spy(new Airport());
        when(mockAirport.stormyWeather()).thenReturn(false);
        mockAirport.land(new Plane());
        when(mockAirport.stormyWeather()).thenReturn(true);
        thrown.expect(AirportException.class);
        thrown.expectMessage("Take-off denied. Weather is stormy!");
        mockAirport.takeOff();
        assertEquals("Plane should not have taken off", 1, mockAirport.planes.size());
    }

}