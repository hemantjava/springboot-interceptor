package com.example.demoapi.interceptor;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
public class DemoInterceptor extends HandlerInterceptorAdapter {

    private final boolean isEnable;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //Methods level authentication
      /*  String theMethod = request.getMethod();

        if (HttpMethod.GET.matches(theMethod) || HttpMethod.POST.matches(theMethod))
            // GET, POST methods are allowed
            return true;
            // everything else is not allowed
            response.sendError(HttpStatus.METHOD_NOT_ALLOWED.value());
            return false;*/
        if (!isEnable) {
            response.sendError(HttpStatus.METHOD_NOT_ALLOWED.value());
        }
        return isEnable;

    }
}

