package br.com.edilson.justiniano.message.crypto.bi;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.transaction.annotation.Transactional;

import br.com.edilson.justiniano.message.crypto.dao.MessageDao;
import br.com.edilson.justiniano.message.crypto.model.Message;

@Transactional
public class MessageBusiness {

	private static final String KEY = "AAAASSSSDDDDFFFF";

	private final MessageDao messageDao;
	private final SecretKey key;

	public MessageBusiness(MessageDao messageDao) {
		this.messageDao = messageDao;
		this.key = new SecretKeySpec(KEY.getBytes(), "AES");
	}

	public void saveMessage(Message message) {
		messageDao.save(message);
	}

	public Message retrieveMessage(Long id) {
		return messageDao.getById(id);
	}

	public void createMessage(Message message) {
		messageDao.save(message);
	}

	public void encryptMessage(Message message) {
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptedMessage = cipher.doFinal(message.getMessage().getBytes());
			message.setEncryptMessage(encryptedMessage);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
		        | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void decryptMessage(Message message) {
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);

			byte[] decryptedMessage = cipher.doFinal(message.getEncryptMessage());
			message.setMessage(new String(decryptedMessage));
			message.setEncryptMessage(null);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
		        | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
