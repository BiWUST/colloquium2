package state.state;

import state.NoteService;
import state.user.Role;

public class PublishedNote extends Note {
    public PublishedNote(NoteService noteService) {
        super(noteService);
    }

    @Override
    public void edit(String text) {
        if(this.user.getRole().equals(Role.USER) || this.user.getRole().equals(Role.ADMIN)) {
            this.text = text;
            this.status = Status.DRAFT;
            noteService.setNote(this);
        }
    }

    @Override
    public void publish() {
        throw new RuntimeException("Note is already published.");
    }
}
