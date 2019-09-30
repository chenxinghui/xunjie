package com.example2.demo2.iterator;
/*
迭代器
 */
public class BookShelfIterator implements Iterator{

    private int index;
    private BookShelf bookShelf;

    public BookShelfIterator(BookShelf bookShelf){
        this.bookShelf = bookShelf;
        this.index = 0;
    }
    @Override
    public boolean hashNext() {
        if (index<bookShelf.getLength()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Object next() {
        if (bookShelf.getLength()>0){
            Book book = bookShelf.getBook(index);
            index++;
            return book;

        }else {
            return new Exception();
        }


    }
}
