#!/bin/bash

TOMCAT_HOST_PATH=/var/lib/tomcat7/webapps/tanaguru
#TOMCAT_HOST_PATH=/var/lib/tomcat6/vhost-int-tanaguru/ROOT/

# Copy jar in classpath
cp lib/*.jar $TOMCAT_HOST_PATH/WEB-INF/lib

# Add spring conf for mvc part
sed -i -e "s#</beans>#\t<import resource=\"classpath:conf/context/aria/webapp/aria-beans-webapp.xml\"/>\n\n</beans>#" \
	    "$TOMCAT_HOST_PATH/WEB-INF/tgol-web-app-servlet.xml"

# Add i18n files 
sed -i -e "s#<!--rules-commons i18n#<!--aria1.0 i18n files -->\n\t\t<value>i18n/referential-aria10-I18N</value>\n\t\t<value>i18n/theme-aria10-I18N</value>\n\t\t<value>i18n/criterion-aria10-I18N</value>\n\t\t<value>i18n/rule-aria10-I18N</value>\n\n\t\t<!--rules-commons i18n#" \
	    "$TOMCAT_HOST_PATH/WEB-INF/conf/mvc/tgol-beans-i18n.xml"