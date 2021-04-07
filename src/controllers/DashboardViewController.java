package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.Person;
import models.Professor;
import models.Student;
import utilities.DBUtility;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
        try {
            studentsListView.getItems().addAll(DBUtility.getStudentsFromDB());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        professorsListView.getItems().addAll(DBUtility.getProfessorsFromDB());

        //update the label's to show how many students and professors are in each list
        studentsLabel.setText("Students : "+studentsListView.getItems().size());
        professorsLabel.setText("Professors : "+professorsListView.getItems().size());
    }

    @FXML
    private void createStudentButtonPushed(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../views/createStudentView.fxml","EdMuse Create a new student");
    }
}
