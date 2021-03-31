package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import models.Person;
import models.Professor;
import models.Student;
import utilities.DBUtility;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardViewController implements Initializable {

    @FXML
    private Label studentsLabel;

    @FXML
    private ListView<Student> studentsListView;

    @FXML
    private Label professorsLabel;

    @FXML
    private ListView<Professor> professorsListView;

    @FXML
    private Label coursesLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentsListView.getItems().addAll(DBUtility.getStudentsFromDB());
        DBUtility.getProfessorsFromDB();
    }

//    @FXML
//    private ListView<?> coursesListView;

}
