/**
  * Copyright 2018 bejson.com 
  */
package Http;
import java.util.List;

/**
 * Auto-generated: 2018-09-10 15:42:52
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
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