# SETUP

All custom variables are in env_file.env. 

Custom variables :
- MYSQL_TG_USER - Database user
- MYSQL_TG_PASSWD - Database password
- MYSQL_TG_DB - Database
- TG_CONF_DIR - Tanaguru configuration directory (default: /etc/tanaguru)
- TG_TMP_DIR - Tanaguru configuration directory (default: /var/tmp)
- TG_LOG_DIR - Tanaguru configuration directory (default: /var/log/tanaguru)
- MAIL_DOMAIN - Domain name for postfix
- TG_URL - Tanaguru url (for mails ...)

We recommend you to use env file when starting container.

# Run container

In order to use tanaguru image you will have to redirect a port from you docker host to container.

docker run example :

> sudo docker run -d -p 8000:8080 -env-file env_file.env tanaguru_mysql_ebd:latest