package com.hpzl.businessedition.model;

import java.util.List;

/**
 * @author admin
 * @date 2018/1/31
 */

public class RoomTypeModel {



    public int code;
    public String message;
    public List<ContentBean> content;

    public static class ContentBean {
        /**
         * id : 82
         * name : 小包
         * book_price : 1.00
         * mans : 6
         */

        public String id;
        public String name;
        public String book_price;
        public String mans;
    }
}
