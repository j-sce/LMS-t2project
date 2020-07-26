package org.jtm.t2project.dao.manager;

import org.jtm.t2project.dao.entity.Author;
import org.jtm.t2project.dao.entity.Book;
import org.jtm.t2project.dao.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {

	@Autowired
	BookManager bookManager;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(HttpServletRequest request, HttpServletResponse response, Model model) {
//        List <Book> books = bookManager.;
//        model.addAttribute("books", books);
		response.setStatus(HttpServletResponse.SC_OK);
		return "index";
	}

	@RequestMapping(value = "/librarian", method = RequestMethod.GET)
	public String librarian(HttpServletRequest request, HttpServletResponse response, Model model) {
		response.setStatus(HttpServletResponse.SC_OK);
		return "librarian";
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String student(HttpServletRequest request, HttpServletResponse response, Model model) {
		response.setStatus(HttpServletResponse.SC_OK);
		return "student";
	}

	@RequestMapping(value = "/insertbook", method = RequestMethod.GET)
	public String getInsertBook(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		// Create Class Entity
		Book book = new Book();
		model.addAttribute("book", book);
//        model.addAttribute("authorsList", bookManager.findAuthor(null));

		return "insertbook";
	}

	@RequestMapping(value = "/insertbook", method = RequestMethod.POST)
	public String insertBook(@ModelAttribute("book") Book book, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		try {
			book = bookManager.insertBook(book);
			model.addAttribute("message", "Book - " + book.getTitle() + " Was added to DB, id: " + book.getId());
		} catch (Exception exception) {
			model.addAttribute("errorMessage", "Error occur: not unique ID");
			return "insertbook";
		}

		return "insertbook";
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
	
	@GetMapping("/issuebook")
	public String issueBook(ModelMap model) {
		Book book = new Book();
		try {
			List<Book> books = bookManager.bookAll(book);
			model.addAttribute("books", books);
		} catch (Exception exception) {
			model.addAttribute("errorMessage", "Error occured");
			return "error";
		}
		return "issuebook";
	}

	@RequestMapping(value = "/issuebook", method = RequestMethod.GET)
	public String issueBook(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		Book book = new Book();
		model.addAttribute("book", book);
		
			return "issuebook";
	}
	
	@RequestMapping(value = "/issuebook", method = RequestMethod.POST)
	public String issueBook(@ModelAttribute("book") Book book, HttpServletRequest request, HttpServletResponse response, ModelMap model) {	
		
		try {
			book = bookManager.issueBook(book);
			model.addAttribute("message", "Book - " + book.getTitle() + " was issued from DB, id: " + book.getId());
		} catch (Exception exception) {
			model.addAttribute("errorMessage", "Error occur: not unique ID");
			return "issuebook";
		}

		return "issuebook";
	}




}