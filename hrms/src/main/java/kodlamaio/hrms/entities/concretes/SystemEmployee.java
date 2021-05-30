package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@Table(name = "system_employees")
public class SystemEmployee extends User {

	@Column(name = "first_name")
	@NotBlank(message = "First Name Cannot Be Empty or Blank")
	private String firstName;

	@Column(name = "last_name")
	@NotBlank(message = "Last Name Cannot Be Empty or Blank")
	private String lastName;

}
