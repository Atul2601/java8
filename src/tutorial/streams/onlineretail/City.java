package tutorial.streams.onlineretail;

import java.util.*;

class City {
    private final String name;
    private final int zipCode;
    private static final Map<Integer,City> cache = new HashMap<>();

    public int getZipCode() {
        return zipCode;
    }

    public static City city(String name, int zipCode){
        //To demonstrate usage of Optional
        return Optional.of(cache.get(zipCode)).orElse(newCity(name, zipCode));
    }

    private static City newCity(String name, int zipCode) {
        City city = new City(name, zipCode);
        cache.put(zipCode, city);
        return city;
    }

    protected City(String name, int zipCode) {
        this.name = name;
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City))
            return false;

        City city = (City) o;

        return zipCode == city.zipCode && name.equalsIgnoreCase(city.name);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + zipCode;
        return result;
    }
}

