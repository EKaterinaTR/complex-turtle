import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class SolutionTest {
    ManagerRacesAndPlaces managerRacesAndPlaces;
    final static String FIELD = "STWSWTPPTPTTPWPP";

    @Before
    public void createTestData() {
        managerRacesAndPlaces = new ManagerRacesAndPlaces() {
            private Set<String> races = Set.of("Human", "Swamper", "Woodman");
            private Set<Character> places = Set.of('T', 'S', 'W', 'P');
            private Map<String, Map<Character, Integer>> creatureToPassPlacePrices =
                    Map.of(
                            "Human", Map.of('S', 5, 'W', 2, 'T', 3, 'P', 1),
                            "Swamper", Map.of('S', 2, 'W', 2, 'T', 5, 'P', 2),
                            "Woodman", Map.of('S', 3, 'W', 3, 'T', 2, 'P', 2)
                    );

            @Override
            public Set<String> getRaces() {
                return races;
            }

            @Override
            public Set<Character> getPlaces() {
                return places;
            }

            @Override
            public Map<String, Map<Character, Integer>> getPrices() {
                return creatureToPassPlacePrices;
            }
        };
    }

    @Test
    public void getResult_OnTestDataForHumanEquals_10() {
        assertEquals(10,
                Solution.getResult(FIELD, "Human", managerRacesAndPlaces));

    }

    @Test
    public void getResult_OnTestDataForSwamperEquals_15() {
        assertEquals(15,
                Solution.getResult(FIELD, "Swamper", managerRacesAndPlaces));

    }

    @Test
    public void getResult_OnTestDataForWoodmanEquals_12() {
        assertEquals(12,
                Solution.getResult(FIELD, "Woodman", managerRacesAndPlaces));

    }

    @Test
    public void getResultWithManagerRacesAndPlacesFromFile_ForHumanEquals_10() {
        assertEquals(10,
                Solution.getResult(FIELD, "Human"));

    }

    @Test
    public void getResultWithManagerRacesAndPlacesFromFile_OnTestDataForSwamperEquals_15() {
        assertEquals(15,
                Solution.getResult(FIELD, "Swamper"));

    }

    @Test
    public void getResultWithManagerRacesAndPlacesFromFile_OnTestDataForWoodmanEquals_12() {
        assertEquals(12,
                Solution.getResult(FIELD, "Woodman"));

    }
}
