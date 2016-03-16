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

package org.apache.jmeter.threads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

/**
 * Holds context for a thread.
 * Generated by JMeterContextService.
 * 
 * The class is not thread-safe - it is only intended for use within a single thread.
 */
public class JMeterContext {
    private JMeterVariables variables;

    private SampleResult previousResult;

    private Sampler currentSampler;

    private Sampler previousSampler;

    private boolean samplingStarted;

    private StandardJMeterEngine engine;

    private JMeterThread thread;

    private AbstractThreadGroup threadGroup;

    private int threadNum;

    private boolean restartNextLoop = false;

    private ConcurrentHashMap<String, Object> samplerContext = new ConcurrentHashMap<String, Object>(5);

    JMeterContext() {
        clear0();
    }

    public void clear() {
        clear0();
    }

    private void clear0() {
        variables = null;
        previousResult = null;
        currentSampler = null;
        previousSampler = null;
        samplingStarted = false;
        threadNum = 0;
        thread = null;
        samplerContext.clear();
    }

    /**
     * Gives access to the JMeter variables for the current thread.
     * 
     * @return a pointer to the JMeter variables.
     */
    public JMeterVariables getVariables() {
        return variables;
    }

    public void setVariables(JMeterVariables vars) {
        this.variables = vars;
    }

    public SampleResult getPreviousResult() {
        return previousResult;
    }

    public void setPreviousResult(SampleResult result) {
        this.previousResult = result;
    }

    public Sampler getCurrentSampler() {
        return currentSampler;
    }

    public void setCurrentSampler(Sampler sampler) {
        this.previousSampler = currentSampler;
        this.currentSampler = sampler;
    }

    /**
     * Returns the previousSampler.
     *
     * @return Sampler
     */
    public Sampler getPreviousSampler() {
        return previousSampler;
    }

    /**
     * Returns the threadNum.
     *
     * @return int
     */
    public int getThreadNum() {
        return threadNum;
    }

    /**
     * Sets the threadNum.
     *
     * @param threadNum
     *            the threadNum to set
     */
    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }

    public JMeterThread getThread() {
        return this.thread;
    }

    public void setThread(JMeterThread thread) {
        this.thread = thread;
    }

    public AbstractThreadGroup getThreadGroup() {
        return this.threadGroup;
    }

    public void setThreadGroup(AbstractThreadGroup threadgrp) {
        this.threadGroup = threadgrp;
    }

    public StandardJMeterEngine getEngine() {
        return engine;
    }

    public void setEngine(StandardJMeterEngine engine) {
        this.engine = engine;
    }

    public boolean isSamplingStarted() {
        return samplingStarted;
    }

    public void setSamplingStarted(boolean b) {
        samplingStarted = b;
    }

    /**
     * if set to <code>true</code> a restart of the loop will occurs
     *
     * @param restartNextLoop
     *            flag whether restart will occur
     */
    public void setRestartNextLoop(boolean restartNextLoop) {
        this.restartNextLoop = restartNextLoop;
    }

    /**
     * a restart of the loop was required ?
     * @return the restartNextLoop
     */
    public boolean isRestartNextLoop() {
        return restartNextLoop;
    }

    /**
     * Clean cached data after sample
     */
    public void cleanAfterSample() {
        if(previousResult != null) {
            previousResult.cleanAfterSample();
        }
        samplerContext.clear();
    }

    /**
     * Sampler context is cleaned up as soon as Post-Processor have ended
     * @return Context to use within PostProcessors to cache data
     */
    public Map<String, Object> getSamplerContext() {
        return samplerContext;
    }
}
