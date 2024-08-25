package ru.kata.springBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import ru.kata.springBoot.entity.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

   @PersistenceContext
   private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = entityManager.createQuery("from User", User.class).getResultList();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        //entityManager.persist(user);
        entityManager.merge(user);
    }

    @Override
    public User getUser(int id) {
        TypedQuery<User> q = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        q.setParameter("id", id);
        return q.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }

}
