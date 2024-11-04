package loginmodules;

import java.security.Principal;

public class Roles implements Principal {

	private String role;

	Roles(String role) {
		this.role = role;
	}

	@Override
	public String getName() {
		return this.role;
	}

}
