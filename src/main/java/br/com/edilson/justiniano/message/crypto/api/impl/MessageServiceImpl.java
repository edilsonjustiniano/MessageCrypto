package br.com.edilson.justiniano.message.crypto.api.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.edilson.justiniano.message.crypto.api.MessageService;
import br.com.edilson.justiniano.message.crypto.bi.MessageBusiness;
import br.com.edilson.justiniano.message.crypto.model.Message;

@Component
@Path("/message")
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageBusiness messageBusiness;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void createMessage(Message message) {
		if (StringUtils.isEmpty(message.getMessage())) {
			// TODO: throw a bad request exception
		}
		messageBusiness.encryptMessage(message);
		messageBusiness.saveMessage(message);
	}

	@GET
	@Path("/{id}/encrypt")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Message getEncryptedMessage(@PathParam("id") Long id) {
		if (StringUtils.isEmpty(id)) {
			// TODO: throw a bad request exception
		}
		Message message = messageBusiness.retrieveMessage(id);
		message.setMessage(new String(message.getEncryptMessage()));
		message.setEncryptMessage(null);

		return message;
	}

	@GET
	@Path("/{id}/decrypt")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Message getDecryptedMessage(@PathParam("id") Long id) {
		if (StringUtils.isEmpty(id)) {
			// TODO: throw a bad request exception
		}
		Message message = messageBusiness.retrieveMessage(id);
		if (message != null) {
			messageBusiness.decryptMessage(message);
		}
		return message;
	}

}
