package com.company.workflowservice.workitemhandler;

import java.util.List;
import java.util.UUID;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.company.workflowservice.data.mongo.CustomerRepository;
import com.company.workflowservice.model.Customer;
import com.company.workflowservice.service.RestClientService;

@Component("MongoDBPersistenceWorkItemHandler")
public class MongoDBPersistenceWorkItemHandler implements WorkItemHandler {
	
	@Autowired
	@Qualifier("customerRepository")
	CustomerRepository customerRepository;
	
	@Autowired
	RestClientService restService;

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		
		System.out.println("Entering...");
		List<String> customers = (List<String>)workItem.getParameter("Customer");
		System.out.println("Getting Customers...");
		List<String> urls = (List<String>)workItem.getParameter("URLs");
		System.out.println("Done");
		
		if(customers!=null) {
			System.out.println("Customer " + customers.size());
			
			customers.forEach(System.out::println);
			urls.forEach(System.out::println);
			
			int qty = customers.size();
			if (qty == urls.size()) {
				for (int i = 0; i<qty;i++) {
				Customer cust = new Customer();
				cust.setName(customers.get(i));
				String url = urls.get(i);
				String result = restService.getBodyFromRestApiCall(url);
				cust.setResponseBody(result);
				cust.setUrl(url);
				cust.setId(UUID.randomUUID().toString());
				cust.setIncome(100.0);
				customerRepository.save(cust);
				}
			}
		} else {
			System.out.println("The client list is empty!");
		}

		manager.completeWorkItem(workItem.getId(), null);	
		
	}

	@Override
	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		manager.abortWorkItem(workItem.getId());
	}

}
