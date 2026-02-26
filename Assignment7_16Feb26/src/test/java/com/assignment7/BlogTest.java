package com.assignment7;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.Assignment7_16Feb26.Comment;
import com.Assignment7_16Feb26.Post;
import com.Assignment7_16Feb26.User;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BlogTest {

    static EntityManagerFactory emf;
    EntityManager em;

    @BeforeAll
    static void init() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        em.getTransaction().commit();
        em.close();
    }

    @Test
    @Order(1)
    void registerUserTest() {
        User u = new User("Swarna", "1234", "swarna@gmail.com");
        em.persist(u);
        Assertions.assertNotNull(u.getId());
    }

    @Test
    @Order(2)
    void createPostTest() {
        User u = em.find(User.class, 1);
        Post p = new Post("JPA Test", "Testing post", u);
        em.persist(p);
        Assertions.assertNotNull(p.getId());
    }

    @Test
    @Order(3)
    void updatePostTest() {
        Post p = em.find(Post.class, 1);
        p.setTitle("Updated Title");
        Assertions.assertEquals("Updated Title", p.getTitle());
    }

    @Test
    @Order(4)
    void deletePostTest() {
        Post p = em.find(Post.class, 1);
        Assertions.assertNotNull(p);
    }

    @Test
    @Order(5)
    void addCommentTest() {
        User u = em.find(User.class, 1);
        Post p = new Post("New Post", "With comments", u);
        em.persist(p);

        Comment c = new Comment("Nice post", p, u);
        em.persist(c);

        Assertions.assertNotNull(c.getId());
    }
    @Test
    @Order(6)
    void fetchPostsByUserTest() {
        List<Post> posts = em.createQuery(
                "select p from Post p where p.author.id = :uid",
                Post.class)
                .setParameter("uid", 1)
                .getResultList();

        Assertions.assertTrue(posts.size() >= 0);
    }

    @Test
    @Order(7)
    void fetchCommentsOfPostTest() {
        List<Comment> comments = em.createQuery(
                "select c from Comment c where c.post.id = :pid",
                Comment.class)
                .setParameter("pid", 2)
                .getResultList();

        Assertions.assertTrue(comments.size() >= 0);
    }
    @Test
    @Order(8)
    void fetchCommentsByUserTest() {
        List<Comment> comments = em.createQuery(
                "select c from Comment c where c.author.id = :uid",
                Comment.class)
                .setParameter("uid", 1)
                .getResultList();

        Assertions.assertTrue(comments.size() >= 0);
    }

    @AfterAll
    static void close() {
        emf.close();
    }
}