
package com.core.exception;

import com.core.data.result.ResultStatusCode;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.zip.DataFormatException;


/**
 * @author dechun.yuan
 */


/**
 * 全局异常捕获处理
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * http请求的方法不正确
     */

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public String httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        logger.error("http请求的方法不正确:【" + e.getMessage() + "】");
        return ExceptionUtil.resultOf(ResultStatusCode.RequestMethodNotAllowed);
    }


    /**
     * 请求参数不全
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public String missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
        logger.error("请求参数不全:【" + e.getMessage() + "】");
        return ExceptionUtil.resultOf(ResultStatusCode.MissingServletRequestParameter);
    }


    /**
     * 请求参数类型不正确
     */

    @ExceptionHandler(TypeMismatchException.class)
    @ResponseBody
    public String typeMismatchExceptionHandler(TypeMismatchException e) {
        logger.error("请求参数类型不正确:【" + e.getMessage() + "】");
        return ExceptionUtil.resultOf(ResultStatusCode.TypeMismatchException);
    }


    /**
     * 数据格式不正确
     */
    @ExceptionHandler(DataFormatException.class)
    @ResponseBody
    public String dataFormatExceptionHandler(DataFormatException e) {
        logger.error("数据格式不正确:【" + e.getMessage() + "】");
        return ExceptionUtil.resultOf(ResultStatusCode.DataFormatException);
    }


    /**
     * 非法输入
     */

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String illegalArgumentExceptionHandler(IllegalArgumentException e) {
        logger.error("非法输入:【" + e.getMessage() + "】");
        return ExceptionUtil.resultOf(ResultStatusCode.IllegalArgumentException);
    }

    /***
     * 算术异常类
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public String arithmeticExecption(ArithmeticException e) {
        logger.error("算术异常:【" + e.getMessage() + "】");
        return ExceptionUtil.resultOf(ResultStatusCode.ArithmeticException);
    }


    /***
     * 类型强制转换异常
     * @param e
     * @return
     */
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public String classCastException(ClassCastException e) {
        logger.error("类型强制转换异常:【" + e.getMessage() + "】");
        return ExceptionUtil.resultOf(ResultStatusCode.ClassCastException);
    }


    /***
     * 处理其他异常
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public String allExceptionHandler(Exception e) {
        logger.error("具体错误信息:【" + ExceptionUtil.getErrorMessage(e) + "】");//会记录出错的代码行等具体信息
        int count = 0; //只打印15行的错误堆栈
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            logger.error(stackTraceElement.toString());
            if (count++ > 13) break;
        }
        return ExceptionUtil.resultOf(ResultStatusCode.SystemException);
    }
}


