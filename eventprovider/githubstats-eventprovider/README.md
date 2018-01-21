

#MySql service
NOTES:
MySQL can be accessed via port 3306 on the following DNS name from within your cluster:
cloying-pug-mysql.default.svc.cluster.local

To get your root password run:

    kubectl get secret --namespace default cloying-pug-mysql -o jsonpath="{.data.mysql-root-password}" | base64 --decode; echo

To connect to your database:

1. Run an Ubuntu pod that you can use as a client:

    kubectl run -i --tty ubuntu --image=ubuntu:16.04 --restart=Never -- bash -il

2. Install the mysql client:

    $ apt-get update && apt-get install mysql-client -y

3. Connect using the mysql cli, then provide your password:
    $ mysql -h cloying-pug-mysql -p
  