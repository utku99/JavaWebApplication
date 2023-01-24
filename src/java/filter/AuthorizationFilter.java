package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthorizationFilter implements Filter {
   

	public AuthorizationFilter() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {

			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
                        
                        String reqURI = reqt.getRequestURI();
                        
			HttpSession ses = reqt.getSession(false);
			
                        
                        if(reqURI.endsWith("WebApplication1/"))
                            resp.sendRedirect(reqt.getContextPath() + "/faces/home.xhtml");
                        
                        else if (reqURI.indexOf("/signIn.xhtml") >= 0
					|| (ses != null && ses.getAttribute("username") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("home.xhtml")
                                        || reqURI.contains("about.xhtml")
                                        || reqURI.contains("signUp.xhtml"))
                        chain.doFilter(request, response);
                        
                        else
                            resp.sendRedirect(reqt.getContextPath() + "/faces/signIn.xhtml");
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

        
        @Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
        
	@Override
	public void destroy() {

	}

  

   
        
}