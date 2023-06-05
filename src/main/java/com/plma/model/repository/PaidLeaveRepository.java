package com.plma.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbtest.db.model.entity.PaidLeave;

public interface PaidLeaveRepository extends CrudRepository<PaidLeave, Integer> {

}
