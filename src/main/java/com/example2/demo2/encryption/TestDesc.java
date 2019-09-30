package com.example2.demo2.encryption;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class TestDesc {
    Key key;

    public TestDesc(String s){

        getKey(s);//生成密钥
    }

    //根据参数生成key
    public void getKey(String key){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(new SecureRandom(key.getBytes()));
            this.key =keyGenerator.generateKey();
            keyGenerator = null;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /*
    文件file进行加密，并保存到destfile文件中
     */
    public void encrypt(String file, String destFile) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        // cipher.init(Cipher.ENCRYPT_MODE, getKey());
        cipher.init(Cipher.ENCRYPT_MODE, this.key);
        InputStream is = new FileInputStream(file);
        OutputStream out = new FileOutputStream(destFile);
        CipherInputStream cis = new CipherInputStream(is, cipher);
        byte[] buffer = new byte[1024];
        int r;
        while ((r = cis.read(buffer)) > 0) {
            out.write(buffer, 0, r);
        }
        cis.close();
        is.close();
        out.close();
    }

    /*
    对file文件进行解密并保存到destfile文件中
     */
    public void decrypt(String file,String destFile) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE,this.key);
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(destFile);
        CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream,cipher);
        byte[] buffer = new byte[1024];
        int r;
        while((r=inputStream.read(buffer))>0){
            cipherOutputStream.write(buffer,0,r);
        }
        cipherOutputStream.close();
        outputStream.close();
        inputStream.close();
    }

    public static void main(String[] args) throws Exception {

        TestDesc testDesc = new TestDesc("aaaa");
        testDesc.encrypt("F:/qqq.txt","F:/www.txt");

        testDesc.decrypt("F:/www.txt","F:/ww.txt");

    }
}
