package com.plma.controller;//nakasone
//import java.awt.TextArea;
//import java.awt.event.ActionEvent;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;
import com.plma.model.entity.Department;
import com.plma.model.entity.EmployeeInfo;
import com.plma.model.service.EmployeeInfoService;
import com.plma.model.shareddata.SharedData;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
/*
 * 個人データ検索画面のコントローラークラス
 * */
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.Window;

@Controller
public class KensakuSceneController {

	@Autowired
	private SpringFXMLLoader fxmlLoader;

	@Autowired
	EmployeeInfoService service;
	

	@Autowired
	SharedData sd;

	@FXML
	private Button menu_button;

	@FXML
	private Button kensaku_button;

	@FXML
	private Button All_button;

	@FXML
	private ComboBox<Integer> day;

	@FXML
	private ComboBox<String> department;

	@FXML
	private ComboBox<Integer> department1;

	@FXML
	private TextArea firstname_hurigana_text;

	@FXML
	private TextArea firstname_text;

	@FXML
	private TextArea lastname_hurigana_text;

	@FXML
	private TextArea lastname_text;

	@FXML
	private ComboBox<Integer> month;

	@FXML
	private ComboBox<String> syaincode_ComboBox;

	@FXML
	private ComboBox<Integer> year;

	public String getTextAreaContent(TextArea textArea) {
	    String content = textArea.getText();
	    return (content == null || content.isEmpty()) ? null : content;
	}
	@FXML
	void initialize() {
		assert menu_button != null : "fx:id=\"Menu_button\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
		assert kensaku_button != null : "fx:id=\"kensaku_button\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
		assert day != null : "fx:id=\"day\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
		assert All_button != null : "fx:id=\"day\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
		assert department != null : "fx:id=\"department\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
		assert department1 != null : "fx:id=\"department1\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
		assert firstname_hurigana_text != null : "fx:id=\"firstname_hurigana_text\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
		assert firstname_text != null : "fx:id=\"firstname_text\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
		assert lastname_hurigana_text != null : "fx:id=\"lastname_hurigana_text\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
		assert lastname_text != null : "fx:id=\"lastname_text\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
		assert month != null : "fx:id=\"month\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
		assert syaincode_ComboBox != null : "fx:id=\"syaincode_ComboBox\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";
		assert year != null : "fx:id=\"year\" was not injected: check your FXML file 'ShinkitourokuScene.fxml'.";



		// ComboBoxに値を登録
		for (int y = 2000; y < 2024; y++) {
			year.getItems().add(Integer.valueOf(y));
		}

		for (int m = 1; m < 13; m++) {
			month.getItems().add(Integer.valueOf(m));
		}

		for (int d = 1; d < 32; d++) {
			day.getItems().add(Integer.valueOf(d));
		}




		//DepartmentDBからgetDepartment_nameを取得して表示
		Iterable<Department> departments = service.getDepartment();

		for (Department dep : departments) {
			String departmentName = dep.getDepartment_name();
			department.getItems().add(departmentName);
		}



		for (int dept1 = 1; dept1 < 6; dept1++) {//所定労働日数
			department1.getItems().add(dept1);
		}
		
		for(int syaincode = 100; syaincode < 201; syaincode++) {
			syaincode_ComboBox.getItems().add(Integer.toString(syaincode));
		}


	}



	//DepartmentDBよりDepartment_nameとequalsDepartment_numberを取得メソッド
	private Integer getDepartmentNumber(String departmentName) {
		Iterable<Department> departments = service.getDepartment();

		for (Department department : departments) {
			if (department.getDepartment_name().equals(departmentName)) {
				return department.getDepartment_number();
			}
		}

		return null; // 該当する部署が見つからなかった場合は null を返す（適宜エラーハンドリングを行ってください）
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

	@FXML//全取得
	void allBtn_OnClick(ActionEvent event) {

		

		Iterable<EmployeeInfo> iterable = service.selectAll();
		
		try {
			sd.setEmployeeInfo(iterable);
			/*
			 * 現在表示されている画面を閉じる
			 */
			Scene s = ((Node)event.getSource()).getScene();
			Window window = s.getWindow();
			window.hide();
			Parent parent = fxmlLoader.load(getClass().getResource("/com/plma/view/hitKensakuView.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("メインメニュー");
			stage.show();
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			if (e.getCause() instanceof InvocationTargetException) {
				Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
				targetException.printStackTrace();
			}
		}
	}




	@FXML//複数の&&条件による検索
	void kensaku_button_onClick(ActionEvent event) {

		Date date = null;
		
		Integer yearItem = year.getSelectionModel().getSelectedItem();
		Integer monthItem = month.getSelectionModel().getSelectedItem();
		Integer dayItem = day.getSelectionModel().getSelectedItem();
		
		
		
		if(!(yearItem == null && monthItem == null && dayItem == null)) {
			

			
			// コンボボックスの値から日付を作成
			LocalDate selectedDate = LocalDate.of(year.getValue(), month.getValue(), day.getValue());
			// java.sql.Dateに変換
			date = Date.valueOf(selectedDate);
		}

		


		try {

			//部署名をDBで照らし合わせてDepartmentNumberを取得する
			String selectedDepartment = department.getValue();
			Integer departmentNumber = getDepartmentNumber(selectedDepartment);



			Iterable<EmployeeInfo> searchResults = service.findByEightParams(
					syaincode_ComboBox.getSelectionModel().getSelectedItem(),//社員コード
					date,//入社日
					getTextAreaContent(firstname_hurigana_text),//名前ふりがな
					getTextAreaContent(lastname_hurigana_text),//苗字ふりがな
					getTextAreaContent(firstname_text),//名前
					getTextAreaContent(lastname_text),//苗字
					departmentNumber,    //部署名      		
					department1.getValue());//所定労働日数
			System.out.println("----------------------------------------------");
			System.out.println(syaincode_ComboBox.getPromptText());
			System.out.println(date);
			System.out.println(firstname_text.getText());
			System.out.println( lastname_text.getText());
			System.out.println( firstname_hurigana_text.getText());
			System.out.println(lastname_hurigana_text.getText());
			System.out.println(year.getValue());
			System.out.println(month.getValue());
			System.out.println(day.getValue());
			System.out.println(department.getValue());
			System.out.println(departmentNumber);
			System.out.println(department1.getValue());
			System.out.println("----------------------------------------------");

			sd.setEmployeeInfo(searchResults);
			/*
			 * 現在表示されている画面を閉じる
			 */
			Scene s = ((Node)event.getSource()).getScene();
			Window window = s.getWindow();
			window.hide();
			Parent parent = fxmlLoader.load(getClass().getResource("/com/plma/view/hitKensakuView.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("メインメニュー");
			stage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
			if (e.getCause() instanceof InvocationTargetException) {
				Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
				targetException.printStackTrace();
			}
		}
		
	}
}
	
		
	









