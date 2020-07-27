package org.jtm.t2project.dao.manager;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.jtm.t2project.dao.entity.Author;
import org.jtm.t2project.dao.entity.Book;
import org.jtm.t2project.dao.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @RolesAllowed("ADMIN")
    @GetMapping("/insertbook")
    public String insertBookForm(ModelMap model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("authorsList", bookManager.findAuthors());

        return "insertbook";
    }

    @RolesAllowed("ADMIN")
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

    @RolesAllowed("ADMIN")
    @GetMapping("/updatebook/{id}")
    public String getUpdatableBook(@PathVariable("id") Long id, Model model) {
        Book book = bookManager.findBookById(id).orElseThrow(NullPointerException::new);
        model.addAttribute("book", book);
        model.addAttribute("authorsList", book.getBookAuthors());

        return "updatebook";
    }

    @RolesAllowed("ADMIN")
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

    @RolesAllowed("ADMIN")
    @GetMapping("/deletebook/{id}")
    public String getDeletableBook(@PathVariable("id") Long id, Model model) {
        Book book = bookManager.findBookById(id).orElseThrow(NullPointerException::new);
        model.addAttribute("book", book);
        return "deletebook";
    }

    @RolesAllowed("ADMIN")
    @PostMapping("/deletebook")
    public String deleteBook(Book book, ModelMap model) {
        try {
            bookManager.deleteBook(book);
        } catch (Exception exception) {
            model.addAttribute("errorMessage", "Error occured");
            return "deletebook";
        }
        return "redirect:/";
    }

	@GetMapping("/findbook")
	public String findBook(ModelMap model) {
		Book book = new Book();
		try {
			List<Book> books = bookManager.findAll(book);
			model.addAttribute("books", books);
		} catch (Exception exception) {
			model.addAttribute("errorMessage", "Error occur");
			return "error";
		}
		return "findbook";
	}

	@RequestMapping(value = "/findbook", params = "subject")
	public String findBookBySubject(String subject, ModelMap model) {
		Subject subj = new Subject();
		subj.setName(subject);
		try {
			List<Book> booksSubjects = bookManager.findBySubjectsNames(subject);
			model.addAttribute("books", booksSubjects);
		} catch (Exception exception) {
			model.addAttribute("errorMessage", "Error occur");
			return "error";
		}
		return "findbook";
	}

	@RequestMapping(value = "/findbook", params = "author")
	public String findBookByAuthor(String author, ModelMap model) {
		Author auth = new Author();
		auth.setName(author);
		try {
			List<Book> books = bookManager.findByAuthors(author);
			model.addAttribute("books", books);
		} catch (Exception exception) {
			model.addAttribute("errorMessage", "Error occur");
			return "error";
		}
		return "findbook";
	}

	@RequestMapping(value = "/findbook")
	public String findBooks(Long isbn, String title, String publisher, Integer year, Boolean available, String name,
			ModelMap model) {
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		book.setPublisher(publisher);
		book.setYear(year);
		book.setAvailable(available);
		try {
			List<Book> books = bookManager.findBooks(book);
			model.addAttribute("books", books);
		} catch (Exception exception) {
			model.addAttribute("errorMessage", "Error occur");
			return "error";
		}
		return "findbook";
	}

}
