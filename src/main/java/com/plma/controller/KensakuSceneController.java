package com.plma.controller;//nakasone
//import java.awt.TextArea;
//import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.model.entity.EmployeeInfo;
import com.plma.model.service.EmployeeInfoService;

//import ch.qos.logback.core.pattern.parser.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
	EmployeeInfoService service;
	//EmployeeInfoServiceImpl service;

	@FXML
	private Button menu_button;

    @FXML
    private Button kensaku_button;

    @FXML
    private ComboBox<Integer> day;

    @FXML
    private ComboBox<String> department;

    @FXML
    private ComboBox<String> department1;

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
    void kensaku_button_onClick(ActionEvent event) {

    	// Comboboxから入力された情報を取得
        String firstname =Optional.ofNullable(firstname_text.getText()).filter(s -> !s.isEmpty()).orElse(null);
        String lastname =  Optional.ofNullable(lastname_text.getText()).filter(s -> !s.isEmpty()).orElse(null);
        String firstnameHiragana =  Optional.ofNullable(firstname_hurigana_text.getText()).filter(s -> !s.isEmpty()).orElse(null);
        String lastnameHiragana = Optional.ofNullable(lastname_hurigana_text.getText()).filter(s -> !s.isEmpty()).orElse(null);
        Integer selectedYear = Optional.ofNullable(year.getPromptText()).filter(s -> !s.isEmpty()).map(Integer::parseInt).orElse(null);

        Integer selectedMonth = Optional.ofNullable(month.getPromptText()).filter(s -> !s.isEmpty()).map(Integer::parseInt).orElse(null);
        Integer selectedDay = Optional.ofNullable(day.getPromptText()).filter(s -> !s.isEmpty()).map(Integer::parseInt).orElse(null);
        String selectedDepartment = Optional.ofNullable(department.getPromptText()).filter(s -> !s.isEmpty()).orElse(null);
        String selectedDepartment1 = Optional.ofNullable(department1.getPromptText()).filter(s -> !s.isEmpty()).orElse(null);
        String selectedSyainCode = Optional.ofNullable(syaincode_ComboBox.getPromptText()).filter(s -> !s.isEmpty()).orElse(null);
     // データベースから検索

        try {

            Iterable<EmployeeInfo> searchResults = service.findByEightParams(
            		null,
            		Date.valueOf("2013-04-01"),
            		null,
            		null,
            		null,
                    null,
                    null,
                    null);


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