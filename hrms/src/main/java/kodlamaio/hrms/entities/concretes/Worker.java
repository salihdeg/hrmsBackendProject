package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "workerEmailVerification" })
@Table(name = "workers")
public class Worker extends User {

	@Column(name = "first_name")
	@NotBlank(message = "First Name Cannot Be Empty or Blank")
	private String firstName;

	@Column(name = "last_name")
	@NotBlank(message = "Last Name Cannot Be Empty or Blank")
	private String lastName;

	@Column(name = "nationality_id")
	@Size(min = 11, max = 11, message = "Nationality Id Must Be Eleven Character.")
	@NotBlank(message = "Nationality Id Cannot Be Empty or Blank")
	private String nationalityId;

	@Column(name = "year_of_birth")
	@NotNull
	private int yearOfBirth;
	
	@OneToOne(mappedBy = "worker")
	private WorkerEmailVerification workerEmailVerification;
	
}
