# Configuration of Tanaguru web application

Here is the list of the parameters you can found in the /etc/tanaguru/tanaguru.conf file and thus can help you to customize your installation : 

|        Parameter Name          |  Description   |         Default value         |
| :----------------------------- | :------------- | :---------------------------- |
|**changePasswordUrl**           | This parameter is based on web-app-url and **shouldn't be modified**. It corresponds to the Url of the modify password page sent to a user that wants to reset its password. | ${web-app-url}/home/contract/audit-result.html |
|**contrastfinderServiceUrl**    | This is the URL of the service Contrast Finder used to be aggregated within the audit result interface to provide corrections about color issues | http://contrast-finder.tanaguru.com |
|**crawlConfigFilePath**    | This parameter is based on tgol-deployment-path and **shouldn't be modified**. It corresponds to the path that locates the configuration files needed by the crawler (heritrix). | ${tgol-deployment-path}/crawler/ |
|**emailSentToUserExclusionList**| The synchronousAuditDelay parameter defines a delay from which a synchronous audit will be managed as an asynchronous audit. When the audit is terminated an email is sent to the used. In some occasions, for some users, we don't want that email to be sent (for the guest user for example). The "emailSentToUserExclusionList" defines the lists of users (by their email and separated by a ";") that won't be alerted by email when the execution of one of the audits they launch has exceeded the synchronous delay. | *Empty*|
|**enable-account-settings**     | Enable/Disable the access through the login page to the forgotten password page and the access of the user account settings page for an authentified user. | false |
|**generatedHtmlExplanationLink**| The link that leads to the page that explains the characteristics and constraints of the generated HTML. This parameter is not supposed to be modified. | http://www.tanaguru.org/en/content/generated-html-characteristics  |
|**crawlerHome**                 | Path used by the Crawler to copy its temporary files (**should't be modified**). | /var/tmp/tanaguru |
|**geckodriverPath**             | Path to geckodriver. | /opt/geckodriver |
|**hibernate.dialect**           | Represents a dialect of SQL implemented by a particular RDBMS |  |
|**isAllowedToSendKrashReport**  | Authorize the application to send krash reports | |
|**jdbc.driverClassName**        | JDBC driver class | com.mysql.jdbc.Driver |
|**jdbc.url**                    | JDBC Url | Depends on the value of "**--mysql-tg-db**" and "**--mysql-tg-host**" installation script options |
|**jdbc.username**               | JDBC Username | Depends on the value of the "**--mysql-tg-user**" installation script option |
|**jdbc.password**               | JDBC Password | Depends on the value of the "**--mysql-tg-passwd**" installation script option |
|**jpa.showSql**                 | Enable/Disable the log traces in the mysql log file (for debug purpose). | false |
|**krashReportMailList**         | List of emails (comma-separated list) used to send krash reports. If isAllowedToSendKrashReport property is set to false, this option is ignored, but has to be present, even empty | support@tanaguru.com |
|**maxSimultaneousAuditPage**    | Determines the number of page audits that can be run simultaneously. In case of low resources server, this value can be reduced to avoid memory issues. | 10 |
|**maxSimultaneousAuditScenario**| Determines the number of scenario audits that can be run simultaneously. In case of low resources server, this value can be reduced to avoid memory issues. | 2 |
|**maxSimultaneousAuditSite**    | Determines the number of site audits that can be run simultaneously. In case of low resources server, this value can be reduced to avoid memory issues. | 2 |
|**maxSimultaneousAuditUpload**  | Determines the number of upload audits that can be run simultaneously. In case of low resources server, this value can be reduced to avoid memory issues. | 2 |
|**pageLoadTimeout**             | Timeout from which a page is seen as fully loaded | 20 (in seconds) |
|**proxyHost**                   | Defines the value of the proxy host when the server accesses the web through a proxy. Has to be present but empty when no proxy is used. | *Empty* |
|**proxyPort**                   | Defines the value of the proxy port when the server accesses the web through a proxy. Has to be present with an empty when no proxy is used. | *Empty* |
|**proxyExclusionUrl**           | Defines Url patterns that must ignore the proxy parameters. Possible values are : **127.0.0.1**, **127.0.0.1;localhost;myhost;**, **myhost**, **mydomain.com**, **internalhost;mydomain.com** | *Empty* |
|**synchronousAuditDelay**       | The result of a page audit or a group of audit audit is returned synchronously. For many reasons, an audit can last more than a few seconds, and this variable enables to define a delay from which a synchronous audit will be managed in a asynchronous way. After this delay, an audit in progress page is sent back, and the user is alerted by email when the audit is terminated. | 25000 (in ms) |
|**tanaguruVersion**             | The version of the current instance of Tanaguru (**should't be modified**) | depends on the version |
|**tempFolderRootPath**          | Path used by the application to copy its temporary files (**should't be modified**) | /var/tmp/tanaguru |
|**tgol-deployment-path**        | Path that locates the configuration folder embeded by the web application (**should't be modified**) | No default value,  on the value of the "**--tanaguru-url**" and "**tomcat-webapps**" installation script options |
|**tgol-persistenceXmlLocation** | Path of the file that define the persistence layer of the application. This option **shouldn't be modified**. | classpath:/conf/persistence.xml. |
|**web-app-url**                 | Url of the web application. This option is needed to send info and links by email (when an audit is terminated for example) | Depends on the value of the "**--tanaguru-url**" installation script option |
|**webresourceUrlPrefix**        | This parameter is based on web-app-url and **shouldn't be modified**. It corresponds to the Url of the audit-result page sent to a user when a site audit is terminated | ${web-app-url}/home/contract/audit-result.html |
|**rmi.port**                    | Determines the port used for the RMI API of Tanaguru |  |



