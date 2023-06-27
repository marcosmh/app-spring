package com.std.springapp.librerias.commonsio;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CommonsIOLib {

    public static void copyFile(String source1, String dest1, String filename) throws IOException {

        File source = new File (source1);
        File dest = new File (dest1, filename);

        FileUtils.copyFile(source, dest);
    }
}
