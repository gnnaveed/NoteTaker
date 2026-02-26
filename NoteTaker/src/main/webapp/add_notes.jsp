<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Add Notes</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
      integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet"/>
</head>
<body>
<div class="container mt-3">
    <%@ include file="/navbar.jsp" %>

    <!-- Success message from servlet -->
    <%
    String msg = (String) session.getAttribute("msg");
    if(msg != null) {
    %>
        <div class="alert alert-success"><%= msg %></div>
    <%
        session.removeAttribute("msg");
    }
    %>

    <h1>Please Fill Your Details</h1>
    <form action="SaveNoteServlet" method="post">
    

        <!-- Note Title -->
        <div class="form-group">
            <label for="noteTitle">Note Title</label>
            <input type="text" class="form-control" id="noteTitle" name="noteTitle" 
                   placeholder="Enter note title here" required>
            <small class="form-text text-muted">
                Give a short title to your note.
            </small>
        </div>

        <!-- Note Content -->
        <div class="form-group">
            <label for="noteContent">Note Content</label>
            <textarea class="form-control" id="noteContent" name="noteContent" rows="5" 
                      placeholder="Write your note here..." required></textarea>
            <small class="form-text text-muted">
                You can write anything here. Your notes are saved only for you.
            </small>
        </div>

        <!-- Submit Button -->
        <div class="text-center mt-3">
            <button type="submit" class="btn btn-primary">Add</button>
        </div>

    </form>
</div>
</body>
</html>
