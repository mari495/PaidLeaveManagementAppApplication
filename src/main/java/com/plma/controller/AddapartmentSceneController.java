package com.plma.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.plma.SpringFXMLLoader;
import com.plma.model.entity.Department;
import com.plma.model.repository.DepartmentRepository;
import com.plma.model.service.EmployeeInfoService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.Window;
@Controller
public class AddapartmentSceneController {

	@Autowired
	private SpringFXMLLoader fxmlLoader;
	@Autowired
	private EmployeeInfoService service;
	 @Autowired
		DepartmentRepository dep_repository;
	 //@Autowired
		//PaidLeaveRepository pl_repository;

    @FXML
    private Button Menu_button;

    @FXML
    private Button add_button;

    @FXML
    private TextArea department_text;

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
    void adddepartmentnameOnClick(ActionEvent event) {
    	//departmentナンバーはとりあえず100から振っていく感じで作成
    	

    	 // 部門番号を固定で100から振っていく
        //Integer nextDepartmentNumber = 100;
       //１仮入れ
    	 int currentRowCount = (int) dep_repository.count();
         Integer nextDepartmentNumber = currentRowCount + 100;
         //adddepartment.setDepartment_number(nextDepartmentNumber);
    	Department adddepartment = new Department(null,nextDepartmentNumber, department_text.getText());
    	
        try  {
        	
           
            // Departmentをデータベースに保存
        	service.insertDepartment(adddepartment);
            
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getCause() instanceof InvocationTargetException) {
                Throwable targetException = ((InvocationTargetException) e.getCause()).getTargetException();
                targetException.printStackTrace();
            }
        }

       
    }
}
