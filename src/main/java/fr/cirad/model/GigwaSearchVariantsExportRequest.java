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

import java.util.List;

/**
 *
 * @author sempere
 */
public class GigwaSearchVariantsExportRequest extends GigwaSearchVariantsRequest {

    private String exportFormat;
    private boolean keepExportOnServer;
    private List<String> exportedIndividuals;

    public GigwaSearchVariantsExportRequest(){
        super();
    }

	public String getExportFormat() {
		return exportFormat;
	}

	public void setExportFormat(String exportFormat) {
		this.exportFormat = exportFormat;
	}

	public boolean isKeepExportOnServer() {
		return keepExportOnServer;
	}

	public void setKeepExportOnServer(boolean keepExportOnServer) {
		this.keepExportOnServer = keepExportOnServer;
	}
	
	public List<String> getExportedIndividuals() {
		return exportedIndividuals;
	}

	public void setExportedIndividuals(List<String> exportedIndividuals) {
		this.exportedIndividuals = exportedIndividuals;
	}
}