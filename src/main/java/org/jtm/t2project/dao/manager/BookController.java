package org.jtm.t2project.dao.manager;

import org.jtm.t2project.dao.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

}
