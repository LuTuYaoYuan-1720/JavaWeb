package domain;

public class Book {
    private String bookNumber;
    private String bookTitle;
    private String editor;
    private int price;
    private String publishingHouse;
    private String detail;

    @Override
    public String toString() {
        return "Book{" +
                "bookNumber='" + bookNumber + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", editor='" + editor + '\'' +
                ", price=" + price +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
