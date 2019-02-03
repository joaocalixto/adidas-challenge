package com.example.itenerarysearch.eureka;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;

@Component
public class EurekaService {

	@Autowired
	private DiscoveryClient discoveryClient;

	public URI getInstance(String serviceId) {

		List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);

		if(instances != null && !instances.isEmpty()) {

			return instances.get(0).getUri();

		}

		return null;

	}

}