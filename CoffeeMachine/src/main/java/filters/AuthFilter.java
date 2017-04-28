package filters;


import by.training.nc.dev3.beans.User;
import com.sun.net.httpserver.HttpExchange;
import org.apache.commons.lang.StringUtils;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Win on 25.04.2017.
 */
public class AuthFilter implements Filter {
    private List<String> pathFilters = Arrays.asList();



    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String url = ((HttpServletRequest)servletRequest).getRequestURI();
        String path=StringUtils.substringAfterLast(url, "/");
        if (!pathFilters.contains(path)) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        HttpSession httpSession=((HttpServletRequest) servletResponse).getSession();
        User user = (User)httpSession.getAttribute("user");
        if (user != null) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        ((HttpServletResponse)servletResponse).sendRedirect("index.jsp");
    }

    public void destroy() {

    }
}
