package main.java.com.farmrecordkeeper2.gui;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by garrettcoggon on 7/18/15.
 */
public class CSVFIleFilter extends FileFilter{

        @Override
        public boolean accept(File f) {
            if(f.isDirectory()){
                return true;
            }
            String name = f.getName();

            String extension = Utils.getFileExtension(name);

            if (extension == null){
                return false;
            }
            if(extension.equals("csv")){
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public String getDescription() {
            return "CSV Files (*.csv)";
        }

    }
