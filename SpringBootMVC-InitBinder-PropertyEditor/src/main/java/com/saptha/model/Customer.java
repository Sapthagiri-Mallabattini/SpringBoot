package com.saptha.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import lombok.Data;

@Data
public class Customer {
	private Integer cno;
	private String cname;
	private Date dob;
	private LocalDate doj;
	private LocalDateTime dop=LocalDateTime.now();
	private LocalTime tob;
}
