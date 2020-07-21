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

	@RequestMapping(value = "/findbook", method = RequestMethod.GET)
	public String getSearchBook(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		// Create Class Entity
		Book book = new Book();
		Author author = new Author();
		Subject subject = new Subject();
		model.addAttribute("book", book);
		model.addAttribute("author", author);
		model.addAttribute("subject", subject);

		try {
			List<Book> books = bookManager.findAll(book);
			model.addAttribute("books", books);
		} catch (Exception exception) {
			model.addAttribute("errorMessage", "Error occur");
			return "error";
		}

		return "booklist";
	}

	@GetMapping("/findbooks")
	public String findBook(Long isbn, String title, String publisher, Integer year, Boolean available, String name, ModelMap model) {
		Book book = new Book();
		book.setTitle(title);
		book.setIsbn(isbn);
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

		return "booklist";
	}
	
	@GetMapping("/findbooks2")
	public String findBook(ArrayList<Long> ids, ModelMap model) {
//		ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(2l);
		ids.add(3l);
		try {
			List<Book> books = bookManager.findBySubjects(ids);
			model.addAttribute("books", books);
		} catch (Exception exception) {
			model.addAttribute("errorMessage", "Error occur");
			return "error";
		}
		return "booklist";
	}
	
	@GetMapping("/findbooks3")
	public String findBookSubject(String name, ModelMap model) {
		Subject subject = new Subject();
		subject.setName(name);
		try {
			List<Book> books = bookManager.findBySubjectsNames(name);
			model.addAttribute("books", books);
		} catch (Exception exception) {
			model.addAttribute("errorMessage", "Error occur");
			return "error";
		}
		return "booklist";
	}
	
}
