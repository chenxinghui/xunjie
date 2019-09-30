package com.example2.demo2.encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class SecreUtills {

    //算法
    private static final String Algorithm = "DESede";
    //密钥
    private static final String PASSWORD_CRYPT_KEY= "2012PinganVitality075522628888ForShenZhenBelter075561869839";

    /*
    根据字符串生成密钥字节数组
     */
    public static byte[] build3DesKey(String keyStr) throws UnsupportedEncodingException {
        //声明一个24字节的数组，默认里面都是0
        byte[] key = new byte[24];
        //将字符串转成字节数组
        byte[] temp = keyStr.getBytes("UTF-8");
        if (key.length>temp.length){
            System.arraycopy(temp,0,key,0,temp.length);
        }else {
            System.arraycopy(temp,0,key,0,key.length);
        }
        return key;
    }

    /*
    加密
     */
    public static byte[] encryptMode(byte[] src){
        try {
            //通过算法和密钥，生成SecretKey密钥对象
            SecretKey secretKey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY),Algorithm);
            //根据算法实例化Cipher，cipher负责加密和解密
            Cipher cipher = Cipher.getInstance(Algorithm);
            //传入加密或解密模式，以及密钥对象，实例化cipher对象
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            //传入字节数组，实现加密或解密，并返回一个byte数组
            return cipher.doFinal(src);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }
    /*
    解密
     */
    public static byte[] decryptMode(byte[] src){
        try {
            SecretKey secretKey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY),Algorithm);
            Cipher cipher = Cipher.getInstance(Algorithm);
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            cipher.doFinal(src);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) throws Exception {
        String msg = "3Des加密前";
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("11");
        list.add("1111");
        list.add("11111");
        list.add("111");
        System.out.println("jiamiqian : "+msg);

        byte[] bytes = SecreUtills.encryptMode(msg.getBytes());
        System.out.println("加密后："+new String(bytes));

    }
}
