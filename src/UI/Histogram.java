package UI;



import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import Game.Stats;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Histogram extends ApplicationFrame {

	private DefaultCategoryDataset dataset;
	private Stats stats;
	public ChartPanel chart;
   public Histogram(Stats stats) {
      super("");
      this.stats = stats;
      dataset = new DefaultCategoryDataset();
      JFreeChart lineChart = ChartFactory.createLineChart(
         "Histogram",
         "Days", "Stats",
         dataset,
         PlotOrientation.VERTICAL,
         true,true,false);
         
      
      chart = new ChartPanel(lineChart);
      chart.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      updateData();
      //setContentPane(chart);
      
   }

   public void updateData() {
      dataset.addValue( stats.coins , "Coins" , stats.day + "" );
      dataset.addValue( stats.food , "Food" , stats.day + "" );
      dataset.addValue( stats.population , "Population" , stats.day + "" );
      dataset.addValue( stats.defense , "Defense" , stats.day + "" );
      dataset.addValue( stats.happiness , "Happiness" , stats.day + "" );

   }
   

}
