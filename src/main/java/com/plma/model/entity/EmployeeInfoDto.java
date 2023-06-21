/*
 * このコードでは、TableViewとTableColumnを使用して列にデータを表示しています。
 * 例えば、id_col.setCellValueFactory(new PropertyValueFactory<EmployeeInfoDto, Integer>("id"))は、
 * id_colというTableColumnにEmployeeInfoDtoオブジェクトのgetId()メソッドを呼び出して値を取得し、
 * その値を表示するように設定しています。
 * 同様に、他の列もそれぞれ対応するプロパティ名と型を指定して設定しています。
 * */
package com.plma.model.entity;//nakasone

import java.sql.Date;

public class EmployeeInfoDto {
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
	/* 年次有給休暇管理簿作成日 */
	private Date annual_paid_leave_report_date;
	/* 有給休暇付与日数 */
	private Integer granted_paid_leave_days;
	/* 有給休暇残数 */
	private Integer remaining_paid_leave_days;



	public Integer getId() {
		return id;
	}



	public String getCode() {
		return code;
	}



	public Date getJoin_date() {
		return join_date;
	}



	public String getHurigana_lastname() {
		return hurigana_lastname;
	}



	public String getHurigana_firstname() {
		return hurigana_firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public String getFirstname() {
		return firstname;
	}



	public String getDepartment_name() {
		return department_name;
	}



	public Integer getWorking_days() {
		return working_days;
	}



	public Date getReference_date() {
		return reference_date;
	}



	public Date getAnnual_paid_leave_report_date() {
		return annual_paid_leave_report_date;
	}



	public Integer getGranted_paid_leave_days() {
		return granted_paid_leave_days;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}



	public void setHurigana_lastname(String hurigana_lastname) {
		this.hurigana_lastname = hurigana_lastname;
	}



	public void setHurigana_firstname(String hurigana_firstname) {
		this.hurigana_firstname = hurigana_firstname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}



	public void setWorking_days(Integer working_days) {
		this.working_days = working_days;
	}



	public void setReference_date(Date reference_date) {
		this.reference_date = reference_date;
	}



	public void setAnnual_paid_leave_report_date(Date annual_paid_leave_report_date) {
		this.annual_paid_leave_report_date = annual_paid_leave_report_date;
	}



	public void setGranted_paid_leave_days(Integer granted_paid_leave_days) {
		this.granted_paid_leave_days = granted_paid_leave_days;
	}



	public void setRemaining_paid_leave_days(Integer remaining_paid_leave_days) {
		this.remaining_paid_leave_days = remaining_paid_leave_days;
	}



	public Integer getRemaining_paid_leave_days() {
		return remaining_paid_leave_days;
	}



	public EmployeeInfoDto(Integer id, String code, Date join_date, String hurigana_lastname, String hurigana_firstname, String lastname, String firstname, String department_name, Integer working_days, Date reference_date, Date annual_paid_leave_report_date, Integer granted_paid_leave_days, Integer remaining_paid_leave_days) {
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
		this.granted_paid_leave_days = granted_paid_leave_days;
		this.remaining_paid_leave_days = remaining_paid_leave_days;
	}
}
