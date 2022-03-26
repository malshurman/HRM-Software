package ba.etf.unsa.hrms.models;

import java.sql.Blob;
import java.util.Date;

public class Employee {
    private int ID;
    private int jobID;
    private int managerID;
    private int departmentID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Character sex;
    private Date birthDate;
    private Blob profileImage;

    public Employee(int ID, int jobID, int managerID, int departmentID, String firstName, String lastName, String email,
                    String phoneNumber, Character sex, Date birthDate, Blob profileImage) {
        this.ID = ID;
        this.jobID = jobID;
        this.managerID = managerID;
        this.departmentID = departmentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.birthDate = birthDate;
        this.profileImage = profileImage;
    }


}