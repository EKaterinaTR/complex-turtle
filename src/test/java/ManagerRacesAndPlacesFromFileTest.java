import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class ManagerRacesAndPlacesFromFileTest {


    @Test
    public void readConfig_RightReadPlacesFromFile() {
        assertEquals(Set.of('T', 'S', 'W', 'P'), new ManagerRacesAndPlacesFromFile().getPlaces());
    }

    @Test
    public void readConfig_RightReadRacesFromFile() {
        assertEquals(Set.of("Human", "Swamper", "Woodman"), new ManagerRacesAndPlacesFromFile().getRaces());
    }

    @Test
    public void readConfig_RightReadPricesFromFile() {
        assertEquals(Map.of(
                "Human", Map.of('S', 5, 'W', 2, 'T', 3, 'P', 1),
                "Swamper", Map.of('S', 2, 'W', 2, 'T', 5, 'P', 2),
                "Woodman", Map.of('S', 3, 'W', 3, 'T', 2, 'P', 2)
        ), new ManagerRacesAndPlacesFromFile().getPrices());
    }

}
