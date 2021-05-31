package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "admin_verifications")
public class AdminVerification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "admin_verify")
	private boolean adminVerify = false;
	
	@OneToOne()
	@JoinColumn(name = "user_id")
	private Employer employer;
	
	public AdminVerification() {
		super();
		this.id = 0;
		this.adminVerify = false;
	}
}
