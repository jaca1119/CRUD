package com.itvsme.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CrudController
{
    private TextRepository repository;

    @Autowired
    public CrudController(TextRepository repository)
    {
        this.repository = repository;

        repository.save(new SimpleText("Test1"));
        repository.save(new SimpleText("Test2"));
        repository.save(new SimpleText("Test3"));
        repository.save(new SimpleText("Test1"));
    }





//    @PostMapping("/add")
//    public SimpleText newText(@RequestBody SimpleText text)
//    {
//        return repository.save(text);
//    }

    @GetMapping("/add")
    public String greetingForm(Model model)
    {
        model.addAttribute("simpleText", new SimpleText());
        return "add";
    }

    @PostMapping("/add")
    public String greetingSubmit(@ModelAttribute SimpleText greeting)
    {
        repository.save(greeting);
        return "texts";
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("simpleText", repository.findAll());
        return "/all";
    }


}
