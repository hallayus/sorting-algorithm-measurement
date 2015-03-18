package com.hallayus.algoperm.algoperm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.DefaultCategoryDataset;


import com.hallayus.algoperm.algoperm.algorithms.InsertionSort;
/**
 * Hello world!
 *
 */
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
        PermutationTraverser t = new PermutationTraverser(6);
        HashMap<Integer,Integer> h = t.getOperationCount(new InsertionSort());
        /*
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        h.put(1, 3);
        h.put(2, 7);
        h.put(3, 5);
        h.put(4, 2);
        */
        DefaultCategoryDataset data = convertData(h, "Sort");
    	javax.swing.SwingUtilities.invokeLater(new App(data));
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
        
        ChartPanel panel = new ChartPanel(chart);
        
        frame.add(panel);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        
	}
	
	private static DefaultCategoryDataset convertData(HashMap<Integer,Integer> map, String dataname)
	{
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Integer key : map.keySet()) {
			dataset.addValue((double)map.get(key), (Comparable)key, (Comparable)dataname);
		}
		
		return dataset;
	}
}
