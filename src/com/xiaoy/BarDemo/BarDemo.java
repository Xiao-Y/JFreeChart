package com.xiaoy.BarDemo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;

/**
 * @author XiaoY
 *
 * @explain 
 * 饼状图
 * @date: 
 * 2015年1月1日 下午3:26:38
 */
public class BarDemo
{
	public static void main(String[] args)
	{
		JFreeChart chart = ChartFactory.createBarChart3D(
									  title, //主标题，不能为空
									  categoryAxisLabel, 
									  valueAxisLabel, 
									  dataset, 
									  orientation, 
									  legend,//子标题（图例） 
									  tooltips, 
									  urls
									  );
	}
}
