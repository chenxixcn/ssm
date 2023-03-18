package com.sm.service;

import com.sm.bean.Depart;
import com.sm.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeService {
    Employee login(String ename,String epass);

    int updatePass(Integer eid, String epass);

    List<Employee> selectEmployeeByStatus(Integer estatus);

    List<Employee> selectEmployeeByRealName( Integer estatus,String realname);

    int insertEmployee(Employee employee);

    int updateEmployee(Employee employee);

    Employee selectEmployeeByEid(Integer eid);

    List<Depart> selectDepart(Integer dstatus);
}
