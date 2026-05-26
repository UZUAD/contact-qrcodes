package com.lsjglobal;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.HashMap;
import java.util.Map;

public class AhnJiYoonQrGenerator {
    public static void main(String[] args) {
        try {
            String qrUrl = SvgUtil.qrUrl("Ahn_ji_yoon.vcf");
            int size = 300;

            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.MARGIN, 1);

            BitMatrix matrix = new MultiFormatWriter()
                    .encode(qrUrl, BarcodeFormat.QR_CODE, size, size, hints);

            String svgFileName = "Ahn_ji_yoon_qr.svg";
            SvgUtil.writeSvg(matrix, svgFileName);
            System.out.println("✅ QR 생성 완료: qr/" + svgFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
