/**
  * Copyright 2018 bejson.com 
  */
package grabticket.jsonBean.getBillJsonBean;
import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2018-09-12 22:11:56
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

    private String deptStationCode;
    private String arrStationCode;
    private String trainCode;
    private Date deptDate;
    private String seatPrice;
    private String runTime;
    private String deptTime;
    private int packId;
    private List<Passengers> passengers;
    private ContactsInfo contactsInfo;
    private boolean usingTrainAccount;
    private String trainZWCode;
    private String source;
    private String clientTotalFee;
    private String reserveTrainCode;
    private String reserveZwCode;
    public void setDeptStationCode(String deptStationCode) {
         this.deptStationCode = deptStationCode;
     }
     public String getDeptStationCode() {
         return deptStationCode;
     }

    public void setArrStationCode(String arrStationCode) {
         this.arrStationCode = arrStationCode;
     }
     public String getArrStationCode() {
         return arrStationCode;
     }

    public void setTrainCode(String trainCode) {
         this.trainCode = trainCode;
     }
     public String getTrainCode() {
         return trainCode;
     }

    public void setDeptDate(Date deptDate) {
         this.deptDate = deptDate;
     }
     public Date getDeptDate() {
         return deptDate;
     }

    public void setSeatPrice(String seatPrice) {
         this.seatPrice = seatPrice;
     }
     public String getSeatPrice() {
         return seatPrice;
     }

    public void setRunTime(String runTime) {
         this.runTime = runTime;
     }
     public String getRunTime() {
         return runTime;
     }

    public void setDeptTime(String deptTime) {
         this.deptTime = deptTime;
     }
     public String getDeptTime() {
         return deptTime;
     }

    public void setPackId(int packId) {
         this.packId = packId;
     }
     public int getPackId() {
         return packId;
     }

    public void setPassengers(List<Passengers> passengers) {
         this.passengers = passengers;
     }
     public List<Passengers> getPassengers() {
         return passengers;
     }

    public void setContactsInfo(ContactsInfo contactsInfo) {
         this.contactsInfo = contactsInfo;
     }
     public ContactsInfo getContactsInfo() {
         return contactsInfo;
     }

    public void setUsingTrainAccount(boolean usingTrainAccount) {
         this.usingTrainAccount = usingTrainAccount;
     }
     public boolean getUsingTrainAccount() {
         return usingTrainAccount;
     }

    public void setTrainZWCode(String trainZWCode) {
         this.trainZWCode = trainZWCode;
     }
     public String getTrainZWCode() {
         return trainZWCode;
     }

    public void setSource(String source) {
         this.source = source;
     }
     public String getSource() {
         return source;
     }

    public void setClientTotalFee(String clientTotalFee) {
         this.clientTotalFee = clientTotalFee;
     }
     public String getClientTotalFee() {
         return clientTotalFee;
     }

    public void setReserveTrainCode(String reserveTrainCode) {
         this.reserveTrainCode = reserveTrainCode;
     }
     public String getReserveTrainCode() {
         return reserveTrainCode;
     }

    public void setReserveZwCode(String reserveZwCode) {
         this.reserveZwCode = reserveZwCode;
     }
     public String getReserveZwCode() {
         return reserveZwCode;
     }

}