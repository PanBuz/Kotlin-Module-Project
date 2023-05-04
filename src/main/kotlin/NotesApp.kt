class NotesApp {
    private val archives = mutableListOf<Archive>()

    fun addArchive(name: String) {
        archives.add(Archive(name, mutableListOf()))
    }

    fun addNoteToArchive(archiveIndex: Int, title: String, content: String) {
        archives[archiveIndex].notes.add(Note(title, content))
    }

    fun getArchives(): List<String> {
        return archives.map { it.name }
    }

    fun getNotesFromArchive(archiveIndex: Int): List<String> {
        return archives[archiveIndex].notes.map { it.title }
    }

    fun getNoteContentFromArchive(archiveIndex: Int, noteIndex: Int): String {
        return archives[archiveIndex].notes[noteIndex].content
    }
}