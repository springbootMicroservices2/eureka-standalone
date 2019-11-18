# eureka-standalone

Eureka server :-

step1 :- add eureka server and web dependency 
step 2 :- @EnableEurekaServer in Application.Java 
Step 3 :- in application propertie add the following property:-

#In which port the server will be bound-->
server.port=8090

#This determines if this server registers itself as a client; as I said earlier,
#the Eureka server is also acting as a client so that it #can sync the registry. 
#The value being false means it prevents itself from acting as a client-->

eureka.client.registerWithEureka=false

#Does not register itself in the service registry-->
eureka.client.fetch-registry=false

employeeProducer :-

step 1 add Discovery client dependency
step 2 @EnableDiscoveryClient in application.java
Step3 : in application propertie add the following property:-
#It consults with other Eureka servers to sync the service registry. As it is in standalone mode, I am giving the local server address-->
eureka.client.serviceUrl.defaultZone=http://localhost:8090/eureka

#Unique name for a Eureka server service.this is our the instanceID whith which client will query discoveryClient and fetch the employeeproducer url-->
spring.application.name=



employeeConsuemer  :-
step 1 add Discovery client dependency
Step2 in application propertie add the following property:-
#It consults with other Eureka servers to sync the service registry. As it is in standalone mode, I am giving the local server address-->
eureka.client.serviceUrl.defaultZone=http://localhost:8090/eureka
Step3 @Autowired
	private DiscoveryClient discoveryClient;
Step 4 List<ServiceInstance> instances = discoveryClient.getInstances("employee-producer");
		ServiceInstance serviceInstance = instances.get(0);
		String baseUrl = serviceInstance.getUri().toString();
		baseUrl = baseUrl + "/employee";
