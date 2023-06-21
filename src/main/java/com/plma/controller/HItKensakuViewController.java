/*package com.plma.controller;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;
import com.plma.model.entity.EmployeeInfo;
import com.plma.model.service.EmployeeInfoService;
import com.plma.model.shareddata.SharedData;

import javafx.fxml.FXML;

@Controller
public class HItKensakuViewController {

	@Autowired
	private SpringFXMLLoader fxmlLoader;

	@Autowired
	EmployeeInfoService service;
	//EmployeeInfoServiceImpl service;

	@Autowired
	SharedData sd;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableColumn<?, ?> annual_paid_leave_report_date_col;

	@FXML
	private TableColumn<?, ?> code_col;

	@FXML
	private TableView<?> datatable;

	@FXML
	private TextField deleteBox;

	@FXML
	private Button deleteBtn;

	@FXML
	private TableColumn<?, ?> department_col;

	@FXML
	private TableColumn<?, ?> firstname_col;

	@FXML
	private TableColumn<?, ?> granted_paid_leave_days_col;

	@FXML
	private TableColumn<?, ?> hurigana_first_col;

	@FXML
	private TableColumn<?, ?> hurigana_last_col;

	@FXML
	private TableColumn<?, ?> id_col;

	@FXML
	private TableColumn<?, ?> joindate_col;

	@FXML
	private TableColumn<?, ?> lastname_col;

	@FXML
	private TableColumn<?, ?> reference_date_col;

	@FXML
	private TableColumn<?, ?> remaining_paid_leave_days_col;

	@FXML
	private Label resultDelete;

	@FXML
	private Label resultUpdate;

	@FXML
	private TextField updateBox;

	@FXML
	private Button updateBtn;

	@FXML
	private TableColumn<?, ?> working_days_col;

	@FXML
	void deleteBtn_OnClick(ActionEvent event) {

	}

	@FXML
	void updateBtn_OnClick(ActionEvent event) {
	}


	@FXML//型合わせる
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



	//Iterable<EmployeeInfo> result = sd.getEmployeeInfo();//resultから各columnに入れていく
}*/
