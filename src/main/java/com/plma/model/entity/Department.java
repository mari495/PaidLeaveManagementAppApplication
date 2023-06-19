package com.plma.model.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	@Id
	private Integer id;
	/* 部署番号 */
	private Integer department_number;
	/* 部署名 */
	private String department_name;
}
