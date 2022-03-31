package ba.etf.unsa.hrms.controllers;

import ba.etf.unsa.hrms.dao.HumanResourcesDAO;
import ba.etf.unsa.hrms.models.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DashboardController {
    private HumanResourcesDAO dao;
    private ObservableList<Employee> listEmployee;

    @FXML private Tab tabEmployee;
    @FXML private Tab tabJob;
    @FXML private Tab tabHours;
    @FXML private ListView<Employee> listViewEmployee;
    @FXML private TextField fldSearchEmployees;

    public DashboardController() {
        dao = HumanResourcesDAO.getInstance();
    }

    @FXML public void initialize() {
        setTabsToEmployee();
    }

    private void setTabsToEmployee() {
        try {
            EmployeeInfoController employeeInfoController = new EmployeeInfoController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/personal_info.fxml"));
            loader.setController(employeeInfoController);
            loader.load();
            tabEmployee.setContent(loader.getRoot());

            JobInfoController jobInfoController = new JobInfoController();
            loader = new FXMLLoader(getClass().getResource("/fxml/job_info.fxml"));
            loader.setController(jobInfoController);
            loader.load();
            tabJob.setContent(loader.getRoot());

            HoursInfoController hoursInfoController = new HoursInfoController();
            loader = new FXMLLoader(getClass().getResource("/fxml/hours_info.fxml"));
            loader.setController(hoursInfoController);
            loader.load();
            tabHours.setContent(loader.getRoot());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
