package myhealthylife.telegram.bot.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chats_data")
public class ChatsData {
	
	@Id
    @Column(name="chatId")
    private long chatId;
	
	private String personId;
	
}
