/*従業員情報（EmployeeInfo）に関する操作を定義するためのインターフェースです。
 * 具体的には、従業員情報の追加、取得、削除、検索などのメソッドが宣言されています。*/

package com.plma.model.service;//nakasone

import java.sql.Date;
import java.util.Optional;

import com.plma.model.entity.Department;
import com.plma.model.entity.EmployeeInfo;
import com.plma.model.entity.EmployeeInfoDto;
import com.plma.model.entity.PaidLeave;


public interface EmployeeInfoService {
	void insertEmployeeInfo(EmployeeInfo empinfo);//従業員情報をデータベースに追加
	Iterable<EmployeeInfo> selectAll();//データベース内のすべての従業員情報を取得
	Optional<EmployeeInfo> findById(Integer code);//指定された従業員コードに基づいて従業員情報を検索
	void deleteById(Integer code);//指定された従業員コードに基づいて従業員情報を削除
	boolean existsById(Integer code);//指定された従業員コードが存在するかどうかを確認
	Iterable<EmployeeInfo> findByJoinDateAndDepartment(Date joinDate, Integer department_number);//入社日と部署番号に基づいて従業員情報を検索
    Iterable<EmployeeInfo> findByParams(String name, Integer department_number, Integer working_days);//名前、部署番号、所定労働日数に基づいて従業員情報を検索

    Iterable<Department> selectDepAll();
    Optional<Department> findByDepartmentNumber(Integer department_number);// 指定された部署番号に基づいて部署情報を検索

    /*全ての従業員情報をDTO形式で取得します。DTOはEmployeeInfoDto型のオブジェクトであり、
     * 返されるオブジェクトはIterable<EmployeeInfoDto>型です。*/
    Iterable<EmployeeInfoDto> getAllEmployeeInfoDto();


    /*指定された従業員コードに基づいて従業員情報をDTO形式で検索します。
     * 返されるオブジェクトはOptional<EmployeeInfoDto>型です。*/
    Optional<EmployeeInfoDto> findByIdEmpDto(Integer code);

    /* 入社日と部署名に基づいて従業員情報をDTO形式で検索します。
     * 返されるオブジェクトはIterable<EmployeeInfoDto>型です。*/
    Iterable<EmployeeInfoDto> findByJoinDateAndDepartmentDto(Date joinDate, String department_name);

    /*名前、部署名、所定労働日数に基づいて従業員情報をDTO形式で検索します。
     * 返されるオブジェクトはIterable<EmployeeInfoDto>型です。*/
    Iterable<EmployeeInfoDto> findByParamsDto(String name, String department_name, Integer working_days);

    Iterable<EmployeeInfo> findByEightParamsWithDate(String code,
													Date join_date,
													String hurigana_lastname,
													String hurigana_firstname,
													String lastname,
													String firstname,
													Integer department_number,
													Integer working_days);

    Iterable<EmployeeInfo> findByEightParamsWithoutDate(String code,
			String hurigana_lastname,
			String hurigana_firstname,
			String lastname,
			String firstname,
			Integer department_number,
			Integer working_days);

    Iterable<EmployeeInfo> findByEightParams(String code,
			Date join_date,
			String hurigana_lastname,
			String hurigana_firstname,
			String lastname,
			String firstname,
			Integer department_number,
			Integer working_days);

    void insertDepartment(Department dm);
    void insertPaidLeave(PaidLeave pl);
    Iterable<Department> getDepartment();
	EmployeeInfoDto convertToDto(EmployeeInfo emp);
	Iterable<PaidLeave> getPaidLeave();
	
	//PaidLeaveDBからデータ削除用
	void deleteByPaidLeave(Date paid_leave_date,String co);
}
