package com.example.quartzScheduling.xmlToJsonQuartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class QuartzConfiguration {

	@Bean
	public JobDetail XmlToJsonJobDetail() {
		return JobBuilder.newJob(XmlToJsonJob.class)
				.withIdentity("XmlToJsonJob", "group1")
				.storeDurably()
				.build();
	}
	
	@Bean
	public Trigger XmlToJsonJobTrigger() {
		return TriggerBuilder.newTrigger()
				.forJob(XmlToJsonJobDetail())
				.withIdentity("XmlToJsonTrigger", "group1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInMinutes(1)
                .repeatForever())
                .build();
	}	
}
