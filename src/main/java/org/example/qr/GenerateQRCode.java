package org.example.qr;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Code to generate a QR Code...
 */
public class GenerateQRCode {
    public static void generateQRcode(String qrCodeContent, String qrCodePath, String charset, Map map, int qrCodeHeight, int qrCodeWidth) throws WriterException, IOException {
        //the BitMatrix class represents the 2D matrix of bits
        //MultiFormatWriter is a factory class that finds the appropriate Writer subclass
        //for the BarcodeFormat requested and encodes the barcode with the supplied contents.
        BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeContent.getBytes(charset), charset), BarcodeFormat.QR_CODE, qrCodeWidth, qrCodeHeight);
        MatrixToImageWriter.writeToFile(matrix, qrCodePath.substring(qrCodePath.lastIndexOf('.') + 1), new File(qrCodePath));
    }

    public static void main(String[] args) throws WriterException, IOException, NotFoundException {
        String qrCodeContent = "MY NAME IS KVS";
        String qrCodePath = "C:\\Users\\Admin\\IdeaProjects\\QRGeneratorAndReader\\Output\\Quote.png";
        //Encoding charset to be used
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        //generates QR code with Low level(L) error correction capability
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        //invoking the user-defined method that creates the QR code
        generateQRcode(qrCodeContent, qrCodePath, charset, hashMap, 200, 200);//increase or decrease height and width accodingly
        //prints if the QR code is generated
        System.out.println("QR Code created successfully.");
    }
}  