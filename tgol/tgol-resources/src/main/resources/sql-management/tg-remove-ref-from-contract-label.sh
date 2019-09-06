#!/bin/bash

# 20120824 jkowalczyk

# For Getopts: very first ":" for error managing, then a ":" after each option requiring an argument
DbUser=
DbUserPasswd=
DbName=

while getopts ":l:u:r:" opt; do
  case $opt in
    l) ContractLabel="$OPTARG" ;;
    u) UserEmail="$OPTARG" ;;
    r) Refs="$OPTARG" ;;
    :) echo "Missing argument for option -$OPTARG" ;;
    ?) echo "Unkown option $OPTARG" ;;
  esac
done

if [ -z "$ContractLabel" ] || [ -z "$UserEmail" ] || [ -z "$Refs" ]; then
	echo "Usage $0 -l <ContractLabel> -u <UserEmail> -r \"[...]\" "
        echo "Remove referentials to the given contract"
        echo "  The \"r\" option represents the referential and can take several values from :"
        echo "     - r1 -> Accessiweb 2.1"
	exit 0
fi