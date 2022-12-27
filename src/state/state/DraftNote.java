package state.state;

import state.NoteService;
import state.user.Role;

public class DraftNote extends Note {
    public DraftNote(NoteService noteService) {
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
        if(this.user.getRole().equals(Role.ADMIN)) {
            this.status = Status.PUBLISHED;
            noteService.setNote(this);
        } else {
            throw new RuntimeException("Only admin can publish note.");
        }
    }
}
