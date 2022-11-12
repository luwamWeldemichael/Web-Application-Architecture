# WAA Lab 6

### Summary

This application was built with spring-boot and enabled token-based authentication & authorization with Spring Security & JWT.

### The Refresh Token has a different value and expiration time than the Access Token, and we added multiple things to ensure maximum security:

* Add secret keys to application settings.
* Use different secret keys for an access token and refresh token to avoid using an access token as a refresh token.
* Store refresh tokens in the database so we can force all users to log out if we need or to revoke all active refresh tokens for specific users if someone gets access to the refresh token.
* If the user tries to refresh his access token using an expired refresh token, the app will remove that token from DB and tell the user to re-login.
* to refresh the access token no need to send the previous access token. The refresh token will be enough.

## Group Members:
- ### Alkhadher Alqiari
- ### Selam Mehari
- ### Luwam Weldemichael
- ### Henok Michael


