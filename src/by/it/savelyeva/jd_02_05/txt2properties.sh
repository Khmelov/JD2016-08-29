#!/usr/bin/env bash
LANGPATH=$(pwd)
echo $LANGPATH
rm -f $LANGPATH/*.properties
for file in $LANGPATH/language*.txt;
    do echo "Processing $file ..";
    native2ascii -encoding utf-8 $file ${file%.txt}.properties;
done;