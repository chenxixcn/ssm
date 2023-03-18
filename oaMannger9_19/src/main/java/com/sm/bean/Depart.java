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
public class Depart {
    private Integer did;
    private String dname;
    private String duty;
    private Date credate;
    private Integer dstatus;
}
