package db.mark;

import db.DB;
import db.user.UserTableImpl;
import model.Mark;
import model.Marks;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MarkTableImpl extends DB implements MarkTable {

    private static MarkTableImpl instance;

    private MarkTableImpl() throws Exception {}

    public static MarkTableImpl getInstance() throws Exception {
        if(instance == null)
            instance = new MarkTableImpl();
        return instance;
    }

    @Override
    public Marks getMarks() {
        Marks marks = new Marks();
        String query = "select * from marks";
        try(Statement stmt = connection.createStatement()) {
            ResultSet marksResult = stmt.executeQuery(query);
            while (marksResult.next()){
                User user = UserTableImpl.getInstance().getUser(marksResult.getInt("userId"));

                marks.add(new Mark(
                        marksResult.getInt("id"),
                        user,
                        marksResult.getString("lessonName"),
                        marksResult.getInt("mark")
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return marks;
    }

    @Override
    public Marks getMarksForUserId(int id) {
        Marks marks = new Marks();
        String query = String.format("select * from marks where userId = %d", id);
        try(Statement stmt = connection.createStatement()) {
            ResultSet marksResult = stmt.executeQuery(query);
            while (marksResult.next()){
                User user = UserTableImpl.getInstance().getUser(marksResult.getInt("userId"));

                marks.add(new Mark(
                        marksResult.getInt("id"),
                        user,
                        marksResult.getString("lessonName"),
                        marksResult.getInt("mark")
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return marks;
    }
}
