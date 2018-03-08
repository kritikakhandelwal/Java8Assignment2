package twitter.tweet.view;

//import java.util.Optional;
//import java.util.concurrent.CompletableFuture;
import edu.knoldus.Constant;
import twitter.tweet.model.Twitter;

public class Application {

    public static void main(String[] args) {

        Twitter twitter = new Twitter("#KnolFest");
        twitter.noOfTweets();
        twitter.averageTweetsPerDay();
        twitter.averageLikes();
        twitter.averageReTweets();
        try {
            Thread.sleep(Constant.THREETHOUSAND);
        } catch (InterruptedException e) {
            e.getMessage();
        }

    }
}