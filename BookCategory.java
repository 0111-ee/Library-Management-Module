package Alpha;

class Ebook extends Book {
    public Ebook(int bookId, String bookTitle, String bookAuthor, String importDate, String bookAvailability) {
        super(bookId, bookTitle, bookAuthor, importDate, bookAvailability, "Ebook");
    }

    @Override
    public String getBookCategory() {
        return "Ebook";
    }
}

class Fiction extends Book {
    public Fiction(int bookId, String bookTitle, String bookAuthor, String importDate, String bookAvailability) {
        super(bookId, bookTitle, bookAuthor, importDate, bookAvailability, "Fiction");
    }

    @Override
    public String getBookCategory() {
        return "Fiction";
    }
}

class Magazine extends Book {
    public Magazine(int bookId, String bookTitle, String bookAuthor, String importDate, String bookAvailability) {
        super(bookId, bookTitle, bookAuthor, importDate, bookAvailability, "Magazine");
    }

    @Override
    public String getBookCategory() {
        return "Magazine";
    }
}

class ReferenceBook extends Book {
    public ReferenceBook(int bookId, String bookTitle, String bookAuthor, String importDate, String bookAvailability) {
        super(bookId, bookTitle, bookAuthor, importDate, bookAvailability, "ReferenceB");
    }

    @Override
    public String getBookCategory() {
        return "ReferenceB";
    }
}
