import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 
 * @author amandabcampos
 *
 */


public class Task {
	
	private String teamMemberName;
	private String description;
	private Date dueDate; 
	private boolean completionStatus;
	
	public Task(String teamMemberName, String description, Date dueDate) {
		this.teamMemberName = teamMemberName;
		this.description = description;
		this.dueDate = dueDate;
		this.completionStatus = false;
	}

	public String getTeamMemberName() {
		return teamMemberName;
	}

	public void setTeamMemberName(String teamMemberName) {
		this.teamMemberName = teamMemberName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(boolean completionStatus) {
		this.completionStatus = completionStatus;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
		return 
				String.format("%15s  %15s  %15s  %30s\n", teamMemberName, ft.format(dueDate), completionStatus, description) +
				String.format("-------------------------------------------------------------------------------------");
	}
	
	
}
