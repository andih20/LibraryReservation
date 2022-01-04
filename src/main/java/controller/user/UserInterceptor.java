package controller.user;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        String url = request.getRequestURI();
        //拦截不登录直接到main界面到请求
        if(url.contains("/toMain") || url.contains("/Main")){
            HttpSession session = request.getSession();
            Object obj = session.getAttribute("user");
            if(obj!=null){
//                request.getRequestDispatcher("/toMain").forward(request,response);
                return true;
            }
            else{
                request.getRequestDispatcher("/toLogin").forward(request,response);
                return false;
            }
        }
        return true;
    }
    @Override
    public  void postHandle(HttpServletRequest request, HttpServletResponse response,
                            Object handler, ModelAndView modelAndView)throws Exception{

    }
    @Override
    public  void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                             Object handler, Exception ex)throws Exception{

    }
}
