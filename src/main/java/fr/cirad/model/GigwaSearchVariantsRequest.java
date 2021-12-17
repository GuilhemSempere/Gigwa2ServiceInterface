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

import fr.cirad.controller.GigwaMethods;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.ga4gh.methods.SearchVariantsRequest;

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
    private HashMap<String, Float> annotationFieldThresholds = new HashMap();
    private Float missingData = 100f;
    private Float minmaf = 0f;
    private Float maxmaf = 50f;
    private Integer mostSameRatio = 100;
    
    private List<String> callSetIds2;
    private String gtPattern2 = "Any";
    private HashMap<String, Float> annotationFieldThresholds2 = new HashMap();
    private Float missingData2 = 100f;
    private Float minmaf2 = 0f;
    private Float maxmaf2 = 50f;
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

    public Float getMissingData() {
        return missingData;
    }

    public void setMissingData(Float missingData) {
        this.missingData = missingData;
    }

    public Float getMinmaf() {
        return minmaf;
    }

    public void setMinmaf(Float minmaf) {
        this.minmaf = minmaf;
    }

    public Float getMaxmaf() {
        return maxmaf;
    }

    public void setMaxmaf(Float maxmaf) {
        this.maxmaf = maxmaf;
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

    public Float getMissingData2() {
        return missingData2;
    }

    public void setMissingData2(Float missingData2) {
        this.missingData2 = missingData2;
    }

    public Float getMinmaf2() {
        return minmaf2;
    }

    public void setMinmaf2(Float minmaf2) {
        this.minmaf2 = minmaf2;
    }

    public Float getMaxmaf2() {
        return maxmaf2;
    }

    public void setMaxmaf2(Float maxmaf2) {
        this.maxmaf2 = maxmaf2;
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

        String delimitor = GigwaMethods.ID_SEPARATOR;
        String[] result = id.split(delimitor);
        if (result.length == expectedParamCount) {
            return result;
        } else {
            return null;
        }
    }
}
