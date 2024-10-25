package edu.iuh.fit.gk_xe.controlers;

import edu.iuh.fit.gk_xe.daos.QuanlyLoaiXeDAO;
import edu.iuh.fit.gk_xe.daos.QuanlyXeDAO;
import edu.iuh.fit.gk_xe.models.Loaixe;
import edu.iuh.fit.gk_xe.models.Xe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "controlServlet", value = "/ControlServlet")
public class QuanlyXeServlet extends HttpServlet {

    private QuanlyLoaiXeDAO loaiXeDAO;
    private QuanlyXeDAO xeDAO;
    public void init() {
        loaiXeDAO = new QuanlyLoaiXeDAO();
        xeDAO = new QuanlyXeDAO();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        switch (action) {
            case "ListLoaiXe":
                List<Loaixe> loaiXes = (List<Loaixe>) loaiXeDAO.findAll();
                request.setAttribute("ListLoaiXe", loaiXes);
                request.getRequestDispatcher("DSLoaiXe.jsp").forward(request, response);
                break;
            case "ListXe":
                if (request.getParameter("maLoai") == null || request.getParameter("maLoai").isEmpty()) {
                    List<Xe> xes = (List<Xe>) xeDAO.findAll();
                    request.setAttribute("ListXe", xes);
                } else {
                    List<Xe> xes = (List<Xe>) xeDAO.findByMaLoai(request.getParameter("maLoai"));
                    request.setAttribute("ListXe", xes);
                }
                request.getRequestDispatcher("DSxe.jsp").forward(request, response);
                break;
            case "add":
                List<Loaixe> loaiXes1 = (List<Loaixe>) loaiXeDAO.findAll();
                request.setAttribute("loaiXeList", loaiXes1);
                request.getRequestDispatcher("ThemXe.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession();

        switch (action) {
            case "submit":
                String tenXe = req.getParameter("tenXe");
                Double gia = Double.parseDouble(req.getParameter("gia"));
                Integer namSX = Integer.parseInt(req.getParameter("namSX"));
                String maLoai = req.getParameter("loaiXe");
                Loaixe loaixe = loaiXeDAO.findById(maLoai).get();
                Xe xe = new Xe(UUID.randomUUID().toString(), tenXe, gia, namSX, loaixe);
                xeDAO.addXe(xe);
                resp.sendRedirect("ControlServlet?action=ListXe");
                break;
            default:
                break;
        }
    }

    public void destroy() {
    }
}
