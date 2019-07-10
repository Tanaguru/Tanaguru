FROM ubuntu:16.04
USER root
WORKDIR /
ENV TOMCAT_USER="tomcat8"                                   \
    CATALINA_HOME="/var/lib/tomcat8"                        \
    WEBAPP_PORT="8080"                                      \
    TOMCAT_WEBAPP="/var/lib/tomcat8/webapps"                \
    MYSQL_TG_USER="tanaguru"                                \
    MYSQL_TG_HOST="-h172.17.0.3"                            \
    MYSQL_TG_PASSWD="tanaguru"                              \
    MYSQL_TG_DB="tanaguru"                                  \
    TG_ADMIN_EMAIL="support@tanaguru.com"                   \
    TG_ADMIN_PASSWD="admin"                                 \
    FIREFOX_PATH="/opt/firefox/firefox"                     \
    TG_VERSION="6.0.0"                                      \
    TG_URL="localhost:8080/tanaguru"                        \
    MY_DEFAULT_TOMCAT="/var/lib/tomcat8/bin/catalina.sh"    \
    TG_CONF_DIR="/etc/tanaguru/"                            \
    TG_TMP_DIR="/var/tmp/tanaguru"                          \
    TG_LOG_DIR="/var/log/tanaguru"                          \
    MAIL_DOMAIN="your.hostname.com"

RUN useradd -rm -d /var/lib/$TOMCAT_USER -s /bin/bash -u 1000 $TOMCAT_USER      && \
    addgroup $TOMCAT_USER $TOMCAT_USER

COPY xvfb_init_d /
RUN chmod +x xvfb_init_d

COPY setenv.sh /
RUN chmod +x setenv.sh

RUN cd /opt                                          && \
 apt-get update                                      && \
 apt-get install -y apt-utils wget ca-certificates bzip2 zip apache2 libgtk-3-0 libgtk-3-dev libdbus-glib-1-2

COPY tanaguru.apache.conf /
RUN a2enmod -q proxy_http                                                                                       && \
    rm -rf /etc/apache2/sites-available/*                                                                       && \
    rm -rf /etc/apache2/sites-enabled/*                                                                         && \
    mv /tanaguru.apache.conf /etc/apache2/sites-available/                                                      && \
    ln -s /etc/apache2/sites-available/tanaguru.apache.conf /etc/apache2/sites-enabled/tanaguru.apache.conf     && \
    service apache2 restart

# Following Tanaguru installation process : https://tanaguru.readthedocs.io/en/develop/prerequisites-webapp-doc/

# INSTALL PREREQUISITES
## OPEN JDK 8
RUN apt-get install -y openjdk-8-jre                 && \
    update-java-alternatives -s java-1.8.0-openjdk

## TOMCAT
ADD http://mirrors.standaloneinstaller.com/apache/tomcat/tomcat-8/v8.5.42/bin/apache-tomcat-8.5.42.tar.gz /
RUN tar xzf /apache-tomcat*.tar.gz                                                                                && \
    rm /apache-tomcat*.tar.gz                                                                                     && \
    mv /apache-tomcat*/* $CATALINA_HOME                                                                           && \
    rm -rf $TOMCAT_WEBAPP/*                                                                                       && \
    mv /setenv.sh $CATALINA_HOME/bin                                                                              && \
    apt-get install -y libspring-instrument-java                                                                  && \
    ln -s /usr/share/java/spring3-instrument-tomcat.jar $CATALINA_HOME/lib/spring3-instrument-tomcat.jar          && \
    ln -s /usr/share/java/mysql-connector-java.jar $CATALINA_HOME/lib/mysql-connector-java.jar                    && \
    chown $TOMCAT_USER:$TOMCAT_USER -R $CATALINA_HOME

## XVFB
RUN apt-get install -y xvfb                     && \
    mv /xvfb_init_d /etc/init.d/xvfb


## FIREFOX
ADD http://download-origin.cdn.mozilla.net/pub/firefox/releases/61.0/linux-x86_64/en-US/firefox-61.0.tar.bz2 /
RUN tar xvfj /firefox-61.0.tar.bz2              && \
    mv firefox /opt/firefox-61.0                && \
    ln -s /opt/firefox-61.0 /opt/firefox

## GECKODRIVER
ADD https://github.com/mozilla/geckodriver/releases/download/v0.21.0/geckodriver-v0.21.0-linux64.tar.gz /
RUN tar xzf /geckodriver-v0.21.0-linux64.tar.gz     && \
    mv geckodriver /opt/geckodriver

## W3C VALIDATOR
ADD https://github.com/validator/validator/releases/download/18.11.5/vnu.jar_18.11.5.zip /
RUN unzip /vnu.jar_*.zip -d /opt/w3cValidator                                                       && \
    mv /opt/w3cValidator/dist/vnu.jar /opt/w3cValidator/                                            && \
    chmod +x /opt/w3cValidator/vnu.jar

## POSTFIX
RUN echo "postfix postfix/mailname string "$MAIL_DOMAIN | debconf-set-selections                    && \
    echo "postfix postfix/main_mailer_type string 'Satellite system'" | debconf-set-selections      && \
    echo "postfix postfix/relayhost string ''" | debconf-set-selections                             && \
    apt-get install -y postfix mailutils

## TANAGURU
ADD http://download.tanaguru.org/Tanaguru/tanaguru-$TG_VERSION.i386.tar.gz /
RUN tar xzf /tanaguru-$TG_VERSION.i386.tar.gz                                           && \
    rm /tanaguru-$TG_VERSION.i386.tar.gz                                                && \
    chmod +x ./tanaguru*/install.sh

##################################################

EXPOSE 80

##################################################
# ENTRYPOINT
COPY docker-entrypoint.sh /
COPY tanaguru-entrypoint.sh /

RUN chmod +x /docker-entrypoint.sh          && \
    chmod +x /tanaguru-entrypoint.sh

ENTRYPOINT ["bash","docker-entrypoint.sh"]