package com.kodilla.jpa.domain;




import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JpaTestSuite {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Test
    void shouldPersistUser() {

        //Given
        EntityManager em = emf.createEntityManager();
        User kodilla = new User(null, "Kodilla",  "Wrocław");

        //When
        em.getTransaction().begin();
        em.persist(kodilla);
        em.flush();
        em.getTransaction().commit();

        //Then
        Long key = kodilla.getId();
        User readUser = em.find(User.class, key);
        em.close();
        assertThat(readUser.getName()).isEqualTo(kodilla.getName());
    }
}