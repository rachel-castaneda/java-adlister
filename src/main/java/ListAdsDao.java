import java.util.ArrayList;
import java.util.List;

public class ListAdsDao implements Ads{

    private List<Ad> ads;

    public List<Ad> all () {
        if(ads == null) {
            ads = generateAds();
        }
        return ads;
    }

    private List<Ad> generateAds() {
        List<Ad> ads = new ArrayList<>();
        ads.add(new Ad(
                1,
                1,
                "playstation for sale",
                "slightly used playstation"
        ));
        ads.add(new Ad(
                2,
                1,
                "super nintendo",
                "brand new, old school classic"
        ));
        ads.add(new Ad(
                3,
                2,
                "junior java developer position",
                "minimum 7 years experience"
        ));
        ads.add(new Ad(
                4,
                2,
                "javascript developer needed",
                "must ahve strong java skills"
        ));
        return ads;
    }

}
