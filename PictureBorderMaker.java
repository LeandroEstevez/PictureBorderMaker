/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picturebordermaker;

import java.io.File;
import static java.lang.System.exit;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author leandroestevez
 */
public class PictureBorderMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String path = "";
                
        //Create a file chooser
        final JFileChooser fc = new JFileChooser();
        
        //Add a custom file filter and disable the default
	//(Accept All) file filter.
        fc.addChoosableFileFilter(new ImageFilter());
        fc.setAcceptAllFileFilterUsed(false);
        
        int returnVal = fc.showOpenDialog(null);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            
            File file = fc.getSelectedFile();
            
            path = file.getAbsolutePath();
            
            Picture pic = new Picture();
        
            pic.load(path);

            int newWidth = pic.getWidth() - 40;
            int newHeight = pic.getHeight() - 40;

            pic.scale(newWidth, newHeight);

            pic.move(20, 20);

            pic.border(10);
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Thank you for using Picture Border Maker");
            
            exit(0);
            
        }
        
    }
    
}
