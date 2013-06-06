/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package org.ofbiz.entity.config.model;

import org.ofbiz.base.lang.ThreadSafe;
import org.ofbiz.entity.GenericEntityConfException;
import org.w3c.dom.Element;

/**
 * An object that models the <code>&lt;sql-load-path&gt;</code> element.
 *
 * @see <code>entity-config.xsd</code>
 */
@ThreadSafe
public final class SqlLoadPath {

    private final String path; // type = xs:string
    private final String prependEnv; // type = xs:string

    public SqlLoadPath(Element element) throws GenericEntityConfException {
        String path = element.getAttribute("path").intern();
        if (path.isEmpty()) {
            throw new GenericEntityConfException("<" + element.getNodeName() + "> element path attribute is empty");
        }
        this.path = path;
        this.prependEnv = element.getAttribute("prepend-env").intern();
    }

    /** Returns the value of the <code>path</code> attribute. */
    public String getPath() {
        return this.path;
    }

    /** Returns the value of the <code>prepend-env</code> attribute. */
    public String getPrependEnv() {
        return this.prependEnv;
    }
}