package org.jtm.t2project.dao.manager;

import org.springframework.security.access.annotation.Secured;
import org.jtm.t2project.dao.entity.Author;
import org.jtm.t2project.dao.entity.Book;
import org.jtm.t2project.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class BookController {

    @Autowired
    BookManager bookManager;

    @Autowired
    AuthorService authorService;


    @GetMapping("/")
    public String homePage(Model model) {
        return "index";
    }

    @GetMapping("/librarian")
    public String librarian(Model model) {
        return "librarian";
    }


    @Secured("ROLE_ADMIN")
    @GetMapping("/insertbook")
    public String insertBookForm(ModelMap model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("authorsList", bookManager.findAuthors());

        return "insertbook";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/insertbook")
    public String insertBook(Book book, ModelMap model) {
        try {
            book = bookManager.insertBook(book);
            model.addAttribute("message", "Book - "
                    + book.getTitle() + ". Was added to database, id: " + book.getId());
            model.addAttribute("authorsList", bookManager.findAuthors());
        } catch (Exception exception) {
            model.addAttribute("errorMessage", "Error occured");
            return "insertbook";
        }
        return "insertbook";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/updatebook/{id}")
    public String getUpdatableBook(@PathVariable("id") Long id, Model model) {
        Book book = bookManager.findBookById(id).orElseThrow(NullPointerException::new);
        model.addAttribute("book", book);
        model.addAttribute("authorsList", book.getBookAuthors());

        return "updatebook";
    }

    @Secured("ROLE_ADMIN")
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

    @Secured("ROLE_ADMIN")
    @GetMapping("/deletebook/{id}")
    public String getDeletableBook(@PathVariable("id") Long id, Model model) {
        Book book = bookManager.findBookById(id).orElseThrow(NullPointerException::new);
        model.addAttribute("book", book);
        return "deletebook";
    }

    @Secured("ROLE_ADMIN")
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
