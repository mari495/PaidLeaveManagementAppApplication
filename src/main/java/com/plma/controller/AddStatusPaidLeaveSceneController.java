package com.plma.controller;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;
import com.plma.model.entity.Department;
import com.plma.model.entity.EmployeeInfoDto;
import com.plma.model.entity.PaidLeave;
import com.plma.model.entity.PaidLeaveDto;
import com.plma.model.repository.DepartmentRepository;
import com.plma.model.repository.PaidLeaveRepository;
import com.plma.model.service.EmployeeInfoService;
import com.plma.model.service.EmployeeInfoServiceImpl;

import javafx.collections.ObservableList;
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
import javafx.scene.control.TextField;
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








    @FXML
    private Button allBtn;
    @FXML
    private Button insertBtn;
    @FXML
    private Button all_button;

    @FXML
    private TextArea codeBox;

    @FXML
    private TextField deleteBox;

    @FXML
    private Button deleteBtn;

    
    @FXML
    private Button add_button;


    @FXML
    private TextArea firstname_hurigana_text;

    @FXML
    private TextArea firstname_text;

    @FXML
    private Button kensaku_button;

    @FXML
    private TextArea lastname_hurigana_text;

    @FXML
    private TextArea lastname_text;

    @FXML
	private ComboBox<Integer> month;
    @FXML
 	private ComboBox<Integer> day;
    @FXML
 	private ComboBox<Integer> year;
    @FXML
  	private ComboBox<Integer> Addmonth;
      @FXML
   	private ComboBox<Integer> Addday;
      @FXML
   	private ComboBox<Integer> Addyear;
      @FXML
  	private ComboBox<String> department;

    

	

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
    	 
    	 
    	 
    	  assert add_button != null : "fx:id=\"add_button\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
          assert all_button != null : "fx:id=\"all_button\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
          
          assert codeBox != null : "fx:id=\"codeBox\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
          
         
          assert day != null : "fx:id=\"day\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";        
          assert month != null : "fx:id=\"month\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";     
          assert year != null : "fx:id=\"year\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
          assert Addmonth != null : "fx:id=\"day\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
          assert Addday != null : "fx:id=\"month\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";    
          assert Addyear != null : "fx:id=\"year\" was not injected: check your FXML file 'AddStatusPaidLeave.fxml'.";
        
        
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
		// ComboBoxに値を登録
				for (int y = 2000; y < 2024; y++) {
					Addyear.getItems().add(Integer.valueOf(y));
				}

				for (int m = 1; m < 13; m++) {
					Addmonth.getItems().add(Integer.valueOf(m));
				}

				for (int d = 1; d < 32; d++) {
					Addday.getItems().add(Integer.valueOf(d));
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
    
    @FXML//
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

        	
        	
        	ObservableList<PaidLeaveDto> all_pld = datatable.getItems();
        	
        	
        	for(PaidLeaveDto pld : all_pld) {
        		String code_pld = pld.getCode();
        		System.out.println(code_pld);
        		if (inputCode.equals(code_pld)){
                	PaidLeave pl = new PaidLeave();
                	pl.setId(null); // 登録IDを設定
                	pl.setCode(code_pld); // 社員コードを設定
                	pl.setPaid_leave_date(date); // 有給休暇取得日を設定
                    // Departmentをデータベースに保存
                	service.insertPaidLeave(pl);
            } else {
               
                System.out.println("一致するレコードが見つかりませんでした");
                //一致する社員コードが見つからなかった場合メッセージボックス実装予定
        	
       
        	
        	}
        		
        	}
        	    
        	
                
        	  
        	
            
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getCause() instanceof InvocationTargetException) {
                Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
                targetException.printStackTrace();
            }
        }

        /*
         * 現在表示されている画面を閉じる
         */
        Scene s = ((Node)event.getSource()).getScene();
        Window window = s.getWindow();
        window.hide();
    }


    void setTableViewPaidLeaveDto(PaidLeaveDto emp) {
        datatable.getItems().add(new PaidLeaveDto(
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
        		    emp.getPaidLeave_date()
        		));
    }





    
    
    public EmployeeInfoDto convertToPaidLeave(EmployeeInfoDto EmployeeInfoDto) {
    	Map<Integer, String> departmentNumberToNameMap = StreamSupport.stream(service.selectDepAll().spliterator(), false)
    		    .collect(Collectors.toMap(Department::getDepartment_number, Department::getDepartment_name));

	    return new EmployeeInfoDto(
	    		EmployeeInfoDto.getId(),
	    		EmployeeInfoDto.getCode(),
	    		EmployeeInfoDto.getJoin_date(),
	    		EmployeeInfoDto.getHurigana_lastname(),
	    		EmployeeInfoDto.getHurigana_firstname(),
	    		EmployeeInfoDto.getLastname(),
	    		EmployeeInfoDto.getFirstname(),
	        departmentNumberToNameMap.get(EmployeeInfoDto.getDepartment_name()),
	        EmployeeInfoDto.getWorking_days(),
	        EmployeeInfoDto.getReference_date(),
	        EmployeeInfoDto.getAnnual_paid_leave_report_date(),
	        EmployeeInfoDto.getGranted_paid_leave_days(),
	        EmployeeInfoDto.getRemaining_paid_leave_days()
	    );
	}

    
    @FXML//全取得
    void allBtn_OnClick(ActionEvent event) {

    	Iterable<EmployeeInfoDto> EmployeeInfoDtoList = service.getAllEmployeeInfoDto();
    	System.out.println("PaidLeaveDtoList"+EmployeeInfoDtoList);
//PaidLeaveDto型からPaidLeaveDtoへコンバート
    	
    	List<PaidLeaveDto> PaidLiaveList = new ArrayList<>();
    	
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
		    		emp.getRemaining_paid_leave_days(),
		    		emp.getGranted_paid_leave_days(),
		    		null);   //PaidLeaveDBから取得のためNullで登録
		    PaidLiaveList.add(paid); // リストに要素を追加
		    	
		}

        try {
        	for(PaidLeaveDto paid : PaidLiaveList) {
        		System.out.println(paid);

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

    

    
    

   
   
}


