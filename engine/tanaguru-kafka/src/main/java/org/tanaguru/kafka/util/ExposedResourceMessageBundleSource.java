/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.kafka.util;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;

/**
 *
 * @author tanaguru
 */
public class ExposedResourceMessageBundleSource extends ReloadableResourceBundleMessageSource {

    private static final Logger LOGGER = Logger.getLogger(ExposedResourceMessageBundleSource.class);

    @Override
    protected Properties loadProperties(Resource resource, String fileName) throws IOException {
        return super.loadProperties(resource, fileName);
    }

    /**
     * Gets all messages for presented Locale.
     * @param locale user request's locale
     * @return all messages
     */
    public Properties getMessages(Locale locale){
        return getMergedProperties(locale).getProperties();
    }
}
