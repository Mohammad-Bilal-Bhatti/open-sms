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

/**
 *
 * @author Bilal Bhatti
 */
public class ImagesHandler {

    /*
    * Purpose: This class is responsible for storing and getting filess    
     */

    private final String imgDir;
    private final int maxSize = Config.MAX_IMG_SIZE; 

    public ImagesHandler(String imgDir) {
        this.imgDir = imgDir;
        File dir = new File(imgDir);
        if (!dir.exists()) {
            dir.mkdirs();
            this.hide(dir.getAbsolutePath());
        }
    }

    public boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public ImageIcon loagImage(String path) {
        ImageIcon imageIcon = new ImageIcon(path);
        Image scaleImage = imageIcon.getImage().getScaledInstance(220, 180, Image.SCALE_DEFAULT);
        return new ImageIcon(scaleImage);

    }

    /*
    * @Purpose: save the image and return its path.
     */
    public String saveImage(String sourceFilePath) {
        //First it validates the size of the file
        String alteredImage = this.validateImageSize(sourceFilePath);
        File sourceFile = new File(alteredImage);

        String fileName = sourceFile.getName().toLowerCase();
        String newFileName = this.generateFileName(fileName);

        String destinationFilePath = this.imgDir + "\\" + newFileName;
        File destinationFile = new File(destinationFilePath);

        // Try to save the file.
        try {
            if (!destinationFile.exists()) {
                destinationFile.createNewFile(); // Create file if not exists.
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


            this.hide(destinationFile.getAbsolutePath());
            return destinationFile.getAbsolutePath();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String generateFileName(String fileName) {
        String currentDate = DateFormatter.formatDate(new Date()) + "-";
        return currentDate + fileName;
    }

    public void hide(String path) {
        Path p = Paths.get(path);
        try {
            DosFileAttributes dos = Files.readAttributes(p, DosFileAttributes.class);
            Files.setAttribute(p, "dos:hidden", true);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void unhide(String path) {
        Path p = Paths.get(path);
        try {
            DosFileAttributes dos = Files.readAttributes(p, DosFileAttributes.class);
            Files.setAttribute(p, "dos:hidden", false);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /*
    * @Purpose: Validate to image size to certail thrashold value.
     */
    public String validateImageSize(String imagePath) {
        File image = new File(imagePath);
        long imageSizeInBytes = image.length();

        //If the image size is greater than maxSize than resize the original image to imgWidth x imgHeightpx
        if (imageSizeInBytes > maxSize) {
            return this.resizeImage(imagePath, Config.IMG_WIDTH, Config.IMG_HEIGHT);
        }
        return imagePath;
    }

    /*
    * @Purpose: Resize the image to specific width and height
    * @Parms: image String: image path to convert
    * @Parms: width int: width to convert
    * @Parms: height int: height to convert
    * @Return: String: path of converted image.
     */
    public String resizeImage(String image, int width, int height) {
        try {
            File originalFile = new File(image);
            String parentPath = originalFile.getParent();
            BufferedImage originalImage = ImageIO.read(originalFile);

            int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB
                    : originalImage.getType();

            int IMG_WIDTH = width;
            int IMG_CLAHEIGHT = height;

            BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_CLAHEIGHT,
                    type);

            File replacedFile = new File(parentPath + "\\" + "Resized_" + originalFile.getName());
            if (!replacedFile.exists()) {
                replacedFile.createNewFile();
            }
            ImageIO.write(resizedImage, "png", replacedFile);

            return replacedFile.getAbsolutePath();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        return null;
    }
}
