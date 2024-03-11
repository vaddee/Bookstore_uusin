package fi.hh.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.hh.bookstore.domain.Book;
import fi.hh.bookstore.domain.Category;
import fi.hh.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    
    @RequestMapping(value = "/categorylist", method = RequestMethod.GET)
    public String getCategories(Model model) {

        model.addAttribute("categories", categoryRepository.findAll());

        return "categorylist"; // categorylist.html
    }

    
    @RequestMapping(value = "/newcategory", method = RequestMethod.GET)
    public String getNewCategoryForm(Model model) {

        
        model.addAttribute("category", new Category());

        return "addcategory"; // addcategory.html
    }

    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String saveNewCategory(Category newCategory, Model model) {

        
        categoryRepository.save(newCategory);
        
        return "redirect:/categorylist";
    }
}

