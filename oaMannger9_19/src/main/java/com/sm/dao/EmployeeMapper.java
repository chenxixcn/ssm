package com.sm.dao;

import com.sm.bean.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    Employee selectEmployeeByNameAndPass(@Param("ename") String ename, @Param("epass") String epass);

    int updatePass(@Param("eid") Integer eid, @Param("epass") String epass);

    List<Employee> selectEmployeeByStatus(Integer estatus);

    List<Employee> selectEmployeeByRealName(@Param("estatus") Integer estatus, @Param("realname") String realname);

    int insertEmployee(Employee employee);

    int updateEmployee(Employee employee);

    Employee selectEmployeeByEid(Integer eid);

    List<Integer> selectEidByPosition(int position);

    int selectByDid(int did);
}
