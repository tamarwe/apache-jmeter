echo "Running JMeter Test with %1 users and %2 rampup"

cd %JMETER_HOME%
call jmeter.bat -n -Jusers=%1 -Jrampup=%2 -t %TEST_PLAN_HOME%/%TEST_PLAN_TEMPLATE% -l %TEST_PLAN_HOME%/%1U_%2Rampup.csv -j %TEST_PLAN_HOME%/%1U_%2Rampup_jmeter.log
cd %TEST_PLAN_HOME%

echo Sleeping %SLEEP_BETWEEN_TESTS% seconds before the next test scenario
sleep %SLEEP_BETWEEN_TESTS%
