package com.servlets;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.Helper.FactoryProvider;
import com.entities.Note;

@WebServlet("/SaveNoteServlet")  // This is the URL path for your form
public class SaveNoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String title = request.getParameter("noteTitle");
            String content = request.getParameter("noteContent");

            Note note = new Note(title, content, new Date());

            Session s = FactoryProvider.getFactory().openSession();
            Transaction tx = s.beginTransaction();
            s.save(note);
            tx.commit();
            s.close();

            // Set success message in session
            HttpSession session = request.getSession();
            session.setAttribute("message", "Note added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = request.getSession();
            session.setAttribute("message", "Something went wrong: " + e.getMessage());
        }

        // Redirect back to the add notes page
        response.sendRedirect("add_notes.jsp");
    }
}
