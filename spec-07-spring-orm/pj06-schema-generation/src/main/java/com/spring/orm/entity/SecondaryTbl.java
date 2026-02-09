package com.spring.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SecondaryTables;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "main_tbl")
//@SecondaryTable(name = "sub_table")
@SecondaryTables({ @SecondaryTable(name = "sub_tbl"), @SecondaryTable(name = "oth_tbl") })
public class SecondaryTbl {

	@Id
	private int id;

	private String name;

	@Column(table = "sub_tbl", name = "information")
	private String subInformation;

	@Column(table = "oth_tbl", name = "otherInfo")
	private String othInfo;
}
