#!/bin/sh

export JMETER_HOME=/IBM/apache-jmeter-2.12/bin
export TEST_PLAN_HOME=/IBM/apache-jmeter-2.12/ibm/testcases
export TEST_PLAN_TEMPLATE=Lombardi_Production_Benchmark-v8.5.0.jmx

#sleep for 2 minutes between each run
export SLEEP_BETWEEN_TESTS=120

#JVM_ARGS - JMeter JVM_ARG 
export JVM_ARGS="-Xms512m -Xmx2048m"

######################################################################################################
#General set of tests to test starting 2 BPDs/sec, 5 BPDs/sec, 10 BPDs/sec
######################################################################################################
#1 User, 2 Ramp Up 
$TEST_PLAN_HOME/testPlan.sh 1 2

#1 User, 5 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 1 5

#1 User, 10 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 1 10

#100 User, 10 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 100 10

#100 User, 20 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 100 20

#100 User, 50 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 100 50

#250 User, 25 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 250 25

#250 User, 50 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 250 50

#250 User, 125 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 250 125

#300 User, 30 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 300 30

#300 User, 60 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 300 60

#300 User, 150 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 300 150

#500 User, 50 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 500 50

#500 User, 100 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 500 100

#500 User, 250 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 500 250

#750 User, 75 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 750 75

#750 User, 150 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 750 150

#750 User, 375 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 750 375

#1000 User, 100 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 1000 100

#1000 User, 200 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 1000 200

#1000 User, 500 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 1000 500

#1500 User, 150 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 1500 150

#1500 User, 300 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 1500 300

#1500 User, 750 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 1500 750

#2000 User, 200 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 2000 200

#2000 User, 400 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 2000 400

#2000 User, 1000 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 2000 1000

#2500 User, 250 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 2500 250

#2500 User, 500 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 2500 500

#2500 User, 1250 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 2500 1250

#3000 User, 300 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 3000 300

#3000 User, 600 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 3000 600

#3000 User, 1500 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 3000 1500

#4000 User, 400 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 4000 400

#4000 User, 800 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 4000 800

#4000 User, 2000 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 4000 2000

#5000 User, 500 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 5000 500

#5000 User, 1000 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 5000 1000

#5000 User, 2500 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 5000 2500

#6000 User, 600 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 6000 600

#6000 User, 1200 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 6000 1200

#6000 User, 3000 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 6000 3000

#7000 User, 700 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 7000 700

#7000 User, 1400 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 7000 1400

#7000 User, 3500 Ramp Up
$TEST_PLAN_HOME/testPlan.sh 7000 3500
