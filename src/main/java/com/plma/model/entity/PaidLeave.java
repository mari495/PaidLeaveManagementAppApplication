package com.plma.model.entity;

import java.sql.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaidLeave {
	/* 登録ID */
    @Id
    private Integer id;
    /* 社員コード */
    private Integer code;
    /* 有給休暇取得日 */
    private Date paid_leave_date;
}
