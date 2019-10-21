# NeGenSearch
New Generation Search

Including modules:

## Crawler
### Purpose
To crawl data webpage from the Intenet. We chose Wikipedia website for this project.
### How to run?
1. Clone this project to your local
2. Edit configuration of crawler in BasicCrawlController.java file
3. Cd to directory: Crawler/
4. Run command to start crawling: "bash run.sh" 
5. If it occurs error in compiling, please ENABLE the first line of file run.sh, and re-run the command in line 4.
  

## Search 
### Purpose
To search a query
### How to run?
1. Clone this project to your local
2. Cd to directory: Crawler/
3. Edit query search at runSearch.sh. (For example: if you want to search "programming", edit -Dexec.args in the runSearch.sh as: -Dexec.args="programming")
4. Run command to start crawling: "bash runSearch.sh" 
5. Result would be returned on both screen and file : "./src/main/resources/ResultSearch.txt"
  
