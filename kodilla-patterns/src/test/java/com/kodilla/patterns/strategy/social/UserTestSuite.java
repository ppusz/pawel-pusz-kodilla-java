package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.Publishers.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.Publishers.TwitterPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User millenial = new Millenials("John Somebody");
        User yGenUser = new YGeneration("Alexa Febra");
        User zGenUser = new ZGeneration("Grzegorz Brzęczyszczykiewicz");

        //When
        String millenialShare = millenial.sharePost();
        String yGenShare = yGenUser.sharePost();
        String zGenShare = zGenUser.sharePost();
        System.out.println(millenial.getName() + " is " + millenialShare);
        System.out.println(yGenUser.getName() + " is " + yGenShare);
        System.out.println(zGenUser.getName() + " is " + zGenShare);

        //Then
        Assert.assertEquals("sharing on Facebook", millenialShare);
        Assert.assertEquals("sharing on Twitter", yGenShare);
        Assert.assertEquals("sharing on Snapchat", zGenShare);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User developingUser = new Millenials("Mr. X");

        //When
        String firstShare = developingUser.sharePost();
        System.out.println(developingUser.getName() + " is " + firstShare);
        developingUser.setSocialPublisher(new TwitterPublisher());
        String secondShare = developingUser.sharePost();
        System.out.println(developingUser.getName() + " is " + secondShare);
        developingUser.setSocialPublisher(new SnapchatPublisher());
        String thirdShare = developingUser.sharePost();
        System.out.println(developingUser.getName() + " is " + thirdShare);

        //Then
        Assert.assertEquals("sharing on Facebook", firstShare);
        Assert.assertEquals("sharing on Twitter", secondShare);
        Assert.assertEquals("sharing on Snapchat", thirdShare);
    }

}
