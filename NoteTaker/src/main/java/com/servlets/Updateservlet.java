package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;   // ✅ Required
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;                 // ✅ Required
import org.hibernate.Transaction;             // ✅ Required

import com.entities.Note;                     // ✅ Required
import com.Helper.FactoryProvider;            // ✅ Required

@WebServlet("/UpdateServlet")
public class Updateservlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        Note note = session.get(Note.class, id);

        if (note != null) {
            note.setTitle(title);
            note.setContent(content);
            session.update(note);
        }

        tx.commit();
        session.close();

        response.sendRedirect("all_notes.jsp");
    }
}
