#!/bin/bash

# 20111102 mfaure

# For Getopts: very first ":" for error managing, then a ":" after each option requiring an argument
DbUser=
DbUserPasswd=
DbName=

while getopts ":e:p:l:f:" opt; do
  case $opt in
    e) Email="$OPTARG" ;;
    p) Passwd="$OPTARG" ;;
    l) LastName="$OPTARG" ;;
    f) FirstName="$OPTARG" ;;
    :) echo "Missing argument for option -$OPTARG" ;;
    ?) echo "Unkown option $OPTARG" ;;
  esac
done

if [ -z "$Email" ] || [ -z "$Passwd" ] || [ -z "$LastName" ] || [ -z "$FirstName" ]; then
	echo "Usage $0 -e <Email> -p <password> -l <LastName> -f <FirstName> "
	exit -1
fi

Md5pwd=$(/usr/bin/java -jar ./Passwdmd5/jacksum.jar -a md5 -q "txt:${Passwd}")
Md5pwd=$(echo $Md5pwd | cut -c1-32)