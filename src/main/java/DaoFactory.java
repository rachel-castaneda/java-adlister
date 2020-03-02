public class DaoFactory {

    private static Ads adsDao;
    static Ads getAdsDao(){
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }

}
