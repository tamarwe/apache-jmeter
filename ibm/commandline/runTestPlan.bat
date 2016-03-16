@echo off

call ..\setupEnv.bat


rem sleep for 2 minutes between each run
SET SLEEP_BETWEEN_TESTS=120

rem #####################################################################################################
rem General set of tests to test starting 2 BPDs/sec, 5 BPDs/sec, 10 BPDs/sec
rem #####################################################################################################
rem 1 User, 2 Ramp Up 
call .\testPlan.bat 1 2

rem 1 User, 5 Ramp Up
rem replace call .\testPlan.bat 1 5

rem 1 User, 10 Ramp Up
rem replace call .\testPlan.bat 1 10

rem 100 User, 10 Ramp Up
rem replace call .\testPlan.bat 100 10

rem 100 User, 20 Ramp Up
rem replace call .\testPlan.bat 100 20

rem 100 User, 50 Ramp Up
rem replace call .\testPlan.bat 100 50

rem 250 User, 25 Ramp Up
rem replace call .\testPlan.bat 250 25

rem 250 User, 50 Ramp Up
rem replace call .\testPlan.bat 250 50

rem 250 User, 125 Ramp Up
rem replace call .\testPlan.bat 250 125

rem 300 User, 30 Ramp Up
rem replace call .\testPlan.bat 300 30

rem 300 User, 60 Ramp Up
rem replace call .\testPlan.bat 300 60

rem 300 User, 150 Ramp Up
rem replace call .\testPlan.bat 300 150

rem 500 User, 50 Ramp Up
rem replace call .\testPlan.bat 500 50

rem 500 User, 100 Ramp Up
rem replace call .\testPlan.bat 500 100

rem 500 User, 250 Ramp Up
rem replace call .\testPlan.bat 500 250

rem 750 User, 75 Ramp Up
rem replace call .\testPlan.bat 750 75

rem 750 User, 150 Ramp Up
rem replace call .\testPlan.bat 750 150

rem 750 User, 375 Ramp Up
rem replace call .\testPlan.bat 750 375

rem 1000 User, 100 Ramp Up
rem replace call .\testPlan.bat 1000 100

rem 1000 User, 200 Ramp Up
rem replace call .\testPlan.bat 1000 200

rem 1000 User, 500 Ramp Up
rem replace call .\testPlan.bat 1000 500

rem 1500 User, 150 Ramp Up
rem replace call .\testPlan.bat 1500 150

rem 1500 User, 300 Ramp Up
rem replace call .\testPlan.bat 1500 300

rem 1500 User, 750 Ramp Up
rem replace call .\testPlan.bat 1500 750

rem 2000 User, 200 Ramp Up
rem replace call .\testPlan.bat 2000 200

rem 2000 User, 400 Ramp Up
rem replace call .\testPlan.bat 2000 400

rem 2000 User, 1000 Ramp Up
rem replace call .\testPlan.bat 2000 1000

rem 2500 User, 250 Ramp Up
rem replace call .\testPlan.bat 2500 250

rem 2500 User, 500 Ramp Up
rem replace call .\testPlan.bat 2500 500

rem 2500 User, 1250 Ramp Up
rem replace call .\testPlan.bat 2500 1250

rem 3000 User, 300 Ramp Up
rem replace call .\testPlan.bat 3000 300

rem 3000 User, 600 Ramp Up
rem replace call .\testPlan.bat 3000 600

rem 3000 User, 1500 Ramp Up
rem replace call .\testPlan.bat 3000 1500

rem 4000 User, 400 Ramp Up
rem replace call .\testPlan.bat 4000 400

rem 4000 User, 800 Ramp Up
rem replace call .\testPlan.bat 4000 800

rem 4000 User, 2000 Ramp Up
rem replace call .\testPlan.bat 4000 2000

rem 5000 User, 500 Ramp Up
rem replace call .\testPlan.bat 5000 500

rem 5000 User, 1000 Ramp Up
rem replace call .\testPlan.bat 5000 1000

rem 5000 User, 2500 Ramp Up
rem replace call .\testPlan.bat 5000 2500

rem 6000 User, 600 Ramp Up
rem replace call .\testPlan.bat 6000 600

rem 6000 User, 1200 Ramp Up
rem replace call .\testPlan.bat 6000 1200

rem 6000 User, 3000 Ramp Up
rem replace call .\testPlan.bat 6000 3000

rem 7000 User, 700 Ramp Up
rem replace call .\testPlan.bat 7000 700

rem 7000 User, 1400 Ramp Up
rem replace call .\testPlan.bat 7000 1400

rem 7000 User, 3500 Ramp Up
rem replace call .\testPlan.bat 7000 3500
