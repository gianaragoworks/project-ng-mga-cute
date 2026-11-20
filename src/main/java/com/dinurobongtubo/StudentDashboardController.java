
package com.dinurobongtubo;

import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class StudentDashboardController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label profileName;

    @FXML
    private Label profileDetails;

    @FXML
    private Label profileInitials;

    @FXML
    private void showBrowseItems() throws IOException {
        App.setRoot("browse-items");
    }

    @FXML
    private void showMyRequests() throws IOException {
        App.setRoot("my-requests");
    }
    @FXML
    private void showBorrowedReturns() throws IOException {
        App.setRoot("borrowed-returns");
    }
    @FXML
    private void showLiabilities() throws IOException {
        App.setRoot("liabilities");
    }

    @FXML
    public void initialize() {

        String name = StudentSession.fullName;
        String studentId = StudentSession.studentId;
        String department = StudentSession.department;

        if (name == null || name.isBlank()) {
            name = "Student";
        }

        if (studentId == null) {
            studentId = "No Student ID";
        }

        if (department == null) {
            department = "No Department";
        }

        welcomeLabel.setText(
            "Welcome back, " + name +
            " — Track your campus equipment borrows and requests."
        );

        profileName.setText(name);
        profileDetails.setText(studentId + " • " + department);

        String[] nameParts = name.trim().split("\\s+");

        String initials = "";

        if (nameParts.length >= 2) {
            initials = nameParts[0].substring(0, 1)
                    + nameParts[nameParts.length - 1].substring(0, 1);
        } else if (!nameParts[0].isEmpty()) {
            initials = nameParts[0].substring(0, 1);
        }

        profileInitials.setText(initials.toUpperCase());
    }

    @FXML
    private void showDashboard() {
        // Already on the dashboard.
    }

    @FXML
    private void showComingSoon(ActionEvent event) {

        Button clickedButton = (Button) event.getSource();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("HiramMate");
        alert.setHeaderText(clickedButton.getText());
        alert.setContentText(
            "This feature will be implemented in the next development stage."
        );

        alert.showAndWait();
    }
}
