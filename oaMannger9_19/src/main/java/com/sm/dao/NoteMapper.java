package com.sm.dao;

import com.sm.bean.Note;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteMapper {
    List<Note> selectNoteByEid(int eid);

    int insertNote(Note note);

    List<Note> selectStatus(@Param("nstatus") int nstatus,@Param("eids") List<Integer> eids);

    int updateStatus(@Param("nid") int nid,@Param("nstatus") int nstatus);

    Note selectByNid(int nid);

    int updateNote(Note note);
}
