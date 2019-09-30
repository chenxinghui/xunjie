package com.example2.demo2.iterator;
/*
书架类，当外部想要遍历书架是就调用这个方法
 */
public class BookShelf implements Aggregate{
    private Book[] books;
    private int last;

    public BookShelf(int maxsize){
        this.books = new Book[maxsize];
    }

    public Book getBook(int index){
        return books[index];
    }

    public void appendBook(Book book){
        this.books[last] = book;
        last++;
    }
    public int getLength(){
        return books.length;
    }
    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
