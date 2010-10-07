#!/bin/bash -e

basedir=../out

apisrc=../../api/src
astsrc=../../generator/src
parsrc=../../parser/src
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

doCopy()
{
    sdir=$basedir/$1
    tdir=$2
    if [ -d $sdir ]; then
        count="$(cp -av $sdir/* $tdir | wc -l)"
    else
        count=0
    fi
    echo $count
}

filecount="$(\
        (\
            doCopy interface      $apisrc; \
            doCopy implementation $astsrc; \
            doCopy parser         $parsrc; \
            doCopy utils          $utlsrc; \
            doCopy parser-root    ../../parser; \
        ) | (n=0; while read line; do n="$(($n+$line))"; echo $n; done | tail -n 1) \
    )"

echo "Finished utilizing generated sources.  Found $filecount files."