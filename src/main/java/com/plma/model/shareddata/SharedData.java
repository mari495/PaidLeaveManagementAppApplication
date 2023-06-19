package com.plma.model.shareddata;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.plma.model.entity.EmployeeInfo;

@Component
public class SharedData {
    private EmployeeInfo ei;

    public void setEmployeeInfoOneByOne(String code,
			Date join_date,
			String hurigana_lastname,
			String hurigana_firstname,
			String lastname,
			String firstname,
			Integer department_number,
			Integer working_days)
    {
        this.ei.setCode(code);
        this.ei.setJoin_date(join_date);
        this.ei.setHurigana_lastname(hurigana_lastname);
        this.ei.setHurigana_firstname(hurigana_firstname);
        this.ei.setLastname(lastname);
        this.ei.setFirstname(firstname);
        this.ei.setDepartment_number(department_number);
        this.ei.setWorking_days(working_days);
    }

    public void setEmployeeInfo(EmployeeInfo ei) {
    	this.ei = ei;
    }

    public EmployeeInfo getEmployeeInfo() {
        return this.ei;
    }
}
