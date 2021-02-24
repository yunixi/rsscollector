package com.yunixi.rsscollector.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RssFeedVO {

    private String link;
    private String title;
    private String description;
    private String date;
}
