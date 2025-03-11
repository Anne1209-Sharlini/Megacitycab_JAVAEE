<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletResponse" %>
<%
    // Prevent browser caching by setting headers
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setHeader("Expires", "0"); // Proxies

    // Check session validity
    if (session == null || session.getAttribute("email") == null) {
        response.sendRedirect("login.jsp");  // Redirect to login if session is invalid
        return;
    }
%>

<h1>Welcome, <%= session.getAttribute("email") %></h1>
<a href="logout">Logout</a>
