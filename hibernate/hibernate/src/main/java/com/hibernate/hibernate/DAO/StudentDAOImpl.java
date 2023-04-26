package com.hibernate.hibernate.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.hibernate.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    
    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        // TODO Auto-generated method stub
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student", Student.class);

        //return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByFirstname(String firstName) {

        //create query -- :theDta is just a placeholder
        TypedQuery<Student> query=entityManager.createQuery("FROM Student WHERE firstName=:theData", Student.class);

        //set query parameter
        query.setParameter("theData", firstName);

        //return query result
        return query.getResultList();
    }

   
    
}
