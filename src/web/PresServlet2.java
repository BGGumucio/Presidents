package web;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class PresServlet2
 */
@WebServlet("/presServlet2")
public class PresServlet2 extends HttpServlet {
        private List<President> sortByParty;
        private static final long serialVersionUID = 1L;
        private List<President> presList;
        private  int presNum =0;
        
         
        //Kick off WhiteHouse to read the CSV and make an array of President objects for each line
        //ServletContext context = getServletContext();
        Whitehouse house;
        public void init(){
             house = new Whitehouse(getServletContext());
         }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //Get data from the user

        String party = request.getParameter("party");
        HttpSession session2 = request.getSession();
        // Save the bean somewhere the JSP can find it
        if (session2.getAttribute("presListSorted") == null) {
            // first time
            session2.setAttribute("presListSorted", new ArrayList<President>());
        }
        presList = (List<President>)session2.getAttribute("presListSorted");
  
        presList.clear();
 
        President nextPres;

        
        switch(party){
        case "Democrat":
            sortByParty = house.getSorted("Democrat");
            System.out.println(sortByParty);
            presList.clear();
//            if (session.getAttribute("presList") != null){
//                presList.clear();
//            }
            session2.setAttribute("presList", sortByParty);
             presList = (List<President>)session2.getAttribute("presListSorted");
            request.getRequestDispatcher("/index2.jsp").forward(request, response);
            break;
        case "Democratic-Republican":
        	presList.clear();
             sortByParty = house.getSorted("Democratic-Republican");
//             if (session2.getAttribute("preslistSorted") != null){
//                 presList.clear();
//             }
             session2.setAttribute("presList", sortByParty);
              presList = (List<President>)session2.getAttribute("presListSorted");
             request.getRequestDispatcher("/index2.jsp").forward(request, response);
             break;
        case "Federalists":
               sortByParty = house.getSorted("Federalist");
              if (session2.getAttribute("preslistSorted") != null){
                  presList.clear();
              }
              session2.setAttribute("presList", sortByParty);
               presList = (List<President>)session2.getAttribute("presListSorted");
              request.getRequestDispatcher("/index2.jsp").forward(request, response);
              break;
        case "Independent":
              sortByParty = house.getSorted("Independent");
              if (session2.getAttribute("preslistSorted") != null){
                  presList.clear();
              }
              session2.setAttribute("presList", sortByParty);
               presList = (List<President>)session2.getAttribute("presListSorted");
              request.getRequestDispatcher("/index2.jsp").forward(request, response);
              break;
        case "Republican":
             sortByParty = house.getSorted("Republican");
             if (session2.getAttribute("preslistSorted") != null){
                 presList.clear();
             }
             session2.setAttribute("presList", sortByParty);
              presList = (List<President>)session2.getAttribute("presListSorted");
             request.getRequestDispatcher("/index2.jsp").forward(request, response);
             break;
        case "Whig":
             sortByParty = house.getSorted("Whig");
             if (session2.getAttribute("preslistSorted") != null){
                 presList.clear();
             }
             session2.setAttribute("presList", sortByParty);
              presList = (List<President>)session2.getAttribute("presListSorted");
             request.getRequestDispatcher("/index2.jsp").forward(request, response);
             break;
            
        }
      }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
