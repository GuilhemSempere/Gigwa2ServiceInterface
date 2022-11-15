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

import java.util.Collection;
import java.util.List;

/**
 *
 * @author petel, sempere, mignerot
 */
public class GigwaChartRequest extends GigwaSearchVariantsRequest {

    private String displayedSequence;
    private Long displayedRangeMin;
    private Long displayedRangeMax;
    private Integer displayedRangeIntervalCount;
    private String displayedVariantType;
    private List<List<String>> displayedAdditionalGroups;
    private Collection<String> plotIndividuals;
    private boolean fTreatFirstGroupIndividualsAsSingletons = false;	// if true, first group will be split to consider each individual it contains as a separate group

	public GigwaChartRequest(){
        super();
    }
    
    public String getDisplayedSequence() {
        return displayedSequence;
    }

    public void setDisplayedSequence(String displayedSequence) {
        this.displayedSequence = displayedSequence;
    }

    public Long getDisplayedRangeMin() {
        return displayedRangeMin;
    }

    public void setDisplayedRangeMin(Long displayedRangeMin) {
        this.displayedRangeMin = displayedRangeMin;
    }

    public Long getDisplayedRangeMax() {
        return displayedRangeMax;
    }

    public void setDisplayedRangeMax(Long displayedRangeMax) {
        this.displayedRangeMax = displayedRangeMax;
    }

    public Integer getDisplayedRangeIntervalCount() {
        return displayedRangeIntervalCount;
    }

    public void setDisplayedRangeIntervalCount(Integer displayedRangeIntervalCount) {
        this.displayedRangeIntervalCount = displayedRangeIntervalCount;
    }

    public String getDisplayedVariantType() {
        return displayedVariantType;
    }

    public void setDisplayedVariantType(String displayedVariantType) {
        this.displayedVariantType = displayedVariantType;
    }
    
    public List<List<String>> getDisplayedAdditionalGroups() {
		return displayedAdditionalGroups;
	}

	public void setDisplayedAdditionalGroups(List<List<String>> displayedAdditionalGroups) {
		this.displayedAdditionalGroups = displayedAdditionalGroups;
	}
	
	public Collection<String> getPlotIndividuals() {
		return this.plotIndividuals;
	}
	
	public void setPlotIndividuals(Collection<String> plotIndividuals) {
		this.plotIndividuals = plotIndividuals;
	}
	
	public boolean treatFirstGroupIndividualsAsSingletons() {
		return fTreatFirstGroupIndividualsAsSingletons;
	}

	public void setfTreatFirstGroupIndividualsAsSingletons(boolean fTreatFirstGroupIndividualsAsSingletons) {
		this.fTreatFirstGroupIndividualsAsSingletons = fTreatFirstGroupIndividualsAsSingletons;
	}
}
