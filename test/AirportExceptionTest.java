import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AirportExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void customExceptionMessage() throws AirportException {
        thrown.expect(AirportException.class);
        thrown.expectMessage("Custom Message");
        throw new AirportException("Custom Message");
    }

}