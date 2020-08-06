package ru.geekbrains.sample.dao;


import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.geekbrains.sample.persistence.entity.Book;
import ru.geekbrains.sample.persistence.entity.Tutor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TutorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Tutor> findTutors() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tutor> criteriaQuery = criteriaBuilder.createQuery(Tutor.class);
        CriteriaDelete<Tutor> criteriaDelete= criteriaBuilder.createCriteriaDelete(Tutor.class);
        Root<Tutor> root = criteriaQuery.from(Tutor.class);
        Selection[] selections = {root.get("id"), root.get("name")};

//        criteriaDelete.where(criteriaBuilder.like(root.<String>get("name"),"%asya%"));

        criteriaQuery.select(criteriaBuilder.construct(Tutor.class,selections))
                .where(criteriaBuilder.like(root.<String>get("surname"),"%ov%"));

        CriteriaQuery<Tutor> all = criteriaQuery.select(root);
        return entityManager.createQuery(all).getResultList();
    }


}
