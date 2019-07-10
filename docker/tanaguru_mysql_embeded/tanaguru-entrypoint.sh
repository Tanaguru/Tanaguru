#!/bin/bash
set -e
echo
echo "tanaguru-entrypoint launched"
echo

echo "Container - Init Script - Tanaguru initialization"
echo

echo "Launch Tanaguru installer"
cd /tanaguru*
echo "yes" | ./install.sh --mysql-tg-db $MYSQL_TG_DB \
                  --mysql-tg-host "localhost" \
                  --mysql-tg-user $MYSQL_TG_USER \
                  --mysql-tg-passwd $MYSQL_TG_PASSWD \
                  --tanaguru-url $TG_URL \
                  --tomcat-webapps $TOMCAT_WEBAPP \
                  --tomcat-user $TOMCAT_USER \
                  --tg-admin-email $TG_ADMIN_EMAIL \
                  --tg-admin-passwd $TG_ADMIN_PASSWD \
                  --firefox-esr-path $FIREFOX_PATH \
                  --display-port :99 \
                  --tg-version $TG_VERSION

echo "w3cValidatorHome=/opt/w3cValidator" >> $TG_CONF_DIR/tanaguru.conf

echo "Container - End Script - Tanaguru initialization"
echo