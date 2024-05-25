cd eaNoEvaluationSupport
del com\trinity\ea\*.class
"C:\Program Files\Java\jdk1.5.0_02\bin\javac.exe" -source 1.4 -target 1.4 -classpath .. com/trinity/ea/*.java
cd ..