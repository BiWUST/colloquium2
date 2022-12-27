package state;

import state.state.DraftNote;
import state.state.Note;
import state.user.Role;
import state.user.User;

public class NoteService {
    private Note note;

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public static void main(String[] args) {
        {
            NoteService noteService = new NoteService();
            Note note = new DraftNote(noteService);
            note.setUser(new User("admin", Role.ADMIN));

            note.edit("Hello World!");
            System.out.println(noteService.getNote());

            note.publish();
            System.out.println(noteService.getNote());

            note.edit("Hello World! Edited");
            System.out.println(noteService.getNote());

            note.publish();
            System.out.println(noteService.getNote());
        }
        {
            NoteService noteService = new NoteService();
            Note note = new DraftNote(noteService);
            note.setUser(new User("user", Role.USER));

            note.edit("Hello World!");
            System.out.println(noteService.getNote());

            try {
                note.publish();
                System.out.println(noteService.getNote());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
