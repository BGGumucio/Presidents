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
        //String incomingNumber = request.getParameter("presNum");//The number the user sends in as a String
//        String submit = request.getParameter("submit");
//        String next = request.getParameter("next");
//        String previous = request.getParameter("previous");
        String party = request.getParameter("party");
        //String option = request.getParameter("option");//This is the common name for submit, next, and previous
        HttpSession session = request.getSession();
        // Save the bean somewhere the JSP can find it
        if (session.getAttribute("presListSorted") == null) {
            // first time
            session.setAttribute("presListSorted", new ArrayList<President>());
        }
        presList = (List<President>)session.getAttribute("presListSorted");
        presList.clear();
        //Determine what the user wants done with the information
       
        //System.out.println(incomingNumber);
        President nextPres;
//      if(incomingNumber != null){
//        party = null;
//          switch(option){
//          case "submit":
//              if(incomingNumber.trim().equals("")){
//                  incomingNumber = "1";
//              }
//              boolean loop = true;
//              while(loop){
//                  try{
//                      presNum = Integer.parseInt(incomingNumber.trim());//The number president the user wants.
//                      loop = false;
//                  }catch(NumberFormatException e){
//                      System.out.println("Wrong input");
//                      java.util.Scanner scanner = new java.util.Scanner(System.in);
//                      scanner.next();
//                  }
//              }
//              if(presNum < 1){
//                  presNum = 1;
//              }else if (presNum > 44){
//                  presNum = 44;
//              }
//                  
//                  //presNum = presNum;
//              nextPres = house.getPresident(presNum);
//             
//  //            // Save the bean somewhere the JSP can find it
//  //            if (session.getAttribute("presList") == null) {
//  //                // first time
//  //                session.setAttribute("presList", new ArrayList<President>());
//  //            }
//  //            presList = (List<President>)session.getAttribute("presList");
//              presList.add(nextPres);
//  //            for (President president : presList) {
//  //              System.out.println(president);
//  //                  }
//              request.setAttribute("presNum", presList.get(presList.size() - 1));
//              request.getRequestDispatcher("/index.jsp").forward(request, response);
//              break;
//          case "next":
//              presNum += 1;
//              if(presNum  > 44){
//                  this.presNum = 44;
//              }
//              
//                  nextPres = house.getPresident(presNum);
//              
//  //            // Save the bean somewhere the JSP can find it
//  //            if (session.getAttribute("presList") == null) {
//  //                // first time
//  //                session.setAttribute("presList", new ArrayList<President>());
//  //            }
//  //            presList = (List<President>)session.getAttribute("presList");
//              
//              presList.add(nextPres);
//              request.setAttribute("presNum", presList.get(presList.size() - 1));
//              request.getRequestDispatcher("/index.jsp").forward(request, response);
//              break;
//          case "previous":
//              this.presNum -=1;
//              if(this.presNum < 1){
//                  presNum = 1;
//              }
//              nextPres = house.getPresident(presNum);
//              // Save the bean somewhere the JSP can find it
//  //            if (session.getAttribute("presList") == null) {
//  //                // first time
//  //                session.setAttribute("presList", new ArrayList<President>());
//  //            }
//             // presList = (List<President>)session.getAttribute("presList");
//              presList.add(nextPres);
//              request.setAttribute("presNum", presList.get(presList.size() - 1));
//              request.getRequestDispatcher("/index.jsp").forward(request, response);
//              break;
//  //        case "Democrat":
//  //            List<President> sortByParty = house.getSorted("Democrat");
//  //            if (session.getAttribute("preslist") != null){
//  //                presList.clear();
//  //            }
//  //            session.setAttribute("presList", sortByParty);
//  //             presList = (List<President>)session.getAttribute("presList");
//  //            request.getRequestDispatcher("/index.jsp").forward(request, response);
//  //            break;
//              
//          
//          }
//      }else if(party != null){ 
          //incomingNumber = null;
        
        switch(party){
        case "Democrat":
            sortByParty = house.getSorted("Democrat");
            if (session.getAttribute("preslistSorted") != null){
                presList.clear();
            }
            session.setAttribute("presList", sortByParty);
             presList = (List<President>)session.getAttribute("presListSorted");
            request.getRequestDispatcher("/index2.jsp").forward(request, response);
            break;
        case "Democratic-Republican":
             sortByParty = house.getSorted("Democratic-Republican");
             if (session.getAttribute("preslistSorted") != null){
                 presList.clear();
             }
             session.setAttribute("presList", sortByParty);
              presList = (List<President>)session.getAttribute("presListSorted");
             request.getRequestDispatcher("/index2.jsp").forward(request, response);
             break;
        case "Federalists":
               sortByParty = house.getSorted("Federalist");
              if (session.getAttribute("preslistSorted") != null){
                  presList.clear();
              }
              session.setAttribute("presList", sortByParty);
               presList = (List<President>)session.getAttribute("presListSorted");
              request.getRequestDispatcher("/index2.jsp").forward(request, response);
              break;
        case "Independent":
              sortByParty = house.getSorted("Independent");
              if (session.getAttribute("preslistSorted") != null){
                  presList.clear();
              }
              session.setAttribute("presList", sortByParty);
               presList = (List<President>)session.getAttribute("presListSorted");
              request.getRequestDispatcher("/index2.jsp").forward(request, response);
              break;
        case "Republican":
             sortByParty = house.getSorted("Republican");
             if (session.getAttribute("preslistSorted") != null){
                 presList.clear();
             }
             session.setAttribute("presList", sortByParty);
              presList = (List<President>)session.getAttribute("presListSorted");
             request.getRequestDispatcher("/index2.jsp").forward(request, response);
             break;
        case "Whig":
             sortByParty = house.getSorted("Whig");
             if (session.getAttribute("preslistSorted") != null){
                 presList.clear();
             }
             session.setAttribute("presList", sortByParty);
              presList = (List<President>)session.getAttribute("presListSorted");
             request.getRequestDispatcher("/index2.jsp").forward(request, response);
             break;
            
        }
      }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
