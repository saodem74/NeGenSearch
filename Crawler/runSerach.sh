# mvn clean dependency:copy-dependencies package
mvn compile
mvn exec:java -Dexec.mainClass="BasicSearchController"