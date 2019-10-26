package com.itvsme.crud;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TextRepository extends CrudRepository<SimpleText, Integer>
{
    List<SimpleText> findByText(String text);
    SimpleText findByID(int ID);
}
