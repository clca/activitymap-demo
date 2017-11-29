Maps demo

Note: before re-running the demo:
-	delete GithubStats V2 Api descriptor
-	delete Githubstats V2 Api descriptor

This needs to be done only once in the cluster, If githubstats Broker does not exist:
-	Go to the Microservice management console
-	Select ‘New User Service’
-	Use the githubstats.tar.gz file under the brokers directory to create the broker. 

This needs to be done only once in the cluster:
-	Kubectl create –f deployments/githubstats-ingress.yaml
-	Kubectl create –f deployments/map-ingress.yaml
-	Kubectl create –f deployments/githubstats-service.yaml

Demo steps:
1.	I’m the backend developer, I have the code for a service that pull and aggregate data from github.
2.	I have a docker image already deployed in a registry so now I want to deploy the service in the cluster
3.	Kubectl create –f deployments/githubstats-v2.yaml
4.	Show that the service is starting with kubectl get po
5.	I want to make easier for the developer(s) that want to use my service so now I want to publish an ApiDescriptor that specifies the APIs that my service exposes
6.	Go to the Microservices admin console
7.	Go to APIs
8.	Create a new API by uploading the blueprint file under apis/githubstatsv2.md
9.	After the APi file is uploaded, bind it to a service instance, in the services’ dropdown select githubstats V2
10.	Now that I have an ApiDescriptor bound to a service I can move to the frontend service
11.	Go to the Microservices admin console, select the GithubStats API V2
12.	Select ‘View API’, show the description of the APIs and that there is the possibility to use a mock service to test the Apis if the service behind them is not deployed.
13.	Select ‘download client library’ (Javascript)
14.	You can unzip the library and open the frontend project in an editor (ex. VS Code) but you can skip it and say that this library allows the frontend client to connect to the backend without having to find out where the service is running (IP/Port number) and having to deal with making the HTTP REST calls, the library takes care of all of that
15.	After the frontend service has been updated, it is packaged in a docker image and pushed to a registry (the service has been already published to save time so no need to actually run through the process)
16.	Now I want to deploy the frontend service: kubectl create –f deployments/map-deployment-v2.yaml
17.	I also need to create a service to expose my frontend service so kubectl create –f deployments/map-service.yaml
18.	Now I can go to the IP address of the cluster and see the service running by going to the following url <cluster IP>/map/
a.	Note: you can find the IP address to use by running this command: kubectl get ing
19.	Now we want to make the backend service better because our customers asked us to provide a way to go back in-time and see how the map change so we need to store the historical data in a database (mysql in this case)
20.	First I create a Broker that will manage the connection to the database
21.	Go to the microservices admin console
22.	Create a new ‘User Service’ using the mysqlbroker.tar.gz file under the /brokers directory 
23.	Now you can imagine that I updated my service and published the image on a repo
24.	I want to deploy the new version of the service now kubectl create –f deployments/githubstats-v3.yaml
25.	There are two version of my service now running in the cluster, show it with kubectl get po
26.	Now, like I have done before, I publish a new version of my APIs (the new service exposes new APIs to query historical data
27.	Goto the microservice admin console, repeat the process and create a new Api by uploading apis/githubstatsv3.md
a.	Note: there is no need to bind a service to the description	
28.	Now I can go back to the frontend service and update it, like I have done before, I update the code and publish a new version of my docker image
29.	I deploy the new version in the cluster: kubectl create –f deployments/map-deployment-v3.yaml
30.	I have two versions of the frontend and two versions of the backend, show it via kubectl get po
31.	I want now to redirect traffic to the right versions using the service mash
32.	First I redirect traffic to the V3 version of my backend service: istioctl replace –f mesh/githubstats-routing-v2.yaml
a.	Now all traffic to the Githubstats service goes to the V3 version
33.	I want to show the new frontend, so like I have done with the backend service, I redirect traffic to the new version: istioctl replace –f mesh/map-v3-routing.yaml
34.	Go to the maps page and how I should see the slides on the side that allows to move in the timescale
35.	Now the service is running so I want to be able to monitor it
36.	Before going to the grafana/zipkin console, have 3 bash shells open and run the 3 bash scripts under the /load directory, one on each shell
a.	Note: you have to have ‘watch’ installed so brew install watch
b.	Note: you have to edit the bash scripts and update the IP address in the curl commands (will make it a parameter in the future)
37.	After all 3 scripts are running you can go in the grafana dashboard and so that the system is collecting metrics about the running services
38.	You can move to the zipkin console and show that it shows, in realtime, data flowing across services. You can select one and show that the UI displays the two versions of the (for instance) githubstats service and you can tell that, in the future, we will be able to show information about the actual APIs that are used.
 

 

