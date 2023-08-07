package com.digit.hibernateServlet.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.digit.hibernateServlet.bean.AadharDetails;


public class HibernateManager {
	public static Session session;

	public HibernateManager() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); // connects to cfg
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());

		session = sessionFactory.openSession();
		System.out.println("Connected to pf...");
	}

	public boolean register(AadharDetails ad) {
		Transaction tran = session.beginTransaction();
		Serializable save = session.save(ad);
		tran.commit();
		System.out.println("Registered");
		if (save == null) {
			return false;
		}
		return true;
	}

	public List showAllDetails() {
		Transaction tran = session.beginTransaction();
		Query q = session.createQuery("From AadharDetails");
		List li = q.list();
		Iterator itr = li.iterator();
	
		tran.commit();
		return li;
	}
	public void update(String aadharNo, String chngVal, String newVal) {
		Transaction transaction=session.beginTransaction();
		AadharDetails s = (AadharDetails) session.get(AadharDetails.class, aadharNo);
		switch(chngVal) {
        case "2":
            s.setEmail(newVal);
            break;
        case "1":
            s.setPhone(newVal);
            break;
        }

        session.update(s);

        System.out.println("Update Success");
        transaction.commit();
	}
	public void deleteData(String aadharNo) {
        Transaction tran=session.beginTransaction();
        AadharDetails s = (AadharDetails) session.get(AadharDetails.class, aadharNo);

        session.delete(s);

        System.out.println("Delete Success");
        tran.commit();

    }
	public AadharDetails showSpecific(String aadharNo) {
        session.beginTransaction();
        AadharDetails s = (AadharDetails) session.get(AadharDetails.class, aadharNo);
        System.out.println(s.getName());

        return s;

    }
}
