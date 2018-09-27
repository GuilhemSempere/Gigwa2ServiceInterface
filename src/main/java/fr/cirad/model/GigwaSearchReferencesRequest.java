/*******************************************************************************
 * GIGWA - Service interface
 * Copyright (C) 2016, 2018, <CIRAD> <IRD>
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License, version 3 as published by
 * the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 *
 * See <http://www.gnu.org/licenses/agpl.html> for details about GNU General
 * Public License V3.
 *******************************************************************************/
package fr.cirad.model;

import org.ga4gh.methods.SearchReferencesRequest;

/**
 *
 * @author petel extends SearchReferencesRequest to allow filter on
 * project/variantSet
 */
public class GigwaSearchReferencesRequest extends SearchReferencesRequest {

    private String variantSetId = "-1";

    public String getVariantSetId() {
        return variantSetId;
    }

    public void setVariantSetId(String variantSetId) {
        this.variantSetId = variantSetId;
    }
}
