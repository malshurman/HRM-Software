package ba.etf.unsa.hrms.models;

import java.util.Locale;

public class Location {
    private int ID;
    private String street;
    private String city;
    private Locale country;

    public Location(int ID, String street, String city, String country) {
        this.ID = ID;
        this.street = street;
        this.city = city;
        this.country = Locale.forLanguageTag(country);
    }
}
