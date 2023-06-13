package com.plma.controller;//nakasone

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;
import com.plma.model.entity.EmployeeInfo;
import com.plma.model.service.EmployeeInfoService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.Window;


@Controller
public class ShinkitourokuSceneController {
	
	 @Autowired
	private EmployeeInfoService Service;
//仮作成不要なら除去
	@Autowired
	private SpringFXMLLoader fxmlLoader;

	
	//EmployeeInfoServiceImpl service;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Menu_button;

    @FXML
    private Button add_button;

    @FXML
    private ComboBox<String> day;

    @FXML
    private ComboBox<String> department;

    @FXML
    private ComboBox<String> department1;
    
    @FXML
    private ComboBox<String> month;

    @FXML
    private ComboBox<String> syaincode_ComboBox;

    @FXML
    private ComboBox<String> year;

    @FXML
    private TextArea firstname_hurigana_text;

    @FXML
    private TextArea firstname_text;

    @FXML
    private TextArea lastname_hurigana_text;

    @FXML
    private TextArea lastname_text;


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
			stage.setTitle("メインメニュー");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
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


        
    	//ComboBoxに値を登録
    		for(int y = 2000; y < 2024; y++) {
    			year.getItems().add(Integer.toString(y));
    		}

    		for(int m = 1; m < 13; m++) {
    			month.getItems().add(Integer.toString(m));
    		}

    		for(int d = 1; d < 32; d++) {
    			day.getItems().add(Integer.toString(d));
    		}

    		
    		for(int dept = 101; dept < 107; dept++) {
    			department.getItems().add(Integer.toString(dept));
    		}//仮入れ
    		for(int dept1 = 1; dept1 < 6; dept1++) {
    			department1.getItems().add(Integer.toString(dept1));
    		}
    		//仮入れ
    		for(int syaincode = 1; syaincode < 100; syaincode++) {
    			syaincode_ComboBox.getItems().add(Integer.toString(syaincode));
    		}
        
        
    }
    
    
    void closeWindow(ActionEvent event){
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
   
    @FXML
	void addOnClick(ActionEvent event) {
    	
    	System.out.println(lastname_hurigana_text.getText());
        System.out.println(firstname_hurigana_text.getText());
        System.out.println(lastname_text.getText());
        System.out.println(firstname_text.getText());
        System.out.println(year.getValue());
        System.out.println(month.getValue());
        System.out.println(day.getValue());
        System.out.println(department.getValue());
        System.out.println(department1.getValue());

        System.out.println("Year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);

        EmployeeInfo empinfo = new EmployeeInfo(
        );
        
        empinfo.setHurigana_lastname(lastname_hurigana_text.getText());
        empinfo.setHurigana_firstname(firstname_hurigana_text.getText());
        empinfo.setFirstname(firstname_text.getText());
        empinfo.setLastname(lastname_text.getText());
        empinfo.setWorking_days(Integer.parseInt(department1.getValue()));//所定労働日数
        empinfo.setDepartment_number(Integer.parseInt(department.getValue()));//部署名
        empinfo.setCode("");//社員コードstringに変更
        
        
        
     // "join_date"から年の部分を取得
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //LocalDate joinDate = LocalDate.of(Integer.parseInt(year.getValue()), Integer.parseInt(month.getValue()), Integer.parseInt(day.getValue()));
        
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        empinfo.setJoin_date(sqlDate);

        try {
        	Service.insertEmployeeInfo(empinfo);
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getCause() instanceof InvocationTargetException) {
                Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
                targetException.printStackTrace();
            }
        }

        closeWindow(event);
    }
    
}
