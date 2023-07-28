//有給休暇管理簿作成用のクラスです。
package com.plma.model.entity;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PaidLeaveDto3  {
	/* 年度 */
	private String fiscal_year;
	/* 登録ID */
	private Integer id;
	/* 社員コード */
	private String code;
	/* 入社日 */
	private Date join_date;
	
	/* 名字 */
	private String lastname;
	/* 名前 */
	private String firstname;
	/* ふりがな名字 */
	private String hurigana_lastname;
	/* ふりがな名前 */
	private String hurigana_firstname;
	/* 部署名 */
	private String department_name;
	/* 所定労働日数 */
	private Integer working_days;
	/* 有給休暇発生日（基準日） */
	private Date reference_date;
	
	/*管理簿作成日 */
	private Date annual_paid_leave_report_date;
	
	/* 前年度繰越日数 */
	private Integer fiscal_year_carried_over_day;
	
	/* 有給休暇付与日数 */
	private Integer granted_paid_leave_days;
	
	/* 有給休暇使用日数 */
	private Integer Number_of_days_used;
	/* 有給休暇残数 */
	private Integer remaining_paid_leave_days;
	/* 有給休暇取得日 */
	private Date PaidLeave_date;
	
	
	
	public PaidLeaveDto3(String fiscal_year,Integer id, String code, Date join_date, String hurigana_lastname, String hurigana_firstname,
			String lastname, String firstname, String department_name, Integer working_days, Date reference_date,Date annual_paid_leave_report_date,Integer fiscal_year_carried_over_day,
			Integer granted_paid_leave_days,Integer Number_of_days_used, Integer remaining_paid_leave_days, Date paidLeave_date) {
		super();
		this.fiscal_year=fiscal_year;
		this.id = id;
		this.code = code;
		this.join_date = join_date;
		this.hurigana_lastname = hurigana_lastname;
		this.hurigana_firstname = hurigana_firstname;
		this.lastname = lastname;
		this.firstname = firstname;
		this.department_name = department_name;
		this.working_days = working_days;
		this.reference_date = reference_date;
		this.annual_paid_leave_report_date = annual_paid_leave_report_date;
		
		this.fiscal_year_carried_over_day=fiscal_year_carried_over_day;
		
		this.granted_paid_leave_days = granted_paid_leave_days;
		this.Number_of_days_used = Number_of_days_used;
		
		this.remaining_paid_leave_days = remaining_paid_leave_days;
		this.PaidLeave_date = paidLeave_date;
	}
	
	public String getFiscal_year() {
		return fiscal_year;
	}
	public void setFiscal_year(String fiscal_year) {
		this.fiscal_year = fiscal_year;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public String getHurigana_lastname() {
		return hurigana_lastname;
	}
	public void setHurigana_lastname(String hurigana_lastname) {
		this.hurigana_lastname = hurigana_lastname;
	}
	public String getHurigana_firstname() {
		return hurigana_firstname;
	}
	public void setHurigana_firstname(String hurigana_firstname) {
		this.hurigana_firstname = hurigana_firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public Integer getWorking_days() {
		return working_days;
	}
	public void setWorking_days(Integer working_days) {
		this.working_days = working_days;
	}
	public Date getReference_date() {
		return reference_date;
	}
	public void setReference_date(Date reference_date) {
		this.reference_date = reference_date;
	}
	public Date getAnnual_paid_leave_report_date() {
		return annual_paid_leave_report_date;
	}
	public void setAnnual_paid_leave_report_date(Date annual_paid_leave_report_date) {
		this.annual_paid_leave_report_date = annual_paid_leave_report_date;
	}
	
	
	
	
	
	

	public Integer getFiscal_year_carried_over_day() {
		return fiscal_year_carried_over_day;
	}
	public void setFiscal_year_carried_over_day(Integer fiscal_year_carried_over_day) {
		this.fiscal_year_carried_over_day = fiscal_year_carried_over_day;
	}
	
	
	public Integer getGranted_paid_leave_days() {
		return granted_paid_leave_days;
	}
	public void setGranted_paid_leave_days(Integer granted_paid_leave_days) {
		this.granted_paid_leave_days = granted_paid_leave_days;
	}

	public Integer getNumber_of_days_used() {
		return Number_of_days_used;
	}
	public void setNumber_of_days_used(Integer Number_of_days_used) {
		this.Number_of_days_used = Number_of_days_used;
	}
	
	
	
	public Integer getRemaining_paid_leave_days() {
		return remaining_paid_leave_days;
	}
	public void setRemaining_paid_leave_days(Integer remaining_paid_leave_days) {
		this.remaining_paid_leave_days = remaining_paid_leave_days;
	}
	public Date getPaidLeave_date() {
		return PaidLeave_date;
	}
	public void setPaidLeave_date(Date paidLeave_date) {
		this.PaidLeave_date = paidLeave_date;
	}
	

}
