//package org.example.controller;
//
//import org.example.entity.Book;
//import org.example.entity.Library;
//import org.example.entity.User;
//import org.example.entity.UserData;
//import org.example.service.DefaultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//@Controller
//public class DefaultController {
//
//    private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
//    private final DefaultService service;
//    private Long userId;
//
//    @Autowired
//    public DefaultController(DefaultService service) {
//        this.service = service;
//    }
//
//
//    public boolean adminLogin() throws IOException {
//        System.out.println("Write down Admin email:");
//        String adminEmail = read.readLine();
//        System.out.println("Write down Admin password:");
//        String adminPassword = read.readLine();
//
//        return service.adminLogin(adminEmail, adminPassword) != null;
//    }
//
//
//    public void userRegistration() throws IOException {
//        System.out.println("User Email:");
//        String userEmail = read.readLine();
//        System.out.println("User PASSWORD:");
//        String userPassword = read.readLine();
//        System.out.println("name");
//        String name = read.readLine();
//        System.out.println("street");
//        String street = read.readLine();
//        System.out.println("house Number");
//        String houseNo = read.readLine();
//
//        UserData userData = new UserData();
//        userData.setHouseNumber(houseNo);
//        userData.setName(name);
//        userData.setStreet(street);
//
//        User user = new User();
//        user.setEmail(userEmail);
//        user.setPassword(userPassword);
//
//        userData.setUser(user);
//
//        service.userRegistration(userData);
//
//    }
//
//
//    public boolean userLogin() throws IOException {
//        System.out.println("Write down User email:");
//        String userEmail = read.readLine();
//        System.out.println("Write down User password:");
//        String userPassword = read.readLine();
//
//        if (service.userLogin(userEmail, userPassword) != null) {
//            userId = service.userLogin(userEmail, userPassword).getId();
//            return true;
//        } else {
//            return false;
//
//        }
//
//    }
//
//    public void addNewBook() throws IOException {
//        System.out.println("write author");
//        String author = read.readLine();
//        System.out.println("write title");
//        String title = read.readLine();
//
//        Book book = new Book();
//        book.setAuthor(author);
//        book.setTitle(title);
//        book.setStatus("not issued");
//
//        service.addNewBook(book);
//    }
//
//    public void issueBook() throws IOException {
//        System.out.println("Write down Book id");
//        Long bookId = Long.valueOf(read.readLine());
//
//        service.issueBook(bookId, userId);
//    }
//
//    public void giveBackBook() throws IOException {
//        System.out.println("Write down Book id");
//        Long bookId = Long.valueOf(read.readLine());
//
//        service.giveBackBook(bookId, userId);
//
//    }
//
//    public void addBookToLibrary() throws IOException {
//        System.out.println("Write down Book id");
//        Long bookId = Long.valueOf(read.readLine());
//        System.out.println("write down library id");
//        Long libraryId = Long.valueOf(read.readLine());
//
//        service.addBookToLibrary(bookId, libraryId);
//    }
//
//    public void giveBackBookFromLibrary() throws IOException {
//        System.out.println("Write down Book id");
//        Long bookId = Long.valueOf(read.readLine());
//        System.out.println("write down library id");
//        Long libraryId = Long.valueOf(read.readLine());
//
//        service.giveBackBookFromLibrary(bookId, libraryId);
//    }
//
//    public void addLibrary() throws IOException {
//        System.out.println("Enter name of the Library");
//        String libraryName = read.readLine();
//
//        Library library = new Library();
//        library.setName(libraryName);
//
//        service.addLibrary(library);
//
//    }
//
//
//
//    public void returnMyBooks(){
//        System.out.println("MY BOOKS: " + service.returnMyBooks(userId));
//    }
//
//    public void returnIssuedBooks(){
//        System.out.println("Issued Books: " + service.returnIssuedBooks());
//    }
//
//    public void returnNotIssuedBooks(){
//        System.out.println("Not Issued: " + service.returnNotIssuedBooks());
//    }
//
//    public void showLibrary(){
//        System.out.println("Libraries: " + service.showLibrary());
//    }
//
//}
