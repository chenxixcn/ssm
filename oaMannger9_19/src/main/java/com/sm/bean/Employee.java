package com.sm.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Integer eid;
    private String ename;
    private String epass;
    private String realname;
    private Integer esex;
    private Date entrydate;
    private Date leavedate;
    private Integer position;
    private Integer sal;
    private Integer estatus;
    private Integer did;
    private Depart depart;
}
