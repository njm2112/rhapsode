/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * NOTICE

 * This software was produced for the U.S. Government
 * under Basic Contract No. W15P7T-13-C-A802,
 * W15P7T-12-C-F600, and W15P7T-13-C-F600, and is
 * subject to the Rights in Noncommercial Computer Software
 * and Noncommercial Computer Software Documentation
 * Clause 252.227-7014 (FEB 2012)
 *
 * (C) 2013-2017 The MITRE Corporation. All Rights Reserved.
 *
 */
package org.rhapsode.app.handlers.search;


import org.apache.lucene.queryparser.classic.ParseException;
import org.rhapsode.app.RhapsodeSearcherApp;
import org.rhapsode.app.contants.C;
import org.rhapsode.lucene.search.variant.TargetRequest;
import org.rhapsode.util.ParamUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TargetRequestBuilder extends BaseRequestBuilder {


    public void extract(RhapsodeSearcherApp config, HttpServletRequest servletRequest,
                        TargetRequest request) throws IOException, ParseException {
        super.extractBase(config, servletRequest, request);
        //TODO: parameterize
        request.setAllowTargetOverlaps(false);
        //TODO: pull from default values in searcher searcherApp
        request.setMaxWindows(ParamUtil.getInt(servletRequest.getParameter(C.MAX_VISITED_WINDOWS), 10000));
        request.setNormalizeTarget(ParamUtil.getBooleanChecked(servletRequest.getParameter(C.NORMALIZE_TARGET), true));
        request.setNumResults(ParamUtil.getInt(servletRequest.getParameter(C.NUM_RESULTS), 10000));
        request.setShowCodePoints(ParamUtil.getBooleanChecked(servletRequest.getParameter(C.SHOW_CODE_POINTS), false));
    }
}
