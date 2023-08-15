package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Book;
import com.bookStore.service.BookService;

@Controller
public class BookController
{
	@Autowired
	private BookService service;
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/book-register")
	public String bookRegister()
	{
		return "bookRegister";
	}
	
	@GetMapping("/available-books")
	public ModelAndView getAllBooks()
	{
		List<Book> list=service.getAllBooks();
		ModelAndView m=new ModelAndView();
		m.setViewName("bookList");
		return m.addObject("book", list);
		
		//return new ModelAndView("bookList", "book", list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b)
	{
		service.save(b);
		return "redirect:/available-books";
	}
}











