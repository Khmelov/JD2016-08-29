#!/usr/bin/env bash
LANGPATH=/Users/waldemartsiamruk/IdeaProjects/Students/JD2016-08-29v2/src/by/it/tsiamruk/jd02_05
rm -f $LANGPATH/*.properties
for file in $LANGPATH/language*.txt;
    do
    native2ascii -encoding utf-8 $file ${file%.txt}.properties;
done;