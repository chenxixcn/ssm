package com.sm.service.Impl;

import com.sm.bean.Employee;
import com.sm.bean.Note;
import com.sm.dao.EmployeeMapper;
import com.sm.dao.NoteMapper;
import com.sm.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
@Service
@Transactional
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Note> selectNoteByEid(int eid) {
        return noteMapper.selectNoteByEid(eid);
    }

    @Override
    public int insertNote(Note note) {
        return noteMapper.insertNote(note);
    }

    @Override
    public List<Note> selectStatus(int nstatus, HttpSession session) {
        Employee emp = (Employee) session.getAttribute("emp");
        int position=emp.getPosition()+1;
        List<Integer> eids=employeeMapper.selectEidByPosition(position);
        if(position==1){
            eids.add(emp.getEid());
        }
        List<Note> notes=noteMapper.selectStatus(nstatus,eids);
        return notes;
    }

    @Override
    public int updateStatus(int nid, int nstatus) {
        return noteMapper.updateStatus(nid,nstatus);
    }

    @Override
    public Note selectByNid(int nid) {
        return noteMapper.selectByNid(nid);
    }

    @Override
    public int updateNote(Note note) {
        note.setSubdate(new Date());
        note.setNstatus(0);
        return noteMapper.updateNote(note);
    }
}
