package com.example.sv_2016.beorder_visitor_v0;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;

public class ScanQRCodeActivity extends AppCompatActivity implements QRCodeReaderView.OnQRCodeReadListener {

    private TextView resultTextView;
    private QRCodeReaderView mydecoderview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qrcode);

        mydecoderview = (QRCodeReaderView) findViewById(R.id.qrdecoderview);
        mydecoderview.setOnQRCodeReadListener(ScanQRCodeActivity.this);

        // Use this function to enable/disable decoding
        mydecoderview.setQRDecodingEnabled(true);

        // Use this function to change the autofocus interval (default is 5 secs)
        mydecoderview.setAutofocusInterval(2000L);

        // Use this function to enable/disable Torch
        mydecoderview.setTorchEnabled(true);

        // Use this function to set front camera preview
        mydecoderview.setFrontCamera();

        // Use this function to set back camera preview
        mydecoderview.setBackCamera();
    }

    // Called when a QR is decoded
    // "text" : the text encoded in QR
    // "points" : points where QR control points are placed in View
    @Override
    public void onQRCodeRead(String text, PointF[] points) {
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mydecoderview.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mydecoderview.stopCamera();
    }
}