/**
  * Copyright 2018 bejson.com 
  */
package grabticket.jsonBean;


public class TrainDeptStations {

    private String cityCode;
    private String cityName;
    private String cityIndex;
    private String cityFullPinyin;
    private String cityShortPinyin;
    public void setCityCode(String cityCode) {
         this.cityCode = cityCode;
     }
     public String getCityCode() {
         return cityCode;
     }

    public void setCityName(String cityName) {
         this.cityName = cityName;
     }
     public String getCityName() {
         return cityName;
     }

    public void setCityIndex(String cityIndex) {
         this.cityIndex = cityIndex;
     }
     public String getCityIndex() {
         return cityIndex;
     }

    public void setCityFullPinyin(String cityFullPinyin) {
         this.cityFullPinyin = cityFullPinyin;
     }
     public String getCityFullPinyin() {
         return cityFullPinyin;
     }

    public void setCityShortPinyin(String cityShortPinyin) {
         this.cityShortPinyin = cityShortPinyin;
     }
     public String getCityShortPinyin() {
         return cityShortPinyin;
     }

}