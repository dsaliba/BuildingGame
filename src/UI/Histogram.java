//package UI;
//
//
//
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.JFreeChart;
//import org.jfree.ui.ApplicationFrame;
//import org.jfree.ui.RefineryUtilities;
//
//import Game.Stats;
//
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.DefaultCategoryDataset;
//
//public class Histogram extends ApplicationFrame {
//
//   public Histogram(Stats stats) {
//      super("");
//      JFreeChart lineChart = ChartFactory.createLineChart(
//         "Histogram",
//         "Days", "Stats",
//         //createDataset(),
//         PlotOrientation.VERTICAL,
//         true,true,false);
//         
//      ChartPanel chartPanel = new ChartPanel(lineChart);
//      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
//      setContentPane(chartPanel);
//   }
//
////   private DefaultCategoryDataset addData(String[] data) {
////      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
////      dataset.addValue( 15 , "schools" , "1970" );
////      dataset.addValue( 30 , "schools" , "1980" );
////      dataset.addValue( 60 , "schools" ,  "1990" );
////      dataset.addValue( 120 , "schools" , "2000" );
////      dataset.addValue( 240 , "schools" , "2010" );
////      dataset.addValue( 300 , "schools" , "2014" );
////      return dataset;
////   }
//   
//
//}
