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
        //add Student's and professor's to the ListView
        studentsListView.getItems().addAll(DBUtility.getStudentsFromDB());
        professorsListView.getItems().addAll(DBUtility.getProfessorsFromDB());

        //update the label's to show how many students and professors are in each list
        studentsLabel.setText("Students : "+studentsListView.getItems().size());
        professorsLabel.setText("Professors : "+professorsListView.getItems().size());

        //1. a new view / controller to move to
        //2. code to recognize when the "create student" button is pushed to change scenes

    }

//    @FXML
//    private ListView<?> coursesListView;

}
