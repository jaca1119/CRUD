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

    @GetMapping("/allObjects")
    public String allObjects()
    {
        return "allObjects";
    }
}
