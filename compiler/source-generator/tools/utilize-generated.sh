#!/bin/bash

basedir=../out

apisrc=../../api/src
astsrc=../../ast/src

if [ ! -d "../out" ]; then
	echo "Must be run from within the tools directory after sources are generated"
	exit 1
fi

for d in "$apisrc/" "$astsrc/"; do
    find "$d" -name '*.java' | while read line; do
        if [ -n "$(cat "$line" | grep '@Generated' | grep 'edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator')" ]; then
            echo "deleted $line"
            rm "$line"
        fi
    done
	mkdir -p "$d"
done

cp -av $basedir/interface/* $apisrc/
cp -av $basedir/implementation/* $astsrc/
