package login.dao;

public class test {
    public static void main(String[] args) {
        ILoginDaoImpl loginDao = new ILoginDaoImpl();
        int a = loginDao.login("admin@gmail.com","123","admin");
        System.out.println("value "+a);
    }
}
