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

        repository.save(new SimpleText("Sample text"));
        repository.save(new SimpleText("Another one"));
        repository.save(new SimpleText("Bites"));
        repository.save(new SimpleText("The Dust"));
    }


//    @PostMapping("/add")
//    public SimpleText newText(@RequestBody SimpleText text)
//    {
//        return repository.save(text);
//    }

    @GetMapping("/allObjects")
    public String allObjects()
    {
        return "allObjects";
    }

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
        model.addAttribute("simpleTextUpdate", new SimpleText());
        return "/all";
    }



    @PostMapping("/all")
    public String update(@ModelAttribute SimpleText update) {
        System.out.println(repository.findByID(update.getID()));
        System.out.println(update.getID());
        System.out.println(update.getText());
//        repository.findByID(update.getID()).setText(update.getText());

        return "/all";
    }


}
