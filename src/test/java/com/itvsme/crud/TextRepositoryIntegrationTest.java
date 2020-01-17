package com.itvsme.crud;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


@DataJpaTest
public class TextRepositoryIntegrationTest
{
    @Autowired
    private TextRepository repository;

    @Test
    void testInjectedRepositoryIsNotNull()
    {
        Assertions.assertThat(repository).isNotNull();
    }

    @Test
    void testSaveInRepository()
    {
        SimpleText simpleText = new SimpleText("test");

        SimpleText saved = repository.save(simpleText);

        Assertions.assertThat(simpleText).isSameAs(saved);
    }
}
