//package org.example;
//
//import org.example.config.SpringConfig;
//import org.example.controller.DefaultController;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class LibraryManagementSystem {
//
//    private static Boolean adminGo = true;
//    private static Boolean userGo = true;
//    private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void main(String[] args) throws IOException {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//                SpringConfig.class
//        );
//
//
//        DefaultController defaultController = context.getBean("defaultController", DefaultController.class);
//
//        System.out.println("1.  Login ADMIN");
//        System.out.println("2.  Login User");
//        System.out.println("3.  User Register ");
//
//        String choice = read.readLine();
//
//        if (choice.equals("1")) {
//
//            if (defaultController.adminLogin()) {
//
//                while (adminGo) {
//                    System.out.println("1. Return Issued Books");
//                    System.out.println("2. Return Not Issued Books");
//                    System.out.println("3. Add New Book");
//                    System.out.println("4. Add Book To Library");
//                    System.out.println("5. Delete Book From Library");
//                    System.out.println("6. Add new Library");
//                    System.out.println("7. Show Library");
//                    System.out.println("0. To Quit");
//                    String AdminChoice = read.readLine();
//
//                    switch (AdminChoice) {
//                        case "1":
//                            defaultController.returnIssuedBooks();
//                            break;
//                        case "2":
//                            defaultController.returnNotIssuedBooks();
//                            break;
//                        case "3":
//                            defaultController.addNewBook();
//                            break;
//                        case "4":
//                            defaultController.addBookToLibrary();
//                            break;
//                        case "5":
//                            defaultController.giveBackBookFromLibrary();
//                            break;
//                        case "6":
//                            defaultController.addLibrary();
//                            break;
//                        case "7":
//                            defaultController.showLibrary();
//                            break;
//                        default:
//                            adminGo = false;
//                    }
//                }
//
//            } else
//                System.out.println("WRONG Input data  ");
//
//
//        } else if (choice.equals("2")) {
//
//
//            if (defaultController.userLogin()) {
//
//
//                System.out.println("You logged in as an User");
//
//                while (userGo) {
//                    System.out.println("1. Return My Books");
//                    System.out.println("2. Return Not Issued Books");
//                    System.out.println("3. Issue Book");
//                    System.out.println("4. GiveBack Book");
//                    System.out.println("0. To Quit");
//                    String userChoice = read.readLine();
//
//                    switch (userChoice) {
//                        case "1":
//                            defaultController.returnMyBooks();
//                            break;
//                        case "2":
//                            defaultController.returnNotIssuedBooks();
//                            break;
//                        case "3":
//                            defaultController.issueBook();
//                            break;
//                        case "4":
//                            defaultController.giveBackBook();
//                            break;
//                        default:
//                            userGo = false;
//
//                    }
//
//
//                }
//
//            } else
//                System.out.println("WRONG Input data");
//
//        } else if (choice.equals("3")) {
//            defaultController.userRegistration();
//        } else
//            System.out.println("exit");
//
//    }
//}
//
//
