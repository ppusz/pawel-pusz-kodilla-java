package com.kodilla.patterns.strategy.social.Publishers;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class SnapchatPublisher implements SocialPublisher {

    @Override
    public String share() {
        return "Snapchat";
    }
}
