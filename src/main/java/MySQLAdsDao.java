import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private static Config config;
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.URL,
                    config.USERNAME,
                    config.PASSWORD
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
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads;");
            return createAdsFromResults(rs);
        } catch (SQLException ex) {
            System.out.println("there was an error retrieving ads");
        }
        return null;
    }
    
    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }
    
    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
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

    @Override
    public boolean delete(long id) {

        return false;
    }

    @Override
    public boolean update(Ad ad) {
        return false;
    }

    @Override
    public boolean refresh(Ad ad) {
        return false;
    }

    public static void main(String[] args) {
        MySQLAdsDao dao = new MySQLAdsDao(config);
//        Ad newAd = new Ad(1, "Test", "test");
//        dao.insert(newAd);
        List<Ad> ads = dao.all();
        for (Ad ad : ads) {
            System.out.println(ad.getTitle());
        }
    }
}
