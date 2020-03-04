import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    List<Ad> allSortedByTitle();
    List<Ad> getAllByUser(long userId);
    List<Ad> getAdsByCategory(String category);
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    Ad getOne(long id);
    Ad retrieve (long id);

    boolean delete (long id);
    boolean update (Ad ad);
    boolean refresh (Ad ad);
}
