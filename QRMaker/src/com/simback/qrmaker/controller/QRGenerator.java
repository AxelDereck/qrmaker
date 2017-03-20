package com.simback.qrmaker.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRGenerator {
	
	private static int WHITE = 0xFFFFFF;
	private static int BLACK = 0x000;
	
	private static int width = 256, height = 256;
	private static int background = WHITE;
	private static int foreground = BLACK;
	private static BarcodeFormat qr_format = BarcodeFormat.QR_CODE;
	private static QRCodeWriter qr_writer = new QRCodeWriter();
	private static BufferedImage qr_image = null;
		
	public static void main(String[] args) {
//		test();
/*	    int cWhite = 255 << 16 | 255 << 8 | 255;
	    System.out.println("Code Hex utiilisé pour le blanc : " + Integer.toHexString(cWhite));
	    System.out.println("Code Hex utiilisé pour le blanc : " + Integer.toHexString(WHITE));
*/
		generateQR("E:\\QRMaker\\KimAx.png", "KimAx");
	}
	
	public static int generateQR(String filePath, String text) {
		qr_image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		try {
			BitMatrix bitMatrix = qr_writer.encode(text, qr_format, width, height);
			for(int i = 0; i < width; i++)
				for(int j = 0; j < height; j++)
					qr_image.setRGB(i, j, bitMatrix.get(i,j) ? BLACK : WHITE);
			ImageIO.write(qr_image, "PNG", new File(filePath));
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	public static int getSize() {
		return height;
	}

	public static void setSize(int size) {
		QRGenerator.height = size;
		QRGenerator.width = size;
	}

	public static int getBackground() {
		return background;
	}

	public static void setBackground(int background) {
		QRGenerator.background = background;
	}

	public static int getForeground() {
		return foreground;
	}

	public static void setForeground(int foreground) {
		QRGenerator.foreground = foreground;
	}

	public static void test() {
		QRCodeWriter writer = new QRCodeWriter();
	    int width = 256, height = 256;
	    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // create an empty image
	    int white = 255 << 16 | 255 << 8 | 255;
	    int black = 0;
	    try {
	        BitMatrix bitMatrix = writer.encode("FLA&RO001", BarcodeFormat.QR_CODE, width, height);
	        for (int i = 0; i < width; i++) {
	            for (int j = 0; j < height; j++) {
	                image.setRGB(i, j, bitMatrix.get(i, j) ? black : white); // set pixel one by one
	            }
	        }
	 
	        try {
	            ImageIO.write(image, "jpg", new File("E:\\QRMaker\\FLA&RO001.jpg")); // save QR image to disk
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	 
	    } catch (WriterException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }

	}
}
