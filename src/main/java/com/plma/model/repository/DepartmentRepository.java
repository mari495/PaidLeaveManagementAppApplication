package com.plma.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.plma.model.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
