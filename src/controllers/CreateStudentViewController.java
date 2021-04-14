package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Student;
import utilities.DBUtility;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateStudentViewController implements Initializable {

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private DatePicker birthday;

    @FXML
    private Label msgLabel;

    @FXML
    private ComboBox<String> majorComboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        msgLabel.setText("");
        majorComboBox.getItems().addAll(DBUtility.getMajors());

    }

    /**
     * When the button is pushed, try to create a new Student object
     */
    @FXML
    private void createNewStudent() throws SQLException {
        try {
            Student newStudent = new Student(firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    addressTextField.getText(),
                    birthday.getValue());

            //if nothing is selected, it returns null.  If an object is selected
            //it returns the object
            String major = majorComboBox.getValue();
            System.out.println(major);

            //get a studentNum from the DB and update the Student object
            int studentNum = DBUtility.insertStudentIntoDB(newStudent);

            if (studentNum>0)
            {
                newStudent.setStudentNum(studentNum);
            }
            msgLabel.setText("New Student: "+newStudent.toString());
        } catch(IllegalArgumentException e)
        {
            msgLabel.setText(e.getMessage());
        }
    }

    @FXML
    private void changeToDashBoardView(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../views/dashboardView.fxml","Edmuse");
    }
}
