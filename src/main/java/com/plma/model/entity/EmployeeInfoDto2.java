package com.plma.model.entity;

import java.sql.Date;

public class EmployeeInfoDto2 extends EmployeeInfoDto {
	
	private Integer a;
	private Integer b;
	private Integer c;
	

	public EmployeeInfoDto2(Integer id, String code, Date join_date, String hurigana_lastname,
			String hurigana_firstname, String lastname, String firstname, String department_name, Integer working_days,
			Date reference_date, Date annual_paid_leave_report_date, Integer granted_paid_leave_days,
			Integer remaining_paid_leave_days, Integer a, Integer b, Integer c) {
		super(id, code, join_date, hurigana_lastname, hurigana_firstname, lastname, firstname, department_name, working_days,
				reference_date, annual_paid_leave_report_date, granted_paid_leave_days, remaining_paid_leave_days);
		// TODO 自動生成されたコンストラクター・スタブ
		
		this.a = a;
		this.b = b;
		this.c = c;
	}

}
