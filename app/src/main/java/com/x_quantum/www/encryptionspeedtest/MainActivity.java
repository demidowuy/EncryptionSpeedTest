package com.x_quantum.www.encryptionspeedtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainActivity extends AppCompatActivity {
    private static byte[] text = "testmepls".getBytes();
    KeyPairGenerator kpg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void performEncryption(View v) {
        switch (v.getId()) {
            case R.id.ec256:
                try {
                    long startTime = System.nanoTime();
                    kpg = KeyPairGenerator.getInstance("EC");
                    SecureRandom random = new SecureRandom();
                    kpg.initialize(256, random);
                    KeyPair kp = kpg.generateKeyPair();
                    Key ourPk = kp.getPublic();
                    Log.w("Key", String.valueOf(ourPk));
                    long endTime = System.nanoTime();
                    long duration = (endTime - startTime) / 1000000;
                    Log.w("Duration (ms)", String.valueOf(duration));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.rsa512:
                try {
                    long startTime = System.nanoTime();
                    KeyPairGenerator keyGen;
                    keyGen = KeyPairGenerator.getInstance("RSA");
                    SecureRandom random = new SecureRandom();
                    keyGen.initialize(512, random);

                    KeyPair keyPair = keyGen.genKeyPair();
                    RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
                    Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                    cipher.init(Cipher.ENCRYPT_MODE, publicKey);
                    cipher.doFinal(text);
                    long endTime = System.nanoTime();
                    long duration = (endTime - startTime) / 1000000;
                    Log.w("Key", String.valueOf(publicKey));
                    Log.w("Duration (ms)", String.valueOf(duration));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) {
                    e.printStackTrace();
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.rsa1024:
                try {
                    long startTime = System.nanoTime();
                    kpg = KeyPairGenerator.getInstance("RSA");
                    SecureRandom random = new SecureRandom();
                    kpg.initialize(1024, random);
                    KeyPair kp = kpg.genKeyPair();
                    Key publicKey = kp.getPublic();
                    Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                    cipher.init(Cipher.ENCRYPT_MODE, publicKey);
                    cipher.doFinal(text);
                    long endTime = System.nanoTime();
                    long duration = (endTime - startTime) / 1000000;
                    Log.w("Key", String.valueOf(publicKey));
                    Log.w("Duration (ms)", String.valueOf(duration));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) {
                    e.printStackTrace();
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.rsa2048:
                try {
                    long startTime = System.nanoTime();
                    kpg = KeyPairGenerator.getInstance("RSA");
                    SecureRandom random = new SecureRandom();
                    kpg.initialize(2048, random);
                    KeyPair kp = kpg.genKeyPair();
                    Key publicKey = kp.getPublic();
                    Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                    cipher.init(Cipher.ENCRYPT_MODE, publicKey);
                    cipher.doFinal(text);
                    long endTime = System.nanoTime();
                    long duration = (endTime - startTime) / 1000000;
                    Log.w("Key", String.valueOf(publicKey));
                    Log.w("Duration (ms)", String.valueOf(duration));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) {
                    e.printStackTrace();
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
