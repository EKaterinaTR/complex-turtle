/**
 * This algorithm works for N < 5 and M < 5, for other cases Dijkstra's algorithm should be used.
 */

import exception.UnknownPlaceException;
import exception.UnknownRaceException;
import exception.WrongFieldLengthException;

import java.util.Map;

public class Solution {
    private final static int N = 4;
    private final static int M = 4;

    public static int getResult(String fieldMap, String creatureRace) {
        ManagerRacesAndPlaces managerRacesAndPlaces = new ManagerRacesAndPlacesFromFile();
        return getResult(fieldMap, creatureRace, managerRacesAndPlaces);
    }

    public static int getResult(String fieldMap, String creatureRace, ManagerRacesAndPlaces manager) {
        if (!(N * M == fieldMap.length())) {
            throw new WrongFieldLengthException();
        }
        if (!manager.getRaces().contains(creatureRace)) {
            throw new UnknownRaceException();
        }
        Map<Character, Integer> prices = manager.getPrices().get(creatureRace);
        int[][] field = new int[N][M];
        field[0][0] = 0;
        for (int i = 1; i < fieldMap.length(); i++) {
            field[i % N][i / N] =
                    getMinPriceForPathTo(i % N, i / N, field) + getPlacePrice(fieldMap.charAt(i), prices);
        }
        return field[N - 1][M - 1];
    }

    private static int getMinPriceForPathTo(int i, int j, int[][] field) {
        if (i == 0) {
            return field[i][j - 1];
        }
        if (j == 0) {
            return field[i - 1][j];
        }
        return Math.min(field[i][j - 1], field[i - 1][j]);
    }

    private static int getPlacePrice(char place, Map<Character, Integer> prices) {
        Integer price = prices.get(place);
        if (price == null) {
            throw new UnknownPlaceException();
        }
        return price;
    }
}
