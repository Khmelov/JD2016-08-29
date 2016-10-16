#!/usr/bin/env bash
set -x
rm -f $PWD/*.properties
for file in $PWD/language*.txt;
    do
    native2ascii -encoding utf-8 $file ${file%.txt}.properties;
done;