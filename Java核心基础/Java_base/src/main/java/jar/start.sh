#!/bin/bash

for i in {009..020}
do
    file="$1$i.java"
    touch $file
    className=${file:0:-5}
    echo "package jar;

public class $className{
    public static void main(String[] args) {
    
    }
}
" >> $file
done