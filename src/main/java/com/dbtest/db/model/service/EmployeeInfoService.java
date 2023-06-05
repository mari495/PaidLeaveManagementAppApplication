package com.dbtest.db.model.service;

import java.sql.Date;
import java.util.Optional;

import com.dbtest.db.model.entity.Department;
import com.dbtest.db.model.entity.EmployeeInfo;
import com.dbtest.db.model.entity.EmployeeInfoDto;


public interface EmployeeInfoService {
	void insertEmployeeInfo(EmployeeInfo empinfo);
	Iterable<EmployeeInfo> selectAll();
	Optional<EmployeeInfo> findById(Integer code);
	void deleteById(Integer code);
	boolean existsById(Integer code);
	Iterable<EmployeeInfo> findByJoinDateAndDepartment(Date joinDate, Integer department_number);
    Iterable<EmployeeInfo> findByParams(String name, Integer department_number, Integer working_days);

    Iterable<Department> selectDepAll();
    Optional<Department> findByDepartmentNumber(Integer department_number);
    Iterable<EmployeeInfoDto> getAllEmployeeInfoDto();
    Optional<EmployeeInfoDto> findByIdEmpDto(Integer code);
    Iterable<EmployeeInfoDto> findByJoinDateAndDepartmentDto(Date joinDate, String department_name);
    Iterable<EmployeeInfoDto> findByParamsDto(String name, String department_name, Integer working_days);

}
