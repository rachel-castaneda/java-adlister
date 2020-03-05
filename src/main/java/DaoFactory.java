public class DaoFactory {
    private static Ads adsDao;
    private static Config config = new Config();

    public static Ads getAdsDao(Config config) {
        if (adsDao == null) {
//            adsDao = new ListAdsDao();
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }
}
