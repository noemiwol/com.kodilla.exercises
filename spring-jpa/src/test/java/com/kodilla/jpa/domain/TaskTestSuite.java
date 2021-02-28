package com.kodilla.jpa.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class TaskTestSuite {
    @PersistenceUnit
    private EntityManagerFactory emf;

    private List<Long> insertExampleData(){
        User user1 = new User(null,"Jan", "Kowalski");
        User user2 = new User(null, "Michalina", "Teczka");
        Task task1 = new Task(null, "Pranie", "Nie rozpoczete");
        Task task2 = new Task(null,"Wyprowadzic psa", "W toku");
        Subtask subtask1 = new Subtask(null,"rodzielic wedlug kolorow", "Nie rozpoczete",task1);
        Subtask subtask2 = new Subtask(null, "powiesic pranie", "nie rozpoczete",task1);
        task1.getUsers().addAll(List.of(user1,user2));
        user1.getTasks().addAll(List.of(task1,task2));
        user2.getTasks().addAll(List.of(task1,task2));
        task1.getSubtasks().addAll(List.of(subtask1,subtask2));
        task2.getUsers().addAll(List.of(user1,user2));
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(task1);
        em.persist(task2);
        em.persist(user1);
        em.persist(user2);
        em.persist(subtask1);
        em.persist(subtask2);
        em.flush();
        em.getTransaction().commit();
        em.close();

        return List.of(task1.getId(), task2.getId());

    }

    @Test
    void shouldNPlusOneProblemOccure2() {
        //Given
        List<Long> savedTask = insertExampleData();
        EntityManager em = emf.createEntityManager();

        //When
        System.out.println("****************** BEGIN OF FETCHING *******************");
        System.out.println("*** STEP 1 – query for task ***");

        TypedQuery<Task> query =
                em.createQuery(
                        "from Task "
                                + " where id in (" + taskIds(savedTask) + ")",
                        Task.class);


        EntityGraph<Task> eg = em.createEntityGraph(Task.class);
        eg.addAttributeNodes("subtasks");

        query.setHint("javax.persistence.fetchgraph", eg);

        List<Task> tasks = query.getResultList();

        for (Task task : tasks) {
            System.out.println("*** STEP 2 – read data from task ***");
            System.out.println(task);
            System.out.println("*** STEP 3 – read the user data ***");
            System.out.println(task.getUsers());

            for (Subtask subTask: task.getSubtasks()) {
                System.out.println("*** STEP 4 – read the subtask ***");
                System.out.println(subTask);
            }

        }

        System.out.println("****************** END OF FETCHING *******************");

        //Then
        //Here should be some assertions and the clean up performed

    }

    private String taskIds(List<Long> taskIds) {
        return taskIds.stream()
                .map(n -> "" + n)
                .collect(Collectors.joining(","));
    }
}
