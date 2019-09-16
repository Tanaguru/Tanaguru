# SETUP

All custom variables are in env_file.env. 

Custom variables :
- MYSQL_TG_USER - Database user
- MYSQL_TG_HOST - Database host
- MYSQL_TG_PASSWD - Database password

We recommend you to use env file when starting container.

# Run container

docker run example :

> sudo docker run -d -env-file env_file.env mysql-prepare-tanaguru:latest