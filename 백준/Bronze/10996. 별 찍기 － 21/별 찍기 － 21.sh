#!/bin/bash

read n

if [ "$n" -eq 1 ]; then
    echo "*"
    exit 0
fi

odd=""
even=""

i=1
while [ $i -le $n ]
do
    if [ $((i % 2)) -eq 1 ]; then
        odd="${odd}*"
        even="${even} "
    else
        odd="${odd} "
        even="${even}*"
    fi
    i=$((i + 1))
done

result=""
i=1
while [ $i -le $((2 * n)) ]
do
    if [ $((i % 2)) -eq 1 ]; then
        result="${result}${odd}\n"
    else
        result="${result}${even}\n"
    fi
    i=$((i + 1))
done

printf "%b" "$result"