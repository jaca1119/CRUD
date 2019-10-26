package com.itvsme.crud;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SimpleText
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private String text;

    public SimpleText()
    {

    }

    public SimpleText(String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return String.format("SimpleText [id=%d,  text=%s]",ID, text);
    }

    public int getID()
    {
        return ID;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
