/**このクラスは有給休暇管理簿を作成するためのクラスです
 * PaidLeaveDto3というクラスを表示用に作成しました。
 * 流れ（全てのDBからデータを取得する）
 * EnployeeInfoTable]から情報を出データを取得する
 * 部署名テーブルを取得して名前を取得する
 * PaidLeaveテーブルを取得して有給休暇取得日を取得する
 * 
 * 個人単位での作成なので、プルダウンは個人名での検索作成
 * 
 * 
 * 
 */
package com.plma.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;
import com.plma.model.entity.EmployeeInfo;
import com.plma.model.entity.EmployeeInfoDto;
import com.plma.model.entity.PaidLeave;
import com.plma.model.entity.PaidLeaveDto3;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

@Controller
public class ManagementBookCreationController {

	@Autowired
	private SpringFXMLLoader fxmlLoader;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	

	@Autowired
	EmployeeInfoService service;


	PaidLeaveDto3 paidLeaveDto3;

	@FXML
	private TableColumn<PaidLeaveDto3, String> fiscal_year_col;


	@FXML
	private TableColumn<PaidLeaveDto3, Integer> id_col;


	@FXML
	private TableColumn<PaidLeaveDto3, String> code_col;

	@FXML
	private TableColumn<PaidLeaveDto3, Date> joindate_col;


	@FXML
	private TableColumn<PaidLeaveDto3, String> lastname_col;


	@FXML
	private TableColumn<PaidLeaveDto3, String> firstname_col;


	@FXML
	private TableColumn<PaidLeaveDto3, String> hurigana_first_col;

	@FXML
	private TableColumn<PaidLeaveDto3, String> hurigana_last_col;


	@FXML
	private TableColumn<PaidLeaveDto3, String> department_name_col;

	@FXML
	private TableColumn<PaidLeaveDto3, Integer> working_days_col;


	@FXML
	private TableColumn<PaidLeaveDto3, Date> reference_date_col;


	@FXML
	private TableColumn<PaidLeaveDto3, Date> annual_paid_leave_report_date_col;


	@FXML
	private TableColumn<PaidLeaveDto3, Integer> fiscal_year_carried_over_day_col;

	@FXML
	private TableColumn<PaidLeaveDto3, Integer> granted_paid_leave_days_col;
	@FXML
	private TableColumn<PaidLeaveDto3, Integer> Number_of_days_used_col;

	@FXML
	private TableColumn<PaidLeaveDto3, Integer> remaining_paid_leave_days_col;
	@FXML
	private TableColumn<PaidLeaveDto3, String> PaidLeave_date_col;

	@FXML
	private TableView<PaidLeaveDto3> datatable;



	@FXML
	private ComboBox<String> name_ComboBox;


	@FXML
	private Button menu_button;
	@FXML
	private Button kensaku_button;

	private String approach;//ViewApproachInfomationControllerから受け取った情報を入れる


	@FXML
	void initialize() {
		assert Number_of_days_used_col != null : "fx:id=\"Number_of_days_used_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert PaidLeave_date_col != null : "fx:id=\"PaidLeave_date_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert annual_paid_leave_report_date_col != null : "fx:id=\"annual_paid_leave_report_date_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert code_col != null : "fx:id=\"code_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert datatable != null : "fx:id=\"datatable\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert department_name_col != null : "fx:id=\"department_name_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert firstname_col != null : "fx:id=\"firstname_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert fiscal_year_carried_over_day_col != null : "fx:id=\"fiscal_year_carried_over_day_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert fiscal_year_col != null : "fx:id=\"fiscal_year_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert granted_paid_leave_days_col != null : "fx:id=\"granted_paid_leave_days_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert hurigana_first_col != null : "fx:id=\"hurigana_first_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert hurigana_last_col != null : "fx:id=\"hurigana_last_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert id_col != null : "fx:id=\"id_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert joindate_col != null : "fx:id=\"joindate_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert lastname_col != null : "fx:id=\"lastname_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";

		assert reference_date_col != null : "fx:id=\"reference_date_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert remaining_paid_leave_days_col != null : "fx:id=\"remaining_paid_leave_days_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert working_days_col != null : "fx:id=\"working_days_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";

		assert menu_button != null : "fx:id=\"menu_button\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
		assert name_ComboBox != null : "fx:id=\"name_ComboBox\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";



		fiscal_year_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, String>("fiscal_year"));
		id_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, Integer>("id"));
		code_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, String>("code"));

		joindate_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, Date>("join_date"));

		hurigana_last_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, String>("hurigana_lastname"));
		hurigana_first_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, String>("hurigana_firstname"));
		lastname_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, String>("lastname"));
		firstname_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, String>("firstname"));


		department_name_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, String>("department_name"));
		working_days_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, Integer>("working_days"));

		reference_date_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, Date>("reference_date"));
		annual_paid_leave_report_date_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, Date>("annual_paid_leave_report_date"));

		fiscal_year_carried_over_day_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, Integer>("fiscal_year_carried_over_day"));
		granted_paid_leave_days_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, Integer>("granted_paid_leave_days"));
		remaining_paid_leave_days_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, Integer>("remaining_paid_leave_days"));
		Number_of_days_used_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, Integer>("Number_of_days_used"));
		remaining_paid_leave_days_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, Integer>("remaining_paid_leave_days"));
		PaidLeave_date_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, String>("PaidLeave_date"));

		//ComboBoxの初期化処理

		//DBから
		Iterable<EmployeeInfo> result = service.selectAll();;//全データ抽出各columnに入れていく
		System.out.println("result"+result);
		// ComboBoxに値を追加
		for (EmployeeInfo employeeInfo : result) {
			String code=employeeInfo.getCode();

			String fullName = employeeInfo.getFirstname()  + employeeInfo.getLastname();
			name_ComboBox.getItems().add(code+":"+fullName);
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



	//取得したデータをテーブルに表示するメソッド
	void setTableViewPaidLeaveDto3(PaidLeaveDto3 emp) {

		datatable.getItems().add(emp);
	}




	@FXML
	void Kensaku_button_onClick(ActionEvent event) {
		datatable.getItems().clear();

		// ComboBoxからデータを取得
		approach = name_ComboBox.getSelectionModel().getSelectedItem();
		System.out.println("approach" + approach);
		// ComboBoxから取得したデータの頭３文字を取得して社員コードをString型として保持
		String firstThreeDigits = approach.substring(0, 3);
		System.out.println("firstThreeDigits" + firstThreeDigits);





		List<PaidLeaveDto3> paidLeaveDto3List = new ArrayList<>();

		Iterable<EmployeeInfo> result = service.selectAll();


		// 社員コードに対応する有給休暇情報を取得
		Iterable<PaidLeave> PaidLeaveList = service.getPaidLeave();

		for (EmployeeInfo emp : result) {
			EmployeeInfoDto empDto = service.convertToDto(emp);
			int count = 0; // 回数をカウントして使用回数へ代入するための変数


			System.out.println("emp" + emp);
			for (PaidLeave pltmp : PaidLeaveList) {


				// 新しいPaidLeaveDto3インスタンスをループ内で作成
				PaidLeaveDto3 paDto3 = new PaidLeaveDto3(
						null, // 年度fiscal_year
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
						null, // 前年度繰越日数
						empDto.getGranted_paid_leave_days(), // 有給休暇付与日数
						null, // 使用日数Number_of_days_used
						empDto.getRemaining_paid_leave_days(), // 残数remaining_paid_leave_days
						null); // 取得日 PaidLeave_date

				// 現在の年を取得
				int currentYear = LocalDate.now().getYear();
				// 現在の月を取得
				int currentMonth = LocalDate.now().getMonthValue();
				// 年度をテキストとしてフォーマット（例: "2023"）
				String fiscalYearText;
				if (currentMonth >= 4 && currentMonth <= 12) {
					// 4月から12月の場合はそのままの年を使用
					fiscalYearText = currentYear + "";
				} else {
					// 1月から3月の場合は前の年を使用
					fiscalYearText = (currentYear - 1) + "";
				}
				
				paDto3.setFiscal_year(fiscalYearText);

				paDto3.setFiscal_year_carried_over_day(8); 




				

				if (firstThreeDigits.equals(emp.getCode())&&emp.getCode().equals(pltmp.getCode())) {
					count++;
					
					
					paDto3.setPaidLeave_date(pltmp.getPaid_leave_date());
					paDto3.setNumber_of_days_used(count); 
					System.out.println("+pltmp.getPaid_leave_date()" + pltmp.getPaid_leave_date());
					System.out.println("count" + count);
					System.out.println("pltmp.getCode()" + pltmp.getCode());

					// ここで新しいインスタンスを追加する
					paidLeaveDto3List.add(paDto3);
				}
			}

			
		}

		// DataTableにリストの各要素を追加する
		for (PaidLeaveDto3 paDto3 : paidLeaveDto3List) {
			setTableViewPaidLeaveDto3(paDto3);
		}
	}
}
