package db.mark;

import model.Mark;
import model.Marks;

import java.sql.SQLException;

public interface MarkTable {
    public Marks getMarks();
    public Marks getMarksForUserId(int id);
    public void addMark(Mark mark) throws SQLException;
}
