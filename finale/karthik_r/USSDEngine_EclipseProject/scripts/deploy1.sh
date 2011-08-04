CATALINA_HOME=/home/codejam/Downloads/apache-tomcat-6.0.32
CLASSPATH=/home/codejam/Downloads/apache-tomcat-6.0.32/servlet-api.jar:.
cd $CATALINA_HOME/webapps/USSDEngine/src/ussdengine
javac -cp $CLASSPATH *
mv *.class ../../WEB-INF/classes/ussdengine
cd $CATALINA_HOME/webapps/USSDEngine/src
javac -cp $CLASSPATH:$CATALINA_HOME/webapps/USSDEngine/WEB-INF/classes/ussdengine:$CATALINA_HOME/webapps/USSDEngine/WEB-INF/classes HelloWorld.java
mv *.class $CATALINA_HOME/webapps/USSDEngine/WEB-INF/classes
