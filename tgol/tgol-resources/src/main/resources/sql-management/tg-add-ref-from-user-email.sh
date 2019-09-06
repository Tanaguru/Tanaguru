#!/bin/bash

# 20120824 jkowalczyk

# For Getopts: very first ":" for error managing, then a ":" after each option requiring an argument
DbUser=
DbUserPasswd=
DbName=

while getopts ":u:r:" opt; do
  case $opt in
    u) UserEmail="$OPTARG" ;;
    r) Refs="$OPTARG" ;;
    :) echo "Missing argument for option -$OPTARG" ;;
    ?) echo "Unkown option $OPTARG" ;;
  esac
done

if [ -z "$UserEmail" ] || [ -z "$Refs" ]; then
	echo "Usage $0 -u <UserEmail> -r \"[...]\" "
        echo "Add referentials to all the contracts of the given user"
        echo "  The \"r\" option represents the referential and can take several values from :"
        echo "     - r1 -> Accessiweb 2.1"
        echo "     - r2 -> RGAA 2.2"
        echo "     - r3 -> Accessiweb 2.2"
	exit 0
fi