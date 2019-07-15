set -e
echo
echo "docker-entrypoint launched"
echo

echo "Container - Init Script"
echo

/database-entrypoint.sh

sleep 20
tail -f /var/log/mysql/error.log