package com.sm.service;

import com.sm.bean.Depart;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DepartService {
    Depart selectByDid(int did);
    //     查询部门
    List<Depart> selectByStatus(int dstatus);
    //    添加部门
    int addDepart(Depart depart);
    //    修改部门
    int updateDepart(Depart depart);
}
