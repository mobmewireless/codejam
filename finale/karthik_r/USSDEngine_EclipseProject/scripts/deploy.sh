CATALINA_HOME=/home/codejam/Downloads/apache-tomcat-6.0.32
CLASSPATH=/home/codejam/Downloads/apache-tomcat-6.0.32/servlet-api.jar
rm -r $CATALINA_HOME/webapps/USSDEngine
cp -r /home/codejam/workspace/USSDEngine $CATALINA_HOME/webapps
cd $CATALINA_HOME/webapps/USSDEngine
cd src/ussdengine/
javac -cp $CLASSPATH:. *
mv *.class ../../WEB-INF/classes/ussdengine
cd $CATALINA_HOME/webapps/USSDEngine/src
javac -cp $CLASSPATH:$CATALINA_HOME/webapps/USSDEngine/WEB-INF/classes HelloWorld.java
mv *.class $CATALINA_HOME/webapps/USSDEngine/WEB-INF/classes
