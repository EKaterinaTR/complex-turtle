import java.io.*;
import java.util.*;

class ManagerRacesAndPlacesFromFile implements ManagerRacesAndPlaces {
    private Map<String, Map<Character, Integer>> creatureToPassPlacePrices;
    private Set<Character> places;
    private Set<String> races;

    public ManagerRacesAndPlacesFromFile() {
        this("default.txt");
    }

    public ManagerRacesAndPlacesFromFile(String pathToConfig) {
        readConfig(pathToConfig);
    }

    private void readConfig(String pathToConfig) {
        try (FileReader fr = new FileReader(pathToConfig); BufferedReader br = new BufferedReader(fr)) {
            races = new LinkedHashSet<>(Arrays.asList(br.readLine().split(",")));
            places = new LinkedHashSet<>();
            for (Character place : br.readLine().toCharArray()) {
                places.add(place);
            }
            creatureToPassPlacePrices = new HashMap<>();
            for (String race : races) {
                String[] stringPrices = br.readLine().split(",");
                int i = 0;
                Map<Character, Integer> prices = new HashMap<>();
                for (Character place : places) {
                    prices.put(place, Integer.parseInt(stringPrices[i]));
                    i++;
                }
                creatureToPassPlacePrices.put(race, prices);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

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

}


