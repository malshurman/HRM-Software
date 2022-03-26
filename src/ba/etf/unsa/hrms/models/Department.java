package ba.etf.unsa.hrms.models;

public class Department {
    private int ID;
    private int managerID;
    private int locationID;
    private String name;

    public Department(int ID, int managerID, int locationID, String name) {
        this.ID = ID;
        this.managerID = managerID;
        this.locationID = locationID;
        this.name = name;
    }
}
