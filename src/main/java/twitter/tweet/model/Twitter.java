package twitter.tweet.model;

import edu.knoldus.Constant;
import twitter4j.Query;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

public class Twitter {

    private twitter4j.Twitter twitter = new TwitterFactory().getInstance();
    private Query query;

    public Twitter(final String hashTag) {
        Properties properties = new Properties();
        try {
            InputStream input = new FileInputStream("/home/knoldus/IdeaProjects/"
                    + "AssignmentJava2/src/" + "main/resources/application.config");
            properties.load(input);
            twitter.setOAuthConsumer(properties.getProperty("consumerKey"),
                    properties.getProperty("consumerSecretKey"));
            twitter.setOAuthAccessToken(new AccessToken(properties
                    .getProperty("accessToken"), properties.getProperty("accessSecretToken")));
            query = new Query(hashTag);
            query.setCount(Constant.HUNDRED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return g total number of tweets from hashTag.
     */
    public CompletableFuture<Integer> noOfTweets() {
        return CompletableFuture.supplyAsync(() -> {
            Integer tweetsCount = Constant.IZERO;
            try {
                //System.out.println(twitter.search(query).getTweets());
                tweetsCount = twitter.search(query).getTweets().size();
            } catch (TwitterException e) {
                e.getMessage();
            }
            return tweetsCount;
        }).thenApply(x -> {
            System.out.println("total tweets" + x);
            return x;
        });
    }

    /**
     * @return average tweets per day.
     */
    public CompletableFuture<Double> averageTweetsPerDay() {

        return CompletableFuture.supplyAsync(() -> {

            Double averageTweets = Constant.ZERO;
            try {
                averageTweets = twitter.search(query).getTweets().size() / Constant.SEVEN;
            } catch (TwitterException e) {
                e.getMessage();
            }
            return averageTweets;
        }).thenApply(x -> {
            System.out.println("average tweets per day" + x);
            return x;
        });
    }

    /**
     * @return Average Like Count.
     */
    public CompletableFuture<Double> averageLikes() {
        return CompletableFuture.supplyAsync(() -> {
            Double averageLike = Constant.ZERO;
            try {

                List<Status> twitterStatus = twitter.search(query).getTweets();
                Double twitterSize = twitterStatus.size() + Constant.ZERO;
                averageLike = twitterStatus.parallelStream()
                        .map(tweets -> tweets.getFavoriteCount()).reduce((a, b) -> a + b)
                        .get() / twitterSize;
            } catch (TwitterException te) {
                te.getMessage();
            }
            return averageLike;
        }).thenApply(x -> {
            System.out.println("average likes" + x);
            return x;
        });
    }

    /**
     * @return Average ReTweetCount.
     */
    public CompletableFuture<Double> averageReTweets() {
        return CompletableFuture.supplyAsync(() -> {
            Double totalReTweet = Constant.ZERO;
            try {
                List<Status> twitterStatus = twitter.search(query).getTweets();
                Double twitterSize = twitterStatus.size() + Constant.ZERO;
                totalReTweet = twitterStatus.parallelStream()
                        .map(tweets -> tweets.getRetweetCount())
                        .reduce((a, b) -> a + b).get() / twitterSize;
            } catch (TwitterException te) {
                te.getMessage();
            }
            return totalReTweet;
        }).thenApply(x -> {
            System.out.println("Average reTweets " + x);
            return x;
        });
    }
}


