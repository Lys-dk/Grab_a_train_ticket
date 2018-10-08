/**
  * Copyright 2018 bejson.com 
  */
package grabticket.jsonBean;

import java.util.List;


public class Data {

    private List<TrainInfos> trainInfos;
    private List<TrainDeptStations> trainDeptStations;
    private List<TrainArrStations> trainArrStations;
    public void setTrainInfos(List<TrainInfos> trainInfos) {
         this.trainInfos = trainInfos;
     }
     public List<TrainInfos> getTrainInfos() {
         return trainInfos;
     }

    public void setTrainDeptStations(List<TrainDeptStations> trainDeptStations) {
         this.trainDeptStations = trainDeptStations;
     }
     public List<TrainDeptStations> getTrainDeptStations() {
         return trainDeptStations;
     }

    public void setTrainArrStations(List<TrainArrStations> trainArrStations) {
         this.trainArrStations = trainArrStations;
     }
     public List<TrainArrStations> getTrainArrStations() {
         return trainArrStations;
     }

}