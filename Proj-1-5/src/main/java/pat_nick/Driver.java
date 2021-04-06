package pat_nick;

import pat_nick.dao.ReimbursementDao;
import pat_nick.dao.UserDao;
import pat_nick.model.Reimbursement;
import pat_nick.model.User;

import java.sql.Timestamp;

public class Driver {
    public static void main(String args[]){
        UserDao userDao = new UserDao();
//        User user = new User();
//        user.setUsername("pgonz");
//        user.setFirstname("Patrick");
//        user.setLastname("Gonzalez");
//        user.setEmail("pgonz017@gmail.com");
//        user.setPassword("password");
//        user.setRole_id(5);
//        Reimbursement r1 = new Reimbursement(3.14f, new Timestamp(10000), new Timestamp(11000), "Hello", 6, 7, 8, 9);
//        Reimbursement r2 = new Reimbursement(1.7071f, new Timestamp(10000), new Timestamp(11000), "World", 6, 7, 8, 9);
//        r1.setUser(user);
//        r2.setUser(user);
//        user.getReimbursements().add(r1);
//        user.getReimbursements().add(r2);
//        userDao.insert(user);


//        System.out.println(userDao.getByUsername("pgonz"));


        User deleteUser = new User();
        deleteUser.setId(4);
        deleteUser.setUsername("nzim");
        userDao.delete(deleteUser);
        System.out.println(userDao.getById(4));




        ReimbursementDao reimbursementDao = new ReimbursementDao();
        Reimbursement r = new Reimbursement();
        User rUser = new User();
        r.setAmount(7.14f);
        r.setAuthor(190);
        r.setDescription("Making Dough");
        r.setResolved(new Timestamp(7000));
        r.setResolver(2000);
        r.setStatus_id(443);
        r.setSubmitted(new Timestamp(9000));
        r.setType_id(807);
        rUser.setId(1);
        rUser.setUsername("pgonz");
        r.setUser(rUser);
        reimbursementDao.insert(r);

        System.out.println(reimbursementDao.getByUserId(1));
        System.out.println(reimbursementDao.getById(5));
        System.out.println(reimbursementDao.getList());

        Reimbursement deleteR = new Reimbursement();
        deleteR.setId(2);

        reimbursementDao.delete(deleteR);
        System.out.println(reimbursementDao.getById(2));
//
//
//        r.setId(11);
//        user.setId(8);
//        r.setUser(user);
//        System.out.println(reimbursementDao.getByUserId(8));
//        System.out.println(reimbursementDao.getById(11));
//        reimbursementDao.delete(deleteR);
    }
}
