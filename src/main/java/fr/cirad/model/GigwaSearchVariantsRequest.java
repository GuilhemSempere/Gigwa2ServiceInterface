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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.ga4gh.methods.SearchVariantsRequest;

/**
 * ga4gh SearchVariantsRequest extended with extra option for filtering
 * @author petel, sempere, biggio
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class GigwaSearchVariantsRequest extends SearchVariantsRequest {

    private HttpServletRequest request;
    
    private String selectedVariantTypes = "";
    private String alleleCount = "";
    private String geneName = "";
    private String variantEffect = "";

    private Integer numberGroups = 2;
    
    private List<String> gtPattern = new ArrayList<>(Collections.nCopies(numberGroups, "Any"));
    private List<HashMap<String, Float>> annotationFieldThresholds = new ArrayList<>(Collections.nCopies(numberGroups, new HashMap<>()));
    private List<Float> minMissingData = new ArrayList<>(Collections.nCopies(numberGroups, 0f));
    private List<Float> maxMissingData = new ArrayList<>(Collections.nCopies(numberGroups, 100f));
    private List<Float> minHeZ = new ArrayList<>(Collections.nCopies(numberGroups, 0f));
    private List<Float> maxHeZ = new ArrayList<>(Collections.nCopies(numberGroups, 100f));
    private List<Float> minMaf = new ArrayList<>(Collections.nCopies(numberGroups, 0f));
    private List<Float> maxMaf = new ArrayList<>(Collections.nCopies(numberGroups, 50f));
    private List<Integer> mostSameRatio = new ArrayList<>(Collections.nCopies(numberGroups, 100));
    
    private List<List<String>> additionalCallSetIds;
    
    private boolean discriminate = false;
    private String sortBy = "";
    private String sortDir = "asc";

    private int searchMode = 2;
    private boolean getGT = true;
    private boolean applyMatrixSizeLimit = true;
    
    private String selectedVariantIds = "";
    
    public GigwaSearchVariantsRequest() {
        super.setPageSize(100);
        super.setPageToken("0");
        super.setStart(-1L);
        super.setEnd(-1L);
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    
    public boolean shallApplyMatrixSizeLimit() {
        return applyMatrixSizeLimit;
    }

    public void setApplyMatrixSizeLimit(boolean applyMatrixSizeLimit) {
            this.applyMatrixSizeLimit = applyMatrixSizeLimit;
    }

    public int getSearchMode() {
        return searchMode;
    }

    public void setSearchMode(int searchMode) {
        this.searchMode = searchMode;
    }

    public String getSelectedVariantTypes() {
        return selectedVariantTypes;
    }

    public void setSelectedVariantTypes(String selectedVariantTypes) {
        this.selectedVariantTypes = selectedVariantTypes;
    }

    public Integer getNumberGroups() {
        return numberGroups;
    }

    public void setNumberGroups(Integer numberGroups) {
        this.numberGroups = numberGroups;
    }

    public boolean isGetGT() {
        return getGT;
    }

    public void setGetGT(boolean getGT) {
        this.getGT = getGT;
    }

    public List<String> getGtPattern() {
        return gtPattern;
    }

    public void setGtPattern(List<String> gtPattern) {
        this.gtPattern = gtPattern;
    }

    public void setGtPatternWithIndex(String gtPattern, Integer index) {
        this.gtPattern.set(index, gtPattern);
    }

    public List<HashMap<String, Float>> getAnnotationFieldThresholds() {
	return annotationFieldThresholds;
    }

    public void setAnnotationFieldThresholds(List<HashMap<String, Float>> annotationFieldThresholds) {
        this.annotationFieldThresholds = annotationFieldThresholds;
    }

    public void setAnnotationFieldThresholdsWithIndex(HashMap<String, Float> annotationFieldThresholds, Integer index) {
        this.annotationFieldThresholds.set(index, annotationFieldThresholds);
    }

    public List<Float> getMinMissingData() {
        return minMissingData;
    }

    public void setMinMissingData(List<Float> minMissingData) {
        this.minMissingData = minMissingData;
    }

    public void setMinMissingDataWithIndex(Float minMissingData, Integer index) {
        this.minMissingData.set(index, minMissingData);
    }

    public List<Float> getMaxMissingData() {
        return maxMissingData;
    }

    public void setMaxMissingData(List<Float> maxMissingData) {
        this.maxMissingData = maxMissingData;
    }

    public void setMaxMissingDataWithIndex(Float maxMissingData, Integer index) {
        this.maxMissingData.set(index, maxMissingData);
    }

    public List<Float> getMinHeZ() {
        return minHeZ;
    }

    public void setMinHeZ(List<Float> minHeZ) {
        this.minHeZ = minHeZ;
    }

    public void setMinHeZWithIndex(Float minHeZ, Integer index) {
        this.minHeZ.set(index, minHeZ);
    }

    public List<Float> getMaxHeZ() {
        return maxHeZ;
    }

    public void setMaxHeZ(List<Float> maxHeZ) {
        this.maxHeZ = maxHeZ;
    }

    public void setMaxHeZWithIndex(Float maxHeZ, Integer index) {
        this.maxHeZ.set(index, maxHeZ);
    }

    public List<Float> getMinMaf() {
        return minMaf;
    }

    public void setMinMaf(List<Float> minMaf) {
        this.minMaf = minMaf;
    }

    public void setMinMafWithIndex(Float minMaf, Integer index) {
        this.minMaf.set(index, minMaf);
    }

    public List<Float> getMaxMaf() {
        return maxMaf;
    }

    public void setMaxMaf(List<Float> maxMaf) {
        this.maxMaf = maxMaf;
    }

    public void setMaxMafWithIndex(Float maxMaf, Integer index) {
        this.maxMaf.set(index, maxMaf);
    }

    public String getAlleleCount() {
        return alleleCount;
    }

    public void setAlleleCount(String alleleCount) {
        this.alleleCount = alleleCount;
    }

    public String getGeneName() {
        return geneName;
    }

    public void setGeneName(String geneName) {
        this.geneName = geneName;
    }

    public String getVariantEffect() {
        return variantEffect;
    }

    public void setVariantEffect(String variantEffect) {
        this.variantEffect = variantEffect;
    }
    
    public List<Integer> getMostSameRatio() {
        return mostSameRatio;
    }

    public void setMostSameRatio(List<Integer> mostSameRatio) {
        this.mostSameRatio = mostSameRatio;
    }

    public void setMostSameRatioWithIndex(Integer mostSameRatio, Integer index) {
        this.mostSameRatio.set(index, mostSameRatio);
    }

    public List<List<String>> getAdditionalCallSetIds() {
        return additionalCallSetIds;
    }

    public void setAdditionalCallSetIds(List<List<String>> additionalCallSetIds) {
        this.additionalCallSetIds = additionalCallSetIds;
    }

    public List<List<String>> getAllCallSetIds() {
        return new ArrayList<>(additionalCallSetIds) {{ add(0, getCallSetIds()); }};
    }

    public void setAdditionalCallSetIdsWithIndex(List<String> additionalCallSetIds, Integer index) {
        if (index >= 0 && index < this.additionalCallSetIds.size())
            this.additionalCallSetIds.set(index, additionalCallSetIds);
    }

    public boolean isDiscriminate() {
        return discriminate;
    }

    public void setDiscriminate(boolean discriminate) {
        this.discriminate = discriminate;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortDir() {
        return sortDir;
    }

    public void setSortDir(String sortDir) {
        this.sortDir = sortDir;
    }

    public String getSelectedVariantIds() {
        return selectedVariantIds;
    }

    public void setSelectedVariantIds(String selectedVariantIds) {
        this.selectedVariantIds = selectedVariantIds;
    }
}