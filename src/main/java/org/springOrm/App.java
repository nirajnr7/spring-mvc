package org.springOrm;

import org.springOrm.Entities.Student;
import org.springOrm.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Student s=new Student(1,"niraj","jadugoda");

        ApplicationContext con= new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=con.getBean("studentDao", StudentDao.class);

//        int x=studentDao.insert(s);
//        System.out.println(x+"inserted");

        boolean flag=true;
        while (flag){
            System.out.println("1->insert /n 2->getone 3->getAll 4->delete 5->update 6->exit");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            try {
                int x=Integer.parseInt(br.readLine());
                switch (x){
                    case 1:
                        System.out.println("enter id , name,city ");
                        int id=Integer.parseInt(br.readLine());
                        String name=br.readLine();
                        String city=br.readLine();

                        Student student=new Student(id,name,city);
                        int r=studentDao.insert(student);
                        System.out.println(r);
                        System.out.println("*************************");
                        break;

                    case 2:
                        System.out.println("id ");
                        int sid=Integer.parseInt(br.readLine());
                        Student student1=studentDao.getOne(sid);
                        System.out.println(student1.getStudentName());
                        break;




                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

    }
}
