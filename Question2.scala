case class Book(title: String, author: String, isbn: String)

object Question2 {
  var books: Set[Book] = Set(
    Book("Harry Potter", "J.K. Rowling", "074753269B"),
    Book("Goosebumps", "R.L. Stine", "074233269D"),
    Book("Percy Jackson", "R. Riordan", "078564723H")
  )

  def main(args: Array[String]): Unit = {
    while (true) {
      println("1. Add a new book")
      println("2. Remove a book by ISBN")
      println("3. Check if a book exists by entering ISBN")
      println("4. Display all books by a specific author")
      println("5. Display all available books")
      println("6. Search a book by title")
      println("7. Exit")
      print("Enter your choice : ")
      val choice = scala.io.StdIn.readInt()
      choice match {
        case 1 => addNewBook()
        case 2 => removeBook()
        case 3 => checkByISBN()
        case 4 => displayAuthorBooks()
        case 5 => displayBooks()
        case 6 => searchByTitle()
        case 7 =>
          println("System exiting")
          System.exit(0)
        case _ =>
          println("Invalid choice. Please Try Again!")
      }
    }
  }

  def addNewBook(): Unit = {
    print("Enter the title of the Book: ")
    val title = scala.io.StdIn.readLine()
    print("Enter the author of the Book: ")
    val author = scala.io.StdIn.readLine()
    print("Enter the ISBN of the Book: ")
    val isbn = scala.io.StdIn.readLine()

    // Check if a book with the same ISBN already exists
    if (!books.exists(book => book.isbn == isbn)) {
      books += Book(title, author, isbn)
      println(s"Book '$title' added successfully.")
    } else {
      println(s"Book with ISBN '$isbn' already exists.")
    }
  }

  def removeBook(): Unit = {
    print("Enter the ISBN of the Book to remove: ")
    val isbn = scala.io.StdIn.readLine()

    val initialSize = books.size
    books = books.filterNot(book => book.isbn == isbn)
    if (books.size < initialSize) {
      println(s"Book with ISBN '$isbn' removed successfully.")
    } else {
      println(s"Book with ISBN '$isbn' not found.")
    }
  }

  def checkByISBN(): Unit = {
    print("Enter the ISBN of the Book to check: ")
    val isbn = scala.io.StdIn.readLine()

    if (books.exists(book => book.isbn == isbn)) {
      val book = books.find(book => book.isbn == isbn).get
      println(s"Book found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
    } else {
      println(s"Book with ISBN '$isbn' not found.")
    }
  }

  def displayAuthorBooks(): Unit = {
    print("Enter the author of the Books to display: ")
    val author = scala.io.StdIn.readLine()

    val authorBooks = books.filter(book => book.author == author)
    if (authorBooks.nonEmpty) {
      println(s"Books by $author:")
      authorBooks.foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
    } else {
      println(s"No books found by author $author.")
    }
  }

  def displayBooks(): Unit = {
    println("All available books:")
    books.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
  }

  def searchByTitle(): Unit = {
    print("Enter the title of the Book to search: ")
    val title = scala.io.StdIn.readLine()

    val foundBooks = books.filter(book => book.title.equalsIgnoreCase(title))
    if (foundBooks.nonEmpty) {
      println(s"Books with title '$title':")
      foundBooks.foreach(book => println(s"Author: ${book.author}, ISBN: ${book.isbn}"))
    } else {
      println(s"No books found with title '$title'.")
    }
  }
}
