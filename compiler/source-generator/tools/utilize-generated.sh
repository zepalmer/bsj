#!/bin/bash -e

basedir=../out

apisrc=../../api/src
astsrc=../../generator/src
parsrc=../../parser/src-pre
utlsrc=../../stdlib/src

srcs="$apisrc $astsrc $parsrc $utlsrc"

if [ ! -d "../out" ]; then
	echo "Must be run from within the tools directory after sources are generated"
	exit 1
fi

for d in $srcs; do
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
j="$(cp -av $basedir/utils/* $utlsrc/)"
filecount="$( (echo "$n"; echo "$m"; echo "$k"; echo "$j") | egrep -v '^$' | wc -l )"

echo "Finished utilizing generated sources.  Found $filecount files."