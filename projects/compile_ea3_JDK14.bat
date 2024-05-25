cd eaWithUpdateSupport\eaUpdateClasses
del com\trinity\ea\*.class
del com\trinity\ea\actions\*.class
del com\trinity\ea\rules\reader\*.class
del com\trinity\ea\util\*.class
"C:\Program Files\Java\jdk1.5.0_02\bin\javac.exe" -source 1.4 -target 1.4 -classpath ../.. com/trinity/ea/*.java
"C:\Program Files\Java\jdk1.5.0_02\bin\javac.exe" -source 1.4 -target 1.4 -classpath ../.. com/trinity/ea/actions/*.java
"C:\Program Files\Java\jdk1.5.0_02\bin\javac.exe" -source 1.4 -target 1.4 -classpath ../.. com/trinity/ea/rules/reader/*.java
"C:\Program Files\Java\jdk1.5.0_02\bin\javac.exe" -source 1.4 -target 1.4 -classpath ../.. com/trinity/ea/util/*.java
cd ..\..