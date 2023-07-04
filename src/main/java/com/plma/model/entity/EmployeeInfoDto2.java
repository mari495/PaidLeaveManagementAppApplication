package com.plma.model.entity;

import java.sql.Date;

public class EmployeeInfoDto2 extends EmployeeInfoDto {
	
	private Integer Number_of_days_used;//有給休暇使用日数（PaidLeaveDBから回数を取得）
	private Date Expiry_date;//消滅日（基準日からに二年後）
	private String Alert;//有給接近情報アラート
	

	public EmployeeInfoDto2(Integer id, String code, Date join_date, String hurigana_lastname,
			String hurigana_firstname, String lastname, String firstname, String department_name, Integer working_days,
			Date reference_date, Date annual_paid_leave_report_date, Integer granted_paid_leave_days,
			Integer remaining_paid_leave_days, Integer number_of_days_used, Date expiry_date, String alert) {
		super(id, code, join_date, hurigana_lastname, hurigana_firstname, lastname, firstname, department_name, working_days,
				reference_date, annual_paid_leave_report_date, granted_paid_leave_days, remaining_paid_leave_days);
		// TODO 自動生成されたコンストラクター・スタブ
		
		this.Number_of_days_used =number_of_days_used;
		this.Expiry_date = expiry_date;
		
		this.Alert = alert;
		
	}
	
	

}
