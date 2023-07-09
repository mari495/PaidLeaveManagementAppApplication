/**このクラスは
 *
 * 
 * ”１か月切っています”
 * ”３か月切っています”
 * ”６か月切っています”という文字を
 * プルダウンより選択して、検索するまでの画面です。
 * 結果はHitKensakuViewControllerに表示する予定です
 * 
 * 上記の検索文字が
 * 有給休暇消滅日のcolumnに表示されている人を
 * 表をさらに絞って表示することができるように実装予定です
 * 
 * さらに、画面を印刷機能を実装予定です
 *
 * 
 */

package com.plma.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;

import com.plma.SpringFXMLLoader;
import com.plma.model.entity.EmployeeInfoDto;
import com.plma.model.service.EmployeeInfoService;
import com.plma.model.shareddata.SharedData;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ViewPaidVacationExpiryDateController {
	@Autowired
	private SpringFXMLLoader fxmlLoader;

	@Autowired
	EmployeeInfoService service;
	//EmployeeInfoServiceImpl service;

	@Autowired
	SharedData sd;
	
	@Autowired
	EmployeeInfoDto employeeInfoDto;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    
  @FXML
  	private Button menu_button;

    @FXML
    void initialize() {

	
	
    }
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
