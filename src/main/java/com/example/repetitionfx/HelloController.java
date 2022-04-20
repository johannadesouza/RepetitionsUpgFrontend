package com.example.repetitionfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class HelloController {
        @FXML
        private TextField adressTextfield;
        @FXML
        private DatePicker datepickerField;
        @FXML
        private TextField firstnameTextField;
        @FXML
        private TextField lastnameTextfield;
        @FXML
        private TextField phonenumberTextfield;
        @FXML
        private Button registerButton;
        @FXML
        private Label registerMessage;
        @FXML
        private TableView<String> resultUserTable;
        @FXML
        private TextField searchPhonenumberTextfield;

        ConnectionManager connectionManager = new ConnectionManager();

        public void registerUser() {
                String birthdate = datepickerField.toString();
                String firstname = firstnameTextField.getText();
                String lastname = lastnameTextfield.getText();
                String adress = adressTextfield.getText();
                String phonenumber = phonenumberTextfield.getText();

                while (!birthdate.isBlank() && !firstname.isBlank() && !lastname.isBlank() && !adress.isBlank() && !phonenumber.isBlank()) {
                        if (connectionManager.sendRequst("/getUserByPhonenumber=" + phonenumber).equals("User exist!")) {
                                registerMessage.setText("Finns redan en användare registrerad med det här telefonnumret, välj annat!");

                        } else {
                                connectionManager.sendRequst("/addUser=" + "bithdate=" + birthdate + "&firstname" + firstname +
                                        "&lastname=" + lastname + "&adress=" + adress + "&phonenumber=" + phonenumber);
                                registerMessage.setTextFill(Color.GREEN);
                                registerMessage.setText("En person har nu registrerats! Sök efter person med telefonnummer i personregistret!");
                        }
                }
                registerMessage.setTextFill(Color.RED);
                registerMessage.setText("Alla fält måste vara ifyllda!");
        }


        @FXML
        void registerUserOnAction(ActionEvent event) {
                registerUser();
        }

    }