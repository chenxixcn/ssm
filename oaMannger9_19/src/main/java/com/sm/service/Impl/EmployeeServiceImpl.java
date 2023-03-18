package com.sm.service.Impl;

import com.sm.bean.Depart;
import com.sm.bean.Employee;
import com.sm.dao.DepartMapper;
import com.sm.dao.EmployeeMapper;
import com.sm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public Employee login(String ename, String epass) {
        return employeeMapper.selectEmployeeByNameAndPass(ename,epass);
    }

    @Override
    public int updatePass(Integer eid, String epass) {
        return employeeMapper.updatePass(eid,epass);
    }

    @Override
    public List<Employee> selectEmployeeByStatus(Integer estatus) {
        return employeeMapper.selectEmployeeByStatus(estatus);
    }

    @Override
    public List<Employee> selectEmployeeByRealName(Integer estatus, String realname) {
        return employeeMapper.selectEmployeeByRealName(estatus,realname);
    }

    @Override
    public int insertEmployee(Employee employee) {
        employee.setEstatus(0);
        employee.setEntrydate(new Date());
        return employeeMapper.insertEmployee(employee);
    }

    @Override
    public int updateEmployee(Employee employee) {
            if(employee.getEname()!=null){
                return employeeMapper.updateEmployee(employee);
            }
            if (employee.getEstatus()==0){
                employee.setEstatus(1);
                employee.setLeavedate(new Date());
                return employeeMapper.updateEmployee(employee);
            }
                employee.setEstatus(0);
                employee.setLeavedate(null);
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public Employee selectEmployeeByEid(Integer eid) {
        return employeeMapper.selectEmployeeByEid(eid);
    }

    @Autowired
    private DepartMapper departMapper;

    @Override
    public List<Depart> selectDepart(Integer dstatus) {
        return departMapper.selectByStatus(dstatus);
    }


}
