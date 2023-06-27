package com.plma.controller;//nakasone

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.model.entity.Department;
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
    private ComboBox<Integer> day;

    @FXML
    private ComboBox<String> department;

    @FXML
    private ComboBox<String> department1;

    @FXML
    private ComboBox<Integer> month;

    @FXML
    private ComboBox<String> syaincode_ComboBox;

    @FXML
    private ComboBox<Integer> year;

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

     /*修正後のコード
        Iterable<Department> department = new ArrayList<>();
     // リストに要素を追加する処理

        for (Department dep : department) {
            Iterable<Department> departmentName = Service.getDepartment();
            department1.getItems().add(departmentName);
        }*/
        
       
        Iterable<Department> departments = Service.getDepartment();

        for (Department dep : departments) {
            String departmentName = dep.getDepartment_name();
            department.getItems().add(departmentName);
        }
    		/*for(int dept = 101; dept < 107; dept++) {//DepartmentのDBから登録されているデータをもってくる処理に変更
    			
    			department.getItems().add(Integer.toString(dept));
    		}//仮入れ*/
    		
    		
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

    	EmployeeInfo empinfo2 = new EmployeeInfo(null
    			,null//社員コード別で登録
    			,null//入社日別で登録
    			,firstname_hurigana_text.getText()
    			,lastname_hurigana_text.getText()
    			,firstname_text.getText()
    			,lastname_text.getText()
    			,Integer.parseInt(department.getValue())//departmentテキストに変更
    			,Integer.parseInt(department1.getValue())
    			,null/* 有給休暇発生日（基準日） */
    			,null/* 年次有給休暇管理簿作成日 */
    	    	,null//有給日数別で登録
    			,null);//有給残日数別で登録

        Integer yearValue = year.getValue();
        Integer monthValue = month.getValue();
        Integer dayValue = day.getValue();
        if (yearValue == null || monthValue == null || dayValue == null) {
        	System.out.println("日付が選択されていません");
        	return; // もしくは適切な処理を行って終了させる
        } else {

        //コンボボックスからintger型で取得→int型へ変更
        int yearvalue =yearValue;
        int monthvalue = monthValue;
        int dayvalue = dayValue;


        LocalDate currentDate = LocalDate.of(yearvalue, monthvalue, dayvalue);
        Date joinDate = Date.valueOf(currentDate);

        empinfo2.setJoin_date(joinDate);//入社日


     // 半年後の日付を計算
        LocalDate currentDate2 = joinDate.toLocalDate(); // joinDate を LocalDate に変換
        LocalDate halfYearLater = currentDate2.plusMonths(6); // 半年後の日付を計算
        Date halfYearLaterDate = Date.valueOf(halfYearLater); // 半年後の日付を Date 型に変換
        empinfo2.setReference_date(halfYearLaterDate);




     // 最初の3月31日の日付を計算
        int currentYear = currentDate.getYear(); // 現在の年を取得
        LocalDate march31 = LocalDate.of(currentYear, Month.MARCH, 31); // 今年の3月31日の日付を計算
        if (currentDate.isAfter(march31)) { // もし現在の日付が3月31日より後なら、来年の3月31日の日付を計算
            march31 = march31.plusYears(1);
        }
        Date march31Date = Date.valueOf(march31); // 3月31日の日付を Date 型に変換
        empinfo2.setAnnual_paid_leave_report_date(march31Date);


        empinfo2.setGranted_paid_leave_days(0);//新規登録の時点では有給発生0日のため
        empinfo2.setRemaining_paid_leave_days(0);//新規登録の時点では有給残数0日のため

        }

     //java.util.Date date = new java.util.Date();
       // java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        //empinfo1.setJoin_date(sqlDate);

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


		try  {
        	Service.insertEmployeeInfo(empinfo2);
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getCause() instanceof InvocationTargetException) {
                Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
                targetException.printStackTrace();
            }
        }

        closeWindow(event);

    }
    /*@FXML
	void adddddOnClick(ActionEvent event) {





        EmployeeInfo empinfo1 = new EmployeeInfo(
        );

        //empinfo1.setId(null);// IDをnullで設定
        //empinfo1.setId(Integer.parseInt(null));


        empinfo1.setHurigana_lastname(lastname_hurigana_text.getText());
        empinfo1.setHurigana_firstname(firstname_hurigana_text.getText());
        empinfo1.setFirstname(firstname_text.getText());
        empinfo1.setLastname(lastname_text.getText());
        empinfo1.setWorking_days(Integer.parseInt(department1.getValue()));//所定労働日数
        empinfo1.setDepartment_number(Integer.parseInt(department.getValue()));//部署名
        empinfo1.setCode("");//社員コードstringに変更


        Integer yearValue = year.getValue();
        Integer monthValue = month.getValue();
        Integer dayValue = day.getValue();
        if (yearValue == null || monthValue == null || dayValue == null) {
        	System.out.println("日付が選択されていません");
        	return; // もしくは適切な処理を行って終了させる
        } else {

        //コンボボックスからintger型で取得→int型へ変更
        int yearvalue =yearValue;
        int monthvalue = monthValue;
        int dayvalue = dayValue;


        LocalDate currentDate = LocalDate.of(yearvalue, monthvalue, dayvalue);
        Date joinDate = Date.valueOf(currentDate);

        empinfo1.setJoin_date(joinDate);//入社日


     // 半年後の日付を計算
        LocalDate currentDate2 = joinDate.toLocalDate(); // joinDate を LocalDate に変換
        LocalDate halfYearLater = currentDate2.plusMonths(6); // 半年後の日付を計算
        Date halfYearLaterDate = Date.valueOf(halfYearLater); // 半年後の日付を Date 型に変換
        empinfo1.setReference_date(halfYearLaterDate);




     // 最初の3月31日の日付を計算
        int currentYear = currentDate.getYear(); // 現在の年を取得
        LocalDate march31 = LocalDate.of(currentYear, Month.MARCH, 31); // 今年の3月31日の日付を計算
        if (currentDate.isAfter(march31)) { // もし現在の日付が3月31日より後なら、来年の3月31日の日付を計算
            march31 = march31.plusYears(1);
        }
        Date march31Date = Date.valueOf(march31); // 3月31日の日付を Date 型に変換
        empinfo1.setAnnual_paid_leave_report_date(march31Date);


        empinfo1.setGranted_paid_leave_days(10);//仮入れ
        empinfo1.setRemaining_paid_leave_days(10);//仮入れ

        }

     //java.util.Date date = new java.util.Date();
       // java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        //empinfo1.setJoin_date(sqlDate);

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

        try {
        	Service.insertEmployeeInfo(empinfo1);
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getCause() instanceof InvocationTargetException) {
                Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
                targetException.printStackTrace();
            }
        }

        closeWindow(event);
    }*/

}
