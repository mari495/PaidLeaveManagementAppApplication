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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;
import com.plma.model.entity.EmployeeInfoDto;
import com.plma.model.entity.PaidLeave;
import com.plma.model.entity.PaidLeaveDto2;
import com.plma.model.repository.DepartmentRepository;
import com.plma.model.repository.PaidLeaveRepository;
import com.plma.model.service.EmployeeInfoService;
import com.plma.model.service.EmployeeInfoServiceImpl;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
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
	EmployeeInfoServiceImpl employeeInfoServiceImpl;
	@Autowired
	DepartmentRepository dep_repository;
	@Autowired
	PaidLeaveRepository pl_repository;

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

	/*
	private boolean isDuplicateNameRow(PaidLeaveDto paidLeaveDto) {
		String lastname = paidLeaveDto.getLastname();
		String firstname = paidLeaveDto.getFirstname();

		for (PaidLeaveDto2 row : datatable.getItems()) {
			if (row.getLastname().equals(lastname) && row.getFirstname().equals(firstname)) {
				return true;
			}
		}

		return false;
	}*/

	private int calculateRequiredRows(String approach) {
		int requiredRows = 0;

		switch (approach) {
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

		datatable.getItems().add(new PaidLeaveDto2(

				emp.getId(),
				emp.getCode(),
				emp.getJoin_date(),
				emp.getHurigana_lastname(),
				emp.getHurigana_firstname(),
				emp.getLastname(),
				emp.getFirstname(),
				emp.getDepartment_name(),//
				emp.getWorking_days(),
				emp.getReference_date(),
				emp.getGranted_paid_leave_days(),
				emp.getRemaining_paid_leave_days(),
				emp.getPaidLeave_date()


				));
		System.out.println("emp.getPaidLeave_date()"+emp.getPaidLeave_date());

	}
	//countした回数をString型として保持するための変数
	String daysText ="";

	@FXML
	void kensaku_button_onClick(ActionEvent event) {
		approach = approach_Infomation_ComboBox.getSelectionModel().getSelectedItem();

		// 表をクリア
		datatable.getItems().clear();



		Iterable<EmployeeInfoDto> employeeInfoDtoList = service.getAllEmployeeInfoDto();
		Iterable<PaidLeave> paidLeaveList = pl_repository.findAll();

		List<PaidLeaveDto2> paidLeaveDtoList = new ArrayList<>();

		int requiredRows = calculateRequiredRows(approach);




		if (requiredRows >= 0) {
			for (EmployeeInfoDto emp : employeeInfoDtoList) {
				String code = emp.getCode();
				int count = 0;

				for (PaidLeave pltmp : paidLeaveList) {
					if (pltmp.getCode().equals(code)) {
						count++;
						System.out.println("count!!!!!!!!!"+count);
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
								emp.getRemaining_paid_leave_days(),
								emp.getGranted_paid_leave_days(),
								null);//型が違うのであとから追加する
						paidLeaveDto.setPaidLeave_date(String.valueOf(count));
						System.out.println("(String.valueOf(count)"+String.valueOf(count));


						// カウントに応じて日数を設定




						if (count == 1) {
							// １行の場合はpaidLeaveDtoListに追加
							paidLeaveDtoList.add(paidLeaveDto);

							// カウントに応じて日数を設定
							daysText = count + "日間";
							System.out.println("daysText"+daysText);
							paid_leave_date_col.setCellValueFactory(cellData -> new SimpleStringProperty(daysText));

						}else if (count >= 2) {
							// ２行目の場合はcountした文を日数として表示するだけ
							daysText = count + "日間";
							System.out.println("daysText"+daysText);
							paid_leave_date_col.setCellValueFactory(cellData -> new SimpleStringProperty(daysText));
						}
					}
				}
			}



			// テーブルビューにデータを設定
			datatable.getItems().addAll(paidLeaveDtoList);
		}
	}
}
