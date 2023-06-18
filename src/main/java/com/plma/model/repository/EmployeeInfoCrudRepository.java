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

    @Query("SELECT * FROM Employee_Info WHERE ((:code is null) or (code = :code)) "
    		+ "and (join_date = CAST(:join_date AS DATE)) "
    		+ "and ((:hurigana_lastname is null) or (hurigana_lastname = :hurigana_lastname))"
    		+ "and ((:hurigana_firstname is null) or (hurigana_firstname = :hurigana_firstname))"
    		+ "and ((:lastname is null) or (lastname = :lastname))"
    		+ "and ((:firstname is null) or (firstname = :firstname))"
    		+ "and ((:department_number is null) or (department_number = :department_number))"
    		+ "and ((:working_days is null) or (working_days = :working_days))"
    		)
	Iterable<EmployeeInfo> findByEightParamsWithDate(@Param("code") String code,
										@Param("join_date") Date join_date,
										@Param("hurigana_lastname") String hurigana_lastname,
										@Param("hurigana_firstname") String hurigana_firstname,
										@Param("lastname") String lastname,
										@Param("firstname") String firstname,
										@Param("department_number") Integer department_number,
										@Param("working_days") Integer working_days);

    @Query("SELECT * FROM Employee_Info WHERE ((:code is null) or (code = :code)) "
    		+ "and ((:hurigana_lastname is null) or (hurigana_lastname = :hurigana_lastname))"
    		+ "and ((:hurigana_firstname is null) or (hurigana_firstname = :hurigana_firstname))"
    		+ "and ((:lastname is null) or (lastname = :lastname))"
    		+ "and ((:firstname is null) or (firstname = :firstname))"
    		+ "and ((:department_number is null) or (department_number = :department_number))"
    		+ "and ((:working_days is null) or (working_days = :working_days))"
    		)
	Iterable<EmployeeInfo> findByEightParamsWithoutDate(@Param("code") String code,
										@Param("hurigana_lastname") String hurigana_lastname,
										@Param("hurigana_firstname") String hurigana_firstname,
										@Param("lastname") String lastname,
										@Param("firstname") String firstname,
										@Param("department_number") Integer department_number,
										@Param("working_days") Integer working_days);
}