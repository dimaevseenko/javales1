package db.user.mark;

import db.user.UserTableImpl;
import model.Mark;
import model.Marks;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MarkTableImpl implements MarkTable {

    private static MarkTableImpl instance;
    private Connection connection;

    private MarkTableImpl(Connection connection) throws Exception {
        this.connection = connection;
    }

    public static MarkTableImpl getInstance(Connection connection) throws Exception {
        if(instance == null)
            instance = new MarkTableImpl(connection);
        return instance;
    }

    @Override
    public Marks getMarks() {
        Marks marks = new Marks();
        String query = "select * from marks";
        try(Statement stmt = connection.createStatement()) {
            ResultSet marksResult = stmt.executeQuery(query);
            while (marksResult.next()){
                User user = UserTableImpl.getInstance(connection).getUser(marksResult.getInt("userId"));

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
                User user = UserTableImpl.getInstance(connection).getUser(marksResult.getInt("userId"));

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
    public void addMark(Mark mark) {
        String query = String.format("insert into marks(userId, lessonName, mark) values(%d, '%s', %d)", mark.getUser().getId(), mark.getLessonName(), mark.getMark());
        try(Statement stmt = connection.createStatement()) {
            stmt.execute(query);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
