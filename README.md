# eureka-standalone

Eureka server :-

step1 :- add eureka server and web dependency 
step 2 :- @EnableEurekaServer in Application.Java 
Step 3 :- in application propertie add the following property:-
server.port=8090/8071
#telling the server not to register himself in the service registry
eureka.client.registerWithEureka=false

employeeProducer :-

step 1 add Discovery client dependency
step 2 @EnableDiscoveryClient in application.java
Step3 eureka.client.serviceurl.defaultzone=url of eurekaserver
eureka.client.serviceUrl.defaultZone=http://localhost:8090/eureka
spring.application.name=
this is our the instanceID whith which client will query discoveryClient and fetch the employeeproducer url


employeeConsuemer  :-
step 1 add Discovery client dependency
Step2 eureka.client.serviceUrl.defaultZone=http://localhost:8090/eureka
Step3 @Autowired
	private DiscoveryClient discoveryClient;
Step 4 List<ServiceInstance> instances = discoveryClient.getInstances("employee-producer");
		ServiceInstance serviceInstance = instances.get(0);
		String baseUrl = serviceInstance.getUri().toString();
		baseUrl = baseUrl + "/employee";
