package com.plma.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

@Controller
public class ShinkitourokuSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Menu_button;

    @FXML
    private Button add_button;

    @FXML
    private ComboBox<?> day;

    @FXML
    private ComboBox<?> department;

    @FXML
    private ComboBox<?> department1;

    @FXML
    private TextArea firstname_hurigana_text;

    @FXML
    private TextArea firstname_text;

    @FXML
    private TextArea lastname_hurigana_text;

    @FXML
    private TextArea lastname_text;

    @FXML
    private ComboBox<?> month;

    @FXML
    private ComboBox<?> syaincode_ComboBox;

    @FXML
    private ComboBox<?> year;

    @FXML
    void Menu_button_onClick(ActionEvent event) {

    }

    @FXML
    void onNyusyanenComboBoxAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Menu_button != null : "fx:id=\"Menu_button\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
        assert add_button != null : "fx:id=\"add_button\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
        assert day != null : "fx:id=\"day\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
        assert department != null : "fx:id=\"department\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
        assert department1 != null : "fx:id=\"department1\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
        assert firstname_hurigana_text != null : "fx:id=\"firstname_hurigana_text\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
        assert firstname_text != null : "fx:id=\"firstname_text\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
        assert lastname_hurigana_text != null : "fx:id=\"lastname_hurigana_text\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
        assert lastname_text != null : "fx:id=\"lastname_text\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
        assert month != null : "fx:id=\"month\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
        assert syaincode_ComboBox != null : "fx:id=\"syaincode_ComboBox\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
        assert year != null : "fx:id=\"year\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";

    }

}
