package org.example.qr;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Code to read a QR Code...
 */
public class ReadQRcode {
    public static String readQRcode(String path, String charset, Map map) throws FileNotFoundException, IOException, NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(path)))));
        Result rslt = new MultiFormatReader().decode(binaryBitmap);
        return rslt.getText();
    }

    public static void main(String args[]) throws WriterException, IOException, NotFoundException {
        String qrCodePath = "C:\\Users\\Admin\\IdeaProjects\\QRGeneratorAndReader\\Output\\Quote.png";
        //Encoding charset to be used
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        //generates QR code with Low level(L) error correction capability
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        System.out.println("Data stored in the QR Code is: \n" + readQRcode(qrCodePath, charset, hintMap));
    }
}  