#!/bin/sh

#javac -d /home/ken/dvr/builder/classes /home/ken/drv/java/dvr/DVRMain.java

echo -n "Resource file path?  : "
reade resource

echo -n "start month?  ex) 6 : "
read start

echo -n "stop month?   ex) 12 :"
read stop

java DVRMain $resource $start $stop
