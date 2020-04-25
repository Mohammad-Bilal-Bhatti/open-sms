/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Bilal Bhatti
 */
public class CustomFileFilter extends FileFilter{

    private String[] extensions;

    public CustomFileFilter(String[] extensions){
        this.extensions=extensions;
    }
    
    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
      return true;
    } else {
      String path = file.getAbsolutePath().toLowerCase();
      for (int i = 0, n = extensions.length; i < n; i++) {
        String extension = extensions[i];
        if ((path.endsWith(extension) && (path.charAt(path.length() 
                  - extension.length() - 1)) == '.')) {
          return true;
        }
      }
    }
    return false;
    }

    @Override
    public String getDescription() {
        StringBuilder builder = new StringBuilder();
        for(String item : extensions){
         builder.append(item + " | ");
        } 
        return "Custom File Filter: " + builder.toString();
    }

}
