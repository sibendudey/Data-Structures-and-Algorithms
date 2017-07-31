package com.java.programs;

import java.io.*;

/**
 * Created by Sibendu Dey on 6/19/2017.
 *
 * Why -> This file has been created to replace strings with some other strings.
 *
 * How -> Use BufferedReader to read from a file and BufferedWriter to write to a file
 */
public class ReplaceStringFiles {

    private final static String READFILELOCATION = "C:\\Users\\deysi\\Documents\\MMTEL\\Authentication Proxy\\DBPC_Dictionary_Files\\ZhDictionary.json";
    private final static String WRITEFILELOCATION = "C:\\Users\\deysi\\Documents\\MMTEL\\Authentication Proxy\\DBPC_Dictionary_Files\\ZhDictionary_modified.json";

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(READFILELOCATION));
        BufferedWriter writer = new BufferedWriter(new FileWriter(WRITEFILELOCATION));
        String line = null;

        while ( (line = reader.readLine()) != null) {
            if ( line.contains("User-Data-Request"))
                line = line.replace("User-Data-Request" , "Multimedia-Auth-Request") + "\n";
            else if ( line.contains("User-Data-Answer"))
                line = line.replace("User-Data-Answer" , "Multimedia-Auth-Answer") + "\n";
            else if ( line.contains("\"Profile-Update-Request\","))
                line = line.replace("\"Profile-Update-Request\"," , "");
            else if ( line.contains("\"Profile-Update-Answer\""))
                line = line.replace("\"Profile-Update-Answer\"" , "");
            else if ( line.contains("\"Subscribe-Notifications-Request\","))
                line = line.replace("\"Subscribe-Notifications-Request\"," , "");
            else if ( line.contains("\"Subscribe-Notifications-Answer\","))
                line = line.replace("\"Subscribe-Notifications-Answer\"," , "");
            else if ( line.contains("\"Push-Notification-Request\""))
                line = line.replace("\"Push-Notification-Request\"" , "");
            else if ( line.contains("\"Push-Notification-Answer\""))
                line = line.replace("\"Push-Notification-Answer\"" , "");
            else
                line = line + "\n";

            writer.write(line);
        }
        writer.flush();
    }

}
