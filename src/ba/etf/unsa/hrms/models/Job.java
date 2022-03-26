package ba.etf.unsa.hrms.models;

public class Job {
    private int ID;
    private String title;
    private int salary;

    public Job(int ID, String title, int salary) {
        this.ID = ID;
        this.title = title;
        this.salary = salary;
    }
}
