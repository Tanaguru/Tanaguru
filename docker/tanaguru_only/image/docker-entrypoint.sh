set -e
echo
echo "docker-entrypoint launched"
echo

echo "Container - Init Script"
echo

/postfix-entrypoint.sh
/tanaguru-entrypoint.sh

service xvfb start
$CATALINA_HOME/bin/catalina.sh start
sleep 20
tail -f $CATALINA_HOME/logs/catalina.out