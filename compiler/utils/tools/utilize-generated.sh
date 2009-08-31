#!/bin/bash

basedir=../out

apisrc=../../api/src
astsrc=../../ast/src

apipkg=edu/jhu/cs/bsj/compiler/ast
astpkg=edu/jhu/cs/bsj/compiler/impl/ast

if [ ! -d "../out" ]; then
	echo "Must be run from within the tools directory after sources are generated"
	exit 1
fi

for d in "$apisrc/$apipkg" "$astsrc/$astpkg"; do
	rm -rvf "$d"
	mkdir -p "$d"
done

cp -av $basedir/ifaces/$apipkg/* $apisrc/$apipkg
cp -av $basedir/classes/$astpkg/* $astsrc/$astpkg
