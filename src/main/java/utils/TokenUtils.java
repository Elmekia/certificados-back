package utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.Token;
import model.Usuario;

public final class TokenUtils {

	private static final String SECRET = "12345678910";

	private TokenUtils() {

	}

	public static Token parseToken(String tokenStr) {
		try {
			if (tokenStr == null || tokenStr.isEmpty()) {
				return null;
			}
			Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(tokenStr).getBody();
			if (claims == null) {
				return null;
			}
			Token token = new Token();
			Usuario usuario = new Usuario();
			usuario.setId(claims.get("id").toString());
			usuario.setNombre(claims.get("nombre").toString());
			usuario.setApellido(claims.get("apellido").toString());
			usuario.setNivel(Integer.parseInt(claims.get("nivel").toString()));
			token.setUsuario(usuario);
			token.setToken(tokenStr);
			return token;
		} catch (Exception e) {
			return null;
		}
	}

	public static String generateToken(Usuario usuario) {
		Claims claims = Jwts.claims().setSubject(usuario.getId());
		claims.put("id", usuario.getId());
		claims.put("nombre", usuario.getNombre());
		claims.put("apellido", usuario.getApellido());
		claims.put("nivel", usuario.getNivel());
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, SECRET).compact();
	}
}
