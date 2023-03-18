package com.sm.service.Impl;

import com.sm.bean.Depart;
import com.sm.dao.DepartMapper;
import com.sm.dao.EmployeeMapper;
import com.sm.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartMapper departMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public Depart selectByDid(int did) {
        return departMapper.selectByDid(did);
    }

    @Override
    public List<Depart> selectByStatus(int dstatus) {
        return departMapper.selectByStatus(dstatus);
    }

    @Override
    public int addDepart(Depart depart) {
        depart.setDstatus(0);
        depart.setCredate(new Date());
        return departMapper.addDepart(depart);
    }


    @Override
    public int updateDepart(Depart depart) {
        //判断是否为状态修改
        if(depart.getDname()!=null){
            return departMapper.updateDepart(depart);
        }
        //判断是否有员工在此部门
        if(employeeMapper.selectByDid(depart.getDid())!=0){
            return 0;
        }
        //改变状态
        if(depart.getDstatus()==0){
            depart.setDstatus(1);
        }else {
            depart.setDstatus(0);
        }

        return departMapper.updateDepart(depart);
    }


}
