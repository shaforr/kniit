package lab1.task2;

public class SimpleUrl {
    private String protocol; 
    private String address;
    private String domainZone; 
    private String siteName; 
    private String webpageName; 
    private String webPageExtention; 
    private int page;
    private int intParam;
    private double doubleParam;
    private String textParameter;


    public void setProtocol(String protocol){
        this.protocol = protocol;
    }
    public void setAdress(String address){
        this.address = address;
    }
    public void setDomainZone(String domainZone){
        this.domainZone = domainZone;
    }
    public void setSiteName(String siteName){
        this.siteName = siteName;
    }
    public void setWebPageName(String webpageName){
        this.webpageName = webpageName;
    }
    public void setWebPageExtention(String webPageExtention){
            this.webPageExtention = webPageExtention;
    }
    public void setPage(int page){
            this.page = page;
    }
    public void setIntParam(int intParam){
            this.intParam = intParam;
    }
    public void setDoubleParam(double doubleParam){
            this.doubleParam = doubleParam;
    }
    public void setTextParameter(String textParameter){
            this.textParameter = textParameter;
    }


    public String getProtocol(){
        return protocol;
    }
    public String getAdress(){
        return address;
    }
    public String getDomainZone(){
        return domainZone;
    }
    public String getSiteName(){
        return siteName;
    }
    public String getWebPageName(){
        return webpageName;
    }
    public String getWebPageExtention(){
        return webPageExtention;
    }
    public int getPage(){
            return page;
    }
    public int getIntParam(){
            return intParam;
    }
    public double getDoubleParam(){
            return doubleParam;
    }
    public String getTextParameter(){
            return textParameter;
    }

    @Override
    public String toString()
    {
        
        return "protocol = " + protocol + "\n" + 
                "address = " + address +"\n" +
                "domainZone = " + domainZone + "\n" +
                "siteName = " + siteName + "\n" + 
                "page = " + page + "\n" +
                "webpageName = "+ webpageName + "\n" + 
                "webPageExtention = " + webPageExtention + "\n" +
                "intParam = " + intParam + "\n" +
                "doubleParam = " + doubleParam + "\n" +
                "textParameter = " + textParameter;
    
    }
}
