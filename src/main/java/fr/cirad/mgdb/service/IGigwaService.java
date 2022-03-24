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
package fr.cirad.mgdb.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cirad.model.GigwaDensityRequest;
import fr.cirad.model.GigwaSearchVariantsExportRequest;
import fr.cirad.model.GigwaSearchVariantsRequest;
import fr.cirad.model.GigwaVcfFieldPlotRequest;

/**
 * Interface defining gigwa-specific methods (i.e. excluding GA4GH methods)
 *
 * @author adrien petel, guilhem sempere
 */
public interface IGigwaService {

    static public final String ID_SEPARATOR = "§";
    
    /**
     * get list of variant avaible for a specific module and projId
     *
     * @param sModule
     * @param projId
     * @return List<String> containing htsjdk.variant.variantcontext.Type
     */
    public LinkedHashSet<String> getProjectVariantTypes(String sModule, int projId);

    /**
     * sort a list of variant Tpes
     *
     * @param sModule
     * @param projId
     * @return sorted List<String> containing htsjdk.variant.variantcontext.Type
     */
    public List<String> listVariantTypesSorted(String sModule, int projId);

    /**
     * get the list of available module on the server
     *
     * @return List<String>
     */
    public Collection<String> listModules();

    /**
     * get the ploidy level of a genotypeProject
     *
     * @param sModule
     * @param projId
     * @return int ploidy level
     */
    public int getProjectPloidyLevel(String sModule, int projId);

    /**
     * Get the project effect annotations
     *
     * @param sModule
     * @param projId
     * @return TreeSet<String> containing annotations effects
     */
    public TreeSet<String> getProjectEffectAnnotations(String sModule, int projId);

    /**
     *
     * @param sModule
     * @param projId
     * @return
     */
    public List<String> getProjectSequences(String sModule, int projId);

    /**
     * get distinct allele counts
     *
     * @param sModule
     * @param projId
     * @return TresSet<Integer> containing distinct alleles count
     */
	public Collection<Integer> getDistinctAlleleCounts(String sModule, Integer projId);

    /**
     * get a Map with available project for a module
     *
     * @param sModule
     * @return Map<Integer, String>
     */
    public Map<Integer, String> getProjectIdToNameMap(String sModule);

    /**
     * gets a query pattern from its label
     *
     * @param patternName
     * @return String queryPattern
     */
    public String getQueryForGenotypePattern(String patternName);

    /**
     * get the sorted list of individuals for a module and project
     *
     * @param sModule
     * @param project
     * @return List<String> of individuals sorted
     */
    public List<String> listIndividualsInAlphaNumericOrder(String sModule, int project);

    /**
     * return the sequence list of a project
     *
     * @param request
     * @param sModule
     * @param projId
     * @return List<String> containing sequences name
     * @throws FileNotFoundException
     */
    public List<String> listSequences(HttpServletRequest request, String sModule, int projId) throws FileNotFoundException;

    /**
     * build the list of query parameters
     *
     * @param GigwaSearchVariantsRequest
     * @param externallySelectedSeqs
     * @param fForBrowsing : when filtering on variant IDs, if fForBrowsing is true then returned queries will not include the $match on _id
     * @return ArrayList<Object> containing the query parameters
     */
    public Collection<? extends List> buildVariantDataQuery(GigwaSearchVariantsRequest gsvr, List<String> externallySelectedSeqs, boolean fForBrowsing);

    /**
     * Memory usage
     *
     * @return
     */
    public static String memUsage() {
        long maxMem = Runtime.getRuntime().maxMemory() / (1024 * 1024);
        long freeMem = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        long totalMem = Runtime.getRuntime().totalMemory() / (1024 * 1024);
        return "total: " + totalMem + ", free: " + freeMem + ", max: " + maxMem;
    }

    public long countVariants(GigwaSearchVariantsRequest gsvr, boolean fEmptyTempVarColl) throws Exception;

    public long findVariants(GigwaSearchVariantsRequest gsvr) throws Exception;
    
    /**
     * export the list of variants in a .zip file
     *
     * @param request
     * @param token
     * @param response
     * @throws Exception 
     */
    public void exportVariants(GigwaSearchVariantsExportRequest gsvr, String token, HttpServletResponse response) throws Exception;
    /**
     * get the sequence filter count
     *
     * @param request
     * @param sModule
     * @return
     * @throws IOException
     */
    public int getSequenceFilterCount(HttpServletRequest request, String sModule) throws IOException;

    /**
     * get sequence by id filtered with following parameters
     *
     * @param session
     * @param sModule
     * @return
     * @throws FileNotFoundException
     */
    public ArrayList<String> getSequenceIDsBeingFilteredOn(HttpSession session, String sModule) throws FileNotFoundException;

    /**
     * clear the sequencefilter file
     *
     * @param request
     * @param sModule
     */
    public void clearSequenceFilterFile(HttpServletRequest request, String sModule);

    /**
     * clean old temp data
     *
     * @param request
     * @throws IOException
     */
    public void cleanupExpiredExportData(HttpServletRequest request) throws IOException;

    /**
     * abort a process with a specific ID
     *
     * @param processID
     * @return true if aborted succesfully
     */
    public boolean abortProcess(String processID);

    /**
     *
     * @param sModule
     * @param processID
     */
    public void onInterfaceUnload(String sModule, String processID);

    /**
     * get the distinct sequences in selection
     *
     * @param request
     * @param sModule
     * @param projId
     * @param processID
     * @return
     * @throws FileNotFoundException
     */
    public Collection<String> distinctSequencesInSelection(HttpServletRequest request, String sModule, int projId, String processID) throws FileNotFoundException;

    /**
     * get the sequence filter key
     *
     * @param request
     * @param sModule
     * @return
     * @throws IOException
     */
    public String getSequenceFilterQueryKey(HttpServletRequest request, String sModule) throws IOException;

    public String getQueryKey(GigwaSearchVariantsRequest gsvr) throws IOException;

//    public Map<Long, Long> selectionDensity(GigwaDensityRequest gsvdr) throws Exception;
//    public Map<Long, Double> selectionFst(GigwaDensityRequest gdr) throws Exception;
//    public List<Map<Long, Double>> selectionTajimaD(GigwaDensityRequest gdr) throws Exception;
//
//    public Map<Long, Integer> selectionVcfFieldPlotData(GigwaVcfFieldPlotRequest gsvdr) throws Exception;

//    /**
//     * get sequences bases from a FASTA file
//     *
//     * @param seqName
//     * @param start
//     * @param module
//     * @param end
//     * @return
//     */
//    public String getReferenceBases(String seqName, int start, int end, String module) throws Exception; 
    
    /**
     * get description of annotation fields from VCF headers
     * @param module
     * @param projId
     * @return 
     */
    public Map<String, String> getAnnotationHeaders(String module, int projId);
    
    /**
     * get available export formats and descriptions
     * @return 
     */
    public TreeMap<String, HashMap<String, String>> getExportFormats();

	public TreeSet<String> searchableAnnotationFields(String sModule, int projId);
}