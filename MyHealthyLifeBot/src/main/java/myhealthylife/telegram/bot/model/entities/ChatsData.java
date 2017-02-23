package myhealthylife.telegram.bot.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name="id")
	private long id;
	
    private String chatId;
	
	private Integer personId;
	
	public static List<ChatsData> getAll(){
		EntityManager em=ChatsDataDao.instance.createEntityManager();
		List<ChatsData> list=em.createNamedQuery("ChatsData.findAll",ChatsData.class).getResultList();
		ChatsDataDao.instance.closeConnections(em);
		return list;
	}
	
	public static ChatsData save(ChatsData chatsData){
		EntityManager em = ChatsDataDao.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        chatsData=em.merge(chatsData);
        tx.commit();
        ChatsDataDao.instance.closeConnections(em);
        return chatsData;
	}

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	public  Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
