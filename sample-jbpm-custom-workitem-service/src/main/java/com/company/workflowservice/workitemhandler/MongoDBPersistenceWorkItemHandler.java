package com.company.workflowservice.workitemhandler;

import java.util.List;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.company.workflowservice.data.mongo.CustomerRepository;
import com.company.workflowservice.model.Customer;

@Component("MongoDBPersistenceWorkItemHandler")
public class MongoDBPersistenceWorkItemHandler implements WorkItemHandler {
	
	@Autowired
	@Qualifier("customerRepository")
	CustomerRepository customerRepository;

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		
		System.out.println("Entering...");
		List<String> customers = (List<String>)workItem.getParameter("Customer");
		System.out.println("Getting Customers...");
		List<String> urls = (List<String>)workItem.getParameter("URLs");
		System.out.println("Done");
		
		/*
		System.out.println("Customer " + customers.size());
		
		customers.forEach(System.out::println);
		urls.forEach(System.out::println);
		
		int qty = customers.size();
		if (qty == urls.size()) {
			for (int i = 0; i<qty;i++) {
			Customer cust = new Customer();
			cust.setName(customers.get(i));
			cust.setUrl(urls.get(i));
			cust.setId("1");
			cust.setIncome(100.0);
			customerRepository.save(cust);
			}
		}
*/
		manager.completeWorkItem(workItem.getId(), null);	
		
	}

	@Override
	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		manager.abortWorkItem(workItem.getId());
	}

}
