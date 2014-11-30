<%@ page import="org.springframework.security.core.AuthenticationException" %>
<%@ page import="org.springframework.security.web.WebAttributes" %>

<html>
<head>
  <title>Login to CAS failed!</title>
</head>

<body>
<h2>Login to CAS failed!</h2>

<font color="red">
  Your CAS credentials were rejected.<br/><br/>
  Reason:
  <%
    Exception error = ((AuthenticationException) session.getAttribute(AbstractAuthenticationProcessingFilter.AUTHENTICATION_EXCEPTION));
    if(error != null) {
  %>
  <%= error.getMessage() %>
  <%
    }
  %>
</font>

</body>
</html>