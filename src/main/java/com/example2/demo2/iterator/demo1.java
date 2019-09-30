package com.example2.demo2.iterator;

public class demo1 {

    public static void main(String[] args){
        BookShelf bookShelf = new BookShelf(9);
        bookShelf.appendBook(new Book("钢铁是怎样炼成的"));
        bookShelf.appendBook(new Book("大话设计模式"));
        bookShelf.appendBook(new Book("程序员修炼手册"));
        bookShelf.appendBook(new Book("linux基本"));
        bookShelf.appendBook(new Book("孔乙己"));
        Iterator iterator = bookShelf.iterator();
        while (iterator.hashNext()){
            Book book = (Book) iterator.next();
            if (book==null){
                break;
            }
            System.out.println(book.getName());
        }

    }
}
