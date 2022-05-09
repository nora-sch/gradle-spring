package fr.eni.movielibrary.bo;

public class Opinion {
    private long id;
    private int note;
    private String comment;

    public Opinion(){
    }
    public Opinion(long id, int note, String comment){
        this.id = id;
        this.note = note;
        this.comment = comment;
    }
    public Opinion(int note, String comment){
        this.note = note;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Opinion - "+id+" : [note=" + note + ", comment=" + comment + "]";
    }
}
