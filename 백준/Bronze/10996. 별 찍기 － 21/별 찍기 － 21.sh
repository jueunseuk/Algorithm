#!/bin/bash

read n

if [ "$n" -eq 1 ]; then
    echo "*"
    exit 0
fi

i=1
while [ $i -le $((2 * n)) ]
do
    if [ $((i % 2)) -eq 1 ]; then
        j=1
        while [ $j -le $n ]
        do
            if [ $((j % 2)) -eq 1 ]; then
                printf "*"
            else
                printf " "
            fi
            j=$((j + 1))
        done
    else
        j=1
        while [ $j -le $n ]
        do
            if [ $((j % 2)) -eq 1 ]; then
                printf " "
            else
                printf "*"
            fi
            j=$((j + 1))
        done
    fi
    printf "\n"
    i=$((i + 1))
done