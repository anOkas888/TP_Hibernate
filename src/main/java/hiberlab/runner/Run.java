package hiberlab.runner;

import hiberlab.entity.Group;
import hiberlab.entity.Specialty;
import hiberlab.entity.Student;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import hiberlab.utils.NewHibernateUtil;

public class Run {

    public static void main(String[] args) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        //Update
        List<Group> groups = session.createQuery("FROM Group").list();
        Date curDate = new Date();
        groups.forEach(g -> {
            if (curDate.getYear() - g.getCreateDate().getYear() > 4) {
                g.setStatus("Расформирована");
                g.setStatusDate(curDate);
                g.getStudents().forEach(s -> {
                    s.setStatus("Выпускник");
                    s.setStatusDate(curDate);
                    session.update(s);
                });
                session.update(g);
            } else {
                g.setStatus("Сформирована");
                g.setStatusDate(curDate);
                g.getStudents().forEach(s -> {
                    s.setStatus("Зачислен");
                    s.setStatusDate(curDate);
                    session.update(s);
                });
                session.update(g);
            }
        });

        session.flush();
        transaction.commit();
        session.close();
        sf.close();
    }

}
