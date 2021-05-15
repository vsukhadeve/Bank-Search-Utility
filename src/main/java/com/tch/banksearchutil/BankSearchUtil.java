package com.tch.banksearchutil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class BankSearchUtil 
{
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//    }
	
    private static final Logger LOGGER = Logger.getLogger(BankSearchUtil.class.getName());

    /**
     * @param fileLocation the location where the file stays.
     *                     Example: System.getProperty("java.io.tmpdir") + File.separatorChar + "banks.csv"
     * @param mapper       a function for mapping each lines of the file to a an object
     * @param skipLines    to skip first x lines
     * @return List of mapped object. Type of the object is defined on the mapper function.
     */
    public static <T> List<T> parseToObject(String fileLocation, Function<String, T> mapper, int skipLines) {
        try {
            return parseToObject(new FileInputStream(new File(fileLocation)), mapper, skipLines);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "File could not be found at {0}", fileLocation);
            return null;
        }
    }

    /**
     * @param inputStream an inputStream will that will be read and parsed (from a file for example)
     * @param mapper       a function for mapping each lines of the file to a an object
     * @param skipLines    to skip first x lines
     * @return List of mapped object. Type of the object is defined on the mapper function.
     */
    public static <T> List<T> parseToObject(InputStream inputStream, Function<String, T> mapper, int skipLines) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return bufferedReader.lines()
                    .skip(skipLines)
                    .map(mapper)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "File could not be read", e);
            return null;
        }
    }
	
	
}
