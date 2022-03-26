package ba.etf.unsa.hrms.models;

import java.util.Date;

public class PaidTimeOff {
    private int employeeID;
    private int availableDays;
    private Date startDate;
    private Date endDate;

    public PaidTimeOff(int employeeID, int availableDays, Date startDate, Date endDate) {
        this.employeeID = employeeID;
        this.availableDays = availableDays;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
