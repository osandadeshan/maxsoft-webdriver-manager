package com.maxsoft.webdrivermanager.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Project Name    : maxsoft-webdriver-manager
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 9/1/2020
 * Time            : 11:28 AM
 * Description     : This class will help to download IEDriverServer.exe to your local machine
 **/

public class IEDriverDownloader {

    private String driversPath, ieDriverExePath;

    public IEDriverDownloader() {
        driversPath = String.valueOf(File.listRoots()[0].toString().charAt(0)).concat(":/Drivers");
        ieDriverExePath = driversPath.concat("/IEDriverServer.exe");
    }

    public String getIeDriverExePath() {
        return ieDriverExePath;
    }

    public void downloadIEDriverIfNotExists() {
        File destination = new File(getIeDriverExePath());
        if (!destination.exists()) {
            try {
                InputStream input = new URL("https://github.com/osandadeshan/maxsoft-webdriver-manager/raw/1.0.2/src/main/resources/IEDriverServer.exe")
                        .openStream();
                FileOutputStream output = new FileOutputStream(destination);
                byte[] buffer = new byte[4096];
                int n = 0;
                while (-1 != (n = input.read(buffer))) {
                    output.write(buffer, 0, n);
                }
                input.close();
                output.close();
                System.out.println("IEDriver has downloaded and saved to '" + destination + "' successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public IEDriverDownloader createDirectoryIfNotExists() {
        File directory = new File(driversPath);
        if (!directory.exists()) {
            System.out.println("'" + driversPath + "' is not exists.\nCreating '" + driversPath + "' directory.........");
            boolean isDirectoryCreated = directory.mkdir();
            System.out.println("isDirectoryCreated = " + isDirectoryCreated);
        }
        return this;
    }

    public IEDriverDownloader hideDirectory() {
        try {
            Files.setAttribute(Paths.get(driversPath), "dos:hidden", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

}