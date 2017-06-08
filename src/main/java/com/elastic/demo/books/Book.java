package com.elastic.demo.books;

import java.util.List;

/**
 * Created by Kinath on 6/8/2017.
 */
public class Book
{
    String isbn;
    String titlle;
    String author;
    List<String> tags;
    List<String> otherBooks;

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn( String isbn )
    {
        this.isbn = isbn;
    }

    public String getTitlle()
    {
        return titlle;
    }

    public void setTitlle( String titlle )
    {
        this.titlle = titlle;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor( String author )
    {
        this.author = author;
    }

    public List<String> getTags()
    {
        return tags;
    }

    public void setTags( List<String> tags )
    {
        this.tags = tags;
    }

    public List<String> getOtherBooks()
    {
        return otherBooks;
    }

    public void setOtherBooks( List<String> otherBooks )
    {
        this.otherBooks = otherBooks;
    }
}
