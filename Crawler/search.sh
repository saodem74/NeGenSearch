#!/bin/sh
# change this line
cd /Users/tranhieu/Dropbox/Fall2019/SW_architecuture/project/Crawler/ # change it into directory where you push Cralwer
mvn compile
mvn exec:java -Dexec.mainClass="BasicSearchController" -Dexec.args=$1
