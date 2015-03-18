package com.hallayus.algoperm.algoperm;

import java.awt.Color;
import java.awt.GradientPaint;
import java.util.HashMap;

import javax.swing.*;

import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;

import com.hallayus.algoperm.algoperm.algorithms.CopiedQuickSort;
import com.hallayus.algoperm.algoperm.algorithms.InsertionSort;


public class App implements Runnable
{
	private static final String APP_NAME = "Algorithm Permutation Frequency";
	private DefaultCategoryDataset data;
	
	private App(DefaultCategoryDataset data)
	{
		this.data = data;
	}
	
    public static void main( String[] args )
    {
        PermutationTraverser t = new PermutationTraverser(5);
        HashMap<Integer,Integer> isortdata = t.getOperationCount(new InsertionSort());
        HashMap<Integer,Integer> qsortdata = t.getOperationCount(new CopiedQuickSort());

        /*
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        h.put(1, 3);
        h.put(2, 7);
        h.put(3, 5);
        h.put(4, 2);
        */
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        convertData(dataset,isortdata, "Insertion Sort");
        convertData(dataset,qsortdata, "Quick Sort");
        
        
    	javax.swing.SwingUtilities.invokeLater(new App(dataset));
    }

	public void run() {
		JFrame frame = new JFrame(APP_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        
        final JFreeChart chart = ChartFactory.createBarChart(
                "Bar Chart Demo",         // chart title
                "Category",               // domain axis label
                "Value",                  // range axis label
                data,                  // data
                PlotOrientation.VERTICAL, // orientation
                true,                     // include legend
                true,                     // tooltips?
                false                     // URLs?
            );
        
     // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());


        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        
        ChartPanel panel = new ChartPanel(chart);
        
        frame.add(panel);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        
	}
	
	private static void convertData(DefaultCategoryDataset data, HashMap<Integer,Integer> map, String dataname)
	{
		for(Integer key : map.keySet()) {
			data.addValue((double)map.get(key),(Comparable)dataname, (Comparable)key);
		}		
	}
}
