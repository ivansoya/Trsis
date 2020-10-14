package com.soya.trsis.carselling.servlets;

import com.soya.trsis.carselling.model.NewModel;
import com.soya.trsis.carselling.model.NewModel.Data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manno
 */
@WebServlet(name = "servlet", urlPatterns = {"/servlet"})
public class servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        if (request.getParameter("View") != null) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
                             "transitional//en\">\n";
            String title = "List of cars";
            out.println(docType + "<html><head><title>" + title + "</title></head>\n" +
            "<body bgcolor = \"#f0f0f0\">\n<h1 align = \"center\">" + title 
            + "</h1>\n <ul>\n" + "  There are list of cars in this data base: <ul>\n");
            Integer i = 1;
            for (Data data : NewModel.base) {
                out.println("  " + i.toString() + ")" + data.getBrand() + " ");
                out.println("  " + data.getModel() + " ");
                out.println("  " + data.getCost() + " rub </br>");
                i++;
            }
            out.println("</ul></br><form action=\"servlet\" method=\"POST\">\n" +
               "<input type=\"submit\" value=\"Back\" name=\"Back\"/>\n" +
               "</form>");
            out.println("</body></html>");
        }
        else if (request.getParameter("Delete") != null) {
            String index = request.getParameter("index");
            try {
                int i = Integer.parseInt(index);
                i--;
                NewModel.base.remove(i);
                redirect(request, response);
            } catch (Exception e) {
                redirect(request, response);
            }
        }
        else if (request.getParameter("brand") != null ){
            String brand = request.getParameter("brand");
            String model = request.getParameter("model");
            String cost = request.getParameter("cost");
            String sub = request.getParameter("View");
            if (brand == "" || model == "" || cost == "")
                redirect(request, response);
            else {
                NewModel.add(brand, model, cost);
                redirect(request, response);
            }
        }
        else {
            redirect(request, response);
        }
    }

    protected void redirect(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String path = "/servlet.html";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}