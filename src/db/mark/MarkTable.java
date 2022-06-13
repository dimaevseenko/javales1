package db.mark;

import model.Marks;

public interface MarkTable {
    public Marks getMarks();
    public Marks getMarksForUserId(int id);
}
