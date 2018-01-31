package com.hpzl.businessedition.model;

import com.hpzl.businessedition.base.BaseModel;

/**
 * @author admin
 * @date 2018/1/31
 */

public class LoginModel extends BaseModel {

    /**
     * code : 0
     * message : 请求成功
     * content : {"id":"43","store_id":"1","mobile":"13668018462","created_time":"1517209420","status":"2","token":"eyJpZCI6IjQzIiwibm9uY2UiOiJuVGRrcWhWSyIsIm1vYmlsZSI6IjEzNjY4MDE4NDYyIn0="}
     */


    public ContentBean content;

    public static class ContentBean {
        /**
         * id : 43
         * store_id : 1
         * mobile : 13668018462
         * created_time : 1517209420
         * status : 2
         * token : eyJpZCI6IjQzIiwibm9uY2UiOiJuVGRrcWhWSyIsIm1vYmlsZSI6IjEzNjY4MDE4NDYyIn0=
         */

        public String id;
        public String store_id;
        public String mobile;
        public String created_time;
        public String status;
        public String token;
    }
}
