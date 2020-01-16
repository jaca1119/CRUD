package com.itvsme.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner
{

    private TextRepository textRepository;

    @Autowired
    public DataLoader(TextRepository textRepository)
    {
        this.textRepository = textRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        textRepository.save(new SimpleText("Sample text"));
        textRepository.save(new SimpleText("Another one"));
        textRepository.save(new SimpleText("Bites"));
        textRepository.save(new SimpleText("The Dust"));
    }
}
