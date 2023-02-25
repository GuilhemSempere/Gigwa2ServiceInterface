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

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.ga4gh.methods.SearchVariantsRequest;

import fr.cirad.mgdb.service.IGigwaService;

/**
 * ga4gh SearchVariantsRequest extended with extra option for filtering
 * @author petel
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class GigwaSearchVariantsRequest extends SearchVariantsRequest {

    private HttpServletRequest request;
    
    private String selectedVariantTypes = "";
    private String alleleCount = "";
    private String geneName = "";
    private String variantEffect = "";
    
    private String gtPattern = "Any";
    private HashMap<String, Float> annotationFieldThresholds = new HashMap<>();
    private Float minMissingData = 0f;
    private Float maxMissingData = 100f;
    private Float minHeZ = 0f;
    private Float maxHeZ = 100f;
    private Float minMaf = 0f;
    private Float maxMaf = 50f;
    private Integer mostSameRatio = 100;
    
    private List<String> callSetIds2;
    private String gtPattern2 = "Any";
    private HashMap<String, Float> annotationFieldThresholds2 = new HashMap<>();
    private Float minMissingData2 = 0f;
    private Float maxMissingData2 = 100f;
    private Float minHeZ2 = 0f;
    private Float maxHeZ2 = 100f;
    private Float minMaf2 = 0f;
    private Float maxMaf2 = 50f;
    private Integer mostSameRatio2 = 100;
    
    private boolean discriminate = false;
    private String sortBy = "";
    private String sortDir = "asc";

    private int searchMode = 2;
    private boolean getGT = true;
    private boolean applyMatrixSizeLimit = true;
    
    private String selectedVariantIds = "";

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

    public GigwaSearchVariantsRequest() {
        super.setPageSize(100);
        super.setPageToken("0");
        super.setStart(0l);
        super.setEnd(Long.MAX_VALUE);
    }

    public String getSelectedVariantTypes() {
        return selectedVariantTypes;
    }

    public void setSelectedVariantTypes(String selectedVariantTypes) {
        this.selectedVariantTypes = selectedVariantTypes;
    }

    public boolean isGetGT() {
        return getGT;
    }

    public void setGetGT(boolean getGT) {
        this.getGT = getGT;
    }

    public String getGtPattern() {
        return gtPattern;
    }

    public void setGtPattern(String gtPattern) {
        this.gtPattern = gtPattern;
    }

    public HashMap<String, Float> getAnnotationFieldThresholds() {
	return annotationFieldThresholds;
    }

    public void setAnnotationFieldThresholds(HashMap<String, Float> annotationFieldThresholds) {
        this.annotationFieldThresholds = annotationFieldThresholds;
    }

    public Float getMinMissingData() {
        return minMissingData;
    }

    public void setMinMissingData(Float minMissingData) {
        this.minMissingData = minMissingData;
    }

    public Float getMaxMissingData() {
        return maxMissingData;
    }

    public void setMaxMissingData(Float maxMissingData) {
        this.maxMissingData = maxMissingData;
    }

    public Float getMinHeZ() {
        return minHeZ;
    }

    public void setMinHeZ(Float minHeZ) {
        this.minHeZ = minHeZ;
    }

    public Float getMaxHeZ() {
        return maxHeZ;
    }

    public void setMaxHeZ(Float maxHeZ) {
        this.maxHeZ = maxHeZ;
    }

    public Float getMinMaf() {
        return minMaf;
    }

    public void setMinMaf(Float minMaf) {
        this.minMaf = minMaf;
    }

    public Float getMaxMaf() {
        return maxMaf;
    }

    public void setMaxMaf(Float maxMaf) {
        this.maxMaf = maxMaf;
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
    
    public Integer getMostSameRatio() {
        return mostSameRatio;
    }

    public void setMostSameRatio(Integer mostSameRatio) {
        this.mostSameRatio = mostSameRatio;
    }

    public List<String> getCallSetIds2() {
        return callSetIds2;
    }

    public void setCallSetIds2(List<String> callSetIds2) {
        this.callSetIds2 = callSetIds2;
    }

    public String getGtPattern2() {
        return gtPattern2;
    }

    public void setGtPattern2(String gtPattern2) {
        this.gtPattern2 = gtPattern2;
    }

    public HashMap<String, Float> getAnnotationFieldThresholds2() {
        return annotationFieldThresholds2;
    }

    public void setAnnotationFieldThresholds2(HashMap<String, Float> annotationFieldThresholds2) {
        this.annotationFieldThresholds2 = annotationFieldThresholds2;
    }

    public Float getMinMissingData2() {
        return minMissingData2;
    }

    public void setMinMissingData2(Float minMissingData2) {
        this.minMissingData2 = minMissingData2;
    }

    public Float getMaxMissingData2() {
        return maxMissingData2;
    }

    public void setMaxMissingData2(Float maxMissingData2) {
        this.maxMissingData2 = maxMissingData2;
    }
    
    public Float getMinHeZ2() {
        return minHeZ2;
    }

    public void setMinHeZ2(Float minHeZ2) {
        this.minHeZ2 = minHeZ2;
    }

    public Float getMaxHeZ2() {
        return maxHeZ2;
    }

    public void setMaxHeZ2(Float maxHeZ2) {
        this.maxHeZ2 = maxHeZ2;
    }

    public Float getMinMaf2() {
        return minMaf2;
    }

    public void setMinMaf2(Float minMaf2) {
        this.minMaf2 = minMaf2;
    }

    public Float getMaxMaf2() {
        return maxMaf2;
    }

    public void setMaxMaf2(Float maxMaf2) {
        this.maxMaf2 = maxMaf2;
    }

    public Integer getMostSameRatio2() {
        return mostSameRatio2;
    }

    public void setMostSameRatio2(Integer mostSameRatio2) {
        this.mostSameRatio2 = mostSameRatio2;
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
    
    

    /**
     * retrieve info from an ID
     *
     * @param id of the GA4GH object to parse
     * @param expectedParamCount number of params that should be found
     * @return string[] containing Module, Project, VariantSetName | CallSetName
     * , VariantName Or null if the module doesn't exist
     */
    public static String[] getInfoFromId(String id, int expectedParamCount) {

        String delimitor = IGigwaService.ID_SEPARATOR;
        String[] result = id.split(delimitor, -1);
        if (result.length == expectedParamCount) {
            return result;
        } else {
            return null;
        }
    }
}
