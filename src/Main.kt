import java.util.Scanner

class NoteTakingApp {
    private val notes = mutableListOf<String>()

    fun addNote(note: String) {
        notes.add(note)
        println("Note added successfully!")
    }

    fun viewNotes() {
        if (notes.isEmpty()) {
            println("No notes available.")
        } else {
            println("\nYour Notes:")
            notes.forEachIndexed { index, note -> println("${index + 1}. $note") }
        }
    }

    fun deleteNote(index: Int) {
        if (index in 1..notes.size) {
            notes.removeAt(index - 1)
            println("Note deleted successfully!")
        } else {
            println("Invalid note number.")
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val app = NoteTakingApp()

    while (true) {
        println("\n--- Note Taking App ---")
        println("1. Add Note")
        println("2. View Notes")
        println("3. Delete Note")
        println("4. Exit")
        print("Enter your choice: ")

        when (scanner.nextInt()) {
            1 -> {
                print("Enter your note: ")
                scanner.nextLine() // Consume newline
                val note = scanner.nextLine()
                app.addNote(note)
            }
            2 -> app.viewNotes()
            3 -> {
                print("Enter the note number to delete: ")
                val noteNumber = scanner.nextInt()
                app.deleteNote(noteNumber)
            }
            4 -> {
                println("Exiting the app. Goodbye!")
                return
            }
            else -> println("Invalid choice. Please try again.")
        }
    }
}