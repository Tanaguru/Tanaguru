set -e
echo
echo "docker-entrypoint launched"
echo

echo "Container - Init Script"
echo

/tanaguru-entrypoint.sh

service xvfb start
$CATALINA_HOME/bin/catalina.sh start
sleep 20
tail -f $TG_LOG_DIR/tanaguru.log