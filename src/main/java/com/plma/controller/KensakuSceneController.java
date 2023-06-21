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
import com.plma.model.entity.EmployeeInfo;
import com.plma.model.service.EmployeeInfoService;
import com.plma.model.shareddata.SharedData;

//import ch.qos.logback.core.pattern.parser.Node;
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
	//EmployeeInfoServiceImpl service;

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
    private ComboBox<Integer> department;

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

        for (int dept = 101; dept < 107; dept++) {
            department.getItems().add(dept);
        }
        for (int dept1 = 1; dept1 < 6; dept1++) {
            department1.getItems().add(dept1);
        }
    		//仮入れ
    		for(int syaincode = 1; syaincode < 100; syaincode++) {
    			syaincode_ComboBox.getItems().add(Integer.toString(syaincode));
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

    @FXML//全取得
    void allBtn_OnClick(ActionEvent event) {

    	Iterable<com.plma.model.entity.EmployeeInfoDto> employeeInfoDtoList = service.getAllEmployeeInfoDto();

        for (com.plma.model.entity.EmployeeInfoDto model : employeeInfoDtoList) {
            System.out.println(model.getCode());
        }

        try {
        	for(com.plma.model.entity.EmployeeInfoDto emp : employeeInfoDtoList) {
        		System.out.println(emp);

        		
        	}
		}catch(Exception e) {
			e.printStackTrace();
			if (e.getCause() instanceof InvocationTargetException) {
				Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
				targetException.printStackTrace();
			}
		}
    }
    
    @FXML//&&条件による検索
    void kensaku_button_onClick(ActionEvent event) {


     // コンボボックスの値から日付を作成
     LocalDate selectedDate = LocalDate.of(year.getValue(), month.getValue(), day.getValue());
     // java.sql.Dateに変換
     Date date = Date.valueOf(selectedDate);
     
  
        try {

            Iterable<EmployeeInfo> searchResults = service.findByEightParams(
            		syaincode_ComboBox.getPromptText(),//社員コード
            		date,//入社日
            		 firstname_hurigana_text.getText(),//名前ふりがな
            		lastname_hurigana_text.getText(),//苗字ふりがな
            		firstname_text.getText(),//名前
            		 lastname_text.getText(),//苗字
            		 department.getValue(),    //部署名      		
            		 department1.getValue());//所定労働日数
            System.out.println(syaincode_ComboBox.getValue());
            System.out.println(firstname_hurigana_text.getText());
            System.out.println( lastname_text.getText());
            System.out.println( firstname_hurigana_text.getText());
            System.out.println(lastname_hurigana_text.getText());
            System.out.println(year.getValue());
            System.out.println(month.getValue());
            System.out.println(day.getValue());
            System.out.println(department.getPromptText());
            System.out.println(department1.getValue());
            
            sd.setEmployeeInfo(searchResults);
           
            // 検索結果の表示
            for (EmployeeInfo emp : searchResults) {
                System.out.println(emp);
                // サンプルデータを1行追加
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}