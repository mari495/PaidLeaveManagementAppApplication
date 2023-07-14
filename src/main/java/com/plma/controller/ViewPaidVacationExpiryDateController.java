/**このクラスはViewApproachInfomationControllerへ
 *
 * 
 * ”１か月切っています”
 * ”３か月切っています”
 * ”６か月切っています”という文字を
 * プルダウンより選択して、渡す画面です。
 * 結果はViewApproachInfomationControllerに表示する予定です
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
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;
import com.plma.model.entity.EmployeeInfo;
import com.plma.model.entity.EmployeeInfoDto;
import com.plma.model.entity.EmployeeInfoDto2;
import com.plma.model.service.EmployeeInfoService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.Window;
@Controller
public class ViewPaidVacationExpiryDateController {
	
	
	
	@Autowired
	private SpringFXMLLoader fxmlLoader;

	@Autowired
	EmployeeInfoService service;
	//EmployeeInfoServiceImpl service;

	
	EmployeeInfoDto employeeInfoDto;

	@FXML
	private TableColumn<EmployeeInfoDto2, String> firstNameColumn;

	@FXML
	private TableColumn<EmployeeInfoDto2, String> lastNameColumn;
	@FXML
	private TableColumn<EmployeeInfoDto2, Date> annual_paid_leave_report_date_col;

	@FXML
	private TableColumn <EmployeeInfoDto2, Integer>code_col;

	@FXML
	private TableColumn <EmployeeInfoDto2, String>department_col;

	@FXML
	private TableColumn<EmployeeInfoDto2, String> firstname_col;

	@FXML
	private TableColumn<EmployeeInfoDto2, Integer> granted_paid_leave_days_col;

	@FXML
	private TableColumn<EmployeeInfoDto2, String> hurigana_first_col;

	@FXML
	private TableColumn<EmployeeInfoDto2, String> hurigana_last_col;

	@FXML
	private TableColumn<EmployeeInfoDto2, String> name_col;

	@FXML
	private TableColumn <EmployeeInfoDto2, Integer>id_col;

	@FXML
	private TableColumn <EmployeeInfoDto2, Date>joindate_col;

	@FXML
	private TableColumn <EmployeeInfoDto2, String>lastname_col;

	@FXML
	private TableColumn<EmployeeInfoDto2, Date> reference_date_col;

	@FXML
	private TableColumn<EmployeeInfoDto2, Integer> remaining_paid_leave_days_col;


	@FXML
	private TableColumn<EmployeeInfoDto2, Integer> working_days_col;

    @FXML
    private TableView<EmployeeInfoDto2> datatable;
    
    @FXML
	private TableColumn <EmployeeInfoDto2, Integer>Number_of_days_used;//有給休暇使用日数（PaidLeaveDBから回数を取得）

	@FXML
	private TableColumn <EmployeeInfoDto2, Date>Expiry_date;

	@FXML
	private TableColumn <EmployeeInfoDto2, String>Alert;

	@FXML
    private ComboBox<String> approach_Infomation_ComboBox;

   
  @FXML
  	private Button menu_button;
  @FXML
  	private Button kensaku_button;

	private String approach;//ViewApproachInfomationControllerから受け取った情報を入れる

    @FXML
    void initialize() {
    	 assert Alert != null : "fx:id=\"Alert\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert Expiry_date != null : "fx:id=\"Expiry_date\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert Number_of_days_used != null : "fx:id=\"Number_of_days_used\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert annual_paid_leave_report_date_col != null : "fx:id=\"annual_paid_leave_report_date_col\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert approach_Infomation_ComboBox != null : "fx:id=\"approach_Infomation_ComboBox\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert code_col != null : "fx:id=\"code_col\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert datatable != null : "fx:id=\"datatable\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert department_col != null : "fx:id=\"department_col\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert firstname_col != null : "fx:id=\"firstname_col\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert granted_paid_leave_days_col != null : "fx:id=\"granted_paid_leave_days_col\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert hurigana_first_col != null : "fx:id=\"hurigana_first_col\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert hurigana_last_col != null : "fx:id=\"hurigana_last_col\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert id_col != null : "fx:id=\"id_col\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert joindate_col != null : "fx:id=\"joindate_col\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert kensaku_button != null : "fx:id=\"kensaku_button\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert lastname_col != null : "fx:id=\"lastname_col\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert menu_button != null : "fx:id=\"menu_button\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert reference_date_col != null : "fx:id=\"reference_date_col\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert remaining_paid_leave_days_col != null : "fx:id=\"remaining_paid_leave_days_col\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         assert working_days_col != null : "fx:id=\"working_days_col\" was not injected: check your FXML file 'ViewPaidVacationExpiryDate.fxml'.";
         
         
    	//ComboBoxへ値を登録
    	approach_Infomation_ComboBox.getItems().addAll("１か月切っています", "３か月切っています", "６か月切っています");
	
    	
    }
    
    
  //選択された文字情報を受け取るためのメソッド
  		public void setApproach(String approach) {
  	        this.approach = approach;
  	        System.out.println("approach"+this.approach);
  	    }
  		
  		
	void setTableViewEmployeeInfoDto(EmployeeInfoDto2 emp) {
		  approach=approach_Infomation_ComboBox.getSelectionModel().getSelectedItem();
		System.out.println("approach!!!!!!!!!!!!!!!!!"+approach);
		if (this.approach != null) {
		//////////////////////////////////////////////////////////////////
		LocalDate referenceDate = emp.getReference_date().toLocalDate(); // 基準日の取得
		LocalDate expiryDate = referenceDate.plusYears(2);// 消滅日の計算
		// LocalDateをString型にキャスト
		String expiryDateString = expiryDate.toString();


		/////////////////////////////////////////////////////////////

		Integer Number_of_days_used=1; // 有給休暇使用日数（PaidLeaveDBから回数を取得）
		/////////////////////////////////////////////////////////////////      
		LocalDate currentDate = LocalDate.now(); // 現在の日付
		long monthsUntilExpiry = ChronoUnit.MONTHS.between(currentDate, expiryDate); // 当日と消滅日の月数の差
		String alertMessage;
		if (monthsUntilExpiry < 1) {
			alertMessage = "１か月切っています";
		} else if (monthsUntilExpiry < 3) {
			alertMessage = "３か月切っています";
		} else if (monthsUntilExpiry < 6) {
			alertMessage = "６か月切っています";
		} else {
			alertMessage = ""; // 条件に合致しない場合は空文字を設定するなど適宜処理を追加してください
		}
////////////////////////////////////////////////////////////////ビューしたあとに、絞る処理を入れるできなければビューする前に入れる
//選択された文字情報の利用
if (approach.equals("１か月切っています")) {
	System.out.println("テスト"+approach);
//１か月切っている場合の処理
//例: alertMessage = "１か月切っています";
} else if (approach.equals("３か月切っています")) {
	System.out.println("テスト"+approach);
//３か月切っている場合の処理
//例: alertMessage = "３か月切っています";
} else if (approach.equals("６か月切っています")) {
	System.out.println("テスト"+approach);
//６か月切っている場合の処理
//例: alertMessage = "６か月切っています";
}////////////////////////////////////////////////////////////////
		datatable.getItems().add(new EmployeeInfoDto2(
				emp.getId(),
				emp.getCode(),
				emp.getJoin_date(),
				emp.getHurigana_lastname(),
				emp.getHurigana_firstname(),
				emp.getLastname(),
				emp.getFirstname(),
				emp.getDepartment_name(),
				emp.getWorking_days(),//所定労働日数
				emp.getReference_date(),//基準日（有給発生日入社から１年６か月後）
				emp.getAnnual_paid_leave_report_date(),//年休簿作成日
				emp.getGranted_paid_leave_days(),//有給休暇付与日数
				emp.getRemaining_paid_leave_days(),//有給休暇残数
				Number_of_days_used, // 仮登録有給休暇使用日数（PaidLeaveDBから回数を取得）
				Date.valueOf(expiryDateString),//消滅日（基準日からに二年後）
				alertMessage// 有給接近情報アラート
				));
		
		}
	}

    
    @FXML
   	void Kensaku_button_onClick(ActionEvent event) {
    	//ComboBoxから値を取り出して変数へ保存
    	//DBから
    	Iterable<EmployeeInfo> result = service.selectAll();;//全データ抽出各columnに入れていく
		System.out.println("result"+result);
		List<EmployeeInfoDto2> resultDtoList = new ArrayList<>();
		for (EmployeeInfo emp : result) {
			EmployeeInfoDto empDto = service.convertToDto(emp);
			EmployeeInfoDto2 empDto2 = new EmployeeInfoDto2(
					empDto.getId(),
					empDto.getCode(),
					empDto.getJoin_date(),
					empDto.getHurigana_lastname(),
					empDto.getHurigana_firstname(),
					empDto.getLastname(),
					empDto.getFirstname(),
					empDto.getDepartment_name(),
					empDto.getWorking_days(),
					empDto.getReference_date(),
					empDto.getAnnual_paid_leave_report_date(),
					empDto.getGranted_paid_leave_days(),
					empDto.getRemaining_paid_leave_days(),
					null,
					null,//消滅日（基準日からに二年後）仮でNULL
					null);//アラートメッセージ仮でNULL


			resultDtoList.add(empDto2);
			System.out.println("empDto2"+empDto2);
		}

		for (EmployeeInfoDto2 empDto2 : resultDtoList) {

			setTableViewEmployeeInfoDto(empDto2);
		}
		
	}
	  
    	
    
    
    
    
    
    
 






    @FXML
	void Menu_button_onClick(ActionEvent event) {
		
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
