/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static model.testlogin.log;
import org.apache.log4j.Logger;

/**
 *
 * @author Acer
 */
public class backResoreCode {
     static Logger log = Logger.getLogger(backResoreCode.class.getName());
 
    public String backupDb(String backuppath){
        String msg = null;
        
        try {
            Runtime runtime = Runtime.getRuntime();
            Process p =runtime.exec("C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump.exe -uroot -pchamodjava.01 --add-drop-database --port=3307 -B  school_managment -r "+backuppath);
            
            int processComplete = p.waitFor();
            System.out.println(processComplete);
            msg ="Success";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg="Error"+e.getMessage();
        }
        
        return msg;
    }
    public String restore(String restorepath){
        String msg = null;
        
        try {
            Runtime runtime = Runtime.getRuntime();
            String [] restoreCmd =new String[]{"C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysql.exe",
                    "--user=root" ,
                    "--password=chamodjava.01" ,
                    "--port=3307" ,
                    "-e" ,
                    " source " + restorepath};
            Process p =runtime.exec(restoreCmd);
            int processComplete = p.waitFor();
            System.out.println(processComplete);
            msg ="Success";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg="Error"+e.getMessage();
        }
        
        return msg;
        
    }
    
}

