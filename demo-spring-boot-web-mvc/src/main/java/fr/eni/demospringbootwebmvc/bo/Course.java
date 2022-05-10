package fr.eni.demospringbootwebmvc.bo;

public class Course {
    private long id;
    private String title;
    private int duration;
    public Course() {
    }
    public Course(long id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("course [id=");
        builder.append(id);
        builder.append(", title=");
        builder.append(title);
        builder.append(", duration=");
        builder.append(duration);
        builder.append("]");
        return builder.toString();
    }
}
