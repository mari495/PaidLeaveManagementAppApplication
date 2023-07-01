package com.plma.controller;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;
import com.plma.model.entity.EmployeeInfo;
import com.plma.model.entity.EmployeeInfoDto;
import com.plma.model.service.EmployeeInfoService;
import com.plma.model.shareddata.SharedData;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

@Controller
public class HItKensakuViewController {

	@Autowired
	private SpringFXMLLoader fxmlLoader;

	@Autowired
	EmployeeInfoService service;
	//EmployeeInfoServiceImpl service;

	@Autowired
	SharedData sd;
	
	/*@Autowired
	EmployeeInfoDto employeeInfoDto;*/
	
	

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	

	@FXML
	private Label resultDelete;

	@FXML
	private Label resultUpdate;

	@FXML
	private TextField updateBox;

	@FXML
	private Button updateBtn;

	@FXML
	private TextField deleteBox;

	@FXML
	private Button deleteBtn;
	

	@FXML
	private TableColumn<EmployeeInfoDto, String> firstNameColumn;

	@FXML
	private TableColumn<EmployeeInfoDto, String> lastNameColumn;
	@FXML
	private TableColumn<EmployeeInfoDto, Date> annual_paid_leave_report_date_col;

	@FXML
	private TableColumn <EmployeeInfoDto, Integer>code_col;
	
	@FXML
	private TableColumn <EmployeeInfoDto, String>department_col;

	@FXML
	private TableColumn<EmployeeInfoDto, String> firstname_col;

	@FXML
	private TableColumn<EmployeeInfoDto, Integer> granted_paid_leave_days_col;

	@FXML
	private TableColumn<EmployeeInfoDto, String> hurigana_first_col;

	@FXML
	private TableColumn<EmployeeInfoDto, String> hurigana_last_col;

    @FXML
    private TableColumn<EmployeeInfoDto, String> name_col;
    
	@FXML
	private TableColumn <EmployeeInfoDto, Integer>id_col;

	@FXML
	private TableColumn <EmployeeInfoDto, Date>joindate_col;

	@FXML
	private TableColumn <EmployeeInfoDto, String>lastname_col;

	@FXML
	private TableColumn<EmployeeInfoDto, Date> reference_date_col;

	@FXML
	private TableColumn<EmployeeInfoDto, Integer> remaining_paid_leave_days_col;



	@FXML
	private TableColumn<EmployeeInfoDto, Integer> working_days_col;

    @FXML
    private TableView<EmployeeInfoDto> datatable;
	
	
    void setTableViewEmployeeInfoDto(EmployeeInfoDto emp) {
    	
		datatable.getItems().add(new EmployeeInfoDto(
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
				emp.getAnnual_paid_leave_report_date(),
				emp.getGranted_paid_leave_days(),
				emp.getRemaining_paid_leave_days()
				));
    }

    
    /*System.out.println(empDto)で各項目を出力するためにメソッド
    @Override
    public String toString() {
        String id = null;
		String code = null;
		String joinDate = null;
		String huriganaLastname= null;
		String huriganaFirstname= null;
		String lastname = null;
		String firstname = null;
		String departmentName= null;
		String workingDays = null;
		String referenceDate = null;
		String annualPaidLeaveReportDate= null;
		String grantedPaidLeaveDays= null;
		String remainingPaidLeaveDays= null;
		return "EmployeeInfoDto{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", huriganaLastname='" + huriganaLastname + '\'' +
                ", huriganaFirstname='" + huriganaFirstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", workingDays=" + workingDays +
                ", referenceDate='" + referenceDate + '\'' +
                ", annualPaidLeaveReportDate='" + annualPaidLeaveReportDate + '\'' +
                ", grantedPaidLeaveDays=" + grantedPaidLeaveDays +
                ", remainingPaidLeaveDays=" + remainingPaidLeaveDays +
                '}';
    }*/
    
	@FXML
	void initialize() {
		assert annual_paid_leave_report_date_col != null : "fx:id=\"annual_paid_leave_report_date_col\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert code_col != null : "fx:id=\"code_col\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		
		assert datatable != null : "fx:id=\"datatable\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert deleteBox != null : "fx:id=\"deleteBox\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert deleteBtn != null : "fx:id=\"deleteBtn\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert department_col != null : "fx:id=\"department_col\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert firstname_col != null : "fx:id=\"firstname_col\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert granted_paid_leave_days_col != null : "fx:id=\"granted_paid_leave_days_col\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert hurigana_first_col != null : "fx:id=\"hurigana_first_col\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert hurigana_last_col != null : "fx:id=\"hurigana_last_col\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert id_col != null : "fx:id=\"id_col\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert joindate_col != null : "fx:id=\"joindate_col\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert lastname_col != null : "fx:id=\"lastname_col\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert reference_date_col != null : "fx:id=\"reference_date_col\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert remaining_paid_leave_days_col != null : "fx:id=\"remaining_paid_leave_days_col\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert resultDelete != null : "fx:id=\"resultDelete\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert resultUpdate != null : "fx:id=\"resultUpdate\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert updateBox != null : "fx:id=\"updateBox\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert updateBtn != null : "fx:id=\"updateBtn\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		assert working_days_col != null : "fx:id=\"working_days_col\" was not injected: check your FXML file 'hitKensakuView.fxml'.";
		
		id_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Integer>("id"));
	        code_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Integer>("code"));
	        joindate_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Date>("join_date"));
			hurigana_last_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, String>("hurigana_lastname"));
			hurigana_first_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, String>("hurigana_firstname"));
			lastname_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, String>("lastname"));
			firstname_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, String>("firstname"));
			department_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, String>("department_name"));
			working_days_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Integer>("working_days"));
			reference_date_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Date>("reference_date"));
			annual_paid_leave_report_date_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Date>("annual_paid_leave_report_date"));
			granted_paid_leave_days_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Integer>("granted_paid_leave_days"));
			remaining_paid_leave_days_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Integer>("remaining_paid_leave_days"));

		Iterable<EmployeeInfo> result = sd.getEmployeeInfo();//resultから各columnに入れていく
		System.out.println("result"+result);
		List<EmployeeInfoDto> resultDtoList = new ArrayList<>();
		for (EmployeeInfo emp : result) {
		    EmployeeInfoDto empDto = service.convertToDto(emp);
		    resultDtoList.add(empDto);
		    System.out.println("empDto"+empDto);
		}

		for (EmployeeInfoDto empDto : resultDtoList) {
			
		    setTableViewEmployeeInfoDto(empDto);
		}

		
		 //empinfo1.setJoin_date(sqlDate);
       	
		
	   

	}

}
