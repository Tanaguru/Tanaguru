#!/bin/bash

# 20120824 jkowalczyk

# For Getopts: very first ":" for error managing, then a ":" after each option requiring an argument
DbUser=
DbUserPasswd=
DbName=

while getopts ":l:u:f:" opt; do
  case $opt in
    l) ContractLabel="$OPTARG" ;;
    u) UserEmail="$OPTARG" ;;
    f) Functs="$OPTARG" ;;
    :) echo "Missing argument for option -$OPTARG" ;;
    ?) echo "Unkown option $OPTARG" ;;
  esac
done

if [ -z "$ContractLabel" ] || [ -z "$UserEmail" ] || [ -z "$Functs" ]; then
	echo "Usage $0 -l <ContractLabel> -u <UserEmail> -f \"[...]\" "
        echo "Add functionalities to the given contract"
        echo "  The \"f\" option represents the functionalities to add and can take several values from :"
        echo "     - f1 -> Up to 10 pages Audit"
        echo "     - f2 -> Site Audit "
        echo "     - f3 -> File upload Audit "
        echo "     - f4 -> Scenario Audit "
	exit 0
fi