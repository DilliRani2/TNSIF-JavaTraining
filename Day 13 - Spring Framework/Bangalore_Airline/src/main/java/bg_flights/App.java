package bg_flights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    
    
    {
      ApplicationContext con = new ClassPathXmlApplicationContext("Bean.xml");
      
      Flight f = (Flight) con.getBean("welcome");
      
      System.out.println(f.getMessage());
      
      
      
      
    }
}
