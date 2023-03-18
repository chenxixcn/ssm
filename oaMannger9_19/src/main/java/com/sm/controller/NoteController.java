package com.sm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm.bean.Employee;
import com.sm.bean.Note;
import com.sm.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping("/selectNoteByEid.do")
    public ModelAndView selectNoteByEid(int eid, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int  size){
        PageHelper.startPage(page,size);
        List<Note> notes = noteService.selectNoteByEid(eid);
        PageInfo<Note> info =new PageInfo(notes);
        ModelAndView mav = new ModelAndView();
        mav.addObject("info",info);
        mav.addObject("nstatus",null);
        mav.setViewName("/leave.jsp");
        return mav;
    }
    @RequestMapping("/insertNote.do")
    public String insertEmployee(Note note, HttpSession session){
        Employee  emp = (Employee) session.getAttribute("emp");
        noteService.insertNote(note);
        return "/note/selectNoteByEid.do?eid="+emp.getEid();
    }
    @RequestMapping("/selectStatus.do")
    public ModelAndView selectStatus(int nstatus,HttpSession session,@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "5") int  size){
        PageHelper.startPage(page,size);
        List<Note> notes = noteService.selectStatus(nstatus,session);
        PageInfo<Note> info =new PageInfo(notes);
        ModelAndView mav = new ModelAndView();
        mav.addObject("info",info);
        if(0==nstatus){
            mav.addObject("nstatus",0);
        }else{
            mav.addObject("nstatus",1);
        }
        mav.setViewName("/leave.jsp");
        return mav;
    }
    @RequestMapping("/updateStatus.do")
    public String updateStatus(int nid, int nstatus){
        noteService.updateStatus(nid,nstatus);
        return "/note/selectStatus.do?nstatus=0";
    }
    @RequestMapping("/selectByNid.do")
    public ModelAndView selectByNid(int nid){
        Note note = noteService.selectByNid(nid);
        ModelAndView mav = new ModelAndView();
        mav.addObject("note",note);
        mav.setViewName("/editLeave.jsp");
        return mav;
    }
    @RequestMapping("/updateNote.do")
    public String updateNote(Note note){
        noteService.updateNote(note);
        return "/note/selectNoteByEid.do?eid="+note.getEid();
    }
}
