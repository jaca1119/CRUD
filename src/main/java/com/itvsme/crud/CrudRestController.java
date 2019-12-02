package com.itvsme.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CrudRestController
{
    @Autowired
    private TextRepository repository;

    @GetMapping("/texts/{id}")
    public SimpleText getTextById(@PathVariable(value = "id") Integer id)
    {
        return repository.findByID(id);
    }

    @GetMapping("/texts")
    public List<SimpleText> getAllText()
    {
        List<SimpleText> texts = new ArrayList<>();
        repository.findAll().forEach(texts::add);

        return texts;
    }

    @PostMapping("/texts")
    public SimpleText addText(@Valid @RequestBody SimpleText text)
    {
        return repository.save(text);
    }

    @PutMapping("/texts/{id}")
    public SimpleText updateText(@PathVariable(value = "id") Integer textId, @Valid @RequestBody SimpleText textUpdate)
    {
        SimpleText text = repository.findByID(textId);

        text.setText(textUpdate.getText());

        SimpleText updatedText = repository.save(text);
        return updatedText;
    }

    @DeleteMapping("/texts/{id}")
    public ResponseEntity<?> deleteText(@PathVariable(value = "id") Integer id)
    {
        SimpleText text = repository.findByID(id);

        repository.delete(text);
        return ResponseEntity.ok().build();
    }
}
