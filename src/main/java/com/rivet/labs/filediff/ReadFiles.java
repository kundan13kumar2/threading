/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.rivet.labs.filediff;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kundan Kumar
 * @version $Id: ReadFiles.java, v 0.1 2020-03-07 10:15 AM Kundan Kumar Exp $$
 */
public class ReadFiles {


    public static void main(String[] args) throws IOException {

        File file1 = new File("src/main/resources/file1.txt");
        File file2 = new File("src/main/resources/file2.txt");

        BufferedReader br1FileReader = new BufferedReader(new FileReader(file1));
        BufferedReader br2FileReader = new BufferedReader(new FileReader(file2));

        List<String> file1List = new ArrayList<>();
        String string1 = null;
        while ((string1 = br1FileReader.readLine()) != null) {
            file1List.add(string1);
        }

        List<String> file2List = new ArrayList<>();
        String string2 = null;
        while ((string2 = br2FileReader.readLine()) != null) {
            file2List.add(string2);
        }

        List<String> commonElements = file1List.stream().filter(file2List::contains).collect(Collectors.toList());

        List<String> file1Elements = file1List.stream().filter(item -> !file2List.contains(item)).collect(Collectors.toList());
        List<String> file2Elements = file2List.stream().filter(item -> !file1List.contains(item)).collect(Collectors.toList());

        System.out.println("Common : " + Arrays.toString(commonElements.toArray()));
        System.out.println("File1 - File2 : " + Arrays.toString(file1Elements.toArray()));
        System.out.println("File2 - File1 : " + Arrays.toString(file2Elements.toArray()));

    }
}