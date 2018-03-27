package UI;



import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import Game.Stats;

public class Histogram{

	private DefaultCategoryDataset dataset;
	private Stats stats;
	public ChartPanel chart;
   public Histogram(Stats stats) {
      //super("");
      this.stats = stats;
      dataset = new DefaultCategoryDataset();
      JFreeChart lineChart = ChartFactory.createLineChart(
         "Histogram",
         "Days", "Stats",
         dataset,
         PlotOrientation.VERTICAL,
         true,true,false);
         
      
      chart = new ChartPanel(lineChart);
      //chart.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      chart.setPreferredSize( new java.awt.Dimension( 600 , 367 ) );
      updateData();
      //setContentPane(chart);
      
   }

   public void updateData() {
      dataset.addValue( Stats.coins , "Coins" , Stats.day + "" );
      dataset.addValue( Stats.food , "Food" , Stats.day + "" );
      dataset.addValue( Stats.population , "Population" , Stats.day + "" );
      dataset.addValue( Stats.defense , "Defense" , Stats.day + "" );
      dataset.addValue( Stats.happiness , "Happiness" , Stats.day + "" );

   }
   

}
