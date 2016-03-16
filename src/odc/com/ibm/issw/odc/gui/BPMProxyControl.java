/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.ibm.issw.odc.gui;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashSet;

import org.apache.jmeter.gui.GuiPackage;
import org.apache.jmeter.protocol.http.proxy.Daemon;
import org.apache.jmeter.protocol.http.proxy.ProxyControl;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerBase;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testelement.TestElement;

//For unit tests, @see TestProxyControl

/**
 * Class handles storing of generated samples, etc
 */
public class BPMProxyControl extends ProxyControl {

    public BPMProxyControl() {
        setPort(DEFAULT_PORT);
        setExcludeList(new HashSet<String>());
        setIncludeList(new HashSet<String>());
        setCaptureHttpHeaders(true); // maintain original behaviour
    }
    
    @Override
    public synchronized void deliverSampler(HTTPSamplerBase sampler, TestElement[] subConfigs, SampleResult result) {
    	// TODO Auto-generated method stub
    	super.deliverSampler(sampler, subConfigs, result);
    }
}
