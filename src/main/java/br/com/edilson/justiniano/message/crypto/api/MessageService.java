package br.com.edilson.justiniano.message.crypto.api;

import br.com.edilson.justiniano.message.crypto.model.Message;

public interface MessageService {

	void createMessage(Message message);

	Message getEncryptedMessage(Long id);

	Message getDecryptedMessage(Long id);
}
