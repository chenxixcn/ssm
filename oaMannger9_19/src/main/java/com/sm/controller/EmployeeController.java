package com.sm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm.bean.Depart;
import com.sm.bean.Employee;
import com.sm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/login.do")
    public String login(String ename, String epass, HttpSession session){
        Employee emp=employeeService.login(ename,epass);
        if(emp!=null){
            session.setAttribute("emp",emp);
            return "/index.jsp";
        }
        return "/login.jsp";
    }
    @RequestMapping("/myInfo.do")
    public String myInfo() {
        return "/myinfo.jsp";
    }
    @RequestMapping("/loginOut.do")
    public String loginOut(HttpSession session) {
        session.removeAttribute("emp");
        return "/login.jsp";
    }
    @ResponseBody
    @RequestMapping("/updatePass.do")
    public int updatePass(String epass,HttpSession session) {
        Employee emp= (Employee) session.getAttribute("emp");
        int eid=emp.getEid();
        int ok=employeeService.updatePass(eid,epass);
        System.out.println(epass);
        return ok;
    }
    @RequestMapping("/selectEmployeeByStatus.do")
    public ModelAndView selectEmployeeByStatus(Integer estatus,@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "5") int  size) {
        System.out.println("这是selectEmployeeByStatus："+page);
        PageHelper.startPage(page,size);
        List<Employee> employees=employeeService.selectEmployeeByStatus(estatus);
        PageInfo<Employee> info =new PageInfo(employees);
        ModelAndView mav = new ModelAndView();
        mav.addObject("info",info);
        mav.addObject("estatus",estatus);
        mav.setViewName("/user.jsp");
        return mav;
    }
    @RequestMapping("/selectEmployeeByRealName.do")
    public ModelAndView selectEmployeeByRealName(Integer estatus,String realname,@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "5") int  size) {
        PageHelper.startPage(page,size);
        List<Employee> employees=employeeService.selectEmployeeByRealName(estatus,realname);
        PageInfo<Employee> info =new PageInfo(employees);
        ModelAndView mav = new ModelAndView();
        mav.addObject("info",info);
        mav.addObject("estatus",estatus);
        mav.setViewName("/user.jsp");
        return mav;
    }
    @RequestMapping("/insertEmployee.do")
    public String insertEmployee(Employee employee){
        employeeService.insertEmployee(employee);
        return "/employee/selectEmployeeByStatus.do?estatus=0";
    }
    @RequestMapping("/updateEmployee.do")
    public String updateEmployee(Employee employee,@RequestParam(defaultValue = "1") int page){
        Integer estatus=employee.getEstatus();
        employeeService.updateEmployee(employee);
        String str="estatus="+estatus+"&page="+page;
        System.out.println(str);
        return "/employee/selectEmployeeByStatus.do?"+str;
    }
    @RequestMapping("/selectEmployeeByEid.do")
    public ModelAndView selectEmployeeByEid(Integer eid,@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "0") Integer dstatus){
        Employee employee=employeeService.selectEmployeeByEid(eid);
        ModelAndView mav = new ModelAndView();
        mav.addObject("employees",employee);
        List<Depart> departs = employeeService.selectDepart(dstatus);
        mav.addObject("departs",departs);
        mav.addObject("page",page);
        mav.setViewName("/editUser.jsp");
        return mav;
    }
    @RequestMapping("/selectDepart.do")
    public ModelAndView selectDepart(Integer dstatus){
        List<Depart> departs = employeeService.selectDepart(dstatus);
        ModelAndView mav = new ModelAndView();
        mav.addObject("departs",departs);
        mav.setViewName("/addUser.jsp");
        return mav;
    }
}
