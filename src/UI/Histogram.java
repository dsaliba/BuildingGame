package UI;



import java.awt.Color;

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
      lineChart.setBackgroundPaint(new Color(0xFF, 0xFF, 0xFF, 0));
      lineChart.getTitle().setPaint(Color.WHITE);
      lineChart.setBorderPaint(Color.WHITE);
      lineChart.getCategoryPlot().setOutlinePaint(Color.WHITE);
      chart = new ChartPanel(lineChart);
      chart.setPreferredSize( new java.awt.Dimension( 1000 , 367 ) );
     
      updateData();
      chart.setOpaque(false);
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
