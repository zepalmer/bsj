#!/bin/bash

basedir=../out

apisrc=../../api/src
astsrc=../../generator/src
parsrc=../../parser/src-pre

if [ ! -d "../out" ]; then
	echo "Must be run from within the tools directory after sources are generated"
	exit 1
fi

for d in "$apisrc/" "$astsrc/" "$parsrc/"; do
    find "$d" -name '*.java' | while read line; do
        if [ -n "$(cat "$line" | grep '@Generated' | grep 'edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator')" ]; then
            #echo "deleted $line"
            rm "$line"
        fi
    done
	mkdir -p "$d"
done

n="$(cp -av $basedir/interface/* $apisrc/)"
m="$(cp -av $basedir/implementation/* $astsrc/)"
k="$(cp -av $basedir/parser/* $parsrc/)"
filecount="$( (echo "$n"; echo "$m"; echo "$k") | wc -l )"

echo "Finished utilizing generated sources.  Found $filecount files."