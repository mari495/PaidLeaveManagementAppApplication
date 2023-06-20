package com.plma.model.shareddata;

import org.springframework.stereotype.Component;

import com.plma.model.entity.EmployeeInfo;

@Component
public class SharedData {
    private Iterable<EmployeeInfo> ei;

    public void setEmployeeInfo(Iterable<EmployeeInfo> ei) {
    	this.ei = ei;
    }

    public Iterable<EmployeeInfo> getEmployeeInfo() {
        return this.ei;
    }
}
