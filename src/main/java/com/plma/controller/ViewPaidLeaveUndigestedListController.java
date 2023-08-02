/**
 * このクラスは有給休暇を何回取得しているか抽出するため未消化リストを表示する画面です。

 * 
 * 作成流れ
 * データベースからの情報の取得→PaidLeaveDB＆EnployeeInfoTable]からも取得する
 * テーブルへの表示
 * 表示の段階で有給休暇取得日数が何日間あるのか計算してからの表示
 * 
 * カラーセット
 */
package com.plma.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;
import com.plma.model.entity.EmployeeInfoDto;
import com.plma.model.entity.PaidLeave;
import com.plma.model.entity.PaidLeaveDto2;
import com.plma.model.service.EmployeeInfoService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

@Controller
public class ViewPaidLeaveUndigestedListController{


	@Autowired
	private SpringFXMLLoader fxmlLoader;

	@FXML
	private URL location;
	@FXML
	private ResourceBundle resources;


	@Autowired
	EmployeeInfoService service;


	@FXML
	private ComboBox<String> approach_Infomation_ComboBox;

	@FXML
	private TableView<PaidLeaveDto2> datatable;

	@FXML
	private TableColumn<PaidLeaveDto2, Integer> id_col;

	@FXML
	private TableColumn<PaidLeaveDto2, String> code_col;

	@FXML
	private TableColumn<PaidLeaveDto2, Date> joindate_col;


	@FXML
	private TableColumn<PaidLeaveDto2, String> hurigana_last_col;

	@FXML
	private TableColumn<PaidLeaveDto2, String> hurigana_first_col;


	@FXML
	private TableColumn<PaidLeaveDto2, String> lastname_col;


	@FXML
	private TableColumn<PaidLeaveDto2, String> firstname_col;


	@FXML
	private TableColumn<PaidLeaveDto2, String> department_col;


	@FXML
	private TableColumn<PaidLeaveDto2, Integer> working_days_col;

	@FXML
	private TableColumn<PaidLeaveDto2, Date> reference_date_col;


	@FXML
	private TableColumn<PaidLeaveDto2, Integer> granted_paid_leave_days_col;

	@FXML
	private TableColumn<PaidLeaveDto2, Integer> remaining_paid_leave_days_col;


	@FXML
	private TableColumn<PaidLeaveDto2, String> paid_leave_date_col;


	@FXML
	private Button menu_button;

	private String approach;//ViewApproachInfomationControllerから受け取った情報を入れる


	@FXML
	void initialize() {
		assert code_col != null : "fx:id=\"code_col\" was not injected: check your FXML file 'ViewPaidLeaveUndigestedListControllerScene.fxml'.";
		assert datatable != null : "fx:id=\"datatable\" was not injected: check your FXML file 'ViewPaidLeaveUndigestedListControllerScene.fxml'.";
		assert department_col != null : "fx:id=\"department_col\" was not injected: check your FXML file 'ViewPaidLeaveUndigestedListControllerScene.fxml'.";
		assert firstname_col != null : "fx:id=\"firstname_col\" was not injected: check your FXML file 'ViewPaidLeaveUndigestedListControllerScene.fxml'.";
		assert granted_paid_leave_days_col != null : "fx:id=\"granted_paid_leave_days_col\" was not injected: check your FXML file 'ViewPaidLeaveUndigestedListControllerScene.fxml'.";
		assert hurigana_first_col != null : "fx:id=\"hurigana_first_col\" was not injected: check your FXML file 'ViewPaidLeaveUndigestedListControllerScene.fxml'.";
		assert hurigana_last_col != null : "fx:id=\"hurigana_last_col\" was not injected: check your FXML file 'ViewPaidLeaveUndigestedListControllerScene.fxml'.";
		assert id_col != null : "fx:id=\"id_col\" was not injected: check your FXML file 'ViewPaidLeaveUndigestedListControllerScene.fxml'.";
		assert joindate_col != null : "fx:id=\"joindate_col\" was not injected: check your FXML file 'ViewPaidLeaveUndigestedListControllerScene.fxml'.";
		assert lastname_col != null : "fx:id=\"lastname_col\" was not injected: check your FXML file 'ViewPaidLeaveUndigestedListControllerScene.fxml'.";
		assert paid_leave_date_col != null : "fx:id=\"paid_leave_date_col\" was not injected: check your FXML file 'ViewPaidLeaveUndigestedListControllerScene.fxml'.";
		assert reference_date_col != null : "fx:id=\"reference_date_col\" was not injected: check your FXML file 'ViewPaidLeaveUndigestedListControllerScene.fxml'.";
		assert remaining_paid_leave_days_col != null : "fx:id=\"remaining_paid_leave_days_col\" was not injected: check your FXML file 'ViewPaidLeaveUndigestedListControllerScene.fxml'.";
		assert working_days_col != null : "fx:id=\"working_days_col\" was not injected: check your FXML file 'ViewPaidLeaveUndigestedListControllerScene.fxml'.";

		//ComboBoxへ値を登録
		approach_Infomation_ComboBox.getItems().addAll("１日間", "２日間", "３日間","４日間","５日間", "全件取得");

		//テーブルへの表示
		id_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto2, Integer>("id"));
		code_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto2, String>("code"));
		joindate_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto2, Date>("join_date"));
		hurigana_last_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto2, String>("hurigana_lastname"));
		hurigana_first_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto2, String>("hurigana_firstname"));
		lastname_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto2, String>("lastname"));
		firstname_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto2, String>("firstname"));
		department_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto2, String>("department_name"));
		working_days_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto2, Integer>("working_days"));
		reference_date_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto2, Date>("reference_date"));
		granted_paid_leave_days_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto2, Integer>("granted_paid_leave_days"));
		remaining_paid_leave_days_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto2, Integer>("remaining_paid_leave_days"));
		paid_leave_date_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto2, String>("PaidLeave_date"));
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


	
	private int calculateRequiredRows(String approach) {
		int requiredRows = 0;

		switch (approach) {
		case "１日間":
			requiredRows = 1;
			break;
		case "２日間":
			requiredRows = 2;
			break;
		case "３日間":
			requiredRows = 3;
			break;
		case "４日間":
			requiredRows = 4;
			break;
		case "５日間":
			requiredRows = 5;
			break;
		case "全件取得":
			requiredRows = -1; // 全件取得の場合は-1を指定
			break;
		default:
			break;
		}

		return requiredRows;
	}


	//取得したデータをテーブルに表示するメソッド
	void setTableViewPaidLeaveDto2(PaidLeaveDto2 emp) {

		datatable.getItems().add(emp);
		System.out.println("emp.getPaidLeave_date()"+emp.getPaidLeave_date());

	}


	@FXML
	void kensaku_button_onClick(ActionEvent event) {
		approach = approach_Infomation_ComboBox.getSelectionModel().getSelectedItem();
		System.out.println("approach" + approach);
		// 表をクリア
		datatable.getItems().clear();

		Iterable<EmployeeInfoDto> employeeInfoDtoList = service.getAllEmployeeInfoDto();
		Iterable<PaidLeave> paidLeaveList = service.getPaidLeave();

		int requiredRows = calculateRequiredRows(approach);


		for (EmployeeInfoDto emp : employeeInfoDtoList) {//一人ひとりのデータを取り出し
			String code = emp.getCode();
			int count = 0; // countを初期化

			for (PaidLeave paidLeave : paidLeaveList) {
				if (code.equals(paidLeave.getCode())) {
					count++;
				}
			}
			//日数に応じて表示
			if (requiredRows >=1 && count == requiredRows) {
				// カウントに応じて日数を設定
				String daysText = count + "日間";
				System.out.println("daysText" + daysText);

				PaidLeaveDto2 paidLeaveDto = new PaidLeaveDto2(
						emp.getId(),
						emp.getCode(),
						emp.getJoin_date(),
						emp.getHurigana_lastname(),
						emp.getHurigana_firstname(),
						emp.getLastname(),
						emp.getFirstname(),
						emp.getDepartment_name(),
						emp.getWorking_days(),
						emp.getReference_date(),
						emp.getGranted_paid_leave_days(),
						emp.getRemaining_paid_leave_days(),
						daysText
						);

				setTableViewPaidLeaveDto2(paidLeaveDto);
			}//全件取得
			else if(requiredRows==-1){
				// カウントに応じて日数を設定
				String daysText = count + "日間";
				System.out.println("daysText" + daysText);

				PaidLeaveDto2 paidLeaveDto = new PaidLeaveDto2(
						emp.getId(),
						emp.getCode(),
						emp.getJoin_date(),
						emp.getHurigana_lastname(),
						emp.getHurigana_firstname(),
						emp.getLastname(),
						emp.getFirstname(),
						emp.getDepartment_name(),
						emp.getWorking_days(),
						emp.getReference_date(),
						emp.getGranted_paid_leave_days(),
						emp.getRemaining_paid_leave_days(),
						daysText
						);

				setTableViewPaidLeaveDto2(paidLeaveDto);
				//5日以上の人表示
			}else if(requiredRows==5&&count>=5) {
				String daysText = count + "日間";
				System.out.println("daysText" + daysText);

				PaidLeaveDto2 paidLeaveDto = new PaidLeaveDto2(
						emp.getId(),
						emp.getCode(),
						emp.getJoin_date(),
						emp.getHurigana_lastname(),
						emp.getHurigana_firstname(),
						emp.getLastname(),
						emp.getFirstname(),
						emp.getDepartment_name(),
						emp.getWorking_days(),
						emp.getReference_date(),
						emp.getGranted_paid_leave_days(),
						emp.getRemaining_paid_leave_days(),
						daysText
						);

				setTableViewPaidLeaveDto2(paidLeaveDto);
			}

		}datatable.setRowFactory(tv -> {
			
			 System.out.println("alertMessage!!!!!!!!!!!!!!!!!");
		    TableRow<PaidLeaveDto2> row = new TableRow<>();
		    row.itemProperty().addListener((obs, prevItem, currItem) -> {
		        //現在のアイテムがnullでない場合に処理を実行
		        if (currItem != null) {
		            String alertText = currItem.getPaidLeave_date();
		            System.out.println("alertText!!"+alertText);
		            if ("1日間".equals(alertText)) {
		                System.out.println("alert1日間"+alertText);
		                row.setStyle("-fx-background-color: red;");
		            } else if ("2日間".equals(alertText)) {
		                System.out.println("alert2日間"+alertText);
		                row.setStyle("-fx-background-color: orange;");
		            } else if ("3日間".equals(alertText)) {
		                System.out.println("alert３日間"+alertText);
		                row.setStyle("-fx-background-color: yellow;");
		            } else if ("4日間".equals(alertText)) {
		                System.out.println("alert4日間"+alertText);
		                row.setStyle("-fx-background-color: green;");
		            } else{
		                System.out.println("alertM５日間"+alertText);
		                row.setStyle("-fx-background-color: blue;");
		            }
		        } else {
		            row.setStyle(""); // スタイルをリセットする場合
		        }
		    });
		    return row;
		});
		
		
		
		        
		 
	}



}







