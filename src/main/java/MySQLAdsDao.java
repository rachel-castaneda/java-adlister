import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public MySQLAdsDao() {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    Config.URL,
                    Config.USERNAME,
                    Config.PASSWORD
            );
            System.out.println("database connection successful");
        } catch (SQLException ex) {
            System.out.println("database connection failure");
        }

    }

    @Override
    public Long insert(Ad ad) {
        String query = String.format(
                "INSERT INTO ads(user_id, title, description)"+
                        "VALUES (%d, '%s', '%s');", ad.getUserId(), ad.getTitle(), ad.getDescription()
        );
        try {
            Statement stmt = connection.createStatement();
            long id = (long)stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            System.out.println("successfully created new ad");
            return id;
        } catch (SQLException ex) {
            System.out.println("there was an error creating new ad");
        }
        return null;
    }

    @Override
    public List<Ad> all() {
        String query = "SELECT * FROM ads;";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            List<Ad> ads = new ArrayList<>();
            while (rs.next()) {
                ads.add(new Ad(
                        rs.getLong(1),
                        rs.getLong(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }
            return ads;
        } catch (SQLException ex) {
            System.out.println("there was an error retrieving ads");
        }
        return null;
    }

    @Override
    public List<Ad> allSortedByTitle() {
        return null;
    }

    @Override
    public List<Ad> getAllByUser(long userId) {
        return null;
    }

    @Override
    public List<Ad> getAdsByCategory(String category) {
        return null;
    }

    @Override
    public Ad getOne(long id) {
        return null;
    }

    @Override
    public Ad retrieve(long id) {
        return null;
    }

//    @Override
//    public boolean delete(long id) {
//        for (Ad ad  : ads) {
//            if (ad.getId() == id)
//                ads.remove(ad);
//            return true;
//        }
//        return false;
//    }

    @Override
    public boolean update(Ad ad) {
        return false;
    }

    @Override
    public boolean refresh(Ad ad) {
        return false;
    }

    public static void main(String[] args) {
        MySQLAdsDao dao = new MySQLAdsDao();
        Ad newAd = new Ad(1, "Test", "test");
        dao.insert(newAd);
        List<Ad> ads = dao.all();
        for (Ad ad : ads) {
            System.out.println(ad.getTitle());
        }
    }
}
