package com.plma.controller;//nakasone

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.model.service.EmployeeInfoService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

@Controller
public class SetteiSceneController {
	@Autowired
	private EmployeeInfoService Service;

	@FXML
    private Button Addapartment_button;

    @FXML
    private Button Menu_button;


   /*@FXML
    void Addapartment_button_onClick(ActionEvent event) {

    }*/

    @FXML
    void Menu_button_onClick(ActionEvent event) {
    	/*
		 * 現在表示されている画面を閉じる
		 */
		Scene s = ((Node)event.getSource()).getScene();
		Window window = s.getWindow();
		window.hide();

		/*
		 * 新しい画面を生成する
		 */
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/com/plma/view/MainScene.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("新規社員登録");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }
}
