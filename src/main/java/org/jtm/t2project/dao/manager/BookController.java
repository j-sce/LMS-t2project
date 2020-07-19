package org.jtm.t2project.dao.manager;

import org.jtm.t2project.dao.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    BookManager bookManager;

    @GetMapping("/")
    public String homePage(Model model) {
        return "index";
    }

    @GetMapping("/librarian")
    public String librarian(Model model) {
        return "librarian";
    }

    @GetMapping("/insertbook")
    public String insertBookForm(ModelMap model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("authorsList", bookManager.findAuthors(null));

        return "insertbook";
    }

    @PostMapping("/insertbook")
    public String insertBook(Book book, ModelMap model) {
        try {
            book = bookManager.insertBook(book);
            model.addAttribute("message", "Book - "
                    + book.getTitle() + ". Was added to database, id: " + book.getId());
        } catch (Exception exception) {
            model.addAttribute("errorMessage", "Error occured");
            return "insertbook";
        }
        return "insertbook";
    }

    @GetMapping("/updatebook/{id}")
    public String getUpdatableBook(@PathVariable("id") Long id, Model model) {
        Book book = bookManager.findBookById(id).orElseThrow(NullPointerException::new);
        model.addAttribute("book", book);
//        model.addAttribute("authorsList", bookManager.findAuthors(null));

        return "updatebook";
    }

    @PostMapping("/updatebook")
    public String updateBook(Book book, ModelMap model) {
        try {
            book = bookManager.insertBook(book);
            model.addAttribute("message", "Book id: "
                    + book.getId() + " was updated in database.");
        } catch (Exception exception) {
            model.addAttribute("errorMessage", "Error occured");
            return "updatebook";
        }
        return "updatebook";
    }

    @GetMapping("/deletebook/{id}")
    public String getDeletableBook(@PathVariable("id") Long id, Model model) {
        Book book = bookManager.findBookById(id).orElseThrow(NullPointerException::new);
        model.addAttribute("book", book);
        return "deletebook";
    }

    @PostMapping("/deletebook")
    public String deleteBook(Book book, ModelMap model) {
        try {
            bookManager.deleteBook(book);
        } catch (Exception exception) {
            model.addAttribute("errorMessage", "Error occured");
            return "deletebook";
        }
        return "redirect:/librarian";
    }


}
