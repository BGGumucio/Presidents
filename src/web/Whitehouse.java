package web;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
public class Whitehouse {
    private static final String filename = "WEB-INF/presidents.txt";
    private ServletContext servletContext;
    private List<President> presList = new ArrayList<>();
    
    public Whitehouse(ServletContext context) {
        servletContext = context;
        populateList();
    }
    
    private void populateList() {
        InputStream is = servletContext.getResourceAsStream(filename);
        try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = buf.readLine()) != null) {
                
                String[] tokens = line.split("@");
                int termnumber = Integer.parseInt(tokens[0].trim());
                
                String name = tokens[1].trim();
                String years = tokens[2].trim();
                String party = tokens[3].trim();
                String bio = tokens[4].trim();
                String link = tokens[5].trim();
                String imgpath = "./imgs/" + termnumber +".jpg"; 
                String presSubmit = "/Presidents/presServlet?presNum="+ termnumber + "&option=submit";
                
                presList.add(new President(termnumber, name, years, party, bio, link, imgpath, presSubmit));
//              for (President string : presList) {                 
//              System.out.println(string);
//              }
            }
        } catch (Exception e) {
            System.out.println("exception here");
            System.err.println(e);
        }
    }
// sorted President List Method
    public List getSorted(String x){
        List sorted = new ArrayList();
        for (President president : presList) {
            if (x.equals(president.getParty())){
                sorted.add(president);
            }
        }
        return sorted;
    }
// getPresidentmethod
    public President getPresident(int i) {
        President newPres = new President();
        for (President president : presList) {
            if (i == president.getTermnumber()) {
                newPres = president;
            }
        }
        return newPres;
    }
}