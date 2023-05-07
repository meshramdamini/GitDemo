package com.newFramwork.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	// to read the config.proprties file we create read config class in which we create object of properites class
	//and create construvtor in that initalize properties class or crate object afet that create object of file input stream
	//class and send one parameter in that   the to load we properties.load method in that we pass the file input steam object
	//after that we create the methods of config prop file object like url etc
	//to get the values
	Properties properties;
	
	String path = "F:\\ECLIPSE_PROJECTS\\newFramwork\\configuration\\config.properties";
	
	
	//constructor
 public ReadConfig()
 {
	 properties = new Properties();
	 
	 try 
	 {
		FileInputStream Fis = new  FileInputStream(path);
	    try 
	    {
			properties.load(Fis);
		} 
	    catch (IOException e)
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 } 
	 catch (FileNotFoundException e) 
	 {
		e.printStackTrace();
	 }
  }
 
 public String getBaseURL()
 {
	String Value = properties.getProperty("BaseURL");
	if( Value!=null)
		return Value;
	else 
		 throw  new RuntimeException("url not specified in config file");
 }
 
 public String getbeowser()
 {
	String Value = properties.getProperty("browser");
	if( Value!=null)
		return Value;
	else 
		 throw  new RuntimeException("url not specified in config file");
 }
}
