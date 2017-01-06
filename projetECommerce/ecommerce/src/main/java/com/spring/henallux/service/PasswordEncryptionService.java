package com.spring.henallux.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class PasswordEncryptionService 
{
	private static final String strKey ="encry185la34";
	public static String encryptPassword(String passwordToEncrypt) throws Exception
	{
		String encryptedPassword="";
		
		try 
		{
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted=cipher.doFinal(passwordToEncrypt.getBytes());
			encryptedPassword=new String(encrypted);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new Exception(e);
		}
		return encryptedPassword;
	}
	
	public static String decrypt(String encryptedPassword) throws Exception
	{
		String decryptedPassword="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
			byte[] decrypted=cipher.doFinal(encryptedPassword.getBytes());
			decryptedPassword=new String(decrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return decryptedPassword;
	}
}
