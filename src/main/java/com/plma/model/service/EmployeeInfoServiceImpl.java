/*このクラスでは、データベースの従業員情報（EmployeeInfo）を操作するためのメソッドを提供しています。
 * また、データベースから取得した情報をDTO（Data Transfer Object）に変換するためのメソッドも提供しています。
 * DTOは、データの転送や表示に特化したオブジェクトであり、
 * クライアントとサーバー間でデータのやり取りを行う際に使用されます。
 *
 * */

package com.plma.model.service;//nakasone

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plma.model.entity.Department;
import com.plma.model.entity.EmployeeInfo;
import com.plma.model.entity.EmployeeInfoDto;
import com.plma.model.entity.PaidLeave;
import com.plma.model.repository.DepartmentRepository;
import com.plma.model.repository.EmployeeInfoCrudRepository;
import com.plma.model.repository.PaidLeaveRepository;

@Service
@Transactional
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
	/** Repository：注入 */
	@Autowired
	EmployeeInfoCrudRepository repository;
	@Autowired
	DepartmentRepository dep_repository;
	@Autowired
	PaidLeaveRepository pl_repository;

	@Override
	public void insertEmployeeInfo(EmployeeInfo empinfo) {// 従業員情報をデータベースに挿入
		repository.save(empinfo);
	}

	@Override
	public Iterable<EmployeeInfo> selectAll() {// すべての従業員情報を取得
		return repository.findAll();
	}

	@Override
	public Optional<EmployeeInfo> findById(Integer code){//指定された従業員コードに基づいて従業員情報を検索
		return repository.findById(code);

	}

	@Override
	public void deleteById(Integer code) {//指定された従業員コードに基づいて従業員情報を削除
		repository.deleteById(code);
	}

	@Override
	public boolean existsById(Integer code) {//指定された従業員コードが存在するかどうかを確認
		boolean result = repository.existsById(code);
		return result;
	}

	@Override
	public Iterable<EmployeeInfo> findByJoinDateAndDepartment(Date joinDate, Integer department_number){//入社日と部署番号に基づいて従業員情報を検索
		return repository.findByJoinDateAndDepartment(joinDate, department_number);
	}

	@Override
	public Iterable<EmployeeInfo> findByParams(String name, Integer department_number, Integer working_days){//名前、部署番号、所定労働日数に基づいて従業員情報を検索
		return repository.findByParams(name, department_number, working_days);
	}

	@Override
	public Iterable<Department> selectDepAll(){// すべての部署情報を取得
		return dep_repository.findAll();
	}

	@Override
	public	Optional<Department> findByDepartmentNumber(Integer department_number){//指定された部署番号に基づいて部署情報を検索
		return dep_repository.findById(department_number);
	}

	@Override
    public Iterable<EmployeeInfoDto> getAllEmployeeInfoDto() {//すべての従業員情報を従業員情報DTO（EmployeeInfoDto）のリストとして取得

        // EmployeeInfoオブジェクトのリストを取得
    	Iterable<EmployeeInfo> iterable = selectAll();
    	Iterable<EmployeeInfoDto> employeeInfoDtoList = getEIDto(iterable);

        // EmployeeInfoDtoオブジェクトのリストを返す
		return employeeInfoDtoList;
    }
/*EmployeeInfoオブジェクトをEmployeeInfoDtoオブジェクトに変換するためのメソッドです。
 * このメソッドでは、部署番号と部署名のマッピングを作成し、
EmployeeInfoオブジェクトの各フィールドを使用してEmployeeInfoDtoオブジェクトを作成
 * */
	private EmployeeInfoDto convertToDto(EmployeeInfo employeeInfo) {
    	Map<Integer, String> departmentNumberToNameMap = StreamSupport.stream(selectDepAll().spliterator(), false)
    		    .collect(Collectors.toMap(Department::getDepartment_number, Department::getDepartment_name));

	    return new EmployeeInfoDto(
	        employeeInfo.getId(),
	        employeeInfo.getCode(),
	        employeeInfo.getJoin_date(),
	        employeeInfo.getHurigana_lastname(),
	        employeeInfo.getHurigana_firstname(),
	        employeeInfo.getLastname(),
	        employeeInfo.getFirstname(),
	        departmentNumberToNameMap.get(employeeInfo.getDepartment_number()),
	        employeeInfo.getWorking_days(),
	        employeeInfo.getReference_date(),
	        employeeInfo.getAnnual_paid_leave_report_date(),
	        employeeInfo.getGranted_paid_leave_days(),
	        employeeInfo.getRemaining_paid_leave_days()
	    );
	}

	@Override
	public Optional<EmployeeInfoDto> findByIdEmpDto(Integer code){//指定された従業員コードに基づいて従業員情報DTOを検索
		Optional<EmployeeInfo> employeeInfo = findById(code);
		Optional<EmployeeInfoDto> empinfodto = employeeInfo.map(this::convertToDto);
		return empinfodto;
	}

	@Override
	public Iterable<EmployeeInfoDto> findByJoinDateAndDepartmentDto(Date joinDate, String department_name){

        // EmployeeInfoオブジェクトのリストを取得
		Iterable<EmployeeInfo> iterable = repository.findByJoinDateAndDepartment(joinDate, getDepNameToNumber(department_name));
		Iterable<EmployeeInfoDto> employeeInfoDtoList = getEIDto(iterable);

        // EmployeeInfoDtoオブジェクトのリストを返す
		return employeeInfoDtoList;
	}

	@Override
	public Iterable<EmployeeInfoDto> findByParamsDto(String name, String department_name, Integer working_days){
		System.out.println("findByParamsDto : " + getDepNameToNumber(department_name));
        // EmployeeInfoオブジェクトのリストを取得
    	Iterable<EmployeeInfo> iterable = repository.findByParams(name, getDepNameToNumber(department_name), working_days);
    	Iterable<EmployeeInfoDto> employeeInfoDtoList = getEIDto(iterable);

        // EmployeeInfoDtoオブジェクトのリストを返す
		return employeeInfoDtoList;

	}

	@Override
	public Iterable<EmployeeInfo> findByEightParamsWithDate(String code,
															Date join_date,
															String hurigana_lastname,
															String hurigana_firstname,
															String lastname,
															String firstname,
															Integer department_number,
															Integer working_days)
	{
		return repository.findByEightParamsWithDate(code, join_date, hurigana_lastname, hurigana_firstname, lastname, firstname, department_number, working_days);
    }

	@Override
	public Iterable<EmployeeInfo> findByEightParamsWithoutDate(String code,
															String hurigana_lastname,
															String hurigana_firstname,
															String lastname,
															String firstname,
															Integer department_number,
															Integer working_days)
	{
		return repository.findByEightParamsWithoutDate(code, hurigana_lastname, hurigana_firstname, lastname, firstname, department_number, working_days);
    }

	@Override
	public Iterable<EmployeeInfo> findByEightParams(String code,
			Date join_date,
			String hurigana_lastname,
			String hurigana_firstname,
			String lastname,
			String firstname,
			Integer department_number,
			Integer working_days)
	{
		if (join_date == null) {
		    return findByEightParamsWithoutDate(code, hurigana_lastname, hurigana_firstname, lastname, firstname, department_number, working_days);
		} else {
		    return findByEightParamsWithDate(code, join_date, hurigana_lastname, hurigana_firstname, lastname, firstname, department_number, working_days);
		}

	}

	@Override
	public void insertDepartment(Department dm) {// 従業員情報をデータベースに挿入
		dep_repository.save(dm);
	}

	@Override
	public void insertPaidLeave(PaidLeave pl) {
		pl_repository.save(pl);
	}

/*
 * EmployeeInfoオブジェクトのリストをEmployeeInfoDtoオブジェクトのリストに変換するためのメソッド
 * 部署番号と部署名のマッピングを作成し、EmployeeInfoオブジェクトをEmployeeInfoDtoオブジェクトに変換*/
	private Iterable<EmployeeInfoDto> getEIDto(Iterable<EmployeeInfo> iterable){
        // 部署番号をキーとした部署名のMapを作成する処理
    	Map<Integer, String> departmentNumberToNameMap = StreamSupport.stream(selectDepAll().spliterator(), false)
    		    .collect(Collectors.toMap(Department::getDepartment_number, Department::getDepartment_name));

        // EmployeeInfoオブジェクトのリストを取得
		List<EmployeeInfo> employeeInfoList = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());

        // EmployeeInfoオブジェクトをEmployeeInfoDtoオブジェクトに変換
		List<EmployeeInfoDto> employeeInfoDtoList = employeeInfoList.stream()
			    .map(employeeInfo -> new EmployeeInfoDto(
			        employeeInfo.getId(),
			        employeeInfo.getCode(),
			        employeeInfo.getJoin_date(),
			        employeeInfo.getHurigana_lastname(),
			        employeeInfo.getHurigana_firstname(),
			        employeeInfo.getLastname(),
			        employeeInfo.getFirstname(),
			        departmentNumberToNameMap.get(employeeInfo.getDepartment_number()),
			        employeeInfo.getWorking_days(),
			        employeeInfo.getReference_date(),
			        employeeInfo.getAnnual_paid_leave_report_date(),
			        employeeInfo.getGranted_paid_leave_days(),
			        employeeInfo.getRemaining_paid_leave_days()
			    ))
			    .collect(Collectors.toList());

		return employeeInfoDtoList;
	}

	private Integer getDepNameToNumber(String department_name) {//、部署名を部署番号に変換するためのメソッドです。部署名と部署番号のマッピングを作成し、指定された部署名に対応する部署番号を返す
	    Map<String, Integer> departmentNameToNumberMap = StreamSupport.stream(selectDepAll().spliterator(), false)
	            .collect(Collectors.toMap(Department::getDepartment_name, Department::getDepartment_number));
	    return departmentNameToNumberMap.get(department_name);
	}

}
