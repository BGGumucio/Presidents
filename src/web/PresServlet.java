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
@WebServlet("/presServlet")
public class PresServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<President> presList1;
    private  int presNum =0;
    
     
    //Kick off WhiteHouse to read the CSV and make an array of President objects for each line
    //ServletContext context = getServletContext();
    Whitehouse house;
    public void init(){
         house = new Whitehouse(getServletContext());
     }
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get data from the user
        String incomingNumber = request.getParameter("presNum");//The number the user sends in as a String

        String option = request.getParameter("option");//This is the common name for submit, next, and previous
        HttpSession session = request.getSession();
        // Save the bean somewhere the JSP can find it
        if (session.getAttribute("presList1") == null) {
            // first time
            session.setAttribute("presList1", new ArrayList<President>());
        }
        presList1 = (List<President>)session.getAttribute("presList1");
        //Determine what the user wants done with the information
       
//        System.out.println(incomingNumber);
        President nextPres;

            switch(option){
            case "submit":
                if(incomingNumber.trim().equals("")){
                    incomingNumber = "1";
                }
                boolean loop = true;
                while(loop){
                    try{
                        presNum = Integer.parseInt(incomingNumber.trim());//The number president the user wants.
                        loop = false;
                    }catch(NumberFormatException e){
                        System.out.println("Wrong input");
                        java.util.Scanner scanner = new java.util.Scanner(System.in);
                        scanner.next();
                    }
                }
                if(presNum < 1){
                    presNum = 1;
                }else if (presNum > 44){
                    presNum = 44;
                }
                    
                    //presNum = presNum;
                nextPres = house.getPresident(presNum);
 
                presList1.add(nextPres);

                request.setAttribute("presNum", presList1.get(presList1.size() - 1));
                presList1.clear();
                request.getRequestDispatcher("/index.jsp").forward(request, response);
               
                break;
            case "next":
                presNum += 1;
                if(presNum  > 44){
                    this.presNum = 44;
                }
                
                    nextPres = house.getPresident(presNum);

                
                presList1.add(nextPres);
                request.setAttribute("presNum", presList1.get(presList1.size() - 1));
                presList1.clear();
                request.getRequestDispatcher("/index.jsp").forward(request, response);
               
                break;
            case "previous":
                this.presNum -=1;
                if(this.presNum < 1){
                    presNum = 1;
                }
                nextPres = house.getPresident(presNum);

                presList1.add(nextPres);
                request.setAttribute("presNum", presList1.get(presList1.size() - 1));
                presList1.clear();
                request.getRequestDispatcher("/index.jsp").forward(request, response);
               
                break;
    
            
            }

      }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
}