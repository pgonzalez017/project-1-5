package pat_nick;

import pat_nick.dao.UserDao;
import pat_nick.model.Reimbursement;
import pat_nick.model.User;

import java.sql.Timestamp;

public class Driver {
    public static void main(String args[]){
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("pgonz");
        user.setFirstname("Patrick");
        user.setLastname("Gonzalez");
        user.setEmail("pgonz017@gmail.com");
        user.setPassword("password");
        user.setRole_id(5);
        Reimbursement r1 = new Reimbursement(3.14f, new Timestamp(10000), new Timestamp(11000), "Hello", 6, 7, 8, 9);
        Reimbursement r2 = new Reimbursement(1.7071f, new Timestamp(10000), new Timestamp(11000), "World", 6, 7, 8, 9);
        r1.setUser(user);
        r2.setUser(user);
        user.getReimbursements().add(r1);
        user.getReimbursements().add(r2);
        userDao.insert(user);
    }
}
