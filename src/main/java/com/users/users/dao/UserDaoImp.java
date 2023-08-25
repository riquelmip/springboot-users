package com.users.users.dao;

import com.users.users.models.User;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository

@Transactional
public class UserDaoImp implements UserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(Long id) {
        User usuario = entityManager.find(User.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void register(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserCredentials(User user) {
        String query = "FROM User WHERE email = :email";
        List<User> lista = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, user.getPassword())) {
            return lista.get(0);
        }
        return null;
    }
}
