FROM ubuntu:16.04
USER root
WORKDIR /
ENV MYSQL_TG_USER="tanaguru"                                \
    MYSQL_TG_PASSWD="tanaguru"                              \
    MYSQL_TG_DB="tanaguru"                                  \
    MYSQL_PWD="tngTanaguru"

RUN cd /opt                                          && \
 apt-get update                                      && \
 apt-get install -y apt-utils wget ca-certificates


# Following Tanaguru installation process : https://tanaguru.readthedocs.io/en/develop/prerequisites-webapp-doc/

# INSTALL PREREQUISITES
## OPEN JDK 8
RUN apt-get install -y openjdk-8-jre                 && \
    update-java-alternatives -s java-1.8.0-openjdk

## Mysql
RUN echo "mysql-server mysql-server/root_password password "$MYSQL_PWD | debconf-set-selections             && \
    echo "mysql-server mysql-server/root_password_again password "$MYSQL_PWD | debconf-set-selections       && \
    apt-get install -y mysql-server libmysql-java                                                           && \
    echo "max_allowed_packet = 64M" >> /etc/mysql/conf.d/mysql.cnf

##################################################

EXPOSE 3306

##################################################
# ENTRYPOINT
COPY docker-entrypoint.sh /
COPY database-entrypoint.sh /

RUN chmod +x /docker-entrypoint.sh          && \
    chmod +x /database-entrypoint.sh

ENTRYPOINT ["bash","docker-entrypoint.sh"]