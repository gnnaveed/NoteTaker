<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.hibernate.Session" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entities.Note" %>
<%@ page import="com.Helper.FactoryProvider" %>
<%@ page import="org.hibernate.query.Query" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Notes</title>
<link href="css/style.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<%@include file="navbar.jsp"%>
<br>
<h1 class="text-uppercase">All Notes:</h1>

<%
    Session s = FactoryProvider.getFactory().openSession();
    List<Note> list = s.createQuery("from Note", Note.class).list();
    s.close();
%>

<table class="table table-bordered">
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Content</th>
            <th>Added Date</th>
        </tr>
    </thead>
    <tbody>
    <% for(Note note : list) { %>
        <tr>
            <td><%= note.getId() %></td>
            <td><%= note.getTitle() %></td>
            <td><%= note.getContent() %></td>
            <td><%= note.getAddedDate() %></td>
        </tr>
    <% } %>
    </tbody>
</table>
</div>
</body>
</html>
