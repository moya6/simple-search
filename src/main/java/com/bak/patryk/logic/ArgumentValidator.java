package com.bak.patryk.logic;

import java.io.File;

public class ArgumentValidator
{
    public static void validate(String[] args)
    {
        if (args.length == 0)
        {
            throw new IllegalArgumentException("No directory given to index. ");
        }
        if (!(new File(args[0]).isDirectory()))
        {
            throw new IllegalArgumentException("Argument is not a directory");
        }
    }

}
