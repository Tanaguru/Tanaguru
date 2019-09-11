#!/bin/bash
set -e
export JAVA_OPTS="-Xms512M -Xmx2048M -DconfDir=file://$TG_CONF_DIR -DlogDir=$TG_LOG_DIR -Dwebdriver.firefox.bin=${FIREFOX_PATH} -Ddisplay=:99"
