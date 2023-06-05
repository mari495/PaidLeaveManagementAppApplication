package com.plma.model.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbtest.db.model.entity.Department;
import com.dbtest.db.model.entity.EmployeeInfo;
import com.dbtest.db.model.entity.EmployeeInfoDto;
import com.dbtest.db.model.repository.DepartmentRepository;
import com.dbtest.db.model.repository.EmployeeInfoCrudRepository;
import com.dbtest.db.model.repository.PaidLeaveRepository;

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
	public void insertEmployeeInfo(EmployeeInfo empinfo) {
		repository.save(empinfo);
	}

	@Override
	public Iterable<EmployeeInfo> selectAll() {
		return repository.findAll();
	}

	@Override
	public Optional<EmployeeInfo> findById(Integer code){
		return repository.findById(code);

	}

	@Override
	public void deleteById(Integer code) {
		repository.deleteById(code);
	}

	@Override
	public boolean existsById(Integer code) {
		boolean result = repository.existsById(code);
		return result;
	}

	@Override
	public Iterable<EmployeeInfo> findByJoinDateAndDepartment(Date joinDate, Integer department_number){
		return repository.findByJoinDateAndDepartment(joinDate, department_number);
	}

	@Override
	public Iterable<EmployeeInfo> findByParams(String name, Integer department_number, Integer working_days){
		return repository.findByParams(name, department_number, working_days);
	}

	@Override
	public Iterable<Department> selectDepAll(){
		return dep_repository.findAll();
	}

	@Override
	public	Optional<Department> findByDepartmentNumber(Integer department_number){
		return dep_repository.findById(department_number);
	}

	@Override
    public Iterable<EmployeeInfoDto> getAllEmployeeInfoDto() {

        // EmployeeInfoオブジェクトのリストを取得
    	Iterable<EmployeeInfo> iterable = selectAll();
    	Iterable<EmployeeInfoDto> employeeInfoDtoList = getEIDto(iterable);

        // EmployeeInfoDtoオブジェクトのリストを返す
		return employeeInfoDtoList;
    }

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
	public Optional<EmployeeInfoDto> findByIdEmpDto(Integer code){
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

	private Integer getDepNameToNumber(String department_name) {
	    Map<String, Integer> departmentNameToNumberMap = StreamSupport.stream(selectDepAll().spliterator(), false)
	            .collect(Collectors.toMap(Department::getDepartment_name, Department::getDepartment_number));
	    return departmentNameToNumberMap.get(department_name);
	}

}
