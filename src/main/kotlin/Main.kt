
import java.util.Scanner

class Archive(val name: String, val notes: MutableList<Note>)

class Note(val title: String, val content: String)



fun main(args: Array<String>) {
    val app = NotesApp()
    val scanner = Scanner(System.`in`)


    while (true) {

        println("Список архивов:")
        val archives = app.getArchives()
        for (i in archives.indices) {
            println("$i. ${archives[i]}")
        }
        println("${archives.size}. Создать архив")
        println("${archives.size + 1}. Выход")


        if (scanner.hasNextInt()) {
            val choice = scanner.nextInt()


            when {
                choice == archives.size -> {
                    println("Введите название архива:")
                    var name = scanner.next()
                    app.addArchive(name)


                }
                choice == archives.size + 1 -> {

                    break
                }
                choice < archives.size -> {
                    val archiveName = archives[choice]
                    while (true) {
                        println("Список заметок в архиве '$archiveName':")
                        val notes = app.getNotesFromArchive(choice)
                        for (i in notes.indices) {
                            println("$i. ${notes[i]}")
                        }
                        println("${notes.size}. Создать заметку")
                        println("${notes.size + 1}. Назад")
                        if (scanner.hasNextInt()) {
                            val  noteChoice = scanner.nextInt()
                            when {
                                noteChoice == notes.size -> {
                                    println("Введите название заметки:")
                                    val title = scanner.next()
                                    println("Введите содержание заметки:")
                                    val content = readLine()
                                    if (content != null) {
                                        app.addNoteToArchive(choice, title, content)
                                    }
                                }
                                noteChoice == notes.size + 1 -> {

                                    break
                                }
                                noteChoice < notes.size -> {
                                    val noteTitle = notes[noteChoice]
                                    val noteContent =
                                        app.getNoteContentFromArchive(choice, noteChoice)
                                    println("Заметка '$noteTitle': $noteContent")
                                }
                                else -> {
                                    println("Неверный выбор")
                                }
                            }
                        }

                        else {println("Введите число!")
                            scanner.next() }

                    }
                }
                else -> {
                    println("Неверный выбор")
                }

            }

        }

        else {println("Введите число!")
            scanner.next() }

    }
}