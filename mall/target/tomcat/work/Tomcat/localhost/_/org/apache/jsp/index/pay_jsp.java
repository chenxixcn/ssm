/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2023-03-18 06:55:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.index;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pay_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/tld/c.tld", Long.valueOf(1153356282000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>支付</title>\n");
      out.write("\t<meta charset=\"UTF-8\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/public.css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/common.css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/reclassify.css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/address.css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/pay.css\">\n");
      out.write("</head>\n");
      out.write("<body style=\"background: #fff;\">\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header-login.jsp", out, false);
      out.write("\n");
      out.write("\t<div id=\"main\">\n");
      out.write("\t\t\n");
      out.write("\t\t<div id=\"goodslist\">\n");
      out.write("\t\t    <div class=\"tit\" style=\"height: 50px;padding-bottom: 10px;\">商品清单</div>\n");
      out.write("\t\t    <div class=\"list-tit\">\n");
      out.write("\t\t        <ul>\n");
      out.write("\t\t            <li class=\"li1\">商城发货订单</li>\n");
      out.write("\t\t            <li class=\"li3\">单价</li>\n");
      out.write("\t\t            <li class=\"li4\">数量</li>\n");
      out.write("\t\t            <li class=\"li5\">小计</li>\n");
      out.write("\t\t        </ul>\n");
      out.write("\t\t    </div>\n");
      out.write("    \t\t<div class=\"list-cont\">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t        <p class=\"zprice\" style=\"text-align: right;\">应付总金额：\n");
      out.write("\t        \t<span>￥<span id=\"shifu\" style=\"font-size: 32px;font-weight: bold;color: #FF712B;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${orders.total}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span></span>\n");
      out.write("\t        </p>\n");
      out.write("\t\t</div>\n");
      out.write("\t\n");
      out.write("\t\t<div id=\"collect\">\n");
      out.write("\t\t    <div class=\"collect-tit\"><span class=\"tit\">收货信息</span></div>\n");
      out.write("\t\t    <div class=\"collect-cont new-address\" style=\"padding: 0px 0px;\">\n");
      out.write("\t\t\t\t<form action=\"orderPay\" method=\"post\" id=\"form\">\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${orders.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"paytype\">\n");
      out.write("\t\t\t        <div class=\"box clearfix\">\n");
      out.write("\t\t\t\t\t\t<div class=\"left\">\n");
      out.write("\t\t\t\t\t\t\t<span>姓名&nbsp;：&nbsp;</span>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"right\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"name\" name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userInfo.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" placeholder=\"请输入收货人姓名\">\n");
      out.write("\t\t\t\t\t\t<span class=\"Validform_checktip\"></span></div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"box clearfix\">\n");
      out.write("\t\t\t\t\t\t<div class=\"left\">\n");
      out.write("\t\t\t\t\t\t\t<span>电话&nbsp;：&nbsp;</span>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"right\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"phone\" name=\"phone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userInfo.phone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" placeholder=\"请输入收货人电话\">\n");
      out.write("\t\t\t\t\t\t<span class=\"Validform_checktip\"></span></div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"box clearfix\">\n");
      out.write("\t\t\t\t\t\t<div class=\"left\">\n");
      out.write("\t\t\t\t\t\t\t<span>地址&nbsp;：&nbsp;</span>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"right\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"address\" name=\"address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userInfo.address}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" placeholder=\"请输入收货地址\">\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t    </div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\n");
      out.write("\t\t<div class=\"close-foot clearfix\">\n");
      out.write("\t        <div id=\"payway\">\n");
      out.write("\t            <div class=\"payway-tit\">支付方式</div>\n");
      out.write("\t            <div class=\"payway-cont\">\n");
      out.write("\t                <div class=\"way active\" data=\"1\">\n");
      out.write("\t                    <i class=\"iconfont icon-weixin\"></i>微信\n");
      out.write("\t                    <span class=\"iconfont icon-xuanzhong3\"></span>\n");
      out.write("\t                </div>\n");
      out.write("\t                <div class=\"way\" data=\"2\">\n");
      out.write("\t                    <i class=\"iconfont icon-zhifubao\"></i>支付宝\n");
      out.write("\t                    <span class=\"iconfont icon-xuanzhong3\"></span>\n");
      out.write("\t                </div>\n");
      out.write("\t                <!-- \n");
      out.write("\t                <div class=\"way\" data-id=\"3\">\n");
      out.write("\t                    <i class=\"iconfont icon-wallet\"></i>余额支付\n");
      out.write("\t                    <span class=\"iconfont icon-xuanzhong3\"></span>\n");
      out.write("\t                </div> -->\n");
      out.write("\t            </div>\n");
      out.write("\t        </div>\n");
      out.write("\t        <p class=\"submit\" id=\"tijiao\">立即支付</p>\n");
      out.write("\t    </div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("<script src=\"js/jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("// 选择支付方式\n");
      out.write("$(\"#payway .payway-cont .way\").on(\"click\", function () {\n");
      out.write("    $(this).addClass(\"active\").siblings().removeClass(\"active\")\n");
      out.write("});\n");
      out.write("// 提交支付\n");
      out.write("$(\"#tijiao\").on(\"click\", function(){\n");
      out.write("\tvar paytype = $(\".payway-cont .active\").attr(\"data\");\n");
      out.write("\t$(\"input[name=paytype]\").val(paytype);\n");
      out.write("\tif($(\"#name\").val()==\"\"){\n");
      out.write("\t\tlayer.msg(\"请正确填写收货人姓名\");\n");
      out.write("\t\treturn false;\n");
      out.write("\t}\n");
      out.write("\tif($(\"#phone\").val()==\"\"){\n");
      out.write("\t\tlayer.msg(\"请正确填写收货人电话\");\n");
      out.write("\t\treturn false;\n");
      out.write("\t}\n");
      out.write("\tif($(\"#address\").val()==\"\"){\n");
      out.write("\t\tlayer.msg(\"请正确填写收货人地址\");\n");
      out.write("\t\treturn false;\n");
      out.write("\t}\n");
      out.write("\t$(\"#form\").submit();\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /index/pay.jsp(29,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/index/pay.jsp(29,4) '${orders.items}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${orders.items}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /index/pay.jsp(29,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("items");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<ul>\n");
          out.write("\t                    <li class=\"li1\">\n");
          out.write("\t                        <dl>\n");
          out.write("\t                            <a href=\"detail?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.goods.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\n");
          out.write("\t                            \t<dt><img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.goods.cover}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"></dt>\n");
          out.write("\t                                <dd class=\"goodsname\" style=\"padding-top: 36px;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.goods.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</dd>\n");
          out.write("\t                                <dd class=\"goods-des\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.goods.intro}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</dd>\n");
          out.write("\t                            </a>\n");
          out.write("\t                        </dl>\n");
          out.write("\t                    </li>\n");
          out.write("\t                    <li class=\"li3\">￥<span>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.goods.price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</span></li>\n");
          out.write("\t                    <li class=\"li4\">x<span>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.amount}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</span></li>\n");
          out.write("\t                    <li class=\"li5\">￥<span>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.goods.price*items.amount}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</span></li>\n");
          out.write("\t                </ul>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}