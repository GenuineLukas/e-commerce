package org.delivery.api.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * LoggerFilter is a servlet filter that logs HTTP request and response details.
 * It uses ContentCachingRequestWrapper and ContentCachingResponseWrapper to capture the body of the requests and responses.
 */
@Slf4j
@Component
public class LoggerFilter implements Filter {

    /**
     * The doFilter method is overridden to provide custom logging functionality.
     * It wraps the request and response objects with ContentCaching wrappers to capture their content.
     *
     * @param servletRequest  The request object.
     * @param servletResponse The response object.
     * @param filterChain     The filter chain object.
     * @throws IOException      If an I/O error occurs.
     * @throws ServletException If a servlet error occurs.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // Wrap the request and response objects with ContentCaching wrappers to capture their content.
        var req = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
        var res = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);

        log.info("INIT URI : {}", req.getRequestURI());

        // Continue the filter chain by passing the wrapped request and response objects.
        filterChain.doFilter(req, res);

        // Log request headers.
        var headerNames = req.getHeaderNames();
        var headerValues = new StringBuilder();

        // Iterate over header names to collect all header key-value pairs.
        headerNames.asIterator().forEachRemaining(headerKey -> {
            var headerValue = req.getHeader(headerKey);
            // Append header key and value to the headerValues string for logging purposes.
            headerValues.append("[")
                    .append(headerKey)
                    .append(": ")
                    .append(headerValue)
                    .append("] ");
        });

        // Log request body. Convert byte array to string to log the request payload.
        var requestBody = new String(req.getContentAsByteArray());
        var uri = req.getRequestURI();
        var method = req.getMethod();

        // Log the request headers and body.
        log.info(">>>>> uri : {} , method : {} , header : {} , body : {}", uri, method, headerValues, requestBody);

        // Log response headers.
        var responseHeaderValues = new StringBuilder();

        // Iterate over response header names to collect all header key-value pairs.
        res.getHeaderNames().forEach(headerKey -> {
            var headerValue = res.getHeader(headerKey);
            // Append header key and value to the responseHeaderValues string for logging purposes.
            responseHeaderValues.append("[")
                    .append(headerKey)
                    .append(": ")
                    .append(headerValue)
                    .append("] ");
        });

        // Log response body. Convert byte array to string to log the response payload.
        var responseBody = new String(res.getContentAsByteArray());

        // Log the response headers and body.
        log.info("<<<<< uri : {} , method : {} , header : {} , body : {}", uri, method, responseHeaderValues, responseBody);

        // After logging the response, write the cached content back to the response.
        // This is necessary because the response body is cached and needs to be written back for the client to receive it.
        res.copyBodyToResponse();
    }
}
