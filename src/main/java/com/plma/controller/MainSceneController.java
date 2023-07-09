package com.plma.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

@Controller
public class MainSceneController {
	@Autowired
	private SpringFXMLLoader fxmlLoader;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button kensaku_button;

    @FXML
    private Button misyouka_button;

    @FXML
    private Button settei_button;

    @FXML
    private Button shinkitouroku_button;

    @FXML
    private Button syoumetu_button;

    @FXML
    private Button yukyutouroku_button;

    @FXML
    void shinkitouroku_button_onClick(ActionEvent event) {
    	System.out.println("登録画面に来た");
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
			Parent parent = fxmlLoader.load(getClass().getResource("/com/plma/view/ShinkitourokuScene.fxml"));
	        Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("新規社員登録");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void kensaku_button_onClick(ActionEvent event) {
    	System.out.println("検索画面に来た");
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
			Parent parent = fxmlLoader.load(getClass().getResource("/com/plma/view/kensakuScene.fxml"));
	        Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("個人データ検索");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void settei_button_onClick(ActionEvent event) {
    	System.out.println("設定画面に来た");
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
			Parent parent = fxmlLoader.load(getClass().getResource("/com/plma/view/settei.fxml"));
	        Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("設定");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void AddStatusPaidLeave_button_onClick(ActionEvent event) {
    	System.out.println("設定画面に来た");
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
			Parent parent = fxmlLoader.load(getClass().getResource("/com/plma/view/AddStatusPaidLeave.fxml"));
	        Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("設定");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void ViewPaidVacationEpiry_onClick(ActionEvent event) {
    	System.out.println("登録画面に来た");
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
			Parent parent = fxmlLoader.load(getClass().getResource("/com/plma/view/ViewPaidVacationExpiryDate.fxml"));
	        Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("新規社員登録");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert kensaku_button != null : "fx:id=\"kensaku_button\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert misyouka_button != null : "fx:id=\"misyouka_button\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert settei_button != null : "fx:id=\"settei_button\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert shinkitouroku_button != null : "fx:id=\"shinkitouroku_button\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert syoumetu_button != null : "fx:id=\"syoumetu_button\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert yukyutouroku_button != null : "fx:id=\"yukyutouroku_button\" was not injected: check your FXML file 'MainScene.fxml'.";

    }

}
