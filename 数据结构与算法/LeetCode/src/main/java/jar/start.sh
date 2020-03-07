#!/bin/bash

for i in {1..20}
do
    file="$1$i.java"
    touch $file
    className=${file:0:-5}
    echo "package jar;

public class LeetCode1{
    public static void main(String[] args) {
    
    }
}
" >> $file
done