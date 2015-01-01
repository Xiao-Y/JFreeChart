package com.xiaoy.LineDemo;

import java.awt.Font;
import java.awt.Rectangle;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author XiaoY
 *
 * @explain 
 *	线形图
 * @date: 
 * 2015年1月1日 下午8:35:54
 */
public class LineDemo
{
	public static void main(String[] args)
	{
		//数据集
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(5, "季度", "一季度");
		dataset.addValue(2, "季度", "二季度");
		dataset.addValue(10, "季度", "三季度");
		dataset.addValue(1, "季度", "四季度");
		
		JFreeChart chart = ChartFactory.createLineChart(
				"销售量",					//主标题 
				"季度", 						//种类轴（x轴）
				"数量", 						//值轴（y轴）
				dataset, 					//数据集
				PlotOrientation.VERTICAL,	//显示的方向（水平、垂直）
				true, 						//是否显示子标题
				true, 						//是否显示工具
				true						//是否显示url
				);
		
		//处理乱码
		//处理主标题
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		//处理子标题
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 14));
		
		//2、获取图表区域对象(每个种类都不一样，可以输出获取chart.getPlot()的返回值)
		CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
		
		//2.1获取x轴对象
		CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
		//x轴上的对象
		categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 14));
		//x轴外面的对象
		categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 14));
		
		//2.2获取y轴对象
		NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
		//y轴上的对象
		numberAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 14));
		//y轴外面的对象
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 14));
		
		//2.3获取绘图区域的对象
		LineAndShapeRenderer line = (LineAndShapeRenderer) categoryPlot.getRenderer();
		//在图形上显示数字
		line.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		//设置可显
		line.setBaseItemLabelsVisible(true);
		//设置字体
		line.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 14));
		
		//设置转折点（小矩形）
		//小矩形
		Rectangle shape = new Rectangle(7,7);
		//参数: 0 表示第一个，shape:表示小矩形
		line.setSeriesShape(0, shape);
		//设置可显	参数: 0 表示第一个，true:表示显示
		line.setSeriesShapesVisible(0, true);
		
		ChartFrame chartFrame = new ChartFrame("kkth", chart);
		chartFrame.setVisible(true);
		chartFrame.pack();
	}
}
