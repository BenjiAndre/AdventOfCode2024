#!/bin/bash

if [ "$#" -ne 1 ]; then
   echo "Usage: $0 <day>"
   exit 1
fi

SESSION="53616c7465645f5f6098f309310c438a5cde7ba1c395622280ca1f672f7d26b741f279239025d2194867955f02cd09a611d52acb1eb954c6127a0dc1e79f995c"
printf -v day "%02d" $1

curl -s "https://adventofcode.com/2024/day/$1/input" \
   -H "Cookie: session=$SESSION" \
   > "inputs/$day.in"
