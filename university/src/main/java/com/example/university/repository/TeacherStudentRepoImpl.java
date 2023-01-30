package com.example.university.repository;

import com.example.university.pojo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

@Repository
public class TeacherStudentRepoImpl implements TeacherStudentRepo {

//    private static EntityManager em;
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public TeacherStudentRepoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Student findById(String id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("select s from Student s left join  s.teacher_students ts where s.id = ?1");
        query.setParameter(1, id);
        return (Student)query.getSingleResult();
    }

    @Override
    public String insertToStudent(String id, String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Student s = new Student();
        s.setName(name);
        s.setId(id);
        em.merge(s);
        tx.commit();
        return "success";
    }

    @Override
    public String RemoveToStudent(String id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("select s from Student s");
        List<Student> studentList = (List<Student>) query.getResultList();
        Iterator<Student> itr = studentList.iterator();
        while(itr.hasNext()) {
            Student s = itr.next();
            if(s.getId().equals(id)) {
                itr.remove();
                em.remove(s);
            }
        }
        tx.commit();
        return "success";
    }

    @Override
    public String UpdateStudent(String id, String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("select s from Student s");
        List<Student> studentList = (List<Student>) query.getResultList();
        Iterator<Student> itr = studentList.iterator();
        while(itr.hasNext()) {
            Student s = itr.next();
            if(s.getId().equals(id)) {
                itr.remove();
                em.remove(s);
            }
        }
        Student s = new Student();
        s.setName(name);
        s.setId(id);
        em.merge(s);
        tx.commit();
        return "success";
    }


}
