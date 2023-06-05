package com.plma.model.entity;

import java.sql.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfo {
	/* 登録ID */
	@Id
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
	private Integer department_number;
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
}
