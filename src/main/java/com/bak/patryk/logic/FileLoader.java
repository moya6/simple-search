package com.bak.patryk.logic;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileLoader
{
    /**
     *
     * @param directory
     * @return map where : Key - file name, Value - file content represented as string
     */
    public static Map<String, String> loadTextFilesFromDirectory(File directory)
    {
        Map<String, String> fileContentsByFilenameMap = new HashMap<>();
        if (directory.listFiles() != null)
        {
            for (File file : directory.listFiles())
            {
                if (isTextFile(file))
                {
                    try
                    {
                        String content = FileUtils.readFileToString(file);
                        fileContentsByFilenameMap.put(file.getName(), content);
                    } catch (IOException e)
                    {
                        System.out.println("Error loading file " + file.getName());
                    }
                }
            }
        }
        return fileContentsByFilenameMap;
    }

    private static boolean isTextFile(File fileEntry)
    {
        return fileEntry.isFile() && "txt".equals(FilenameUtils.getExtension(fileEntry.getName()));
    }
}
