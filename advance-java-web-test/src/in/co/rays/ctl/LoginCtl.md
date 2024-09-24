```markdown
# LoginCtl Flow:

1. Request `LoginCtl` ki `doPost` method par gai.

2. Kyunki `LoginView.jsp` par form tag ke `action` me `LoginCtl` ka path diya aur `method="post"` likha, isliye request `LoginCtl` ki `doPost` method par jaayegi.

3. `LoginCtl` ki `doPost` method me request se `loginId` aur `password` ko get kiya.

4. `UserModel` ka ek object banaya.

5. Model ki `authenticate(loginId, password)` method ko call kiya, jo return me `UserBean` ka object `bean` deta hai.

6. Check kiya agar `bean != null` ho to, user ko welcome page par bheja aur request me ek success message set kiya. Agar authentication fail ho to, `LoginView.jsp` par error message ke sath `RequestDispatcher` ka use karke forward kiya.

7. `LoginView.jsp` par scriptlet tag ka use karke request se message ko get kiya.

8. Expression tag ka use karke message ko print kiya.
```
