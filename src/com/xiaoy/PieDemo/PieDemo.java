package com.xiaoy.PieDemo;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 * @author XiaoY
 *
 * @explain 
 *	饼形图
 * @date: 
 * 2015年1月2日 下午2:16:06
 */
public class PieDemo
{
	public static void main(String[] args) throws IOException
	{
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("农业", 26.32);
		dataset.setValue("渔业", 8.21);
		dataset.setValue("电信业", 34.02);
		dataset.setValue("IT业", 27.56);
		dataset.setValue("IT业", 33.79);
		dataset.setValue("其它", 17.34);
		
		JFreeChart chart = ChartFactory.createPieChart3D(
				"生产总值", //主标题
				dataset, //数据集
				true, //是否显示图例
				true, //是否显示工具
				true//是否生成url
				);
		//处理中文
		//处理主标题
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		//处理图例
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));
		//获取图表区域对象
		PiePlot3D piePlot = (PiePlot3D) chart.getPlot();
		piePlot.setLabelFont(new Font("宋体", Font.BOLD, 15));
		
		//格式：“上海 32 （34%）”
		String format = "{0} {1} ({2})";
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(format));
		
		//显示
//		ChartFrame frame = new ChartFrame("yyy", chart);
//		frame.setVisible(true);
//		frame.pack();
		
		//生成图片
		File file = new File("D:\\chartPieDemo.jpeg");
		ChartUtilities.saveChartAsJPEG(file, chart, 800, 600);
		System.out.println("图片生成完毕...");
	}
}















