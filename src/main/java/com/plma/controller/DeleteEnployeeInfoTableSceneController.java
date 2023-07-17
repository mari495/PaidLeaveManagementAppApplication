package com.plma.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;
import com.plma.model.service.EmployeeInfoService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

@Controller
public class DeleteEnployeeInfoTableSceneController {
	@Autowired
	private EmployeeInfoService service;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField deleteBox;

    @FXML
    private Button deleteBtn;


	@Autowired
	private SpringFXMLLoader fxmlLoader;
	

    @FXML
    void initialize() {
        assert deleteBox != null : "fx:id=\"deleteBox\" was not injected: check your FXML file 'DeleteEnployeeInfoTableScene.fxml'.";
        assert deleteBtn != null : "fx:id=\"deleteBtn\" was not injected: check your FXML file 'DeleteEnployeeInfoTableScene.fxml'.";

    }

    
    /*
    void deleteBtn_OnClick(ActionEvent event) {
        System.out.println("deleteBox.getText()" + deleteBox.getText());
        if (service.existsById(Integer.parseInt(deleteBox.getText()))) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("削除の確認");
            alert.setContentText("本当に削除しますか？");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                service.deleteById(Integer.parseInt(deleteBox.getText()));
                // clearTable();
                // allBtn_OnClick(event);
            }
        } else {
            System.out.println("Value was null");
        }
    }*/

    /*
   	@FXML
   	private boolean confirmDelete() {
   	    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
   	    alert.setTitle("Confirmation");
   	    alert.setHeaderText("削除の確認");
   	    alert.setContentText("本当に削除しますか？");

   	    Optional<ButtonType> result = alert.showAndWait();
   	    return result.isPresent() && result.get() == ButtonType.OK;
   	}*/
    
   
    
	@FXML
    void deleteBtn_OnClick(ActionEvent event) {
		System.out.println("deleteBox.getText()"+deleteBox.getText());
    	if(service.existsById(Integer.parseInt(deleteBox.getText()))) {
    		//System.out.println("deleteBox.getText()"+deleteBox.getText());
    		service.deleteById(Integer.parseInt(deleteBox.getText()));
    		
    
    	}else {
    		System.out.println("Value was null");
    	}
    }
	
   
    
	@FXML
	void menu_button_onClick(ActionEvent event) {
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
			Parent parent = fxmlLoader.load(getClass().getResource("/com/plma/view/MainScene.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("メインメニュー");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
