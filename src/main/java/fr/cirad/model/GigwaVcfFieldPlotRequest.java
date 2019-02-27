/*******************************************************************************
 * GIGWA - Service interface
 * Copyright (C) 2016 - 2019, <CIRAD> <IRD>
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

import java.util.List;

/**
 *
 * @author petel
 */
public class GigwaVcfFieldPlotRequest extends GigwaDensityRequest {

    private String vcfField;
    private List<String> plotIndividuals;

    public GigwaVcfFieldPlotRequest(){
        super();
    }

	public String getVcfField() {
		return vcfField;
	}

	public void setVcfField(String vcfField) {
		this.vcfField = vcfField;
	}

	public List<String> getPlotIndividuals() {
		return plotIndividuals;
	}

	public void setPlotIndividuals(List<String> plotIndividuals) {
		this.plotIndividuals = plotIndividuals;
	}
    
}
