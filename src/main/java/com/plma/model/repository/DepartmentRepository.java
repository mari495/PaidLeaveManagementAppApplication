package com.plma.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbtest.db.model.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
