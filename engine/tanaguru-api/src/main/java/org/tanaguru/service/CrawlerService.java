/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2015  Tanaguru.org
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
 * Contact us by mail: tanaguru AT tanaguru DOT org
 */
package org.tanaguru.service;

import java.util.List;
import javax.xml.bind.annotation.XmlTransient;
import org.tanaguru.crawler.CrawlerFactory;
import org.tanaguru.entity.audit.Audit;
import org.tanaguru.entity.service.audit.AuditDataService;
import org.tanaguru.entity.service.audit.ContentDataService;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import org.tanaguru.entity.service.subject.WebResourceDataService;
import org.tanaguru.entity.subject.WebResource;

/**
 * 
 * @author jkowalczyk
 */
@XmlTransient
public interface CrawlerService {

    void setParameterDataService(ParameterDataService parameterDataService);

    List<String> getUrlListByCrawlingFromUrlList(Audit audit, List<String> urlList);

    List<String> getUrlListByCrawlingFromUrl(Audit audit, String url);

    void setCrawlerFactory(CrawlerFactory crawlerFactory);
}