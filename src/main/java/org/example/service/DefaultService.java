//package org.example.service;
//
//import org.example.entity.*;
//import org.example.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class DefaultService {
//
//
//    private final AdminRepository adminRepository;
//    private final BookRepository bookRepository;
//    private final UserDataRepository dataRepository;
//    private final UserRepository userRepository;
//    private final LibraryRepository libraryRepository;
//
//    @Autowired
//    public DefaultService(AdminRepository adminRepository, BookRepository bookRepository, UserDataRepository dataRepository, UserRepository userRepository, LibraryRepository libraryRepository) {
//        this.adminRepository = adminRepository;
//        this.bookRepository = bookRepository;
//        this.dataRepository = dataRepository;
//        this.userRepository = userRepository;
//        this.libraryRepository = libraryRepository;
//    }
//
//
//    public Admin adminLogin(String email, String password) {
//        return adminRepository.findAdmin(email, password);
//    }
//
//    public User userLogin(String email, String password) {
//        return userRepository.findUser(email, password);
//    }
//
//    public void userRegistration(UserData userData) {
//        dataRepository.save(userData);
//    }
//
//    public Optional<Book> selectBookById(Long id) {
//        return bookRepository.findById(id);
//    }
//
//
//    public List<Book> returnNotIssuedBooks() {
//        return bookRepository.returnNotIssuedOrIssued("not issued");
//    }
//
//    public List<Book> returnIssuedBooks() {
//        return bookRepository.returnNotIssuedOrIssued("issued");
//    }
//
//
//    public void issueBook(Long book_id, Long user_id) {
//        Optional<Book> optionalBook = bookRepository.findById(book_id);
//
//        if (optionalBook.isPresent()) {
//
//            if (optionalBook.get().getUserId() != null)
//                System.out.println("Book Already issued");
//
//            Book updateBook = optionalBook.get();
//            updateBook.setUserId(user_id);
//            updateBook.setStatus("issued");
//
//            bookRepository.save(updateBook);
//        }
//    }
//
//    public void  addBookToLibrary(Long book_id, Long library_id){
//        Optional<Book> optionalBook = bookRepository.findById(book_id);
//
//        if(optionalBook.isPresent()) {
//
//            if (optionalBook.get().getLibraryId() != null)
//                System.out.println("Book Already in Library");
//
//            Book updateBook = optionalBook.get();
//            updateBook.setLibraryId(library_id);
//
//            bookRepository.save(updateBook);
//        }
//    }
//
//    public void giveBackBookFromLibrary(Long book_id, Long library_id){
//        Optional<Book> optionalBook = bookRepository.findById(book_id);
//
//        if(optionalBook.isPresent()) {
//
//            Book updateBook = optionalBook.get();
//            updateBook.setLibraryId(null);
//
//            bookRepository.save(updateBook);
//        }
//
//    }
//
//    public void addLibrary(Library library){
//        libraryRepository.save(library);
//    }
//
//    public void addNewBook(Book book){
//        bookRepository.save(book);
//    }
//
//    public void giveBackBook(Long book_id, Long user_id) {
//        Optional<Book> optionalBook = bookRepository.findById(book_id);
//
//        if (optionalBook.isPresent()) {
//            Book updateBook = optionalBook.get();
//            updateBook.setStatus("not issued");
//            updateBook.setUserId(null);
//
//            bookRepository.save(updateBook);
//        }
//    }
//
//
//    public Optional<User> returnMyBooks(Long id) {
//
//        return userRepository.findById(id);
//    }
//
//    public List<Library> showLibrary(){
//        return libraryRepository.findAll();
//    }
//
//
//
//
//}
