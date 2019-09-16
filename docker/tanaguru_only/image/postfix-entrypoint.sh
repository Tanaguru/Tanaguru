#!/bin/bash
set -e
echo
echo "postfix-entrypoint launched"
echo

echo "Container - Init Script - Postix initialization"
echo

echo "Launch Postix installer"

echo "postfix postfix/mailname string "$MAIL_DOMAIN | debconf-set-selections                    && \
echo "postfix postfix/main_mailer_type string 'Satellite system'" | debconf-set-selections      && \
echo "postfix postfix/relayhost string ''" | debconf-set-selections                             && \
apt-get install -y postfix mailutils

echo "Container - End Script - Postix initialization"
echo