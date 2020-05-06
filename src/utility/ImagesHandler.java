/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.util.Date;
import config.Config;
import java.awt.Graphics2D;

/**
 *
 * @author Bilal Bhatti
 */
public class ImagesHandler {

    /*
    * Purpose: This class is responsible for storing and getting filess    
     */

    private final String IMG_DIR;
 
    private final int MAX_SIZE = Config.MAX_IMG_SIZE; 
    private final int WIDTH = Config.IMG_WIDTH;
    private final int HEIGHT = Config.IMG_WIDTH;
    

    public ImagesHandler(String imgDir) {
        this.IMG_DIR = imgDir;
        File dir = new File(imgDir);
        if (!dir.exists()) {
            dir.mkdirs();
            this.hide(dir.getAbsolutePath());
        }
    }

    
    public String save(String inputImagePath){
        String fileName = new File(inputImagePath).getName();
        String destinationPath = IMG_DIR + "\\" +  this.generateNewName(fileName);
        return this.storeImage(inputImagePath, destinationPath);
    }
    
    public String save(String inputImagePath, String newName){
        String destinationPath = IMG_DIR + "\\" +  this.generateNewName(newName);
        return this.storeImage(inputImagePath, destinationPath);
    }

    
    private String storeImage(String sourcePath, String destinationPath){
        try{
            if(this.validateFileSize(sourcePath)){ // `true` means file size is perfect no need to resize image.
                // Copy the image to the destination folder
                this.copy(sourcePath, destinationPath);
                // Return destination stored image path.
                return destinationPath;
            }
            // Resize the image.
            BufferedImage resizedImage = this.resizeImage(sourcePath, WIDTH, HEIGHT);
            // Save the Image. and Copy the image to destination folder
            this.saveImage(resizedImage, destinationPath);
            // Return destination stored image path.
            return destinationPath;
        }catch(IOException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean delete(String filePath) {
        try{
            File file = new File(filePath);
            if (file.exists()) {
                return file.delete();
            }
        }catch(NullPointerException npe){
            System.err.println("Null reference on ImageHandler.delete(filePath): "+npe.getMessage());
        }
        return false;
    }

    public ImageIcon loagImage(String path) {
        ImageIcon imageIcon = new ImageIcon(path);
        Image scaleImage = imageIcon.getImage().getScaledInstance(220, 180, Image.SCALE_DEFAULT);
        return new ImageIcon(scaleImage);

    }

    
    private void copy(String sourcePath, String destinationPath) throws IOException{
        
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);
        
        if(!destinationFile.exists()){
            destinationFile.createNewFile();
        }
        
        FileInputStream reader;
        FileOutputStream writer;

        byte[] readBytes = new byte[1024];
        
        //Setting up the Reader and Speed Reader
        reader = new FileInputStream(sourceFile);
        //Setting up the Writer and Speed Writer
        writer = new FileOutputStream(destinationFile);

        int bytesRead;
        while ((bytesRead = reader.read(readBytes)) != -1) {
            writer.write(readBytes, 0, bytesRead); // Read and write on same time.
            writer.flush();
        }
        reader.close();
        writer.close();
    }

    private String generateNewName(String fileName) {
        String currentDate = DateFormatter.formatDate(new Date());
        return currentDate + " " + fileName;
    }

    private void hide(String path) {
        Path p = Paths.get(path);
        try {
            DosFileAttributes dos = Files.readAttributes(p, DosFileAttributes.class);
            Files.setAttribute(p, "dos:hidden", true);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private void unhide(String path) {
        Path p = Paths.get(path);
        try {
            DosFileAttributes dos = Files.readAttributes(p, DosFileAttributes.class);
            Files.setAttribute(p, "dos:hidden", false);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /*
    * @Purpose: Validate file size to certail thrashold value.
     */
    private boolean validateFileSize(String filePath) {
        File file = new File(filePath);
        long sizeInBytes = file.length();

        // If the file size is less than or equal maxSize than return true otherwise false.
        return sizeInBytes <= MAX_SIZE ;
        
    }

    /*
    * @Purpose: Resize the image to specific width and height
    * @Parms: image String: image path to convert
    * @Parms: width int: width to convert
    * @Parms: height int: height to convert
    * @Return: BufferedImage: resized image.
     */
    private BufferedImage resizeImage(String filePath, int width, int height) {
        try {
            File originalFile = new File(filePath);
            String parentPath = originalFile.getParent();
            BufferedImage originalImage = ImageIO.read(originalFile);

            int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB
                    : originalImage.getType();

            int IMG_WIDTH = width;
            int IMG_CLAHEIGHT = height;

            BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_CLAHEIGHT,
                    type);
            
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_CLAHEIGHT, null);
            g.dispose();
            
            return resizedImage;

        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        return null;
    }
    
    private void saveImage(BufferedImage image, String filePath) throws IOException{
        File file = new File(filePath);
        if(!file.exists()){
            file.createNewFile();
        }
        ImageIO.write(image, "png", file);
    }
    
}
