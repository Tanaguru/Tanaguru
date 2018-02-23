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
/**
 *
 * @author mkebri
 */
package org.tanaguru.jms.service.api;

import javax.jms.Destination;
import org.tanaguru.model.AuditModel;


/**
 *
 * @author mkebri
 */
public interface JmsMessageSender {

    
    /**
     * send Object to default destination
     * @param text
     */
    void sendResult(final AuditModel auditModelResult);
  //  void sendResult(final Audit audit);

    /**
     * Send text message to a specified destination
     * @param dest
     * @param text
     */
    void send(final Destination dest, final String text);

    /**
     * Simplify the send by using convertAndSend
     * @param text
     */
    void sendText(final String text);
    
    
    public void sendResult(final String text);
    
}
