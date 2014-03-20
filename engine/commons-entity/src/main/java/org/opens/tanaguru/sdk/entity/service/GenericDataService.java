/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2013  Open-S Company
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
package org.opens.tanaguru.sdk.entity.service;

import java.io.Serializable;
import java.util.Collection;
import org.opens.tanaguru.sdk.entity.Entity;
import org.opens.tanaguru.sdk.entity.dao.GenericDAO;
import org.opens.tanaguru.sdk.entity.factory.GenericFactory;

/**
 * 
 * @author jkowalczyk
 * @param <E>
 * @param <K>
 */
public interface GenericDataService<E extends Entity, K extends Serializable> {

    /**
     *
     * @return the entity created
     */
    E create();

    /**
     *
     * @param entity
     *            the entity to create
     */
    void create(E entity);

    /**
     *
     * @param entity
     *            the entity to delete
     */
    void delete(E entity);

    /**
     *
     * @param key
     *            the key of the entity to delete
     */
    void delete(K key);

    /**
     * 
     * @param entitySet
     */
    void delete(Collection<E> entitySet);

    /**
     *
     * @return all instancies of the entity
     */
    Collection<E> findAll();

    /**
     *
     * @param key
     *            the key of the entity to read
     * @return the entity read
     */
    E read(K key);

    /**
     *
     * @param entity
     *            the entity to update
     * @return the entity updated
     */
    E saveOrUpdate(E entity);

    /**
     * 
     * @param entitySet
     * @return
     */
    Collection<E> saveOrUpdate(Collection<E> entitySet);

    /**
     *
     * @param dao
     *            the DAO to set
     */
    void setEntityDao(GenericDAO<E, K> dao);

    /**
     *
     * @param factory
     *            the factory to set
     */
    void setEntityFactory(GenericFactory<E> factory);

    /**
     *
     * @param entity
     *            the entity to update
     * @return the entity updated
     */
    E update(E entity);
}
