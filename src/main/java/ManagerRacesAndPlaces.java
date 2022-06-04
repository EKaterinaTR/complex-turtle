import java.util.Map;
import java.util.Set;

public interface ManagerRacesAndPlaces {
    Set<String> getRaces();

    Set<Character> getPlaces();

    Map<String, Map<Character, Integer>> getPrices();


}
