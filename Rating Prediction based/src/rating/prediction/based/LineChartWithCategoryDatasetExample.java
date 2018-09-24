package rating.prediction.based;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.LineRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * This program demonstrates how to draw line chart with CategoryDataset
 * using JFreechart library.
 * @author www.codejava.net
 *
 */
public class LineChartWithCategoryDatasetExample extends JFrame {

	public LineChartWithCategoryDatasetExample() {
		super("Line Chart Example with JFreechart");
		
		JPanel chartPanel = createChartPanel();
		add(chartPanel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private JPanel createChartPanel() {
		String chartTitle = "ALL PRODUCT CATEGORIES";
		String categoryAxisLabel = "LEVEL";
		String valueAxisLabel = "RMSE";
		
		CategoryDataset dataset = createDataset();
		
		JFreeChart chart = ChartFactory.createLineChart(chartTitle, 
				categoryAxisLabel, valueAxisLabel, dataset);
		
//		boolean showLegend = false;
//		boolean createURL = false;
//		boolean createTooltip = false;
//		
//		JFreeChart chart = ChartFactory.createLineChart(chartTitle, 
//				categoryAxisLabel, valueAxisLabel, dataset, 
//				PlotOrientation.HORIZONTAL, showLegend, createTooltip, createURL);
		
//		JFreeChart chart = ChartFactory.createLineChart3D(chartTitle, 
//				categoryAxisLabel, valueAxisLabel, dataset);		
		
		customizeChart(chart);
		
		// saves the chart as an image files
		File imageFile = new File("LineChart.png");
		int width = 640;
		int height = 480;
		
		try {
			ChartUtilities.saveChartAsPNG(imageFile, chart, width, height);
		} catch (IOException ex) {
			System.err.println(ex);
		}
		
		return new ChartPanel(chart);
	}

	private CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String series1 = "Beauty";
		String series2 = "Hotel&Travel";
		String series3 = "Pets";
		String series4 = "Shopping";
                String series5 = "Home Servise";
		String series6 = "HomeService";
		String series7 = "Nightlife";
		String series8 = "average";
		
		dataset.addValue(75, series1, "0");
		dataset.addValue(70, series1, "5");
		dataset.addValue(65, series1, "10");
		dataset.addValue(57, series1, "20");
		dataset.addValue(55, series1, "30");
		dataset.addValue(55, series1, "40");
		dataset.addValue(55, series1, "50");
                dataset.addValue(55, series1, "60");
                dataset.addValue(55, series1, "100");
                dataset.addValue(55, series1, "200");
                dataset.addValue(55, series1, "500");
                dataset.addValue(55, series1, "1000");
                dataset.addValue(60, series1, "1500");
                dataset.addValue(67, series1, "2000");
                
                dataset.addValue(70, series2, "0");
		dataset.addValue(65, series2, "5");
		dataset.addValue(60, series2, "10");
		dataset.addValue(55, series2, "20");
		dataset.addValue(50, series2, "30");
		dataset.addValue(50, series2, "40");
		dataset.addValue(50, series2, "50");
                dataset.addValue(50, series2, "60");
                dataset.addValue(50, series2, "100");
                dataset.addValue(50, series2, "200");
                dataset.addValue(50, series2, "500");
                dataset.addValue(50, series2, "1000");
                dataset.addValue(55, series2, "1500");
                dataset.addValue(65, series2, "2000");
                
                dataset.addValue(65, series3, "0");
		dataset.addValue(60, series3, "5");
		dataset.addValue(50, series3, "10");
		dataset.addValue(50, series3, "20");
		dataset.addValue(45, series3, "30");
		dataset.addValue(45, series3, "40");
		dataset.addValue(45, series3, "50");
                dataset.addValue(45, series3, "60");
                dataset.addValue(45, series3, "100");
                dataset.addValue(45, series3, "200");
                dataset.addValue(45, series3, "500");
                dataset.addValue(45, series3, "1000");
                dataset.addValue(50, series3, "1500");
                dataset.addValue(65, series3, "2000");
		
                dataset.addValue(60, series4, "0");
		dataset.addValue(55, series4, "5");
		dataset.addValue(45, series4, "10");
		dataset.addValue(45, series4, "20");
		dataset.addValue(40, series4, "30");
		dataset.addValue(40, series4, "40");
		dataset.addValue(40, series4, "50");
                dataset.addValue(40, series4, "60");
                dataset.addValue(40, series4, "100");
                dataset.addValue(40, series4, "200");
                dataset.addValue(40, series4, "500");
                dataset.addValue(40, series4, "1000");
                dataset.addValue(45, series4, "1500");
                dataset.addValue(55, series4, "2000");
                
                dataset.addValue(55, series5, "0");
		dataset.addValue(50, series5, "5");
		dataset.addValue(40, series5, "10");
		dataset.addValue(35, series5, "20");
		dataset.addValue(35, series5, "30");
		dataset.addValue(35, series5, "40");
		dataset.addValue(35, series5, "50");
                dataset.addValue(35, series5, "60");
                dataset.addValue(35, series5, "100");
                dataset.addValue(35, series5, "200");
                dataset.addValue(35, series5, "500");
                dataset.addValue(35, series5, "1000");
                dataset.addValue(40, series5, "1500");
                dataset.addValue(50, series5, "2000");
                
                dataset.addValue(50, series5, "0");
		dataset.addValue(45, series5, "5");
		dataset.addValue(35, series5, "10");
		dataset.addValue(35, series5, "20");
		dataset.addValue(35, series5, "30");
		dataset.addValue(35, series5, "40");
		dataset.addValue(35, series5, "50");
                dataset.addValue(35, series5, "60");
                dataset.addValue(35, series5, "100");
                dataset.addValue(35, series5, "200");
                dataset.addValue(35, series5, "500");
                dataset.addValue(30, series5, "1000");
                dataset.addValue(35, series5, "1500");
                dataset.addValue(40, series5, "2000");
		


		
		return dataset;
	}
	
	private void customizeChart(JFreeChart chart) {
		CategoryPlot plot = chart.getCategoryPlot();
		LineAndShapeRenderer renderer = new LineAndShapeRenderer();

		// sets paint color for each series
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesPaint(1, Color.GREEN);
		renderer.setSeriesPaint(2, Color.BLUE);
		renderer.setSeriesPaint(3, Color.YELLOW);
                renderer.setSeriesPaint(4, Color.GRAY);
                renderer.setSeriesPaint(5, Color.CYAN);

		// sets thickness for series (using strokes)
		renderer.setSeriesStroke(0, new BasicStroke(4.0f));
		renderer.setSeriesStroke(1, new BasicStroke(3.0f));
		renderer.setSeriesStroke(2, new BasicStroke(2.0f));
		renderer.setSeriesStroke(3, new BasicStroke(1.5f));
                renderer.setSeriesStroke(4, new BasicStroke(1.9f));
                 renderer.setSeriesStroke(5, new BasicStroke(2.9f));
		
		// sets paint color for plot outlines
		plot.setOutlinePaint(Color.BLUE);
		plot.setOutlineStroke(new BasicStroke(2.0f));
		
		// sets renderer for lines
		plot.setRenderer(renderer);
		
		// sets plot background
		plot.setBackgroundPaint(Color.white);
		
		// sets paint color for the grid lines
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new LineChartWithCategoryDatasetExample().setVisible(true);
			}
		});
	}
}