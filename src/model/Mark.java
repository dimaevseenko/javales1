package model;

public class Mark {
    private int id;
    private User user;

    public Mark(int id, User user, String lessonName, int mark) {
        this.id = id;
        this.user = user;
        this.lessonName = lessonName;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    private String lessonName;
    private int mark;

    @Override
    public String toString(){
        return user+" "+lessonName+" "+mark;
    }
}
