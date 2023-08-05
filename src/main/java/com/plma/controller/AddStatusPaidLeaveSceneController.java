package com.plma.controller;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;
import com.plma.model.entity.Department;
import com.plma.model.entity.EmployeeInfo;
import com.plma.model.entity.EmployeeInfoDto;
import com.plma.model.entity.PaidLeave;
import com.plma.model.entity.PaidLeaveDto;
import com.plma.model.repository.DepartmentRepository;
import com.plma.model.repository.PaidLeaveRepository;
import com.plma.model.service.EmployeeInfoService;
import com.plma.model.service.EmployeeInfoServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

@Controller
public class AddStatusPaidLeaveSceneController {

	@Autowired
	private SpringFXMLLoader fxmlLoader;

	@Autowired
	EmployeeInfoService service;
	EmployeeInfoServiceImpl employeeInfoServiceImpl;
	@Autowired
	DepartmentRepository dep_repository;
	@Autowired
	PaidLeaveRepository pl_repository;


	@FXML
	private TableView<PaidLeaveDto> datatable;

	@FXML
	private TableColumn<PaidLeaveDto, Integer> id_col;

	@FXML
	private TableColumn<PaidLeaveDto, String> code_col;

	@FXML
	private TableColumn<PaidLeaveDto, Date> joindate_col;


	@FXML
	private TableColumn<PaidLeaveDto, String> hurigana_last_col;

	@FXML
	private TableColumn<PaidLeaveDto, String> hurigana_first_col;


	@FXML
	private TableColumn<PaidLeaveDto, String> lastname_col;


	@FXML
	private TableColumn<PaidLeaveDto, String> firstname_col;


	@FXML
	private TableColumn<PaidLeaveDto, String> department_col;


	@FXML
	private TableColumn<PaidLeaveDto, Integer> working_days_col;

	@FXML
	private TableColumn<PaidLeaveDto, Date> reference_date_col;


	@FXML
	private TableColumn<PaidLeaveDto, Integer> granted_paid_leave_days_col;

	@FXML
	private TableColumn<PaidLeaveDto, Integer> remaining_paid_leave_days_col;


	@FXML
	private TableColumn<PaidLeaveDto, Date> paid_leave_date_col;


	/**
	 * 登録&削除で使用
	 */
	////////////////////////////////////////////////////
	@FXML
	private ComboBox<Integer> Addmonth;
	@FXML
	private ComboBox<Integer> Addday;
	@FXML
	private ComboBox<Integer> Addyear;

	@FXML
	private TextArea codeBox;


	@FXML
	private Button add_button;
	@FXML
	private Button delete_button;

	/**
	 * 全検索で使用
	 */
	////////////////////////////////////////////////////
	@FXML
	private Button all_button;

	///////////////////////////////////////////////

	/**
	 * 複数＆＆条件検索で使用
	 */

	@FXML
	private ComboBox<String> syaincode_ComboBox;


	@FXML
	private TextArea lastname_text;

	@FXML
	private TextArea firstname_text;

	@FXML
	private TextArea lastname_hurigana_text;

	@FXML
	private TextArea firstname_hurigana_text;


	@FXML
	private ComboBox<Integer> month;
	@FXML
	private ComboBox<Integer> day;
	@FXML
	private ComboBox<Integer> year;

	@FXML
	private ComboBox<String> department;

	@FXML
	private ComboBox<Integer> working_days;


	@FXML
	private Button kensaku_button;


	///////////////////////////////////////////////




	@FXML
	void initialize() {


		assert datatable != null : "fx:id=\"datatable\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert id_col != null : "fx:id=\"id_col\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert code_col != null : "fx:id=\"code_col\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert joindate_col != null : "fx:id=\"joindate_col\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert hurigana_last_col != null : "fx:id=\"hurigana_last_col\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert hurigana_first_col != null : "fx:id=\"hurigana_first_col\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert lastname_col != null : "fx:id=\"lastname_col\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert firstname_col != null : "fx:id=\"firstname_col\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert department_col != null : "fx:id=\"department_col\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert working_days_col != null : "fx:id=\"department_col\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert reference_date_col != null : "fx:id=\"granted_paid_leave_days_col\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert granted_paid_leave_days_col != null : "fx:id=\"granted_paid_leave_days_col\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert remaining_paid_leave_days_col != null : "fx:id=\"annual_paid_leave_report_date_col\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert paid_leave_date_col != null : "fx:id=\"annual_paid_leave_report_date_col\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";

		assert codeBox != null : "fx:id=\"codeBox\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert add_button != null : "fx:id=\"add_button\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert Addmonth != null : "fx:id=\"day\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert Addday != null : "fx:id=\"month\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";    
		assert Addyear != null : "fx:id=\"year\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";

		assert all_button != null : "fx:id=\"all_button\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";

		assert syaincode_ComboBox != null : "fx:id=\"syaincode_ComboBox\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert working_days != null : "fx:id=\"working_days\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert department != null : "fx:id=\"department\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert kensaku_button != null : "fx:id=\"kensaku_button\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert firstname_text != null : "fx:id=\"firstname_text\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert lastname_text != null : "fx:id=\"lastname_text\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert day != null : "fx:id=\"day\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";        
		assert month != null : "fx:id=\"month\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";     
		assert year != null : "fx:id=\"year\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert lastname_hurigana_text != null : "fx:id=\"lastname_hurigana_text\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
		assert firstname_hurigana_text != null : "fx:id=\"firstname_hurigana_text\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";

		id_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto, Integer>("id"));
		code_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto, String>("code"));
		joindate_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto, Date>("join_date"));
		hurigana_last_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto, String>("hurigana_lastname"));
		hurigana_first_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto, String>("hurigana_firstname"));
		lastname_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto, String>("lastname"));
		firstname_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto, String>("firstname"));
		department_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto, String>("department_name"));
		working_days_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto, Integer>("working_days"));
		reference_date_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto, Date>("reference_date"));
		granted_paid_leave_days_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto, Integer>("granted_paid_leave_days"));
		remaining_paid_leave_days_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto, Integer>("remaining_paid_leave_days"));
		paid_leave_date_col.setCellValueFactory(new PropertyValueFactory<PaidLeaveDto, Date>("PaidLeave_date"));





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

		for (int y = 2000; y < 2024; y++) {
			Addyear.getItems().add(Integer.valueOf(y));
		}

		for (int m = 1; m < 13; m++) {
			Addmonth.getItems().add(Integer.valueOf(m));
		}

		for (int d = 1; d < 32; d++) {
			Addday.getItems().add(Integer.valueOf(d));
		}
		for (int y = 1; y < 6; y++) {
			working_days.getItems().add(Integer.valueOf(y));
		}

		for(int syaincode = 100; syaincode < 201; syaincode++) {
			syaincode_ComboBox.getItems().add(Integer.toString(syaincode));
		}



		//DepartmentDBからgetDepartment_nameを取得して表示
		Iterable<Department> departments = service.getDepartment();

		for (Department dep : departments) {
			String departmentName = dep.getDepartment_name();
			department.getItems().add(departmentName);
		}
	}




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
	@FXML
	void Delete_button_onClick(ActionEvent event) {
		Date date = null;

		Integer yearItem = Addyear.getValue();
		Integer monthItem = Addmonth.getValue();
		Integer dayItem = Addday.getValue();
		System.out.println("yearItem"+yearItem);
		System.out.println("monthItem"+monthItem);
		System.out.println("dayItem"+dayItem);
		
		if(!(yearItem == null && monthItem == null && dayItem == null)) {
			// コンボボックスの値から日付を作成
			LocalDate selectedDate = LocalDate.of(Addyear.getValue(), Addmonth.getValue(), Addday.getValue());
			// java.sql.Dateに変換
			date = Date.valueOf(selectedDate);
			System.out.println("date"+date);
			String inputCode = codeBox.getText(); // テキストボックスから入力された値を取得
			
			service.deleteByPaidLeave(date,inputCode);
			
			
		}
	}

	@FXML//テキストボックスに入力された数値と一致する社員コードの行に有給休暇登録をするメソッド
	void addNumber_of_days_usedOnClick(ActionEvent event) {


		Date date = null;

		Integer yearItem = Addyear.getValue();
		Integer monthItem = Addmonth.getValue();
		Integer dayItem = Addday.getValue();
		System.out.println("yearItem"+yearItem);
		System.out.println("monthItem"+monthItem);
		System.out.println("dayItem"+dayItem);


		if(!(yearItem == null && monthItem == null && dayItem == null)) {
			// コンボボックスの値から日付を作成
			LocalDate selectedDate = LocalDate.of(Addyear.getValue(), Addmonth.getValue(), Addday.getValue());
			// java.sql.Dateに変換
			date = Date.valueOf(selectedDate);
			System.out.println("date"+date);

		}

		try  {

			String inputCode = codeBox.getText(); // テキストボックスから入力された値を取得

			// 既存の有給休暇データを取得
	        Iterable<PaidLeave> existingPaidLeaves = service.getPaidLeave();

	        for (PaidLeave paidLeave : existingPaidLeaves) {
	           // String code_pld = paidLeave.getCode();
	            
				if (inputCode.equals(paidLeave.getCode())&&date.equals(paidLeave.getPaid_leave_date())){
					System.out.println("すでに登録してある日付です");
				//何もしない
					
					
				} 

			}PaidLeave pl = new PaidLeave();
					pl.setId(null); // 登録IDを設定
					pl.setCode(inputCode); // 社員コードを設定
					pl.setPaid_leave_date(date); // 有給休暇取得日を設定
					// Departmentをデータベースに保存
					service.insertPaidLeave(pl);

		} catch (Exception e) {
			e.printStackTrace();
			if (e.getCause() instanceof InvocationTargetException) {
				Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
				targetException.printStackTrace();
			}
		}

		
	}



	//取得したデータをテーブルに表示するメソッド
	void setTableViewPaidLeaveDto(PaidLeaveDto emp) {
		datatable.getItems().add(emp);
	}


	//やりたいことDBから取得した日付をすべてもってくる
	// getPaidLeaveDateメソッドの実装
	private List<Date> getPaidLeaveDates(Integer syaincode) {
		List<Date> dates = new ArrayList<>();
		Iterable<PaidLeave> paidLeaves = pl_repository.findAll();

		for (PaidLeave paidLeave : paidLeaves) {
			System.out.println("paidLeave!!!!"+paidLeave);
			if (paidLeave.getCode().equals(syaincode.toString())) {
				dates.add(paidLeave.getPaid_leave_date());
				StringBuilder sb = new StringBuilder();
				sb.append("Dates: ").append(dates);
				System.out.println(sb.toString());
			}
		}


		return dates;


	}


	@FXML//全取得
	void allBtn_OnClick(ActionEvent event) {
		//表をクリア
		datatable.getItems().clear();

		Iterable<EmployeeInfoDto> EmployeeInfoDtoList = service.getAllEmployeeInfoDto();
		Iterable<PaidLeave> PaidLeaveList = pl_repository.findAll();

		System.out.println("EmployeeInfoDtoList"+EmployeeInfoDtoList);

		List<PaidLeaveDto> PaidLiaveDtoList = new ArrayList<>();


		for (EmployeeInfoDto emp : EmployeeInfoDtoList) {
			//EmployeeInfoDto empDto = convertToPaidLeave(emp);
			PaidLeaveDto paid = new PaidLeaveDto(
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
					null);   //PaidLeaveDBから取得のためNullで登録

			int plcnt = 0;

			for(PaidLeave pltmp : PaidLeaveList) {
				if(pltmp.getCode().equals(emp.getCode())) {
					PaidLeaveDto paid_use = new PaidLeaveDto(
							emp.getId(),
							emp.getCode(),
							emp.getJoin_date(),
							emp.getHurigana_lastname(),
							emp.getHurigana_firstname(),
							emp.getLastname(),
							emp.getFirstname(),
							emp.getDepartment_name(),//departmentnameDBからDepartmentNunberと一致するDepartmentNameを取得
							emp.getWorking_days(),
							emp.getReference_date(),
							emp.getGranted_paid_leave_days(),
							emp.getRemaining_paid_leave_days(),
							pltmp.getPaid_leave_date());   //PaidLeaveDBから取得のためNullで登録

					System.out.println("pltmp.getPaid_leave_date()" + pltmp.getPaid_leave_date());
					
					PaidLiaveDtoList.add(paid_use); // リストに要素を追加
					plcnt++;
				}

			}

			if(plcnt == 0) {
				PaidLiaveDtoList.add(paid); // リストに要素を追加
			}

		}

		try {
			for(PaidLeaveDto paid : PaidLiaveDtoList) {
				System.out.println("paid="+paid);

				// サンプルデータを1行追加
				setTableViewPaidLeaveDto(paid);


			}
		}catch(Exception e) {
			e.printStackTrace();
			if (e.getCause() instanceof InvocationTargetException) {
				Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
				targetException.printStackTrace();
			}
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

	
	private String getDepartmentName(Integer departmentNumber) {
	    Iterable<Department> departments = service.getDepartment();

	    for (Department department : departments) {
	        if (department.getDepartment_number().equals(departmentNumber)) {
	            return department.getDepartment_name();
	        }
	    }

	    return null; // 該当する部署が見つからなかった場合は null を返す（適宜エラーハンドリングを行ってください）
	}
	
	public String getTextAreaContent(TextArea textArea) {
		String content = textArea.getText();
		return (content == null || content.isEmpty()) ? null : content;
	}



	
	@FXML//複数の&&条件による検索
	void kensaku_button_onClick(ActionEvent event) {
		//押す度に表をクリア
		datatable.getItems().clear();

		Date date = null;

		Integer yearItem = year.getSelectionModel().getSelectedItem();
		Integer monthItem = month.getSelectionModel().getSelectedItem();
		Integer dayItem = day.getSelectionModel().getSelectedItem();
		
		

		//全てのプルダウンが選択されている場合のみ処理を行う
		if(!(yearItem == null && monthItem == null && dayItem == null)) {



			// コンボボックスの値から日付を作成
			LocalDate selectedDate = LocalDate.of(year.getValue(), month.getValue(), day.getValue());
			// java.sql.Dateに変換
			date = Date.valueOf(selectedDate);
		}
		

		//部署名をDBで照らし合わせてDepartmentNumberを取得する
		String selectedDepartment = department.getValue();
		Integer departmentNumber = getDepartmentNumber(selectedDepartment);
		
		
		Iterable<EmployeeInfo> empInfo = service.findByEightParams(
				syaincode_ComboBox.getSelectionModel().getSelectedItem(),//社員コード
				date,//入社日
				getTextAreaContent(firstname_hurigana_text),//名前ふりがな
				getTextAreaContent(lastname_hurigana_text),//苗字ふりがな
				getTextAreaContent(firstname_text),//名前
				getTextAreaContent(lastname_text),//苗字
				departmentNumber,    //部署名      		
				working_days.getValue());
		System.out.println("----------------------------------------------");
		System.out.println(syaincode_ComboBox.getEditor().getText());
		System.out.println(date);
		System.out.println(firstname_text.getText());
		System.out.println( lastname_text.getText());
		System.out.println( firstname_hurigana_text.getText());
		System.out.println(lastname_hurigana_text.getText());
		System.out.println(year.getValue());
		System.out.println(month.getValue());
		System.out.println(day.getValue());
		System.out.println(department.getValue());
		System.out.println(departmentNumber);
		System.out.println(working_days.getValue());
		System.out.println("----------------------------------------------");

		
		Iterable<PaidLeave> PaidLeaveList = pl_repository.findAll();//PaidLeaveDBから情報取得
		List<PaidLeaveDto> PaidLiaveDtoList = new ArrayList<>();//表示用に新たに作成
		
		for (EmployeeInfo emp : empInfo) {
			
			
			String dptmname = getDepartmentName(emp.getDepartment_number());
			
			PaidLeaveDto paid = new PaidLeaveDto(
					emp.getId(),
					emp.getCode(),
					emp.getJoin_date(),
					emp.getHurigana_lastname(),
					emp.getHurigana_firstname(),
					emp.getLastname(),
					emp.getFirstname(),
					dptmname,//departmentnameDBからDepartmentNunberと一致するDepartmentNameを取得
					emp.getWorking_days(),
					emp.getReference_date(),
					emp.getGranted_paid_leave_days(),
					emp.getRemaining_paid_leave_days(),
					null);   //PaidLeaveDBから取得のためNullで登録
		    		
			
			

			int plcnt = 0;
			//PaidLeaveDBの中で社員コードと一致するかを判断
			for(PaidLeave pltmp : PaidLeaveList) {
				if(pltmp.getCode().equals(emp.getCode())) {
					paid.setPaidLeave_date(pltmp.getPaid_leave_date());//一致したらリストに日付をセット				
					PaidLiaveDtoList.add(paid); 
					plcnt++;//一致の回数をカウント
				}

			}

			if(plcnt == 0) {//一致しなかったら
				PaidLiaveDtoList.add(paid); // リストに要素を追加
			}

		}

		try {
			for(PaidLeaveDto paid : PaidLiaveDtoList) {
				
				setTableViewPaidLeaveDto(paid);

			}
			
		}catch(Exception e) {
			e.printStackTrace();
			if (e.getCause() instanceof InvocationTargetException) {
				Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
				targetException.printStackTrace();
			}
		}
	}






}


