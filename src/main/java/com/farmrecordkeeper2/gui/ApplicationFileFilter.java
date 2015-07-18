package main.java.com.farmrecordkeeper2.gui;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by garrettcoggon on 7/9/15.
 */
public class ApplicationFileFilter extends FileFilter {

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
        else if(extension.equals("app")){
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Application Database Files (*.app)";
    }

}
