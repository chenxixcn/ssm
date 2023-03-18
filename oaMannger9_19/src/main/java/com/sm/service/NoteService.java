package com.sm.service;

import com.sm.bean.Note;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface NoteService {
    List<Note> selectNoteByEid(int eid);
    int insertNote(Note note);
    List<Note> selectStatus(int nstatus, HttpSession session);

    int updateStatus(int nid,int nstatus);

    Note selectByNid(int nid);

    int updateNote(Note note);
}
