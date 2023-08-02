package com.plma.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;
import com.plma.model.entity.Department;
import com.plma.model.entity.EmployeeInfo;
import com.plma.model.entity.EmployeeInfoDto;
import com.plma.model.entity.PaidLeave;
import com.plma.model.service.EmployeeInfoService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

@Controller
public class MainSceneController {
	@Autowired
	private SpringFXMLLoader fxmlLoader;
	
	
	@Autowired
	EmployeeInfoService service;
	
	
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    
    
    @FXML
    private Button kensaku_button;

    @FXML
    private Button misyouka_button;

    @FXML
    private Button settei_button;

    @FXML
    private Button shinkitouroku_button;

    @FXML
    private Button syoumetu_button;

    @FXML
    private Button yukyutouroku_button;

    @FXML
    private Button ManagementBookCreation_button;

    @FXML
    void initialize() throws IOException {
        assert kensaku_button != null : "fx:id=\"kensaku_button\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert misyouka_button != null : "fx:id=\"misyouka_button\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert settei_button != null : "fx:id=\"settei_button\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert shinkitouroku_button != null : "fx:id=\"shinkitouroku_button\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert syoumetu_button != null : "fx:id=\"syoumetu_button\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert yukyutouroku_button != null : "fx:id=\"yukyutouroku_button\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert ManagementBookCreation_button != null : "fx:id=\"ManagementBookCreation_button\" was not injected: check your FXML file 'MainScene.fxml'.";
        
        
        
        
        
        /**
		   * 社員の有給休暇情報の更新処理をinitializeの中で実施
		   */
		    Iterable<EmployeeInfoDto> EmployeeInfoDtoList = service.getAllEmployeeInfoDto();
		    Iterable<PaidLeave> PaidLeaveList = service.getPaidLeave();

		    for (EmployeeInfoDto emp : EmployeeInfoDtoList) {
		    	
		       
		        int setDepartmentNumber=getDepartmentNumber(emp.getDepartment_name());
		        // 所定労働日数と入社日から有給休暇付与日数を計算してセット
		        int Granted_paid_leave_days = calculateGrantedPaidLeaveDays(emp.getWorking_days(), emp.getJoin_date());
		        System.out.println("Granted_paid_leave_days" + Granted_paid_leave_days);

		        
		        
		        int pacnt = 0;//有給休暇使用回数用カウント
		        for (PaidLeave pltmp : PaidLeaveList) {
		            if (pltmp.getCode().equals(emp.getCode())) {
		                pacnt++;
		            }
		        }
		        
		     // 有給休暇残数＝現在の残数ーPaidLeaveカウントした回数（使用日数）
		        int remainingPaidLeaveDays = emp.getGranted_paid_leave_days() - pacnt;
		        
		        
		        // 新しいEmployeeInfoオブジェクトを作成するのではなく、既存のpaidオブジェクトを更新
		        EmployeeInfo paid = new EmployeeInfo(
		            emp.getId(),
		            emp.getCode(),
		            emp.getJoin_date(),
		            emp.getHurigana_lastname(),
		            emp.getHurigana_firstname(),
		            emp.getLastname(),
		            emp.getFirstname(),
		            setDepartmentNumber,
		            emp.getWorking_days(),
		            emp.getReference_date(),
		            emp.getAnnual_paid_leave_report_date(),
		            Granted_paid_leave_days, // 有給休暇付与日数をセット
		            remainingPaidLeaveDays //所定労働日数と有給休暇使用日数より残数を計算
		        );
		        System.out.println("remainingPaidLeaveDays" + remainingPaidLeaveDays);//残作業重複バグ発生中！！
		        
		        // データベースに更新を反映
		        service.insertEmployeeInfo(paid);
		    }
        
        
        

    }
   
 // 所定労働日数から有給休暇付与日数を計算するメソッド
 	public int calculateGrantedPaidLeaveDays(int workingDays,Date joinDate) {
 		 // java.sql.Dateをjava.time.LocalDateに変換
 	    LocalDate joinLocalDate = joinDate.toLocalDate();
 		LocalDate currentDate = LocalDate.now();
 		long monthsSinceJoin = ChronoUnit.MONTHS.between(joinLocalDate, currentDate);

 		// 付与日数を計算
 		int grantedDays = 0;
 		if (workingDays == 5) {
 			// 所定労働日数が5日の場合
 			if (monthsSinceJoin >= 6 && monthsSinceJoin < 18) {
 				grantedDays = 10;
 			} else if (monthsSinceJoin >= 18 && monthsSinceJoin < 30) {
 				grantedDays = 11;
 			} else if (monthsSinceJoin >= 30 && monthsSinceJoin < 42) {
 				grantedDays = 12;
 			} else if (monthsSinceJoin >= 42 && monthsSinceJoin < 54) {
 				grantedDays = 14;
 			} else if (monthsSinceJoin >= 54 && monthsSinceJoin < 66) {
 				grantedDays = 16;
 			} else if (monthsSinceJoin >= 66) {
 				grantedDays = 18;
 			} else {
 				// 6ヶ月未満は付与なし
 				grantedDays = 0;
 			}
 		} else if (workingDays == 4) {
 			// 所定労働日数が4日の場合
 			if (monthsSinceJoin >= 6 && monthsSinceJoin < 18) {
 				grantedDays = 7;
 			} else if (monthsSinceJoin >= 18 && monthsSinceJoin < 30) {
 				grantedDays = 8;
 			} else if (monthsSinceJoin >= 30 && monthsSinceJoin < 42) {
 				grantedDays = 9;
 			} else if (monthsSinceJoin >= 42 && monthsSinceJoin < 54) {
 				grantedDays = 10;
 			} else if (monthsSinceJoin >= 54 && monthsSinceJoin < 66) {
 				grantedDays = 12;
 			} else if (monthsSinceJoin >= 66) {
 				grantedDays = 13;
 			} else {
 				// 6ヶ月未満は付与なし
 				grantedDays = 0;
 			}
 		} else if (workingDays == 3) {
 			// 所定労働日数が3日の場合
 			if (monthsSinceJoin >= 6 && monthsSinceJoin < 18) {
 				grantedDays = 5;
 			} else if (monthsSinceJoin >= 18 && monthsSinceJoin < 30) {
 				grantedDays = 6;
 			} else if (monthsSinceJoin >= 30 && monthsSinceJoin < 42) {
 				grantedDays = 6;
 			} else if (monthsSinceJoin >= 42 && monthsSinceJoin < 54) {
 				grantedDays = 8;
 			} else if (monthsSinceJoin >= 54 && monthsSinceJoin < 66) {
 				grantedDays = 9;
 			} else if (monthsSinceJoin >= 66 && monthsSinceJoin < 78) {
 				grantedDays = 10;
 			} else if (monthsSinceJoin >= 78) {
 				grantedDays = 11;
 			} else {
 				// 6ヶ月未満は付与なし
 				grantedDays = 0;
 			}
 		} else if (workingDays == 2) {
 			// 所定労働日数が2日の場合
 			if (monthsSinceJoin >= 6 && monthsSinceJoin < 18) {
 				grantedDays = 3;
 			} else if (monthsSinceJoin >= 18 && monthsSinceJoin < 30) {
 				grantedDays = 4;
 			} else if (monthsSinceJoin >= 30 && monthsSinceJoin < 42) {
 				grantedDays = 4;
 			} else if (monthsSinceJoin >= 42 && monthsSinceJoin < 54) {
 				grantedDays = 5;
 			} else if (monthsSinceJoin >= 54 && monthsSinceJoin < 66) {
 				grantedDays = 6;
 			} else if (monthsSinceJoin >= 66 && monthsSinceJoin < 78) {
 				grantedDays = 6;
 			} else if (monthsSinceJoin >= 78) {
 				grantedDays = 7;
 			} else {
 				// 6ヶ月未満は付与なし
 				grantedDays = 0;
 			}
 		} else if (workingDays == 1) {
 			// 所定労働日数が1日の場合
 			if (monthsSinceJoin >= 6 && monthsSinceJoin < 18) {
 				grantedDays = 1;
 			} else if (monthsSinceJoin >= 18 && monthsSinceJoin < 30) {
 				grantedDays = 2;
 			} else if (monthsSinceJoin >= 30 && monthsSinceJoin < 42) {
 				grantedDays = 2;
 			} else if (monthsSinceJoin >= 42 && monthsSinceJoin < 54) {
 				grantedDays = 2;
 			} else if (monthsSinceJoin >= 54 && monthsSinceJoin < 66) {
 				grantedDays = 3;
 			} else if (monthsSinceJoin >= 66 && monthsSinceJoin < 78) {
 				grantedDays = 3;
 			} else if (monthsSinceJoin >= 78) {
 				grantedDays = 3;
 			} else {
 				// 6ヶ月未満は付与なし
 				grantedDays = 0;
 			}
 		}

 		return grantedDays;
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
    
    @FXML
    void shinkitouroku_button_onClick(ActionEvent event) {
    	System.out.println("登録画面に来た");
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
			Parent parent = fxmlLoader.load(getClass().getResource("/com/plma/view/ShinkitourokuScene.fxml"));
	        Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("新規社員登録");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void kensaku_button_onClick(ActionEvent event) {
    	System.out.println("検索画面に来た");
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
			Parent parent = fxmlLoader.load(getClass().getResource("/com/plma/view/kensakuScene.fxml"));
	        Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("個人データ検索");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void settei_button_onClick(ActionEvent event) {
    	System.out.println("設定画面に来た");
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
			Parent parent = fxmlLoader.load(getClass().getResource("/com/plma/view/settei.fxml"));
	        Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("設定");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void AddStatusPaidLeave_button_onClick(ActionEvent event) {
    	System.out.println("設定画面に来た");
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
			Parent parent = fxmlLoader.load(getClass().getResource("/com/plma/view/AddStatusPaidLeave.fxml"));
	        Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("有給休暇使用状況登録/有給休暇使用状況削除");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void ViewPaidVacationEpiry_onClick(ActionEvent event) {
    	System.out.println("登録画面に来た");
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
			Parent parent = fxmlLoader.load(getClass().getResource("/com/plma/view/ViewPaidVacationExpiryDate.fxml"));
	        Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("有給休暇消滅接近者情報");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void ViewPaidLeaveUndigestedList_onClick(ActionEvent event) {
    	System.out.println("登録画面に来た");
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
			Parent parent = fxmlLoader.load(getClass().getResource("/com/plma/view/ViewPaidLeaveUndigestedListControllerScene.fxml"));
	        Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("有給休暇未消化者情報");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void ManagementBookCreation_onClick(ActionEvent event) {
    	System.out.println("登録画面に来た");
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
			Parent parent = fxmlLoader.load(getClass().getResource("/com/plma/view/ManagementBookCreation.fxml"));
	        Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("有給休暇管理簿作成画面");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }

    

}
