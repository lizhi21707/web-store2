package com.netease.assignment.web.filter;

import com.netease.assignment.meta.Chart;

import javax.servlet.*;
import java.io.IOException;

/**
 * Description:
 *
 * @author: Tank.Li
 * @date: 2019/3/16 00:26 Saturday
 */
public class ChartFiler implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Chart.setLocalChart(new Chart());
    }

    @Override
    public void destroy() {
        Chart.removeLocalChart();
    }
}
