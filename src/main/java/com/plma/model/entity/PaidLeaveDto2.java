package com.plma.model.entity;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PaidLeaveDto2  {
	/* 登録ID */
	private Integer id;
	/* 社員コード */
	private String code;
	/* 入社日 */
	private Date join_date;
	/* ふりがな名字 */
	private String hurigana_lastname;
	/* ふりがな名前 */
	private String hurigana_firstname;
	/* 名字 */
	private String lastname;
	/* 名前 */
	private String firstname;
	/* 部署名 */
	private String department_name;
	/* 所定労働日数 */
	private Integer working_days;
	/* 有給休暇発生日（基準日） */
	private Date reference_date;
	/* 有給休暇付与日数 */
	private Integer granted_paid_leave_days;
	/* 有給休暇残数 */
	private Integer remaining_paid_leave_days;
	/* 有給休暇取得日 */
	private String PaidLeave_date;
	
	
	
	public PaidLeaveDto2(Integer id, String code, Date join_date, String hurigana_lastname, String hurigana_firstname,
			String lastname, String firstname, String department_name, Integer working_days, Date reference_date,
			Integer granted_paid_leave_days, Integer remaining_paid_leave_days, String paidLeave_date) {
		super();
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
		this.granted_paid_leave_days = granted_paid_leave_days;
		this.remaining_paid_leave_days = remaining_paid_leave_days;
		this.PaidLeave_date = paidLeave_date;
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
	public Integer getGranted_paid_leave_days() {
		return granted_paid_leave_days;
	}
	public void setGranted_paid_leave_days(Integer granted_paid_leave_days) {
		this.granted_paid_leave_days = granted_paid_leave_days;
	}
	public Integer getRemaining_paid_leave_days() {
		return remaining_paid_leave_days;
	}
	public void setRemaining_paid_leave_days(Integer remaining_paid_leave_days) {
		this.remaining_paid_leave_days = remaining_paid_leave_days;
	}
	public String getPaidLeave_date() {
		return PaidLeave_date;
	}
	public void setPaidLeave_date(String paidLeave_date) {
		this.PaidLeave_date = paidLeave_date;
	}
	

}
