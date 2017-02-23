package myhealthylife.telegram.bot.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import myhealthylife.telegram.bot.model.dao.ChatsDataDao;

@Entity
@Table(name="chats_data")
@NamedQuery(name="ChatsData.findAll", query="SELECT c FROM ChatsData c")
public class ChatsData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="chatId")
    private long chatId;
	
	private String personId;
	
	public static List<ChatsData> getAll(){
		EntityManager em=ChatsDataDao.instance.createEntityManager();
		List<ChatsData> list=em.createNamedQuery("ChatsData.findAll").getResultList();
		ChatsDataDao.instance.closeConnections(em);
		return list;
	}

	public long getChatId() {
		return chatId;
	}

	public void setChatId(long chatId) {
		this.chatId = chatId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
}
