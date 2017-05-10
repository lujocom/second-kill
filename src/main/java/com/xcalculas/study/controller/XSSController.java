package com.xcalculas.study.controller;

import com.google.common.collect.Maps;
import com.xcalculas.study.base.BaseController;
import com.xcalculas.study.model.Result;
import com.xcalculas.study.utils.CSRFTokenManager;
import com.xcalculas.study.utils.ResultUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <dl>
 * <dt>second-kill</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 成都微积分科技有限公司</dd>
 * <dd>CreateDate: 2017年04月24日</dd>
 * </dl>
 *
 * @author LuoHui
 */
@RestController
@RequestMapping("/xss")
public class XSSController extends BaseController {


    private String xssData ;

    @RequestMapping("/xss-page")
    public ModelAndView xssTest(HttpSession session) {
        Map<String, Object> result = Maps.newHashMap();
        result.put("csrf", CSRFTokenManager.getTokenForSession(session));
        return packagingMAV(result, "html/xss-test");
    }

    @RequestMapping(value = "/submit-data", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Result<Map<String, Object>> submitXssData(String html, String CSRFToken,HttpSession session) {
        Map<String, Object> result = Maps.newHashMap();
        logger.debug("csrf token : {}", CSRFToken);
        logger.debug("session save token :{}", CSRFTokenManager.getTokenForSession(session));
        result.put("testHtml", "这就是一个测试");
        logger.debug("before encode html: {}", html);
        xssData = htmlEncode(html);
        logger.debug("after encode html: {}", xssData);
        return ResultUtil.success(result);
    }

    private String htmlEncode(String html){
        return html.replaceAll("&","&gt;")
                .replaceAll("<","&lt;")
                .replaceAll(">","&gt;")
                .replaceAll("\\s","&nbsp;")
                .replaceAll("'","&#39")
                .replaceAll("\"","&quot;")
                .replaceAll("\n","<br>");
    }

    @RequestMapping(value = "/get-data", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Result<Map<String, Object>> getXssData() {
        Map<String, Object> result = Maps.newHashMap();
        result.put("testHtml", xssData);
        return ResultUtil.success(result);
    }




}
