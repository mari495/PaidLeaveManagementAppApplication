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
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;
import com.plma.model.entity.Department;
import com.plma.model.entity.EmployeeInfo;
import com.plma.model.entity.PaidLeave;
import com.plma.model.entity.PaidLeaveDto3;
import com.plma.model.repository.DepartmentRepository;
import com.plma.model.repository.PaidLeaveRepository;
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
	DepartmentRepository dep_repository;
	@Autowired
	PaidLeaveRepository pl_repository;

	@Autowired
	EmployeeInfoService service;


	PaidLeaveDto3 paidLeaveDto3;

    @FXML
    private TableColumn<PaidLeaveDto3, Date> fiscal_year_col;
    

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
    private TableColumn<PaidLeaveDto3, Integer> fiscal_year_Carried_Over_day_col;

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



    @FXML
    void initialize() {
        assert Number_of_days_used_col != null : "fx:id=\"Number_of_days_used_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
        assert PaidLeave_date_col != null : "fx:id=\"PaidLeave_date_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
        assert annual_paid_leave_report_date_col != null : "fx:id=\"annual_paid_leave_report_date_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
        assert code_col != null : "fx:id=\"code_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
        assert datatable != null : "fx:id=\"datatable\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
        assert department_name_col != null : "fx:id=\"department_name_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
        assert firstname_col != null : "fx:id=\"firstname_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
        assert fiscal_year_Carried_Over_day_col != null : "fx:id=\"fiscal_year_Carried_Over_day_col\" was not injected: check your FXML file 'ManagementBookCreation.fxml'.";
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
        
        fiscal_year_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, Date>("fiscal_year"));
        
        fiscal_year_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto3, Date>("fiscal_year"));
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
	        String fullName = employeeInfo.getFirstname()  + employeeInfo.getLastname();
	        name_ComboBox.getItems().add(fullName);
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
	
	//PaidLeaveDBよりDepartment_nameとequalsDepartment_numberを取得メソッド
		private Date getPaidLeaveDays(String Code) {
			//Iterable<Department> departments = service.getDepartment();
			Iterable<PaidLeave> paidLeaves = pl_repository.findAll();
			for (PaidLeave paidLeave : paidLeaves) {
				if (paidLeave.getCode().equals(Code)) {
					return paidLeave.getPaid_leave_date();
				}
			}

			return null; // 該当する部署が見つからなかった場合は null を返す（適宜エラーハンドリングを行ってください）
		}
	
	
    @FXML
	void Kensaku_button_onClick(ActionEvent event) {
    	System.out.println("検索ボタンが押された");
    	

		datatable.getItems().clear();
    }
}
