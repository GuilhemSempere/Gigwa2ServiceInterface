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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cirad.model.GigwaSearchVariantsExportRequest;
import fr.cirad.model.MgdbSearchVariantsRequest;

/**
 * Interface defining gigwa-specific methods (i.e. excluding GA4GH methods)
 *
 * @author adrien petel, guilhem sempere
 */
public interface IGigwaService {

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

    public long countVariants(MgdbSearchVariantsRequest gsvr, boolean fEmptyTempVarColl) throws Exception;

    public long findVariants(MgdbSearchVariantsRequest gsvr) throws Exception;
    
    /**
     * export the list of variants in a .zip file
     *
     * @param gsvr
     * @param token
     * @param response
     * @throws Exception 
     */
    public void exportVariants(GigwaSearchVariantsExportRequest gsvr, String token, HttpServletResponse response) throws Exception;

//    /**
//     * get the sequence filter count
//     *
//     * @param request
//     * @param sModule
//     * @return
//     * @throws IOException
//     */
//    public int getSequenceFilterCount(HttpServletRequest request, String sModule) throws IOException;
//
//    /**
//     * get sequence by id filtered with following parameters
//     *
//     * @param session
//     * @param sModule
//     * @return
//     * @throws FileNotFoundException
//     */
//    public ArrayList<String> getSequenceIDsBeingFilteredOn(HttpSession session, String sModule) throws FileNotFoundException;
//
//    /**
//     * clear the sequencefilter file
//     *
//     * @param request
//     * @param sModule
//     */
//    public void clearSequenceFilterFile(HttpServletRequest request, String sModule);

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
     * @throws InterruptedException 
     */
    public void dropTempColl(String sModule, String processID) throws InterruptedException;

    /**
     * get the distinct sequences in selection
     *
     * @param request
     * @param sModule
     * @param projId
     * @param processID
     * @return
     * @throws FileNotFoundException
     * @throws InterruptedException 
     */
    public Collection<String> distinctSequencesInSelection(HttpServletRequest request, String sModule, int projId, String processID) throws FileNotFoundException, InterruptedException;

    /**
     * get the sequence filter key
     *
     * @param request
     * @param sModule
     * @return
     * @throws IOException
     */
//    public String getSequenceFilterQueryKey(HttpServletRequest request, String sModule) throws IOException;

    public String getQueryKey(MgdbSearchVariantsRequest gsvr) throws IOException;

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