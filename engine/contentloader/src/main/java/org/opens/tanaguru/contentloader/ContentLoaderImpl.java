/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2011  Open-S Company
 *
 * This file is part of Tanaguru.
 *
 * Tanaguru is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tanaguru.contentloader;

import java.util.ArrayList;
import java.util.List;
import org.opens.tanaguru.entity.audit.Content;
import org.opens.tanaguru.entity.factory.audit.ContentFactory;
import org.opens.tanaguru.entity.subject.Page;
import org.opens.tanaguru.entity.subject.Site;
import org.opens.tanaguru.entity.subject.WebResource;
import org.opens.tanaguru.util.factory.DateFactory;

/**
 * 
 * @author jkowalczyk
 */
public class ContentLoaderImpl implements ContentLoader {

    private static final int HTTP_CODE_OK = 200;
    private ContentFactory contentFactory;
    private DateFactory dateFactory;
    private Downloader downloader;
    private List<Content> result;
    private WebResource webResource;
    @Override
    public void setWebResource(WebResource webResource) {
        this.webResource = webResource;
    }

    /**
     * Constructor
     * 
     * @param contentFactory
     * @param downloader
     * @param dateFactory 
     */
    ContentLoaderImpl(
            ContentFactory contentFactory, 
            Downloader downloader, 
            DateFactory dateFactory) {
        super();
        this.contentFactory = contentFactory;
        this.downloader = downloader;
        this.dateFactory = dateFactory;
    }

    @Override
    public List<Content> getResult() {
        return result;
    }

    @Override
    public void run() {
        result = run(webResource);
    }

    private List<Content> run(WebResource webResource) {// TODO Handle exceptions like 404, 403, 500, ...
        List<Content> localResult = new ArrayList<Content>();

        if (webResource instanceof Page) {
            downloader.setURL(webResource.getURL());
            downloader.run();
            String stringContent = downloader.getResult();
            Content content = contentFactory.createSSP(
                    dateFactory.createDate(),
                    webResource.getURL(),
                    stringContent,
                    (Page) webResource,
                    HTTP_CODE_OK);
            localResult.add(content);
        }
        if (webResource instanceof Site) {
            Site site = (Site) webResource;
            for (WebResource component : site.getComponentList()) {
                localResult.addAll(run(component));
            }
        }

        return localResult;
    }

}