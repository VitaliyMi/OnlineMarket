package data;

import application.AppConfig;
import model.Client;
import model.Dish;
import model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI on 19.05.2016.
 */
public class DBInitializer {

    @Autowired
    private static DAOClass daoClass;

 /*   private final static String createUsersTableSQL =
            "CREATE TABLE users" +
                    "(user_id Integer unsigned AUTO_INCREMENT PRIMARY KEY, " +
                    "userName varchar(50) )" ;

    private final static String createDishesTableSQL =
            "CREATE TABLE dishes" +
                    "(dish_id Integer AUTO_INCREMENT PRIMARY KEY, " +
                    "dishName varchar(50), " +
                    "price Integer, " +
                    "url longtext)";

    private final static String createTransactionTableSQL=
            " CREATE TABLE transactions" +
                    "(transaction_id Integer AUTO_INCREMENT PRIMARY KEY ," +
                    "dish_id Integer Not NULL ," +
                    "user_id Integer NOT NULL ," +
                    "amount Integer,"+

                    "CONSTRAINT `FK_dish`" +
                    "  FOREIGN KEY (`dish_id`)" +
                    "  REFERENCES `dishes` (`dish_id`),"+
                    "CONSTRAINT `FK_user`" +
                    "  FOREIGN KEY (`user_id`)" +
                    "  REFERENCES `users` (`user_id`))";
*/
    private static Connection con ;
    private static Statement stmt;

    static
    {
        try
        {
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            stmt = con.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void initializeAndPopulateDB() throws SQLException {
        try
        {
            createDB();
            populateDBWithDishes();
            checkData();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }



    private static void createDB() throws SQLException
    {
        stmt.executeUpdate("DROP TABLE IF EXISTS users");
        createUsersTable();

        stmt.executeUpdate("DROP TABLE IF EXISTS dishes");
        createDishesTable();

        stmt.executeUpdate("DROP TABLE IF EXISTS transactions");
        createTransactionTable();


    }


    private static void populateDBWithDishes() throws SQLException
    {
        stmt.executeUpdate("Insert INTO dishes VALUES (1, 'Frog legs', 12 ,'http://oddstuffmagazine.com/wp-content/uploads/2010/09/Fried-frog-legs.jpg' )");
        stmt.executeUpdate("Insert INTO dishes VALUES (2, 'Fried potatoes', 2 ,'http://d3lp4xedbqa8a5.cloudfront.net/s3/digital-cougar-assets/food/2014/11/28/AustralianTableBR113278/pan-fried-potatoes.jpg' )");
        stmt.executeUpdate("Insert INTO dishes  VALUES (3, 'Greek salad', 5 ,'http://www.laaloosh.com/wp-content/uploads/2015/09/Greek-Salad-2-675x462.jpg' )");

    }

    public static void checkData() throws SQLException {
            ResultSet rs = stmt.executeQuery("SELECT * FROM dishes");
            while (rs.next())
            {
                String name = rs.getString("dishName");
                System.out.println(name);
            }
        System.out.println("Success!!!");
    }



private static void createUsersTable() throws SQLException
{
    System.out.println("Creating users table");
 //   stmt.executeUpdate(createUsersTableSQL);
    System.out.println("Users table created");

}


    private static void createDishesTable() throws SQLException
    {
        System.out.println("Creating dishes table");
 //       stmt.executeUpdate(createDishesTableSQL);
        System.out.println("Dishes table created");
    }


    private static void createTransactionTable() throws SQLException
    {
 //       stmt.executeUpdate(createTransactionTableSQL);

    }

    public static void delete() {
        try {
            stmt.executeUpdate("DROP TABLE IF EXISTS users");

            stmt.executeUpdate("DROP TABLE IF EXISTS dishes");

            stmt.executeUpdate("DROP TABLE IF EXISTS transactions");
          /*  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.register(AppConfig.class);
            ctx.refresh();
            daoClass = (DAOClass) ctx.getBean("daoClass");
            initializeAndPopulateDB();
            Client c = new Client("Dmitro");

            Dish d1 = daoClass.getDish("Greek salad");
            Dish d2= daoClass.getDish("Fried potatoes");
            Dish d3 = new Dish();
            d3.setName("borstch");
            d3.setPrice(3);
            List<Transaction> list = new ArrayList<>();
            list.add(new Transaction(c, d1,1));
            list.add(new Transaction(c, d2,2));
            list.add(new Transaction(c, d3,2));
            c.addTransactions(list);
            daoClass.addDish(d3);
             List<Dish> menu = daoClass.getMenu();
            System.out.println(menu);
            checkData();
         //   daoClass.saveTransactions(list);
            System.out.println(c.getTransactions());

            daoClass.addClient(c);
            Client c2 = daoClass.getClient("Dmitro");

            List<Transaction>transactionList=c2.getTransactions();
            for(Transaction t: transactionList)
            {
                System.out.println(t.getDish().getName()+ t.getDish().getPrice());
            }
            System.out.println(c.getTransactions());
            System.out.println("finish");*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
