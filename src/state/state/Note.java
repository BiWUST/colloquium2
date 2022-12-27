package state.state;

import state.NoteService;
import state.user.User;

public abstract class Note {
    protected String text;
    protected Status status;
    protected User user;
    protected NoteService noteService;

    public Note(NoteService noteService) {
        this.noteService = noteService;
    }

    public String getText() {
        return text;
    }

    public Status getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public abstract void edit(String text);

    public abstract void publish();

    @Override
    public String toString() {
        return "Note{" +
                "text='" + text + '\'' +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
