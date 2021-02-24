package com.yunixi.rsscollector.service;

import com.rometools.rome.feed.module.DCModuleImpl;
import com.rometools.rome.feed.module.Module;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndEntryImpl;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.yunixi.rsscollector.vo.RssFeedVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service@RequiredArgsConstructor
public class RssFeedService {
     public String readRssData(String url) {
        System.out.println(url);
        List<RssFeedVO> rssfeedList = new ArrayList<>();
        try {
            URLConnection urlConnection = new URL(url).openConnection();
            InputSource source = new InputSource(urlConnection.getInputStream());
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed syndFeed = input.build(source);

            List res = syndFeed.getEntries();
//            for(Object o : res) {
//                System.out.println(((SyndEntryImpl) o).getDescription().getValue());
//            }

            for(SyndEntry feed : syndFeed.getEntries()) {
                RssFeedVO rssFeedVO = new RssFeedVO();
                rssFeedVO.setLink(feed.getLink());
                rssFeedVO.setTitle(feed.getTitle());
                rssFeedVO.setDescription(feed.getDescription().getValue());
                Module module = ((SyndEntryImpl) feed).getModules().get(0);

//                rssFeedVO.setDate(((SyndEntryImpl) feed).getModules().get(0).toString());
                rssfeedList.add(rssFeedVO);
            }

            rssfeedList.forEach(x -> {
                System.out.println(x);
            });



        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
