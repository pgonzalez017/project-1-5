package pat_nick.dao;


import java.util.List;

import org.hibernate.Hibernate;
import pat_nick.model.User;
import org.apache.log4j.Logger;

import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;


/*
 * Purpose of this Dao is to send/retrieve info about a reimbursement
 * to/from the database. It then returns the composed Reimbursement Object.
 */
public class UserDao implements GenericDao <User> {
    private static final Logger LOGGER = Logger.getLogger(UserDao.class);
    private static SessionFactory factory;

//	private User objectConstructor(ResultSet rs) throws SQLException {
//		return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
//						rs.getString(6), rs.getInt(7));
//	}

    public UserDao(){ factory = SingleSessionFactory.INSTANCE.getFactory();}

    @Override
    public List<User> getList() {
        Session session = factory.openSession();
        session.getTransaction().begin();
        Query<User> query = session.createNamedQuery("getAllUsers", User.class);
        List<User> result = query.getResultList();
        session.close();
        return result;
    }

//	try (Connection c = ConnectionUtil.getInstance().getConnection()) {
//		SessionFactory factory = new Configuration().configure().buildSessionFactory();
//
//		Session session = factory.openSession();
//
//		Query selectAll = session.createQuery("from User");
//		//List<>
//
//		String qSql = "SELECT * FROM ers_users";
//		Statement s = c.createStatement();
//		ResultSet rs = s.executeQuery(qSql);
//
//		while(rs.next()) {
//			l.add(objectConstructor(rs));
//		}
//		LOGGER.debug("A list of users was retrieved from the database.");
//	} catch (SQLException e) {
//		e.printStackTrace();
//		LOGGER.error("An attempt to get all users from the database failed.");
//	}


    @Override
    public User getById(int id) {
        User u = null;
        Session session = factory.openSession();
        session.getTransaction().begin();
        u = (User) session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        return u;
    }

//	@Override
//	public User getById(int id) {
//		User u = null;
//
//		try(Connection c = ConnectionUtil.getInstance().getConnection()) {
//			String qSql = "SELECT * FROM ers_users WHERE ers_users_id = ?";
//			PreparedStatement ps = c.prepareStatement(qSql);
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//
//			if(rs.next())
//				u = objectConstructor(rs);
//
//			LOGGER.debug("Information about user ID " + id + " was retrieved from the database.");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			LOGGER.error("An attempt to get info about user ID " + id + " from the database failed.");
//		}
//		return u;
//	}




    @Override
    public User getByUsername(String username) {
        Session session = factory.openSession();
        User u = null;
        session.getTransaction().begin();
        Query<User> query = session.createNamedQuery("getByUsername", User.class);
        query.setParameter("username", username);
        u = query.getSingleResult();
        session.close();
        return u;
    }

    @Override
    public List<User> getByUserId(int id) {
        //Does Nothing
        return null;
    }

//		try(Connection c = ConnectionUtil.getInstance().getConnection()) {
//			String qSql = "SELECT * FROM ers_users WHERE ers_username = ?";
//			PreparedStatement ps = c.prepareStatement(qSql);
//			ps.setString(1, username.toLowerCase());
//			ResultSet rs = ps.executeQuery();
//
//			if(rs.next()) {
//				//System.out.println("User object was created!");
//				u = objectConstructor(rs);
//			}
//
//			LOGGER.debug("Information about username " + username + " was retrieved from the database.");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			LOGGER.error("An attempt to get info about username " + username + " from the database failed.");
//		}
//		return u;
//	}

    @Override
    public void insert(User t) {
        // TODO Auto-generated method stub
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.persist(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(User t) {
        // TODO Auto-generated method stub
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.remove(t);
        session.getTransaction().commit();
        session.close();
    }
}
