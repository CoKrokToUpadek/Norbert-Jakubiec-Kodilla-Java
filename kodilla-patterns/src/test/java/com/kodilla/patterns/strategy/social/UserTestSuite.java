package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTestSuite {
    @Test
    void testDefaultSharingStrategies(){
        //given
        User facebookUser = new Millenials("tom");
        User snapchatUser = new ZGeneration("mark");
        User twitterUser = new YGeneration("andrew");

        //when
        String facebookUserShare=facebookUser.sharePost();
        String snapchatUserShare=snapchatUser.sharePost();
        String twitterUserShare=twitterUser.sharePost();

        //then
        Assertions.assertEquals("Facebook",facebookUserShare);
        Assertions.assertEquals("Twitter",twitterUserShare);
        Assertions.assertEquals("Snapchat",snapchatUserShare);
    }

    @Test
    void testIndividualSharingStrategy(){
        //given
        User facebookUser = new Millenials("tom");

        //when
        facebookUser.setMedia(new TwitterPublisher());
        String facebookUserShare=facebookUser.sharePost();

        //then
        Assertions.assertEquals("Twitter",facebookUserShare);

    }


}
