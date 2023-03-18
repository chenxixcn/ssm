package com.sm.dao;

import com.sm.bean.Depart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartMapper {
//    根据id查询部门
    Depart selectByDid(Integer did);
//     查询部门
    List<Depart> selectByStatus(Integer dstatus);
//    添加部门
    int addDepart(Depart depart);
//    修改部门
    int updateDepart(Depart depart);

}
