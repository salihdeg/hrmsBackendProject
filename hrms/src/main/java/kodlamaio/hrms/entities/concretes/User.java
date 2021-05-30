package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "email")
	@NotBlank(message = "Email Cannot Be Empty or Blank")
	@Email(message = "This Is Not An Email")
	private String email;
	
	@Column(name = "password")
	@NotBlank(message = "Password Cannot Be Empty or Blank")
	private String password;
	
	
}
