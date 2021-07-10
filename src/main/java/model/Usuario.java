package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
public class Usuario {
	
	private String id;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String password;
	private Integer nivel;
	private LocalDate fechaBloqueo;
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Usuario) {
			return ((Usuario) o).getId().equals(this.id);
		}
		return false;
	}
	
	@Override
    public int hashCode()
    {
		return this.id.hashCode();
    }
	
	
	
}
