package com.plma.model.entity;

import java.sql.Date;



public class PaidLeave2 extends PaidLeave {

	private Integer a;
	private Integer b;
	private Integer c;
	

	public PaidLeave2(Integer id, String code, Date paid_leave_date,Integer a, Integer b, Integer c) {
		super(id, code, paid_leave_date);
		// TODO 自動生成されたコンストラクター・スタブ
		
		this.a = a;
		this.b = b;
		this.c = c;
}
}
