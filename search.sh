ssh txt171930@ares.utdallas.edu "bash search.sh $1" > tmp
scp txt171930@ares.utdallas.edu:/home/txt171930/SE6362/project/NeGenSearch/Crawler/src/main/resources/ResultSearch.txt .
cat ResultSearch.txt
