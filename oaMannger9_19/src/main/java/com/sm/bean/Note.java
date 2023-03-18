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
public class Note {
    private Integer nid;
    private String title;
    private String context;
    private Date startdate;
    private Date enddate;
    private Float length;
    private Date subdate;
    private Integer nstatus;
    private Date reldate;
    private Integer eid;
    private Employee employee;
}
