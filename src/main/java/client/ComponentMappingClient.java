package client;

import entity.Address;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class ComponentMappingClient {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
			//Person having 1 Address
//        			Address address = new Address("200 E Main St", "Seattle", "85123");
//        			Person person = new Person("Ruby", address);

//        			session.save(person);
            //---------------------------------------------------------------------------------------

            //Person having 2 Address (homeAddress and billingAddress) using AttributeOverrides

            Address homeAddress = new Address("200 E Main St", "Seattle", "85123");
            Address billingAddress = new Address("2751  Sigley Road", "Charlotte", "28273");
            Person person = new Person("Ruby", homeAddress, billingAddress);

            session.save(person);


            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
				sessionFactory.close();
//                session.close();
            }
        }

    }
}












