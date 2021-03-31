package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Student;

import java.net.URL;
import java.time.LocalDate;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        msgLabel.setText("");
    }

    /**
     * When the button is pushed, try to create a new Student object
     */
    @FXML
    private void createNewStudent()
    {
        try {
            Student newStudent = new Student(firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    addressTextField.getText(),
                    birthday.getValue(),
                    20000001);
            msgLabel.setText("New Student: "+newStudent.toString());
        } catch(IllegalArgumentException e)
        {
            msgLabel.setText(e.getMessage());
        }
    }
}
