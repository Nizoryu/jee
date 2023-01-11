package fr.formation.inti.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestAttributeListener
 *
 */
@WebListener
public class RequestAttributeListener implements ServletRequestListener, ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public RequestAttributeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	System.out.println("A request attribute is removed");
    	System.out.println("Name of this attribute " + srae.getName());
    	System.out.println("Value of this attribute " + srae.getValue());
    	System.out.println();
    	System.out.println();
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	System.out.println("A new request attribute is added");
    	System.out.println("Name of this attribute " + srae.getName());
    	System.out.println("Value of this attribute " + srae.getValue());
    	System.out.println();
    	System.out.println();
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	System.out.println("A request attribute is replaced");
    	System.out.println("Name of this attribute " + srae.getName());
    	System.out.println("Value of this attribute " + srae.getValue());
    	System.out.println();
    	System.out.println();
    }
	
}
