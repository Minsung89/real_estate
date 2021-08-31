package com.virtual.real_estate.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.virtual.real_estate.entity.MyUserDetail;

public class SecurityUtil {
	/*
	 * 운영IP 입력 
	 * 미사용 -> JHK 2021/04/10 (서버내 설정값으로 구분)
	 * 
	 */
	private static String[] ipList = { "",	"" , ""};
	public static MyUserDetail getCustomUser() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null && !auth.getPrincipal().equals("anonymousUser")){
			System.out.println((MyUserDetail) auth.getPrincipal());
			return (MyUserDetail) auth.getPrincipal();
		} else {
			System.out.println("널?");
			return null;
		}
	}
	
	public static boolean validCustomUser() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null && !auth.getPrincipal().equals("anonymousUser")){
			return true;
		} else {
			return false;
		}
	}
	
	public static String getUserId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null && !auth.getPrincipal().equals("anonymousUser")){
			return ((MyUserDetail)auth.getPrincipal()).getUsername();
		} else {
			return null;
		}
	}

	public static boolean chkDev() throws Exception	{
		
		InetAddress local;
		String ip = "";
		try { 
			local = InetAddress.getLocalHost(); 
			ip = local.getHostAddress(); 
		} catch (UnknownHostException e1) {
			throw new Exception(e1);
		}
		
		if (Arrays.asList(ipList).contains(ip))	{
			return false;
		}	else	{
			return true;
		}
	}
	
	public  static String decode(String encryptedData, String stringPrivateKey) {
        String decryptedData = null;
        try {
            //평문으로 전달받은 개인키를 개인키객체로 만드는 과정
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] bytePrivateKey = Base64.getDecoder().decode(stringPrivateKey.getBytes());
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bytePrivateKey);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

            //만들어진 개인키객체를 기반으로 암호화모드로 설정하는 과정
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            //암호문을 평문화하는 과정
            byte[] byteEncryptedData = Base64.getDecoder().decode(encryptedData.getBytes());
            byte[] byteDecryptedData = cipher.doFinal(byteEncryptedData);
            decryptedData = new String(byteDecryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedData;
    }
	public static String encode(String plainData, String stringPublicKey) {
        String encryptedData = null;
        try {
            //평문으로 전달받은 공개키를 공개키객체로 만드는 과정
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] bytePublicKey = Base64.getDecoder().decode(stringPublicKey.getBytes());
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(bytePublicKey);
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

            //만들어진 공개키객체를 기반으로 암호화모드로 설정하는 과정
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            //평문을 암호화하는 과정
            byte[] byteEncryptedData = cipher.doFinal(plainData.getBytes());
            encryptedData = Base64.getEncoder().encodeToString(byteEncryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedData;
    }
	
}
