package lab1.task2;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
    String url = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";
    Parse(url);
}
    public static void Parse(String url)
    {
        
        SimpleUrl myURL = new SimpleUrl();
        if (url.startsWith("https")){
            myURL.setProtocol("https");
            url = url.substring(8) ;
        }
        else if (url.startsWith("http"))
        {
            myURL.setProtocol("http");
            url = url.substring(7) ;
        }

        String[] urlArray = url.split("/");
        String address = urlArray[0]; 

        if (Pattern.matches("\\w+\\.{1}[a-z]+", address))
        {
            myURL.setAdress(address);
            myURL.setDomainZone(address.split("\\.")[1]);
            url = url.substring(address.length() + 1);
        } 
        
        String siteName = urlArray[1];
        if (Pattern.matches("\\w+", siteName))
        {
            myURL.setSiteName(siteName);
            url = url.substring(siteName.length() + 1);
        }

        String page = urlArray[2];
        if (Pattern.matches("\\d+", page))
        {
            myURL.setPage(Integer.parseInt(page));
            url = url.substring(page.length() + 1);
        }
        String webpageName = urlArray[3].split("\\?")[0];
        if (Pattern.matches("\\w+\\.{1}[a-z]+", webpageName))
        {
            myURL.setWebPageName(webpageName);
            myURL.setWebPageExtention(webpageName.split("\\.")[1]);
            url = url.substring(webpageName.length());
        }
    
        
        if (url.contains("?"))
        {
            url = url.substring(1);
            String[] params = url.split("\\&");
            for(String param : params)
            {
                String key[] = param.split("=");
                switch (key[0]) {
                    case "intParam":
                        myURL.setIntParam(Integer.parseInt(key[1])); 
                        break;
                    case "doubleParam":
                        myURL.setDoubleParam(Double.parseDouble(key[1])); 
                        break;
                    case "textParameter":
                        myURL.setTextParameter(key[1]); 
                        break;
                

                }
                
           
            }
        }


        System.out.println(myURL.toString());

    }

}

