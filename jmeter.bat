java -version
echo "======================================================================"
set PATH=./jdk/jre/bin;%PATH%
call .\ibm\setupEnv.bat

java -version
echo "======================================================================"
cd bin
jmeter.bat -Jusers=1 -Jrampup=30 -t %TEST_PLAN_HOME%/%TEST_PLAN_TEMPLATE%

cd ..
