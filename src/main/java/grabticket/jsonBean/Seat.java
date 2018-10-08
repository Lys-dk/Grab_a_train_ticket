/**
  * Copyright 2018 bejson.com 
  */
package grabticket.jsonBean;


public class Seat {

    private String seatName;
    private String seatNum;
    private String seatPrice;
    private String seatCode;
    private int showButton;
    public void setSeatName(String seatName) {
         this.seatName = seatName;
     }
     public String getSeatName() {
         return seatName;
     }

    public void setSeatNum(String seatNum) {
         this.seatNum = seatNum;
     }
     public String getSeatNum() {
         return seatNum;
     }

    public void setSeatPrice(String seatPrice) {
         this.seatPrice = seatPrice;
     }
     public String getSeatPrice() {
         return seatPrice;
     }

    public void setSeatCode(String seatCode) {
         this.seatCode = seatCode;
     }
     public String getSeatCode() {
         return seatCode;
     }

    public void setShowButton(int showButton) {
         this.showButton = showButton;
     }
     public int getShowButton() {
         return showButton;
     }

}