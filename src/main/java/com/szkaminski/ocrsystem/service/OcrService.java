package com.szkaminski.ocrsystem.service;

import com.szkaminski.ocrsystem.gui.ApiLanguage;
import net.sourceforge.tess4j.*;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@Service
public class OcrService {

    public static String doOCR(String url) throws IOException {
        try {
            URL imageFile = new URL(url);
            BufferedImage bufferedImage = ImageIO.read(imageFile);

            ITesseract instance = new Tesseract();
            instance.setDatapath("\\resources\\traineddata");
            instance.setLanguage(ApiLanguage.setChoosenLangugae());
            return instance.doOCR(bufferedImage);

        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }
}