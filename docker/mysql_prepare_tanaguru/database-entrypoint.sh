#!/bin/bash
set -e
echo
echo "database-entrypoint launched"
echo

echo "Container - Init Script - database initialization"
echo

#ALLOW REMOTE CONNECTION
sed -i 's/bind-address/#bind-address/g' /etc/mysql/mysql.conf.d/mysqld.cnf

echo "Container - Starting mysql..."
service mysql start

Q1="CREATE DATABASE IF NOT EXISTS $MYSQL_TG_DB;"
Q2="GRANT ALL ON *.* TO '$MYSQL_TG_USER'@'%' IDENTIFIED BY '$MYSQL_TG_PASSWD';"
Q3="FLUSH PRIVILEGES;"
SQL="${Q1}${Q2}${Q3}"

mysql -uroot -p$MYSQL_PWD -e "$SQL"

echo "Container - End Script - database initialization"
echo