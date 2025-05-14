package com.example.quartzScheduling.xmlToJsonQuartz;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.json.XML;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.core.io.ClassPathResource;

public class XmlToJsonJob implements Job {
	 public void execute(JobExecutionContext context) throws JobExecutionException {
		 try {
	    	ClassPathResource xmlResource = new ClassPathResource("source/sample1.xml");
			String xmlContent = FileUtils.readFileToString(xmlResource.getFile(), "UTF-8");

			JSONObject jsonObject = XML.toJSONObject(xmlContent);
			File jsonOutput = new File("target/jsonFile.json");
			try (FileWriter writer = new FileWriter(jsonOutput)) {
				writer.write(jsonObject.toString(4));
			}
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
			System.out.println("Converted XML to JSON successfully" + new Date());
	    }
	    }


