package ch17.exam25;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class RootController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<String, Integer> barChart; // x,y축에 들어갈 값들의 타입을 제네릭으로 선언.
    @FXML
    private AreaChart<String, Integer> areaChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        data.add(new PieChart.Data("AWT", 10));
        data.add(new PieChart.Data("Swing", 35));
        data.add(new PieChart.Data("JavaFX", 25));
        data.add(new PieChart.Data("SWT", 30));
        pieChart.setData(data);

        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
        series1.setName("남자"); // 범례 설정하기
        ObservableList<XYChart.Data<String, Integer>> data1 = FXCollections.observableArrayList();
        data1.add(new XYChart.Data<String, Integer>("2015", 40));
        data1.add(new XYChart.Data<String, Integer>("2016", 35));
        data1.add(new XYChart.Data<String, Integer>("2017", 75));
        data1.add(new XYChart.Data<String, Integer>("2018", 40));
        series1.setData(data1);
        barChart.getData().add(series1);
        // areaChart.getData().add(series1); // 데이터는 공유할 수 없다!

        XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
        series2.setName("여자"); // 범례 설정하기
        ObservableList<XYChart.Data<String, Integer>> data2 = FXCollections.observableArrayList();
        data2.add(new XYChart.Data<String, Integer>("2015", 50));
        data2.add(new XYChart.Data<String, Integer>("2016", 35));
        data2.add(new XYChart.Data<String, Integer>("2017", 65));
        data2.add(new XYChart.Data<String, Integer>("2018", 40));
        series2.setData(data2);
        barChart.getData().add(series2);
        //areaChart.getData().add(series2); // 데이터는 공유할 수 없다!

        XYChart.Series<String, Integer> series3 = new XYChart.Series<>();
        series3.setName("평균온도"); // 범례 설정하기
        ObservableList<XYChart.Data<String, Integer>> data3 = FXCollections.observableArrayList();
        data3.add(new XYChart.Data<String, Integer>("2015", 13));
        data3.add(new XYChart.Data<String, Integer>("2016", 6));
        data3.add(new XYChart.Data<String, Integer>("2017", 20));
        data3.add(new XYChart.Data<String, Integer>("2018", 18));
        series3.setData(data3);
        areaChart.getData().add(series3);
        
         XYChart.Series<String, Integer> series4 = new XYChart.Series<>();
        series4.setName("평균수면시간"); // 범례 설정하기
        ObservableList<XYChart.Data<String, Integer>> data4 = FXCollections.observableArrayList();
        data4.add(new XYChart.Data<String, Integer>("2015", 6));
        data4.add(new XYChart.Data<String, Integer>("2016", 8));
        data4.add(new XYChart.Data<String, Integer>("2017", 6));
        data4.add(new XYChart.Data<String, Integer>("2018", 7));
        series4.setData(data4);
        areaChart.getData().add(series4);
    }
}
