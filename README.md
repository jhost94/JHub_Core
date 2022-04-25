# Description
JHub is a new project, with the objective to be a central hub to unite all of my previous and future projects. This is also a learning instrument for me to learn docker, kubernetes and micro-services.

# Instructions
1. To run the DataBase you'll need docker installed. Use:
~~~~
docker-compose up --build db
~~~~
The rest of the docker images are still a WIP.

2. You can use the startup.sh file to run the application. It accepts an argument and this will be the env, by default the env is **local_dev**. Use:
~~~~
. startup.sh
~~~~
or (for example env **prod**):
~~~~
. startup.sh prod
~~~~