package web;
public class President {
    private int termnumber;
    private String name;
    private String years;
    private String party;
    private String bio;
    private String link;
    private String imgpath;
    public President() {
    }
    public President(int termnumber, String name, String years, String party, String bio, String link, String imgpath) {
        super();
        this.termnumber = termnumber;
        this.name = name;
        this.years = years;
        this.party = party;
        this.bio = bio;
        this.link = link;
        this.imgpath = imgpath;
    }
    public int getTermnumber() {
        return termnumber;
    }
    public String getName() {
        return name;
    }
    public String getYears() {
        return years;
    }
    public String getParty() {
        return party;
    }
    public String getBio() {
        return bio;
    }
    public String getLink() {
        return link;
    }
    public String getImgpath() {
        return imgpath;
    }
    public void setTermnumber(int termnumber) {
        this.termnumber = termnumber;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setYears(String years) {
        this.years = years;
    }
    public void setParty(String party) {
        this.party = party;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
    @Override
    public String toString() {
        return "President [termnumber=" + termnumber + ", name=" + name + ", years=" + years + ", party=" + party
                + ", bio=" + bio + ", link=" + link + ", imgpath=" + imgpath + "]";
    }
}