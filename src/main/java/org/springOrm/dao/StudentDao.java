package org.springOrm.dao;

import org.springOrm.Entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;

    //insert
    @Transactional
    public int insert(Student student){
        return (int) hibernateTemplate.save(student);
    }

    //get Single obj
    public Student getOne(int studentid){
        Student s=hibernateTemplate.get(Student.class,studentid);
        return s;
    }

    //getList
    public List<Student> getAll(){
        List<Student> s= hibernateTemplate.loadAll(Student.class);
        return s;
    }

    //
    @Transactional
    public void deleteStudent(int studentid){
        Student s=hibernateTemplate.get(Student.class,studentid);
        hibernateTemplate.delete(s);
    }
    @Transactional
    public void updateStudent(Student student){
        hibernateTemplate.update(student);
    }




    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
