#!/usr/bin/env bash
LANGPATH=$(pwd)
echo $LANGPATH
rm -f $LANGPATH/*.properties
for file in $LANGPATH/language*.txt;
    do echo "Processing $file ..";
    native2ascii -encoding utf-8 $file ${file%.txt}.properties;
done;
#native2ascii -encoding utf-8 $LANGPATH/language.txt $LANGPATH/language.properties
#native2ascii -encoding utf-8 $LANGPATH/language_be_BY.txt $LANGPATH/language_be_BY.properties
#native2ascii -encoding utf-8 $LANGPATH/language_ru_RU.txt $LANGPATH/language_ru_RU.properties