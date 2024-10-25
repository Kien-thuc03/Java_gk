package edu.iuh.fit.candidate_gk.controlers;

import edu.iuh.fit.candidate_gk.daos.CandidateDAO;
import edu.iuh.fit.candidate_gk.daos.ExperienceDAO;
import edu.iuh.fit.candidate_gk.enums.Roles;
import edu.iuh.fit.candidate_gk.models.Candidate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ControlServlet", value = "/control-servlet")
public class ControlServlet extends HttpServlet {
    private CandidateDAO candidateDAO;
    private ExperienceDAO experienceDAO;

    public void init() {
        candidateDAO = new CandidateDAO();
        experienceDAO = new ExperienceDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        switch (action){
            case "Cau4":
                List<Candidate> candidateList = (List<Candidate>) candidateDAO.findAll();
                request.setAttribute("candidateList", candidateList);
                request.getRequestDispatcher("candidate.jsp").forward(request, response);
                break;
            case "ViewCandidate":
                String maUV = request.getParameter("id");
                Candidate candidate = candidateDAO.findById(maUV).get();
                request.setAttribute("candidate", candidate);
                request.getRequestDispatcher("candidate_details.jsp").forward(request, response);
            case "Cau5":
                List<Roles> rolesList = List.of(Roles.values());
                request.setAttribute("rolesList", rolesList);
                request.getRequestDispatcher("report1.jsp").forward(request, response);
                break;
            case "Cau6":
                List<Candidate> candidateListGmail = (List<Candidate>) candidateDAO.findByEmail("@gmail.com");
                request.setAttribute("candidateListGmail", candidateListGmail);
                request.getRequestDispatcher("report2.jsp").forward(request, response);
                break;
            case "Views":
                String rolePr = request.getParameter("Roles");
                Roles role = Roles.valueOf(rolePr);
                List<Candidate> candidateRole = (List<Candidate>) candidateDAO.findByRole(role);
                request.setAttribute("candidateByRole", candidateRole);
                List<Roles> rolesListForView = List.of(Roles.values());
                request.setAttribute("rolesList", rolesListForView);
                request.getRequestDispatcher("report1.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

    public void destroy() {
    }
}
