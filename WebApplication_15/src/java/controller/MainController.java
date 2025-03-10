/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookDAO;
import dao.UserDAO;
import dto.BookDTO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.AuthUtils;

/**
 *
 * @author tungi
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private BookDAO bookDAO = new BookDAO();

    private static final String LOGIN_PAGE = "login.jsp";

    private String processLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = LOGIN_PAGE;
        // Login action
        String strUserID = request.getParameter("strUserID");
        String strPassword = request.getParameter("strPassword");
        if (AuthUtils.isValidLogin(strUserID, strPassword)) {
            url = "search.jsp";
            UserDTO user = AuthUtils.getUser(strUserID);
            request.getSession().setAttribute("user", user);

            // search
            processSearch(request, response);
        } else {
            request.setAttribute("message", "Incorrect UserID or Password");
            url = "login.jsp";
        }
        return url;
    }

    private String processLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = LOGIN_PAGE;
        url = "login.jsp";
        request.getSession().invalidate(); // Hủy phiên làm việc
        return url;
    }

    private String processSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchTerm = request.getParameter("searchTerm");
        if (searchTerm == null) {
            searchTerm = "";
        }
        List<BookDTO> books = bookDAO.searchByTitle2(searchTerm);
        request.setAttribute("books", books);
        request.setAttribute("searchTerm", searchTerm);
        return "search.jsp";
    }

    private String processDeleteBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = LOGIN_PAGE;
        if (AuthUtils.isAdmin(request.getSession())) {
            url = "search.jsp";
            String str_bookid = request.getParameter("id");
            bookDAO.updateQuantityToZero(str_bookid);
            // search
            processSearch(request, response);
        } else {
            response.getWriter().print("<h1>303 Error, ... </h1>");
        }
        return url;
    }
    
     private String processEditBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = LOGIN_PAGE;
        if (AuthUtils.isAdmin(request.getSession())) {
            url = "search.jsp";
            String str_bookid = request.getParameter("id");
            BookDTO book = bookDAO.readbyID(str_bookid);
            request.setAttribute("book", book);
            url ="bookForm.jsp";
            System.out.println("Chuyển trang bookForm.jsp");
        } else {
            response.getWriter().print("<h1>303 Error, ... </h1>");
        }
        return url;
    }

    private String processAddBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = LOGIN_PAGE;
        if (AuthUtils.isAdmin(request.getSession())) {
            try {
                String bookID = request.getParameter("txtBookID");
                String title = request.getParameter("txtTitle");
                String author = request.getParameter("txtAuthor");
                int publishYear = Integer.parseInt(request.getParameter("txtPublishYear"));
                double price = Double.parseDouble(request.getParameter("txtPrice"));
                int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
                String image = request.getParameter("txtImage");
                System.out.println(bookID);
                boolean checkError = false;
                if (bookID == null || bookID.trim().isEmpty()) {
                    request.setAttribute("txtBookID_error", "Book ID cannot be empty.");
                    bookID = "";
                    checkError = true;
                }
                if (title == null || title.trim().isEmpty()) {
                    request.setAttribute("txtTitle_error", "Title cannot be empty.");
                    title = "";
                    checkError = true;
                }
                if (quantity <= 0) {
                    request.setAttribute("txtQuantity_error", "Quantity > 0.");
                    checkError = true;
                }
                BookDTO book = new BookDTO(bookID, title, author, publishYear, price, quantity, image);

                if (!checkError) {
                    bookDAO.create(book);
                    url = "search.jsp";
                    processSearch(request, response);
                } else {
                    request.setAttribute("book", book);
                    url = "bookForm.jsp";
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } else {
            response.getWriter().print("<h1>303 Error, ... </h1>");
        }
        return url;
    }
    
     private String processUpdateBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = LOGIN_PAGE;
        if (AuthUtils.isAdmin(request.getSession())) {
            try {
                String bookID = request.getParameter("txtBookID");
                String title = request.getParameter("txtTitle");
                String author = request.getParameter("txtAuthor");
                int publishYear = Integer.parseInt(request.getParameter("txtPublishYear"));
                double price = Double.parseDouble(request.getParameter("txtPrice"));
                int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
                String image = request.getParameter("txtImage");
                System.out.println(bookID);
                boolean checkError = false;
                if (bookID == null || bookID.trim().isEmpty()) {
                    request.setAttribute("txtBookID_error", "Book ID cannot be empty.");
                    bookID = "";
                    checkError = true;
                }
                if (title == null || title.trim().isEmpty()) {
                    request.setAttribute("txtTitle_error", "Title cannot be empty.");
                    title = "";
                    checkError = true;
                }
                if (quantity <= 0) {
                    request.setAttribute("txtQuantity_error", "Quantity > 0.");
                    checkError = true;
                }
                BookDTO book = new BookDTO(bookID, title, author, publishYear, price, quantity, image);

                if (!checkError) {
                    bookDAO.update(book);
                    url = "search.jsp";
                    processSearch(request, response);
                } else {
                    request.setAttribute("book", book);
                    url = "bookForm.jsp";
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } else {
            response.getWriter().print("<h1>303 Error, ... </h1>");
        }
        return url;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        try {
            String action = request.getParameter("action");
            System.out.println(action);
            if (action == null) {
                url = LOGIN_PAGE;
            }
            if (action != null && action.equals("login")) {
                url = processLogin(request, response);
            } else if (action != null && action.equals("logout")) {
                url = processLogout(request, response);
            } else if (action != null && action.equals("search")) {
                url = processSearch(request, response);
            } else if (action != null && action.equals("delete")) {
                url = processDeleteBook(request, response);
            } else if (action != null && action.equals("add")) {
                url = processAddBook(request, response);
            } else if (action != null && action.equals("edit")) {
                url = processEditBook(request, response);
            } else if (action != null && action.equals("update")) {
                url = processUpdateBook(request, response);
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            if (!url.equals("MainController")) {
                rd.forward(request, response);
            }
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
