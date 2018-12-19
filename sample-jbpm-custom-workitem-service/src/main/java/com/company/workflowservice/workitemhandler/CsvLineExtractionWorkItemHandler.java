package com.company.workflowservice.workitemhandler;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.kie.api.runtime.process.WorkflowProcessInstance;
import org.kie.server.api.model.KieServerInfo;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.services.api.KieServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.drools.core.spi.ProcessContext;


//@Component("CsvLineExtractionWorkItemHandler")
public class CsvLineExtractionWorkItemHandler implements WorkItemHandler {

    @Autowired
    private KieServer kieServer;
    private KieSession kieSession;
	
	public CsvLineExtractionWorkItemHandler(KieSession kieSession) {
		this.kieSession = kieSession;
	}
	
    @Override
	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
	    manager.abortWorkItem(workItem.getId());
	}

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		System.out.println("Executing Work item " + workItem.getId());
		System.out.println("Work item state: " + workItem.getState());
		System.out.println("Work item process instance id : " + workItem.getProcessInstanceId());
		
		//RuntimeEngine runtime = kieServer.
        //KieSession ksession = runtime.getKieSession();
		if (kieServer != null) {
	        ServiceResponse<KieServerInfo> aaa = kieServer.getInfo();
	        System.out.println("Kie container release ID: " + aaa.toString());
		}

		if (kieSession != null) {
	        System.out.println("Kie session ID: " + kieSession.getIdentifier());
		}

        String csvFilePath = workItem.getParameter("CsvPath").toString();
		System.out.println("Reading the following  CSV file: " + csvFilePath);
		List<String> urls = new ArrayList<>();
		List<String> names = new ArrayList<>();
		try (
	            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
	            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
	            		.withFirstRecordAsHeader()
	                    .withIgnoreHeaderCase()
	                    .withTrim());
	        ) {
				Map<String, Integer> headerMap = csvParser.getHeaderMap(); 
				headerMap.forEach((name, index) -> {
					System.out.println("Column " + name + " is at " + index);
	                System.out.println("---------------\n\n");
				});
				
				if (headerMap.containsKey("URL")) {
					System.out.println("CSV contains URL field.");
				} else {
					System.out.println("CSV does not contain URL field.");
					manager.abortWorkItem(workItem.getId());
				}
				
	            for (CSVRecord csvRecord : csvParser) {
	                String url = csvRecord.get("URL");
	                String name = csvRecord.get("Name");
	                urls.add(url);
	                names.add(name);
	                
	                System.out.println("Record No - " + csvRecord.getRecordNumber());
	                System.out.println("---------------");
	                System.out.println("Name: " + name);
	                System.out.println("URL : " + url);
	                System.out.println("---------------\n\n");
	            }

			} catch (IOException e) {
				e.printStackTrace();
			}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("Output", urls);
		result.put("Names", names);
	    
		manager.completeWorkItem(workItem.getId(), result);
		System.out.println("NOW IS DONE");
		System.out.println("Work item state: " + workItem.getState());
		/*
		ProcessContext kcontext = new ProcessContext(this.kieSession);
		System.out.println(kcontext);
		
		System.out.println(workItem.getProcessInstanceId());
		ProcessInstance processInstance = (ProcessInstance)      
	                kieSession.getProcessInstance(workItem.getProcessInstanceId());
		
		System.out.println("PI: " + processInstance);
		
	    System.out.println(processInstance.getProcessName());
	    System.out.println(processInstance.getProcessId());
	    kcontext.setProcessInstance(processInstance);
	    String procVar = (String) kcontext.getVariable("firstname");
	    System.out.println("FirstName: " + procVar);
		*/
	}

}
