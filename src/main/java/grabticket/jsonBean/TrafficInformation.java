/**
  * Copyright 2018 bejson.com 
  */
package grabticket.jsonBean;


public class TrafficInformation {

    private String message;
    private String code;
    private Data data;
    public void setMessage(String message) {
         this.message = message;
     }
     public String getMessage() {
         return message;
     }

    public void setCode(String code) {
         this.code = code;
     }
     public String getCode() {
         return code;
     }

    public void setData(Data data) {
         this.data = data;
     }
     public Data getData() {
         return data;
     }

}