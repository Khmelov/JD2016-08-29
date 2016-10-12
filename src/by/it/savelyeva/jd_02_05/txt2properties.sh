#!/usr/bin/env bash
LANGPATH=/home/nato/java/idea/JD2016-08-29/src/by/it/savelyeva/jd_02_05
rm -f $LANGPATH/*.properties
for file in $LANGPATH/language*.txt;
    do echo "Processing $file ..";
    native2ascii -encoding utf-8 $file ${file%.txt}.properties;
done;
#native2ascii -encoding utf-8 $LANGPATH/language.txt $LANGPATH/language.properties
#native2ascii -encoding utf-8 $LANGPATH/language_be_BY.txt $LANGPATH/language_be_BY.properties
#native2ascii -encoding utf-8 $LANGPATH/language_ru_RU.txt $LANGPATH/language_ru_RU.properties