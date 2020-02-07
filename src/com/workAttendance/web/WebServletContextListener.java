/**
 * 
 */
package com.workAttendance.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author xiaoli.zhan
 *  2014-11-11
 */
public class WebServletContextListener implements ServletContextListener{
	private static ServletContext servletContext=null;
	private  final Logger logger = LoggerFactory.getLogger(getClass());
	
	public static ServletContext getServletContext() {
		//logger.info("------getServletContext------:"+servletContext.toString());
		return servletContext;
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		servletContext=null;
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		servletContext=event.getServletContext();
		logger.info("------contextInitialized------:"+servletContext.toString());
		/*SensorService sensorService = (SensorService)ContextUtil.getSpringBean("sensorService", SensorService.class);
		List<Sensor> sens = sensorService.getSensor();
		Global.sensors = (Sensor[]) (sens.toArray(new Sensor[0]));
		
		for (Sensor sensor : Global.sensors) {
			Sensor01 sen01 = new Sensor01();
			sen01.setSensor(sensor);
			Sen01Curr.getInstance().getSen01s().put(sensor.getSenId(),sen01);
		}
		logger.info("初始化传感器:"+Global.sensors .length);*/

/*		//Simulator初始化
		Simulator.getInstance();*/
	}
}
