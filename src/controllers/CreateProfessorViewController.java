package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import models.Professor;
import utilities.DBUtility;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateProfessorViewController implements Initializable {

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private DatePicker birthday;

    @FXML
    private VBox teachablesVBox;

    @FXML
    private Label msgLabel;

    @FXML
    private void changeToDashBoardView(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../views/dashboardView.fxml","Edmuse");
    }

    @FXML
    void createNewProfessor(ActionEvent event) {
        Professor newProfessor = new Professor(firstNameTextField.getText(),
                                            lastNameTextField.getText(),
                                            addressTextField.getText(),
                                            birthday.getValue(),
                                            getTeachableSubjectsForProf());
    }

    private ArrayList<String> getTeachableSubjectsForProf()
    {
        ArrayList<String> teachables = new ArrayList<>();

        //loop over the check box objects and return a list of selected course codes
        for (Node node : teachablesVBox.getChildren())
        {
            if (node.getClass() == CheckBox.class)
            {
                CheckBox checkBox = (CheckBox) node;  //We know that the node is actually a CheckBox object, so cast it to be CheckBox
                if (checkBox.isSelected())
                    teachables.add(checkBox.getText());
            }
        }

        return teachables;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //loop over the valid course codes and add CheckBox objects to the teachable VBox
        for (String courseCode : DBUtility.getValidCourseCodesFromDB())
        {
            teachablesVBox.getChildren().add(new CheckBox(courseCode));
        }

        msgLabel.setText("");
    }
}
