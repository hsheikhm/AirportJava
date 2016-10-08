import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PlaneTest {

    @Test
    public void newPlaneStatus() {
        Plane plane = new Plane();
        assertEquals("Plane should be flying", "flying", plane.status);
    }

    @Test
    public void newPlaneLocation() {
        Plane plane = new Plane();
        assertEquals("Plane should be in the air", "air", plane.location);
    }

    @Test
    public void planeFlying() {
        Plane plane = new Plane();
        plane.flying();
        assertEquals("Plane should be flying", "flying", plane.status);
        assertEquals("Plane should be in the air", "air", plane.location);
    }

    @Test
    public void planeLanded() {
        Plane plane = new Plane();
        plane.landed();
        assertEquals("Plane should be landed", "landed", plane.status);
        assertEquals("Plane should be in the airport", "airport", plane.location);
    }

    @Test
    public void planeIsFlying() {
        Plane plane = new Plane();
        assertTrue("Plane should be flying", plane.isFlying());
        plane.landed();
        assertFalse("Plane should not be flying", plane.isFlying());
    }

}