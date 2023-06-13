package com.plma.model.repository;//nakasone

import java.sql.Date;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.plma.model.entity.EmployeeInfo;

public interface EmployeeInfoCrudRepository extends CrudRepository<EmployeeInfo, Integer>{
    @Query("SELECT * FROM Employee_Info WHERE join_date = :joinDate AND department_number = :department_number")
    Iterable<EmployeeInfo> findByJoinDateAndDepartment(@Param("joinDate") Date joinDate, @Param("department_number") Integer department_number);
    @Query("SELECT * FROM Employee_Info WHERE ((:lastname is null) or (lastname = :lastname)) and ((:department_number is null) or (department_number = :department_number)) and ((:working_days is null) or (working_days = :working_days))")
	Iterable<EmployeeInfo> findByParams(@Param("lastname") String lastname, @Param("department_number") Integer department_number, @Param("working_days") Integer working_days);
}
