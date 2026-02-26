package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;   // ✅ IMPORTANT
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;                 // ✅ IMPORTANT
import org.hibernate.Transaction;             // ✅ IMPORTANT

import com.entities.Note;                     // ✅ IMPORTANT
import com.Helper.FactoryProvider;            // ✅ IMPORTANT

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int noteId = Integer.parseInt(request.getParameter("id"));

        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        Note note = session.get(Note.class, noteId);

        if(note != null) {   // safer
            session.delete(note);
        }

        tx.commit();
        session.close();

        response.sendRedirect("all_notes.jsp");
    }
}
