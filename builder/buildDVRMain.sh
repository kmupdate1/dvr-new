#!/bin/sh

#javac -d /home/ken/dvr/builder/classes /home/ken/drv/java/dvr/DVRMain.java

echo -n "Resources file path?  : "
reade resources

echo -n "start month?  ex) 6 : "
read start

echo -n "stop month?   ex) 12 :"
read stop

java DVRMain $resources $start $stop
