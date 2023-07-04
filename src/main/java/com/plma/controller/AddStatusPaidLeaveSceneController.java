package com.plma.controller;


import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;
import com.plma.model.entity.EmployeeInfo;
import com.plma.model.entity.EmployeeInfoDto;
import com.plma.model.service.EmployeeInfoService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

@Controller
public class AddStatusPaidLeaveSceneController {

	@Autowired
	private SpringFXMLLoader fxmlLoader;

	@Autowired
	EmployeeInfoService service;
	//EmployeeInfoServiceImpl service;

    @FXML
    private Button allBtn;

    @FXML
    private TableView<EmployeeInfoDto> datatable;

    //@FXML
    //private TableColumn<EmployeeInfoDto, Date> annual_paid_leave_report_date_col;

    @FXML
    private TableColumn<EmployeeInfoDto, Integer> code_col;

    @FXML
    private TableColumn<EmployeeInfoDto, String> department_col;

   // @FXML
   // private TableColumn<EmployeeInfoDto, Integer> granted_paid_leave_days_col;

    @FXML
    private TableColumn<EmployeeInfoDto, String> hurigana_col;

    @FXML
    private TableColumn<EmployeeInfoDto, Date> joindate_col;

    @FXML
    private TableColumn<EmployeeInfoDto, String> name_col;

   // @FXML
   // private TableColumn<EmployeeInfoDto, Date> reference_date_col;

    @FXML
    private TableColumn<EmployeeInfoDto, Integer> total_paid_leave_used_days_col;

    @FXML
    private TableColumn<EmployeeInfoDto, Integer> remaining_paid_leave_days_col;

    //@FXML
   // private TableColumn<EmployeeInfoDto, Integer> working_days_col;

    @FXML
    private TableColumn<EmployeeInfoDto, String> firstname_col;

    @FXML
    private TableColumn<EmployeeInfoDto, String> hurigana_first_col;

    @FXML
    private TableColumn<EmployeeInfoDto, String> hurigana_last_col;

    @FXML
    private TableColumn<EmployeeInfoDto, Integer> id_col;

    @FXML
    private TableColumn<EmployeeInfoDto, String> lastname_col;

    @FXML
    private Button insertBtn;

    @FXML
    private TextField codeBox;

    @FXML
    private TextField deleteBox;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button findCodeBtn;

    @FXML
    private Label resultDelete;

    @FXML
    private Label resultFindCode;

    @FXML
    private Label resultUpdate;

    @FXML
    private TextField updateBox;

    @FXML
    private Button updateBtn;

    @FXML
    private AnchorPane findJoinAndDepartment;

    @FXML
    private Button findJoinAndDepBtn;

    @FXML
    private TextField depMultiple;

    @FXML
    private Button fineMultiple;

    @FXML
    private TextField nameMultiple;

    @FXML
    private TextField wdaysMultiple;

    //a,b,cで追加TableColumn<EmployeeInfoDto, Integer> working_days_col;する
  //a,b,cで追加TableColumn<EmployeeInfoDto, Integer> working_days_col;する
  //a,b,cで追加TableColumn<EmployeeInfoDto, Integer> working_days_col;する
	

    @FXML
    void initialize() {
        assert allBtn != null : "fx:id=\"allBtn\" was not injected: check your FXML file 'TestScene.fxml'.";
       // assert annual_paid_leave_report_date_col != null : "fx:id=\"annual_paid_leave_report_date_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert codeBox != null : "fx:id=\"codeBox\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert code_col != null : "fx:id=\"code_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert datatable != null : "fx:id=\"datatable\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert deleteBox != null : "fx:id=\"deleteBox\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert deleteBtn != null : "fx:id=\"deleteBtn\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert depMultiple != null : "fx:id=\"depMultiple\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert department_col != null : "fx:id=\"department_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert findCodeBtn != null : "fx:id=\"findCodeBtn\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert findJoinAndDepBtn != null : "fx:id=\"findJoinAndDepBtn\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert fineMultiple != null : "fx:id=\"fineMultiple\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert firstname_col != null : "fx:id=\"firstname_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        //assert granted_paid_leave_days_col != null : "fx:id=\"granted_paid_leave_days_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert hurigana_first_col != null : "fx:id=\"hurigana_first_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert hurigana_last_col != null : "fx:id=\"hurigana_last_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert id_col != null : "fx:id=\"id_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert insertBtn != null : "fx:id=\"insertBtn\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert joindate_col != null : "fx:id=\"joindate_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert lastname_col != null : "fx:id=\"lastname_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert nameMultiple != null : "fx:id=\"nameMultiple\" was not injected: check your FXML file 'TestScene.fxml'.";
       // assert reference_date_col != null : "fx:id=\"reference_date_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert remaining_paid_leave_days_col != null : "fx:id=\"remaining_paid_leave_days_col\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert resultDelete != null : "fx:id=\"resultDelete\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert resultFindCode != null : "fx:id=\"resultFindCode\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert resultUpdate != null : "fx:id=\"resultUpdate\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert updateBox != null : "fx:id=\"updateBox\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert updateBtn != null : "fx:id=\"updateBtn\" was not injected: check your FXML file 'TestScene.fxml'.";
        assert wdaysMultiple != null : "fx:id=\"wdaysMultiple\" was not injected: check your FXML file 'TestScene.fxml'.";
       // assert working_days_col != null : "fx:id=\"working_days_col\" was not injected: check your FXML file 'TestScene.fxml'.";

        id_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Integer>("id"));
        code_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Integer>("code"));
        joindate_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Date>("join_date"));
		hurigana_last_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, String>("hurigana_lastname"));
		hurigana_first_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, String>("hurigana_firstname"));
		lastname_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, String>("lastname"));
		firstname_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, String>("firstname"));
		department_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, String>("department_name"));
		//working_days_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Integer>("working_days"));
		//reference_date_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Date>("reference_date"));
		//annual_paid_leave_report_date_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Date>("annual_paid_leave_report_date"));
		//granted_paid_leave_days_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Integer>("granted_paid_leave_days"));
		remaining_paid_leave_days_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Integer>("remaining_paid_leave_days"));

    }


    @FXML//全取得
    void allBtn_OnClick(ActionEvent event) {

    	clearTable();

    	Iterable<EmployeeInfoDto> employeeInfoDtoList = service.getAllEmployeeInfoDto();

        for (EmployeeInfoDto model : employeeInfoDtoList) {
            System.out.println(model.getCode());
        }

        try {
        	for(EmployeeInfoDto emp : employeeInfoDtoList) {
        		System.out.println(emp);

        		// サンプルデータを1行追加
        		setTableViewEmployeeInfoDto(emp);
        	}
		}catch(Exception e) {
			e.printStackTrace();
			if (e.getCause() instanceof InvocationTargetException) {
				Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
				targetException.printStackTrace();
			}
		}
    }

    @FXML
    void insertBtn_OnClick(ActionEvent event) {

    	clearTable();

    	EmployeeInfo empinfo = new EmployeeInfo(null
    			,"XLM99M"
    			,Date.valueOf("2016-04-01")
    			,"やまだ"
    			,"たろう"
    			,"山田"
    			,"太郎"
    			,100
    			,300
    			,Date.valueOf("2016-04-01")
    			,Date.valueOf("2016-04-01")
    	    	,19
    			,3);

		try {
			service.insertEmployeeInfo(empinfo);
			allBtn_OnClick(event);

		}catch(Exception e){
			e.printStackTrace();
			if (e.getCause() instanceof InvocationTargetException) {
				Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
				targetException.printStackTrace();
			}
		}
    }

    @FXML
    void findCodeBtn_OnClick(ActionEvent event) {

    	clearTable();

		try {

			Optional<EmployeeInfoDto> optional = service.findByIdEmpDto(Integer.parseInt(codeBox.getText()));
			EmployeeInfoDto empinfo;

			if (optional.isPresent()) {
			    empinfo = optional.get();
				datatable.getItems().add(empinfo);
		} else {
			    System.out.println("Value was null");
			}

		}catch(Exception e){
			e.printStackTrace();
			if (e.getCause() instanceof InvocationTargetException) {
				Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
				targetException.printStackTrace();
			}
		}
    }

    @FXML
    void updateBtn_OnClick(ActionEvent event) {
    	clearTable();

		Optional<EmployeeInfo> optional = service.findById(Integer.parseInt(updateBox.getText()));
		EmployeeInfo empinfo;

		if (optional.isPresent()) {
		    empinfo = optional.get();
		} else {
		    System.out.println("Value was null");
		    return;
		}

		empinfo.setJoin_date(Date.valueOf("1990-04-01"));

		try {
			service.insertEmployeeInfo(empinfo);
			allBtn_OnClick(event);

		}catch(Exception e){
			e.printStackTrace();
			if (e.getCause() instanceof InvocationTargetException) {
				Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
				targetException.printStackTrace();
			}
		}
    }

    @FXML
    void deleteBtn_OnClick(ActionEvent event) {

    	if(service.existsById(Integer.parseInt(deleteBox.getText()))) {
    		service.deleteById(Integer.parseInt(deleteBox.getText()));
    		clearTable();
    		allBtn_OnClick(event);
    	}else {
    		System.out.println("Value was null");
    	}

    }

    @FXML
    void findJoinAndDepBtn_OnClick(ActionEvent event) {
    	Iterable<EmployeeInfoDto> empinfo = service.findByJoinDateAndDepartmentDto(Date.valueOf("2013-04-02"), "総務部");
    	clearTable();
		for(EmployeeInfoDto emp : empinfo) {
			System.out.println(emp.getLastname());
    		// サンプルデータを1行追加
			setTableViewEmployeeInfoDto(emp);
		}
    }

    @FXML
    void fineMultipleBtn_OnClick(ActionEvent event) {

    	// 各nullチェック
    	String lastname_text = Optional.ofNullable(nameMultiple.getText()).filter(s -> !s.isEmpty()).orElse(null);
    	String depname_text = Optional.ofNullable(depMultiple.getText()).filter(s -> !s.isEmpty()).orElse(null);
    	Integer wdays_text = Optional.ofNullable(wdaysMultiple.getText()).filter(s -> !s.isEmpty()).map(Integer::parseInt).orElse(null);

    	Iterable<EmployeeInfoDto> empinfo = service.findByParamsDto(lastname_text , depname_text, wdays_text);
    	clearTable();
		for(EmployeeInfoDto emp : empinfo) {
			System.out.println(emp);
			// サンプルデータを1行追加
			setTableViewEmployeeInfoDto(emp);
		}

    }

    void clearTable() {
    	datatable.getItems().clear();
    	datatable.refresh();
    }

    void setTableViewEmployeeInfoDto(EmployeeInfoDto emp) {
		datatable.getItems().add(new EmployeeInfoDto(emp.getId(),
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
}


