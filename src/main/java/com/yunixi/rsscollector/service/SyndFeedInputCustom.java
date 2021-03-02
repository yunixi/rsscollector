package com.yunixi.rsscollector.service;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.WireFeedInput;
import org.xml.sax.InputSource;

import java.util.Locale;

public class SyndFeedInputCustom {

    private final WireFeedInput feedInput;
    private boolean preserveWireFeed = false;

    public SyndFeedInputCustom() {
        this(false, Locale.US);
    }

    public SyndFeedInputCustom(final boolean validate, final Locale locale) {
        feedInput = new WireFeedInput(validate, locale);
    }

    public SyndFeed build(final InputSource is) throws IllegalArgumentException, FeedException {
        return new SyndFeedImpl(feedInput.build(is), preserveWireFeed);
    }
}
