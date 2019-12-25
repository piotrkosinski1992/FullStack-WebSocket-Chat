package chat.app.auth.jwt;

class JwtProperties {

  static final int EXPIRATION_TIME = 864_000_000; // 10 days
  static final String TOKEN_PREFIX = "Bearer ";
  static final String TOKEN_HEADER = "Authorization";
  static final String TOKEN_TYPE = "JWT";
  static final String TOKEN_ISSUER = "secure-api";
  static final String TOKEN_AUDIENCE = "secure-app";
  static final String JWT_SECRET = "n2r5u8x/A%D*G-KaPdSgVkYp3s6v9y$B&E(H+MbQeThWmZq4t7w!z%C*F-J@NcRf";
}
